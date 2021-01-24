import java.util.ArrayList;

public class BeamSearch {
    /*树结构*/
    public static class Decision_Tree{
        Node root;
        public Decision_Tree(){
            this.root = new Node("",1);	//初始概率为1
        }
    }
    /*节点结构*/
    public static class Node{
        String name;
        double probability;
        ArrayList<Node> choice = new ArrayList<>();	//该点可供的选项
        public Node(String name,double value){
            this.name = name;
            this.probability = value;
        }
        public void add(String name,double value){	//添加选项
            Node node = new Node(this.name+"→"+name,value);
            this.choice.add(node);
        }
    }


    public static void beamSearch(Node root,int k){
        double[] prob = null;	//用于保存最大的概率及对应的选法的数组
        Node[] nodes = null;
        Node node = root;
        while(node != null){	//循环直至叶子节点
            double[] tempMax = new double[k];	//用于保存当前概率最大的选项
            Node[] tempNode = new Node[k];
            if (nodes == null){	//第一次循环
                for (int j = 0; j < root.choice.size(); j++) {
                    node = root.choice.get(j);
                    double temp = node.probability;
                    if (temp > tempMax[k-1]) {	//如果比保存的选项中概率最小的大，就将其保存并删去概率最小的那个选项
                        insertSort(tempMax,tempNode,node,temp);
                    }
                }
            }
            else {	//不是第一次循环
                for (int i = 0; i < k; i++) {
                    node = nodes[i];	//之前保存的概率最大的节点
                    double prevP = prob[i];	//相应的概率
                    if (node == null){	//如果节点为空，说明之前一个循环时k个分支未填满，当前循环中所有可能性已考虑完毕，直接进入下一个循环
                        node = nodes[0];
                        break;
                    }
                    else if (node.choice.size()==0){	//已经是叶子节点
                        System.out.println(node.name+" "+prevP);	//输出选项以及其概率
                        node = null;
                        continue;
                    }
                    for (int j = 0; j < node.choice.size(); j++) {	//遍历该节点下所有可能选项
                        double temp = node.choice.get(j).probability * prevP;
                        if (temp > tempMax[k-1]) {
                            insertSort(tempMax,tempNode,node.choice.get(j),temp);
                        }
                    }
                }
            }
            prob = tempMax;
            nodes = tempNode;
        }
    }

    public static void insertSort(double[] tempMax,Node[] nodes,Node choice,double probability){//插入排序
        int pos = tempMax.length-2;
        while(pos >= 0 && tempMax[pos] < probability){
            tempMax[pos+1] = tempMax[pos];
            nodes[pos+1] = nodes[pos];
            pos--;
        }
        pos++;
        tempMax[pos] = probability;
        nodes[pos] = choice;
    }

    public static void main(String[] args){
        Decision_Tree tree = new Decision_Tree();
        Node node = tree.root;
        Node temp = null;
        node.add("A",0.6);
        node.add("B",0.3);
        node.add("C",0.1);
        node = node.choice.get(0);
        temp = tree.root.choice.get(0);
        node.add("A",0.2);
        node.add("B",0.7);
        node.add("C",0.1);
        node = temp.choice.get(0);
        node.add("A",0.4);
        node.add("B",0.5);
        node.add("C",0.3);
        node = temp.choice.get(1);
        node.add("A",0.1);
        node.add("B",0.7);
        node.add("C",0.9);
        node = temp.choice.get(2);
        node.add("A",0.6);
        node.add("B",0.1);
        node.add("C",0.8);

        temp = tree.root.choice.get(1);
        temp.add("A",0.5);
        temp.add("B",0.2);
        temp.add("C",0.4);
        node = temp.choice.get(0);
        node.add("A",0.2);
        node.add("B",0.4);
        node.add("C",0.3);
        node = temp.choice.get(1);
        node.add("A",0.7);
        node.add("B",0.2);
        node.add("C",0.3);
        node = temp.choice.get(2);
        node.add("A",0.5);
        node.add("B",0.9);
        node.add("C",0.7);

        temp = tree.root.choice.get(2);
        temp.add("A",0.4);
        temp.add("B",0.8);
        temp.add("C",0.3);
        node = temp.choice.get(0);
        node.add("A",0.2);
        node.add("B",0.4);
        node.add("C",0.3);
        node = temp.choice.get(1);
        node.add("A",0.3);
        node.add("B",0.9);
        node.add("C",0.7);
        node = temp.choice.get(2);
        node.add("A",0.5);
        node.add("B",0.6);
        node.add("C",0.2);

        beamSearch(tree.root,3);
    }
}
