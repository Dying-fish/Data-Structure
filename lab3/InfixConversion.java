import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class InfixConversion {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input an infix expression:");
        String infix = scanner.nextLine();
        String postfix = conversion(infix);
        System.out.println(postfix);
    }
    public static String conversion(String infix){
        StringBuilder postfix = new StringBuilder();    //创建一个StringBuilder保存后缀表达式
        Stack<String> stack = new Stack();  //创建一个栈保存操作符
        boolean isNum = true;   //布尔变量判别是否为连续数字
        String[] infixArray = infix.split(" ");  //将字符串分割
        for(int i=0;i < infixArray.length; i++){
            String str = infixArray[i];
            if (str.equals(" ") || str.equals("")) continue;  //跳过空字符串
            if(isNumber(str)) { //判别是否为数字
                if (!isNum) {
                    postfix.append(" ");    //若先前不是数字，加空格以便识别
                    isNum = true;
                }
                postfix.append(str); //直接入队
            }
            else {
                isNum = false;
                if (isOperator(str)) {  //判别是否为操作符
                    if (stack.isEmpty() || priority(stack.peek())==1 || priority(str) < priority(stack.peek())) {
                        stack.push(str);    //若栈为空或栈顶为左括号或当前操作符优先级大于栈顶操作符时，压入栈内
                    } else {
                        while (!stack.isEmpty() && priority(stack.peek())!=1  && priority(str) >= priority(stack.peek())) {
                            postfix.append(" "+stack.pop());    //否则将栈中元素依次出栈入队，直至栈空或遇到左括号或栈顶优先级大于等于当前运算符
                        }
                        stack.push(str);    //然后再将当前操作符压入栈
                    }
                } else if (str.equals(")")) {   //若当前字符串为右括号时，将栈中元素依次出栈入队，直到遇见对应的左括号或栈空
                    while (!stack.isEmpty() && stack.peek().compareTo("(") != 0) {
                        postfix.append(" "+stack.pop());
                    }
                    stack.pop();    //将左括号出栈
                } else if (str.equals("]")) {
                    while (!stack.isEmpty() && stack.peek().compareTo("[") != 0) {
                        postfix.append(" "+stack.pop());
                    }
                    stack.pop();
                } else if (str.equals("}")) {
                    while (!stack.isEmpty() && stack.peek().compareTo("{") != 0) {
                        postfix.append(" "+stack.pop());
                    }
                    stack.pop();
                } else if(isTrigonometry(str)){     //判断是否为三角函数
                    StringBuilder subString = new StringBuilder();     //创建一个StringBuilder保存三角函数内的字符串
                    int num = 0;
                    while(num != -1 && i < infixArray.length){         //直至找到对应的右括号时停止
                        i++;
                        String temp = infixArray[i];
                        if(temp.equals(")")) num--;
                        else {
                            if (temp.equals("(")) num++;
                            subString.append(temp+" ");     //保存字符串
                        }
                    }
                    postfix.append(conversion(subString.toString())+" "+str.substring(0,str.length()-1));   //递归获取函数内的后缀表达式再入队
                } else {    //出现不明字符串
                    throw new RuntimeException("存在无法识别的字符");
                }
            }
        }
        while (!stack.isEmpty()){   //循环结束后将栈剩余元素出栈入队，直至栈空
            postfix.append(" "+stack.pop());
        }
        return postfix.toString().trim();  //返回后缀表达式
    }
    public static boolean isNumber(String num){ //判别是否为数字
        return num.matches("((-)?\\d+\\.?\\d*)");
    }
    public static boolean isOperator(String symbol){    //判别是否为操作符
        return  symbol.equals("|") || symbol.equals("^") || symbol.equals("&") ||
                symbol.equals("<<") || symbol.equals(">>") || symbol.equals(">>>") ||
                symbol.equals("+") || symbol.equals("-") ||
                symbol.equals("*") || symbol.equals("/")|| symbol.equals("%") ||
                symbol.equals("~") ||
                symbol.equals("{") || symbol.equals("[") || symbol.equals("(");
    }
    public static boolean isTrigonometry(String symbol){    //判断是否为三角函数
        String subString = symbol.substring(0,symbol.length()-1);
        return subString.equals("sin") || subString.equals("cos") || subString.equals("tan") ||
               subString.equals("asin") || subString.equals("acos") || subString.equals("atan");
    }
    public static int priority(String symbol) {  //操作符优先级
        switch (symbol) {
            case "(":
            case "[":
            case "{":
                return 1;
            case "~":
                return 2;
            case "*":
            case "/":
            case "%":
                return 3;
            case "+":
            case "-":
                return 4;
            case "<<":
            case ">>":
            case ">>>":
                return 5;
            case "&":
                return 8;
            case "^":
                return 9;
            case "|":
                return 10;
            default:
                return 14;
        }
    }
}
