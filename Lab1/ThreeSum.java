import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSum {
    static List<List<Integer>> listList = new ArrayList<List<Integer>>();
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);  //先排序
        int prev = nums[0]; //标记第一个数字
        for(int i=0;i<nums.length-2;i++){
            if (i!=0&&nums[i]==prev) {  //如果该数字和标记一致，则可能会导致重复的答案，直接跳过
                continue;
            }
            prev = nums[i]; //新的数字出现，修改标记
            for (int j=i+1;j<nums.length-1;j++){
                for (int k=j+1;k<nums.length;k++){
                    if (nums[i]+nums[j]+nums[k]==0) {
                        List<Integer> list = new ArrayList<Integer>();  //简单粗暴的三重循环枚举法直接获取答案
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        listList.add(list);
                    }
                }
            }

        }
        return listList;    //时间复杂度为O(n^3),空间复杂度为O(1)，有更方便的算法，因为数组排序过了，可以在第三个数使用二分法，时间复杂度为O(n^2logn)
    }

}