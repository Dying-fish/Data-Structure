public class OptSort {
    public static void main(String[] args){
        for(int k=2;k<21;k++) {
            int sum = 0;
            for (int i = 0; i < 50; i++) {
                int[] arr = {5666, 889, 7228, 2327, 9595, 2098, 3877, 3601, 9149, 4061, 1331, 3221, 8353, 9391, 8143, 2085, 1750, 3855, 1655, 70, 8832, 4025, 2688, 9576, 7377, 4597, 221, 4939, 2579, 568, 7438, 7616, 8558, 2734, 2884, 9189, 6351, 8449, 5638, 1638, 7786, 3442, 1384, 7096, 7803, 4656, 7047, 7355, 8720, 8486, 5280, 6741, 8697, 3641, 6492, 693, 3226, 2864, 5336, 6335, 2881, 3212, 623, 675, 2714, 269, 2479, 6645, 8743, 7705, 8222, 7176, 4764, 9928, 8926, 2683, 8372, 2234, 1922, 7964, 8513, 9822, 583, 319, 8162, 4291, 1683, 1930, 4776, 3870, 2308, 5991, 8075, 1495, 2877, 7935, 9385, 3072, 157, 166, 9296, 6788, 4337, 1185, 714, 3188, 7198, 7721, 2499, 4844, 4214, 1531, 4869, 3965, 2005, 912, 1458, 6002, 4007, 643, 4531, 7465, 1426, 3083, 9229, 6498, 3600, 7431, 9903, 5529, 1737, 3796, 6626, 6297, 2675, 3660, 2772, 8917, 4771, 8528, 5217, 8298, 6337, 4160, 7125, 3160, 8130, 8614, 9573, 5222, 5317, 8534, 2330, 8669, 1087, 9590, 5986, 2949, 3590, 3804, 7333, 5133, 268, 8607, 7396, 1613, 8777, 9887, 6862, 2752, 1722, 4075, 6742, 8233, 3160, 2320, 3110, 5341, 8484, 3207, 3465, 7170, 5685, 9158, 8873, 2837, 5222, 5615, 405, 7202, 7788, 1448, 617, 3266, 4082, 3637, 786, 6507, 8404, 9193, 2464, 6685, 8323, 2555, 7556, 9340, 6005, 7232, 4546, 6165, 2848, 6353, 9774, 690, 8026, 7935, 1742, 3328, 3235, 7209, 3293, 7715, 519, 135, 1234, 8496, 7357, 9347, 5449, 9238, 3402, 6216, 9895, 7980, 6215, 455, 6003, 7092, 9140, 1756, 4952, 3558, 3061, 6295, 9035, 5608, 5214, 4656, 3931, 1668, 2429, 6691, 3049, 8032, 3243, 3155, 2343, 2367, 3171, 3561, 8981, 1158, 80, 4656, 82, 592, 2097, 4134, 8370, 1970, 8773, 9771, 39, 4753, 7326, 5050, 6392, 2581, 9705, 8498, 4870, 215, 2940, 5474, 6997, 2257, 4790, 7949, 433, 7687, 9055, 9914, 9876, 7818, 69, 3541, 6839, 9077, 3901, 3887, 1479, 6195, 4548, 8063, 616, 5833, 7019, 8110, 4808, 5451, 5651, 5528, 3949, 7331, 5169, 9383, 5227, 3034, 4115, 9244, 9480, 9324, 5055, 8806, 1997, 2568, 3697, 5984, 1638, 5014, 9478, 524, 7772, 2956, 3535, 709, 7986, 3770, 5996, 6640, 783, 6103, 3522, 8720, 6544, 5040, 9712, 6478, 6932, 2027, 5530, 4688, 7591, 7491, 4288, 839, 1532, 2662, 5857, 443, 892, 5919, 7779, 4438, 2901, 8136, 6730, 5962, 1848, 970, 2395, 2172, 2561, 1814, 7227, 458, 2544, 9203, 9793, 7380, 9245, 2897, 6459, 2986, 6158, 3543, 5993, 2772, 6461, 7864, 4376, 4480, 5721, 6660, 2533, 7181, 5816, 4543, 8043, 5635, 698, 2308, 2950, 3801, 848, 5107, 3729, 7547, 7374, 2174, 6196, 8088, 8578, 6781, 7674, 4531, 1506, 8264, 1096, 5966, 8518, 1547, 886, 1024, 4236, 3372, 8436, 5532, 1350, 8637, 5797, 6987, 4730, 4674, 9790, 7890, 2022, 6106, 5167, 8726, 5522, 7975, 4695, 5305, 4460, 270, 6046, 4542, 9045, 2659, 260, 7331, 7652, 4299, 4187, 7126, 6309, 9878, 9823, 8074, 5311, 9761, 6719, 7107, 1232, 9013, 9751, 258, 3845, 7390, 3474, 4676, 6565, 9957, 5986, 4260, 5872, 5888, 9784, 8700, 9920, 1247, 4445, 2773, 8994, 27, 6124, 5223, 852, 6599, 1860, 4261, 2067, 1866, 2436, 9797, 2492, 4863, 6181, 884, 3680, 1345, 7497, 530, 3691, 965, 8121, 9029, 91, 5071, 6180, 1277, 160, 7848, 7962, 3140, 2316, 4559, 9952, 6895, 5588, 1973, 4217, 5995, 4633, 7741, 8468, 4962, 6196, 7401, 3246, 1100, 9200, 18, 2616, 880, 4728, 6010, 1436, 5356, 4020, 3645, 1856, 5777, 2333, 3879, 4034, 2673, 3994, 6748, 1204, 9127, 9330, 6372, 7254, 1696, 7264, 5743, 5722, 489, 8328, 6979, 2738, 3291, 1602, 7468, 2862, 7291, 5669, 7429, 5985, 5978, 8035, 9805, 5505, 8068, 9689, 9139, 2848, 9951, 1474, 2077, 1064, 3066, 6756, 8516, 703, 2873, 538, 9024, 4490, 6634, 8569, 1168, 3380, 3092, 1319, 4626, 5537, 8310, 6694, 2553, 1472, 8447, 2313, 4591, 3136, 2016, 2818, 5106, 2115, 1337, 233, 8761, 2232, 5283, 5684, 4389, 4847, 3200, 8943, 7259, 936, 2908, 8203, 9301, 2633, 4081, 6237, 6643, 8333, 1972, 702, 3875, 9680, 5451, 5678, 4871, 5819, 7623, 8794, 724, 124, 6928, 3240, 6349, 7298, 1532, 6844, 8658, 4203, 84, 972, 876, 6095, 7459, 509, 9507, 1004, 4984, 2403, 2744, 8951, 815, 4327, 1712, 9406, 7636, 6935, 8814, 9929, 1656, 2830, 698, 1301, 9000, 2924, 6832, 9604, 3011, 6160, 8584, 3704, 8742, 1701, 7783, 7367, 8961, 3671, 8259, 8851, 9366, 7239, 8584, 7221, 9385, 1474, 9374, 3890, 8929, 8708, 3876, 9890, 789, 2425, 6278, 4263, 2958, 5631, 8241, 6621, 5119, 9520, 442, 7381, 8767, 7887, 2600, 2511, 993, 6168, 2413, 5691, 7831, 5258, 1098, 9720, 4250, 9334, 832, 748, 4362, 3778, 7270, 3417, 7231, 4019, 8558, 2379, 777, 8591, 756, 5813, 8718, 54, 8436, 9543, 3208, 5547, 8380, 6137, 8931, 4683, 3746, 2006, 2718, 6272, 5860, 6893, 6506, 6918, 877, 4404, 390, 3924, 8950, 9264, 6865, 2138, 4263, 6819, 6959, 9379, 5306, 3009, 3891, 7909, 6116, 8461, 135, 53, 847, 8702, 9324, 4500, 6002, 3550, 5298, 6109, 6930, 2668, 6790, 6078, 7793, 1020, 7718, 1256, 7089, 7465, 9883, 1047, 4038, 2122, 6973, 7877, 4671, 3268, 6206, 2522, 290, 2546, 6716, 8714, 5118, 8004, 1787, 2404, 4429, 8153, 5474, 9824, 9212, 6580, 2787, 5033, 8520, 5927, 6619, 2055, 6056, 2080, 3918, 8900, 3245, 4240, 8202, 742, 7092, 4255, 5470, 7400, 7445, 9034, 5787, 5868, 4933, 3175, 3381, 2082, 7822, 5033, 3975, 7413, 3305, 8387, 9242, 4393, 6320, 3562, 4761, 3113, 6894, 6438, 9679, 4393, 5247, 1104, 3395, 8361, 2367, 2102, 6992, 7392, 2661, 5168, 4925, 468, 4384, 1177, 5498, 2022, 3063, 6598, 7056, 2022, 2861, 5191, 469, 5690, 943, 9894, 7523, 567, 302, 882, 9089, 5908, 7205, 5677, 6612, 4321, 461, 9784, 5342, 8463, 1024, 1877, 8020, 6172, 2143, 5795, 3250, 5916, 2163, 2754, 3692, 668, 4431, 1057, 5360, 2395, 1294, 7355, 823, 1241, 2109, 3013, 5917, 3171, 8367, 1511, 1670, 7368, 2602, 7985, 612, 9975, 1550, 9957, 9348, 3926, 8194, 9131, 7347, 5559, 1803, 7712, 5279, 7443, 9824, 9129, 4895, 3451, 599, 2279, 6440, 6478, 1256, 432, 8912, 1396, 855, 802, 3090, 5870, 4894, 8466, 7174, 9457, 3591, 8758, 143, 7060, 3054, 5600, 8486, 6250, 5373, 9295, 7828, 9231, 961, 6253, 2153, 9293, 4070, 4825, 9830, 8486, 272, 5988, 7441, 7940, 2964, 4952, 9549, 4781, 4412, 9937, 4940};
                long startTime = System.nanoTime();   //获取开始时间
                MergeSort(arr, 0, arr.length - 1, k);
                long endTime = System.nanoTime(); //获取结束时间
                sum += endTime - startTime;
            }
            System.out.println(k+": " + sum / 50); //取
            // 平均值
        }
    }

    public static <E extends Comparable<E>> void MergeSort(E[] inputArray,int start,int end,int k) {  //泛型分开
        if (end-start+1>=k){ //数组长度大于等于k时分成两个数组
            int mid = (start+end)/2;    //取中点
            MergeSort(inputArray,start,mid,k);
            MergeSort(inputArray,mid+1,end,k);
            Merge(inputArray,start,mid,end); //合并两个有序数组
        }
        else{   //长度小于k时用插入算法排序
            InsertionSort(inputArray,start,end);
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
    public static <E extends Comparable<E>> void InsertionSort(E[] inputArray,int start,int end){
        for(int i=start+1;i<=end;i++){
            E key = inputArray[i];
            int j = i-1;
            while (j>=start&&inputArray[j].compareTo(key)>0){
                inputArray[j+1] = inputArray[j];
                j--;
            }
            inputArray[j+1] = key;
        }
    }

    public static void MergeSort(int[] inputArray,int start,int end,int k) {  //int型
        if (end-start+1>=k){ //数组长度大于等于k时分成两个数组
            int mid = (start+end)/2;    //取中点
            MergeSort(inputArray,start,mid,k);
            MergeSort(inputArray,mid+1,end,k);
            Merge(inputArray,start,mid,end); //合并两个有序数组
        }
        else{   //长度小于k时用插入算法排序
            InsertionSort(inputArray,start,end);
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
    public static void InsertionSort(int[] inputArray,int start,int end){
        for(int i=start+1;i<=end;i++){
            int key = inputArray[i];
            int j = i-1;
            while (j>=start&&inputArray[j]>key){
                inputArray[j+1] = inputArray[j];
                j--;
            }
            inputArray[j+1] = key;
        }
    }

    public static void MergeSort(double[] inputArray,int start,int end,int k) {  //double型
        if (end-start+1>=k){ //数组长度大于等于k时分成两个数组
            int mid = (start+end)/2;    //取中点
            MergeSort(inputArray,start,mid,k);
            MergeSort(inputArray,mid+1,end,k);
            Merge(inputArray,start,mid,end); //合并两个有序数组
        }
        else{   //长度小于k时用插入算法排序
            InsertionSort(inputArray,start,end);
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
    public static void InsertionSort(double[] inputArray,int start,int end){
        for(int i=start+1;i<=end;i++){
            double key = inputArray[i];
            int j = i-1;
            while (j>=start&&inputArray[j]>key){
                inputArray[j+1] = inputArray[j];
                j--;
            }
            inputArray[j+1] = key;
        }
    }

    public static void MergeSort(char[] inputArray,int start,int end,int k) {  //double型
        if (end-start+1>=k){ //数组长度大于等于k时分成两个数组
            int mid = (start+end)/2;    //取中点
            MergeSort(inputArray,start,mid,k);
            MergeSort(inputArray,mid+1,end,k);
            Merge(inputArray,start,mid,end); //合并两个有序数组
        }
        else{   //长度小于k时用插入算法排序
            InsertionSort(inputArray,start,end);
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
    public static void InsertionSort(char[] inputArray,int start,int end){
        for(int i=start+1;i<=end;i++){
            char key = inputArray[i];
            int j = i-1;
            while (j>=start&&inputArray[j]>key){
                inputArray[j+1] = inputArray[j];
                j--;
            }
            inputArray[j+1] = key;
        }
    }
}
