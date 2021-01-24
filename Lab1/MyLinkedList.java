class MyLinkedList {
    LinkedNode head;    //头指针
    LinkedNode tail;    //尾指针
    int length;     //计数器
    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index<0||index>this.length-1) return -1;    //无效序号
        else if(index==this.length-1) return this.tail.val; //直接获取链表尾部数据
        LinkedNode temp = this.head;
        for (int i=0;i<index;i++){  //借助循环找到对应结点
            temp = temp.next;
        }
        return temp.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        LinkedNode node = new LinkedNode(val);  //创建结点
        if (this.length == 0){  //如果链表为空时，尾指针指向该结点
            this.tail = node;
        }
        else {
            node.next = this.head;  //链到头部
        }
        this.head = node;   //修改头指针
        this.length++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        LinkedNode node = new LinkedNode(val);  //创建结点
        if (this.length == 0){  //如果链表为空时，头指针指向该结点
            this.head = node;
        }
        else {
            this.tail.next = node;  //结点链到尾部
        }
        this.tail = node;   //修改尾指针
        this.length++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index<0||index>this.length){  //无效序号
            System.out.println("Invalid index.");
            return;
        }
        else if(index==0){  //插在头部
            this.addAtHead(val);
            return;
        }
        else if (index==this.length){   //插入尾部
            this.addAtTail(val);
            return;
        }
        else {
            LinkedNode temp = this.head;
            for (int i = 0; i < index-1; i++) { //循环找到对应序号的前一个结点
                temp = temp.next;
            }
            LinkedNode node = new LinkedNode(val,temp.next);    //创建结点
            temp.next = node;   //连接
            this.length++;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index<0||index>this.length-1){  //无效序号
            System.out.println("Invalid index.");
            return;
        }
        if (this.length==1){    //修改头尾指针
            this.head = null;
            this.tail = null;
        }
        else if(index==0){  //修改头指针
            this.head = this.head.next;
        }
        else {
            LinkedNode temp = this.head;
            for (int i=0;i<index-1;i++){    //循环找到对应序号的前一个结点
                temp = temp.next;
            }
            if (index==this.length-1){  //修改尾指针
                this.tail = temp.next;
            }
            else {  //修改链表
                temp.next = temp.next.next;
            }
        }
        this.length--;
    }

    public class LinkedNode{    //结点定义
        int val;
        LinkedNode next;
        public LinkedNode(int val){
            this(val,null);
        }
        public  LinkedNode(int val, LinkedNode node){
            this.val = val;
            this.next = node;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 **/