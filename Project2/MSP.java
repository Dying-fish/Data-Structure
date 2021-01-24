import java.util.Arrays;
public class MSP {
    public static int[] bruteForce(int[] change,int low,int high){
        int max = 0;    //初始化最大利润值与买卖策略
        int[] strategy = new int[3];
        for (int start = low;start<=high;start++){    //循环1：开始时间
            int profit = 0; //设置变量记录利润
            for (int end = start;end<=high;end++){    //循环2：结束时间（卖出后的当天）
                profit += change[end];  //计算利润
                if (profit>max){    //修改最大利润
                    max = profit;
                    strategy[0] = start;
                    strategy[1] = end;
                    strategy[2] = profit;
                }
            }
        }
        return strategy;
    }

    public static int[] Dynamic(int[] change,int low,int high){
        int[] res= new int[3];  //初始化
        int start = 0;
        int sum = 0;
        for (int i=low;i<=high;i++){
            sum += change[i];   //计算当前利润
            if(sum>res[2]){     //修改最大利润
                res[0] = start;
                res[1] = i;
                res[2] = sum;
            }
            else if (sum<0){    //如果此刻利润值为负数，说明最大利润策略里不包含之前的时间段
                sum = 0;    //重新设为0，修改买入时间
                start = i+1;
            }
        }
        return res;
    }

    public static int[] MaxSubArray(int[] A,int start,int end){
        if (start==end){
            return new int[]{start,end,A[end]};
        }
        else{
            int mid = (start+end)/2;
            int[] left = MaxSubArray(A,start,mid);
            int[] right = MaxSubArray(A,mid+1,end);
            int[] cross = MaxCrossArray(A,start,mid,end);
            if (left[2] >= right[2] && left[2] >= cross[2])
                return left;
            else if(right[2] >= left[2] && right[2] >= cross[2])
                return right;
            else
                return cross;
        }
    }
    public static int[] MaxCrossArray(int[] A,int start,int mid,int end){
        int leftMax = 0,rightMax = 0,left = mid,right = mid;
        int sum = 0;
        for (int i = mid; i >= start; i--){
            sum += A[i];
            if (sum >= leftMax){
                leftMax = sum;
                left = i;
            }
        }
        sum = 0;
        for (int i = mid+1; i <= end; i++){
            sum += A[i];
            if (sum >= rightMax){
                rightMax = sum;
                right = i;
            }
        }
        return new int[]{left,right,leftMax+rightMax};
    }

    public static void main(String[] args) {
        int[] change = {0, 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7, -11};
        int[] example = {0, -1, -2, -3, -4, -5, -6, -7, -8, -9, -10, -11, -12, -13, -14, -15, -16, -17, -18, -19};
        /*
        for (int t = 25; t <= 50; t += 5) {
            int[] example1 = new int[t];
            for (int i = 0; i < example1.length; i++) {
                int sign = (int) (Math.random() * 10);
                int value = (int) (Math.random() * 100);
                if (sign > 5)
                    example1[i] = value;
                else
                    example1[i] = -value;
            }

            System.out.println(Arrays.toString(example1));
            double sum1 = 0;
            double sum2 = 0;
            double sum3 = 0;
            System.out.println(Arrays.toString(bruteForce(example1, 0, example1.length - 1)));
            System.out.println(Arrays.toString(MaxSubArray(example1, 0, example1.length - 1)));
            System.out.println(Arrays.toString(Dynamic(example1, 0, example1.length - 1)));
            for (int i = 0; i < 20; i++) {
                double start1 = System.nanoTime();
                bruteForce(example1, 0, example1.length - 1);
                double end1 = System.nanoTime();
                sum1 += end1 - start1;
                double start2 = System.nanoTime();
                MaxSubArray(example1, 0, example1.length - 1);
                double end2 = System.nanoTime();
                sum2 += end2 - start2;
                double start3 = System.nanoTime();
                Dynamic(example1, 0, example1.length - 1);
                double end3 = System.nanoTime();
                sum3 += end3 - start3;
            }
            System.out.println(t);
            System.out.println("brute force: " + sum1 / 20);
            System.out.println("Recursive: " + sum2 / 20);
            System.out.println("Dynamic: " + sum3 / 20);
        }
         */
        System.out.println(Arrays.toString(bruteForce(change, 0, change.length - 1)));
        System.out.println(Arrays.toString(MaxSubArray(change, 0, change.length - 1)));
        System.out.println(Arrays.toString(Dynamic(change, 0, change.length - 1)));
    }
}

