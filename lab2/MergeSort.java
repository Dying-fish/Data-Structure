import java.util.Arrays;
public class MergeSort {
    public static void main(String[] args){
        double[] arr = {4 ,5 ,7 ,8 ,1, 2, 6, 3};
        System.out.println(Arrays.toString(arr));
        MergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static <E extends Comparable<E>> void MergeSort(E[] inputArray,int start,int end) {  //泛型
        if (start<end){ //长度大于1时就分开
            int mid = (start+end)/2;    //取中点
            MergeSort(inputArray,start,mid);
            MergeSort(inputArray,mid+1,end);
            Merge(inputArray,start,mid,end); //合并两个有序数组
        }
    }
    public static <E extends Comparable<E>> void Merge(E[] inputArray,int start,int mid,int end){   //合并
        int L1 = mid - start + 1;
        int L2 = end - mid;
        int i,j;
        E[] left = (E[]) new Comparable[L1];  //初始化两个数组
        E[] right = (E[]) new Comparable[L2];
        for (i=0;i<L1;i++){
            left[i] = inputArray[start+i];
        }
        for (j=0;j<L2;j++){
            right[j] = inputArray[mid+1+j];
        }
        i=0;
        j=0;
        for (int k=start;k<=end;k++){   //开始合并
            if (i<L1&&j<L2){
                if (left[i].compareTo(right[j])<0){ //按大小依次插入数组
                    inputArray[k]=left[i];
                    i++;
                }
                else {
                    inputArray[k]=right[j];
                    j++;
                }
            }
            else {  //插入剩余数据
                if (i < L1) {
                    inputArray[k] = left[i];
                    i++;
                } else {
                    inputArray[k] = right[j];
                    j++;
                }
            }
        }
    }
    public static void MergeSort(int[] inputArray,int start,int end) {  //int型
        if (start<end){ //长度大于1时就分开
            int mid = (start+end)/2;    //取中点
            MergeSort(inputArray,start,mid);
            MergeSort(inputArray,mid+1,end);
            Merge(inputArray,start,mid,end); //合并两个有序数组
        }
    }
    public static void Merge(int[] inputArray,int start,int mid,int end){   //合并
        int L1 = mid - start + 1;
        int L2 = end - mid;
        int i,j;
        int[] left = new int[L1];  //初始化两个数组
        int[] right = new int[L2];
        for (i=0;i<L1;i++){
            left[i] = inputArray[start+i];
        }
        for (j=0;j<L2;j++){
            right[j] = inputArray[mid+1+j];
        }
        i=0;
        j=0;
        for (int k=start;k<=end;k++){   //开始合并
            if (i<L1&&j<L2){
                if (left[i]<right[j]){   //按大小依次插入数组
                    inputArray[k]=left[i];
                    i++;
                }
                else {
                    inputArray[k]=right[j];
                    j++;
                }
            }
            else {  //插入剩余数据
                if (i < L1) {
                    inputArray[k] = left[i];
                    i++;
                } else {
                    inputArray[k] = right[j];
                    j++;
                }
            }
        }
    }
    public static void MergeSort(double[] inputArray,int start,int end) {  //double型
        if (start<end){ //长度大于1时就分开
            int mid = (start+end)/2;    //取中点
            MergeSort(inputArray,start,mid);
            MergeSort(inputArray,mid+1,end);
            Merge(inputArray,start,mid,end); //合并两个有序数组
        }
    }
    public static void Merge(double[] inputArray,int start,int mid,int end){   //合并
        int L1 = mid - start + 1;
        int L2 = end - mid;
        int i,j;
        double[] left = new double[L1];  //初始化两个数组
        double[] right = new double[L2];
        for (i=0;i<L1;i++){
            left[i] = inputArray[start+i];
        }
        for (j=0;j<L2;j++){
            right[j] = inputArray[mid+1+j];
        }
        i=0;
        j=0;
        for (int k=start;k<=end;k++){   //开始合并
            if (i<L1&&j<L2){
                if (left[i]<right[j]){   //按大小依次插入数组
                    inputArray[k]=left[i];
                    i++;
                }
                else {
                    inputArray[k]=right[j];
                    j++;
                }
            }
            else {  //插入剩余数据
                if (i < L1) {
                    inputArray[k] = left[i];
                    i++;
                } else {
                    inputArray[k] = right[j];
                    j++;
                }
            }
        }
    }
    public static void MergeSort(char[] inputArray,int start,int end) {  //char型
        if (start<end){ //长度大于1时就分开
            int mid = (start+end)/2;    //取中点
            MergeSort(inputArray,start,mid);
            MergeSort(inputArray,mid+1,end);
            Merge(inputArray,start,mid,end); //合并两个有序数组
        }
    }
    public static void Merge(char[] inputArray,int start,int mid,int end){   //合并
        int L1 = mid - start + 1;
        int L2 = end - mid;
        int i,j;
        char[] left = new char[L1];  //初始化两个数组
        char[] right = new char[L2];
        for (i=0;i<L1;i++){
            left[i] = inputArray[start+i];
        }
        for (j=0;j<L2;j++){
            right[j] = inputArray[mid+1+j];
        }
        i=0;
        j=0;
        for (int k=start;k<=end;k++){   //开始合并
            if (i<L1&&j<L2){
                if (left[i]<right[j]){   //按大小依次插入数组
                    inputArray[k]=left[i];
                    i++;
                }
                else {
                    inputArray[k]=right[j];
                    j++;
                }
            }
            else {  //插入剩余数据
                if (i < L1) {
                    inputArray[k] = left[i];
                    i++;
                } else {
                    inputArray[k] = right[j];
                    j++;
                }
            }
        }
    }
}
