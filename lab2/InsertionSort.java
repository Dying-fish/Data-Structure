import java.util.Arrays;
public class InsertionSort {
    public static void main(String[] args){
        char[] arr = {'x','z','t','Z','a','p','A','b'};
        System.out.println(Arrays.toString(arr));
        InsertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static <E extends Comparable<E>> void InsertionSort(E[] inputArray){    //泛型
        if (inputArray.length<1||inputArray==null){
            System.out.println("Invalid Array");
            return;
        }
        for(int i=1;i<inputArray.length;i++){
            E key = inputArray[i];
            int j = i-1;
            while (j>=0 && inputArray[j].compareTo(key)>0){
                inputArray[j+1] = inputArray[j];
                j--;
            }
            inputArray[j+1] = key;
        }
    }
    public static void InsertionSort(int[] inputArray){    //整型
        if (inputArray.length<1||inputArray==null){
            System.out.println("Invalid Array");
            return;
        }
        for(int i=1;i<inputArray.length;i++){
            int key = inputArray[i];
            int j = i-1;
            while (j>=0 && inputArray[j]>key){
                inputArray[j+1] = inputArray[j];
                j--;
            }
            inputArray[j+1] = key;
        }
    }
    public static void InsertionSort(double[] inputArray){    //浮点型
        if (inputArray.length<1||inputArray==null){
            System.out.println("Invalid Array");
            return;
        }
        for(int i=1;i<inputArray.length;i++){
            double key = inputArray[i];
            int j = i-1;
            while (j>=0 && inputArray[j]>key){
                inputArray[j+1] = inputArray[j];
                j--;
            }
            inputArray[j+1] = key;
        }
    }
    public static void InsertionSort(char[] inputArray){    //字符型
        if (inputArray.length<1||inputArray==null){
            System.out.println("Invalid Array");
            return;
        }
        for(int i=1;i<inputArray.length;i++){
            char key = inputArray[i];
            int j = i-1;
            while (j>=0 && inputArray[j]>key){
                inputArray[j+1] = inputArray[j];
                j--;
            }
            inputArray[j+1] = key;
        }
    }
}
