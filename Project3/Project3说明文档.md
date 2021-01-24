## Project3 说明文档

姓名：赵书誉

学号：18307110072



### 数据结构部分

#### 地图

![image-20201230125115986](./Map\Map.png)



#### 图

由于地图为稀疏图，所以采用邻接表的形式

```
public static class Graph{
    Node[] vertex;	//节点数组
    public Graph(){
        init(this);	//此处省略繁杂的初始化过程
    }
}
```



#### 节点

```
public static class Node{
    String name;	//节点名称
    ArrayList<Edge> Adj;		//邻接边（可以用数组）
    public Node(String name){
        this.name = name;
        this.Adj = new ArrayList<Edge>();
    }
}
```



#### 边

```
public static class Edge{
    int dest;	//目的地
    String pathName;	//路名
    int weight;		//边权
    char type;	//路的类型
    public Edge(int dest,String pathName,int weight,char type){
		if (weight<=0 || (type!='w'&& type!='b'))	//边权为正且路径类型只有‘b’和‘w’两种
            System.out.println("Invalid path");
        else {
            this.dest = dest;
            this.pathName = pathName;
            this.weight = weight;
            this.type = type;
        }
    }
}
```



#### 优先队列

```
static Comparator<S> cmp = new Comparator<S>() {	//优先队列用的比较方法
    public int compare(S e1, S e2) {	//升序排列
        return e1.dis - e2.dis;
    }
};
public static class S{	//为了运算方便自定义的数据结构
    int id;		//对应的节点编号
    int dis;	//跟源点的距离
    public S(int id,int dis){
        this.id = id;
        this.dis = dis;
    }
}
```



### 算法部分

因为图有环路但不存在负权边，因此选用 ***Dijkstra*** 算法，时间复杂度为 ***O(ElgV)***

```
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
        System.out.print(graph.vertex[p[dest]].name + "--" + 			   graph.vertex[p[dest]].Adj.get(path[dest]).pathName + "-→");
    }
}
```



#### 运行截图

运行程序后输入对应位置的编号与是否选择乘巴士，即可导航

![image-20201230153857886](Map\running.png)



### 实验感想

地图选用的是玩的游戏《空洞骑士》中大地图的瞎改版，设置了三条巴士路线，每条有6个站点（其实可以随便加但我懒）。

没想到花费时间最长的是地图的初始化。不会javafx，直接放弃gui，老老实实用控制台了。

打印路径时会把路名一起打印出来，方便验证算法正确性，保证结果不是乱编。