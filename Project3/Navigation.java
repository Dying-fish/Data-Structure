import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Navigation {
    static Comparator<S> cmp = new Comparator<S>() {
        public int compare(S e1, S e2) {
            return e1.dis - e2.dis;
        }
    };
    public static class S{
        int id;
        int dis;
        public S(int id,int dis){
            this.id = id;
            this.dis = dis;
        }
    }
    public static final int maxValue = Integer.MAX_VALUE;
    public static void Dijkstra(Map.Graph graph, int dest, int s,boolean bus){	//导航算法
        PriorityQueue<S> queue = new PriorityQueue<S>(27,cmp); //优先队列
        S[] Q = new S[graph.vertex.length];
        int[] path = new int[graph.vertex.length];  //路径编号数组
        int[] p = new int[graph.vertex.length];    //父节点数组
        for (int i = 0; i<graph.vertex.length;i++){      //初始化
            Q[i] = new S(i,maxValue);
            queue.add(Q[i]);
            p[i] = -1;
            path[i] = -1;
        }
        queue.remove(Q[s]);
        Q[s].dis = 0;	//将源点距离设为0
        queue.add(Q[s]);
        int u;
        while(!queue.isEmpty()){
            S temp = queue.poll();	//获取离源点最近的节点
            u = temp.id;   //获取对应下标
            if (u == dest) {    //到达目的地，打印路径
                System.out.println("行程耗时"+temp.dis+"s");
                printPATH(graph,p,path,s,dest);
                System.out.println(graph.vertex[dest].name);
                return;
            }
            Map.Node U = graph.vertex[u];
            for (int i=0;i<U.Adj.size();i++){	//遍历该节点的邻接边
                if (!bus && U.Adj.get(i).type=='b'){    //判断是否为公交路径
                    continue;   //如果是且不搭乘巴士则跳过
                }
                if (Q[U.Adj.get(i).dest].dis > Q[u].dis + U.Adj.get(i).weight){ //判断是否存在更短路径，是则修改
                    queue.remove(Q[U.Adj.get(i).dest]);
                    path[U.Adj.get(i).dest] = i;
                    Q[U.Adj.get(i).dest].dis = Q[u].dis + U.Adj.get(i).weight;
                    p[U.Adj.get(i).dest] = u;
                    queue.add(Q[U.Adj.get(i).dest]);
                }
            }
        }
    }
    public static void printPATH(Map.Graph graph,int[] p,int[] path,int s,int dest) {   //以递归的方式打印路径
        if (dest != s) {
            printPATH(graph, p, path, s, p[dest]);
            System.out.print(graph.vertex[p[dest]].name + "--" + graph.vertex[p[dest]].Adj.get(path[dest]).pathName + "-→");
        }
    }

    public static void main(String[] args){
        Map.Graph graph = new Map.Graph();
        Scanner scanner = new Scanner(System.in);
        while(true){
            Map.showLocation();
            System.out.println("请输入您现在的位置");
            int s = scanner.nextInt();
            scanner.nextLine();
            System.out.println("请输入目的地");
            int dest = scanner.nextInt();
            scanner.nextLine();
            System.out.println("是否乘坐鹿角虫巴士");
            System.out.println("0:否\t1:是");
            int bus = scanner.nextInt();
            long startTime = System.currentTimeMillis();
            if (bus==0) Dijkstra(graph,dest,s,false);
            else Dijkstra(graph,dest,s,true);
            System.out.println("运算时间为"+(System.currentTimeMillis()-startTime)+"ms");
            System.out.println();
        }
    }
}
