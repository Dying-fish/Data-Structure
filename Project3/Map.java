import java.util.ArrayList;
import java.util.HashMap;

public class Map {
    public static final String[] name = {"格林剧院","马托道场","乌恩之湖","黑卵圣巢","十字路口A",
            "十字路口B","鹿角虫巢穴","席奥画廊","猎人小屋","辐光雕像","水晶之心","十字路口C","图书馆",
            "白女士","银行","王后驿站","梦之钉","安息沼泽","灵魂圣所","十字路口D","深巢","螳螂村",
            "十字路口E","空洞骑士雕像","白色守卫者","愚人斗兽场","白色宫殿"};
    public static final int[] adjNum = {4,3,4,3,5,5,1,2,4,2,2,4,3,2,5,4,3,1,2,4,2,4,3,5,4,2,1};
    public static final int[] dest ={1,3,4,5,0,6,2,1,4,7,8,0,4,5,0,2,3,14,15,0,3,9,16,10,1,
            2,8,2,7,11,12,5,10,9,5,8,13,12,19,11,8,14,11,19,4,12,15,21,19,4,14,18,23,5,17,22,16,
            15,23,13,11,14,20,19,21,14,20,23,24,16,23,25,15,18,22,21,24,21,23,25,26,22,24,24};
    public static final String[] path = {"咆哮悬崖","矿道岔路","矿道","徳特茅斯大道","咆哮悬崖","反击蝇缆车","底部隧道",
            "底部隧道","遗忘十字左路","隐蔽小路","苍绿之径","矿道岔路","遗忘小道","遗忘十字右路",
            "矿道","遗忘十字左路","遗忘小道","雾之峡谷","真菌岔路","徳特茅斯大道","遗忘十字右路","水晶山左道","先知之路","跳跳乐",
            "反击蝇缆车","隐蔽小路","荆棘大道","苍绿之径","荆棘大道","王后花园大道","莫诺蒙路",
            "水晶山左道","水晶山右道","水晶山右道","跳跳乐","王后花园大道","王后花园左路","王后花园右路","王后花园小道",
            "王后花园右路","莫诺蒙路","黑门","王后花园左路","马鹿之径","雾之峡谷","黑门","峡谷小路","真菌荒地","送花大道",
            "真菌岔路","峡谷小路","圣所小门","泪城左道","先知之路","安息小道","守望者电梯","安息小道",
            "圣所小门","圣所大门","马鹿之径","王后花园小道","送花大道","赫拉大道","赫拉大道","废弃车道",
            "真菌荒地","废弃车道","城市大门","排水口小路","守望者电梯","泪城右道","快乐小路",
            "泪城左道","圣所大门","泪城右道","城市大门","皇家水道","排水口小路","皇家水道","王国边缘大道","古老盆地",
            "快乐小路","王国边缘大道","古老盆地"};
    public static final int[] dis = {21,8,12,20,21,15,23,23,15,13,17,8,6,15,12,15,6,18,14,20,15,22,16,27,
            15,13,24,17,24,15,12,22,31,31,27,15,14,13,10,13,12,9,14,5,18,9,6,25,22,14,6,7,16,16,6,17,6,
            7,11,5,10,22,25,25,21,25,21,22,13,17,12,6,16,11,12,22,19,13,19,27,31,6,27,31};

    public static class Node{
        String name;
        ArrayList<Edge> Adj;
        public Node(String name){
            this.name = name;
            this.Adj = new ArrayList<Edge>();
        }
    }
    public static class Edge{
        int dest;
        String pathName;
        int weight;
        char type;
        public Edge(int dest,String pathName,int weight,char type){
            if (weight<=0 || (type!='w'&& type!='b'))
                System.out.println("Invalid path");
            else {
                this.dest = dest;
                this.pathName = pathName;
                this.weight = weight;
                this.type = type;
            }
        }
    }
    public static class Graph{
        Node[] vertex;
        public Graph(){
            init(this);
        }
    }
    public static void init(Graph graph){
        int k = 0;
        graph.vertex = new Node[27];
        for(int i=0;i<27;i++){
            Node node = new Node(name[i]);
            for(int j=0;j<adjNum[i];j++){
                node.Adj.add(new Edge(dest[k],path[k],dis[k],'w'));
                k++;
            }
            graph.vertex[i] = node;
        }
        graph.vertex[0].Adj.add(new Edge(9,"鹿角虫A线",12,'b'));
        graph.vertex[0].Adj.add(new Edge(6,"鹿角虫C线",10,'b'));
        graph.vertex[0].Adj.add(new Edge(2,"鹿角虫C线",10,'b'));
        graph.vertex[2].Adj.add(new Edge(0,"鹿角虫C线",10,'b'));
        graph.vertex[2].Adj.add(new Edge(12,"鹿角虫C线",12,'b'));
        graph.vertex[3].Adj.add(new Edge(15,"鹿角虫B线",10,'b'));
        graph.vertex[3].Adj.add(new Edge(18,"鹿角虫B线",10,'b'));
        graph.vertex[6].Adj.add(new Edge(0,"鹿角虫C线",10,'b'));
        graph.vertex[9].Adj.add(new Edge(0,"鹿角虫A线",12,'b'));
        graph.vertex[9].Adj.add(new Edge(17,"鹿角虫A线",13,'b'));
        graph.vertex[10].Adj.add(new Edge(16,"鹿角虫B线",10,'b'));
        graph.vertex[12].Adj.add(new Edge(2,"鹿角虫C线",12,'b'));
        graph.vertex[12].Adj.add(new Edge(15,"鹿角虫C线",11,'b'));
        graph.vertex[15].Adj.add(new Edge(3,"鹿角虫B线",10,'b'));
        graph.vertex[15].Adj.add(new Edge(21,"鹿角虫B线",11,'b'));
        graph.vertex[15].Adj.add(new Edge(12,"鹿角虫C线",11,'b'));
        graph.vertex[15].Adj.add(new Edge(24,"鹿角虫C线",13,'b'));
        graph.vertex[16].Adj.add(new Edge(10,"鹿角虫B线",10,'b'));
        graph.vertex[16].Adj.add(new Edge(18,"鹿角虫B线",10,'b'));
        graph.vertex[17].Adj.add(new Edge(9,"鹿角虫A线",13,'b'));
        graph.vertex[17].Adj.add(new Edge(25,"鹿角虫A线",11,'b'));
        graph.vertex[18].Adj.add(new Edge(3,"鹿角虫B线",10,'b'));
        graph.vertex[18].Adj.add(new Edge(16,"鹿角虫B线",10,'b'));
        graph.vertex[20].Adj.add(new Edge(26,"鹿角虫A线",15,'b'));
        graph.vertex[21].Adj.add(new Edge(15,"鹿角虫B线",11,'b'));
        graph.vertex[24].Adj.add(new Edge(15,"鹿角虫C线",13,'b'));
        graph.vertex[25].Adj.add(new Edge(17,"鹿角虫A线",11,'b'));
        graph.vertex[25].Adj.add(new Edge(26,"鹿角虫A线",15,'b'));
        graph.vertex[26].Adj.add(new Edge(20,"鹿角虫A线",15,'b'));
        graph.vertex[26].Adj.add(new Edge(25,"鹿角虫A线",15,'b'));
    }

    public static void showLocation(){
        for (int i=0;i< name.length;i++){
            System.out.print(i+":"+name[i]+"\t");
            if (i%10==9){
                System.out.println();
            }
        }
        System.out.println();
    }
}
