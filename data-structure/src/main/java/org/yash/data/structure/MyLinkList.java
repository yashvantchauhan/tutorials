package org.yash.data.structure;

public class MyLinkList {

    Node head;
    Node tail;
    int length;

    public MyLinkList(){

    }

    public MyLinkList(Object value){
        head= new Node();
        head.value= value;

        tail =head;
    }

    public void insert(int index, Object value){
        Node node= new Node(value);

        int currentIndex=0;
        Node currentNode=head;
        while(currentIndex!=index-1){

            currentNode= currentNode.next;
            currentIndex++;
        }

        Node previousNextNode= currentNode.next;

        currentNode.next= node;
        node.next=   previousNextNode;

/*        Node currentNode= head;
        Node previousNode= currentNode;
        while(currentNode!=null){

            if(currentIndex == index){
                previousNode.next=node;

                node.next=currentNode;
                break;
            }
            previousNode = currentNode;
            currentIndex++;
            currentNode= currentNode.next;
        }*/
    }

    public void prepend(Object value){
        Node node= new Node(value);

        node.next=head;

        head= node;
    }

    public void append(Object value){

        if (head == null) {
            head = new Node();
            head.value = value;
            head.next = null;

            tail = head;

            length++;
            return;
        }


        tail.next = new Node();
        tail.next.value = value;

        tail = tail.next;

        length++;
    }


    public void log(){
        Node itNode= head;
        while(itNode!=null){
            System.out.println(itNode);
            itNode= itNode.next;
        }
    }

    private static class Node
    {
        Object value;
        Node next;

        public Node(){

        }

        public Node(Object value){
            this.value=value;

        }
        public void setNext(Node node){
            this.next= node;
        }
        public Node getNext(){
            return next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        MyLinkList myLinkList = new MyLinkList();

        myLinkList.append("apples");
        myLinkList.append("oranges");
        myLinkList.append("grapes");



        myLinkList.log();

        myLinkList.insert(1, "banana");

        System.out.println("* After Insert **** ");
        myLinkList.log();

        myLinkList.prepend("mangoes");

        System.out.println("* After prepend **** ");
        myLinkList.log();
    }
}
