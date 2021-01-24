import java.util.Arrays;

public class Interval_Graph_Coloring {
    /*用于储存活动始末的类*/
    public static class Activity{
        int num;
        int startTime;
        int endTime;
        public Activity(int num,int startTime,int endTime){
            this.num = num;
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    /*贪婪算法*/
    public static void GraphColoring(Activity[] activities){
        System.out.println("活动安排方案如下");
        for (int i=0;i<activities.length;i++){	//先将活动按结束时间升序排序
            for (int j=activities.length-1;j>i;j--){
                if (activities[j].endTime < activities[j-1].endTime){
                    Activity temp = activities[j];
                    activities[j] = activities[j-1];
                    activities[j-1] = temp;
                }
            }
        }
        boolean[] used = new boolean[activities.length];	//查看活动是否已被安排的布尔数组
        boolean over = false;
        int hall = 1;
        while (!over){
            over = true;
            int temp = -1;
            for (int i=0;i<activities.length;i++){
                if (!used[i] && activities[i].startTime > temp){	//如果该活动未被安排且时间不冲突
                    if (over){	//尚未安排大厅
                        System.out.print("Hall "+hall+": ");
                    }
                    temp = activities[i].endTime;	//记录新活动结束时间
                    used[i] = true;
                    System.out.print(activities[i].num+" ");	//输出活动编号
                    over = false;	//存在新活动，循环不应结束
                }
            }
            System.out.println();
            hall++;	//大厅编号
        }
    }
    public static void main(String[] args){
        int[] start = new int[20];
        int[] end = new int[20];
        Activity[] example = new Activity[10];
        example[0] = new Activity(1,29,37);
        example[1] = new Activity(2,19,23);
        example[2] = new Activity(3,3,12);
        example[3] = new Activity(4,20,28);
        example[4] = new Activity(5,8,12);
        example[5] = new Activity(6,9,16);
        example[6] = new Activity(7,16,17);
        example[7] = new Activity(8,25,31);
        example[8] = new Activity(9,25,34);
        example[9] = new Activity(10,13,20);
        Activity[] activities = new Activity[20];
        for (int i=0;i<20;i++){
            start[i] = (int)(Math.random()*40);
            end[i] = start[i]+(int)(1+Math.random()*10);
            activities[i] = new Activity(i+1,start[i],end[i]);
            System.out.println("No."+(i+1)+": "+start[i]+" "+end[i]);
        }
        GraphColoring(example);
    }
}
