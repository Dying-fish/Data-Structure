import java.util.Scanner;
import java.util.Stack;

public class postfixEvaluation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input an postfix expression:");  //输入一个后缀表达式
        String postfix = scanner.nextLine();    //获取后缀表达式
        System.out.println(evaluation(postfix));    //求值
    }
    public static String evaluation(String postfix){
        Stack<String> stack = new Stack<>();    //创建一个栈保存数字
        String[] postfixArray = postfix.split(" "); //分段
        for (String str: postfixArray) {
            if (isNumber(str)) {
                stack.push(str);    //数字直接压入栈
            } else if (str.equals("~")) {   //一元运算符
                int arg = Integer.valueOf(stack.pop());
                arg = ~arg;
                stack.push(String.valueOf(arg));
            } else if (isFunction(str)) {   //是函数
                double arg = Double.valueOf(stack.pop());
                switch (str) {  //除了三角函数还可以随意加入abs，log，exp，ceil，floor等方法
                    case "sin":
                        arg = Math.sin(arg);
                        break;
                    case "cos":
                        arg = Math.cos(arg);
                        break;
                    case "tan":
                        arg = Math.tan(arg);
                        break;
                    case "asin":
                        arg = Math.asin(arg);
                        break;
                    case "acos":
                        arg = Math.acos(arg);
                        break;
                    case "atan":
                        arg = Math.atan(arg);
                        break;
                    default:
                        throw new RuntimeException("无效的后缀表达式");
                }
                stack.push(String.valueOf(arg));
            } else {
                int arg2 = Integer.valueOf(stack.pop());    //获取栈顶的两个参数
                int arg1 = Integer.valueOf(stack.pop());
                int arg;    //用于保存运算后的数值
                switch (str) {  //可以随意加入max，min，pow等方法
                    case "*":
                        arg = arg1 * arg2;
                        break;
                    case "/":
                        arg = arg1 / arg2;
                        break;
                    case "%":
                        arg = arg1 % arg2;
                        break;
                    case "+":
                        arg = arg1 + arg2;
                        break;
                    case "-":
                        arg = arg1 - arg2;
                        break;
                    case "<<":
                        arg = arg1 << arg2;
                        break;
                    case ">>":
                        arg = arg1 >> arg2;
                        break;
                    case ">>>":
                        arg = arg1 >>> arg2;
                        break;
                    case "&":
                        arg = arg1 & arg2;
                        break;
                    case "^":
                        arg = arg1 ^ arg2;
                        break;
                    case "|":
                        arg = arg1 | arg2;
                        break;
                    default:
                        throw new RuntimeException("无效的后缀表达式");
                }
                stack.push(String.valueOf(arg));
            }
        }
        return stack.pop(); //循环结束，返回最终结果
    }
    public static boolean isNumber(String num){ //判别是否为数字
        return num.matches("((-)?\\d+\\.?\\d*)");
    }
    public static boolean isFunction(String str) {  //返回是否为函数，如果要区分单参数函数与双参数函数还得修改
        return str.matches("^\\w{3,4}$");
    }
}
