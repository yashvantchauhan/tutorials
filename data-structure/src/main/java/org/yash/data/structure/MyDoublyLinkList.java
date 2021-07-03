package org.yash.data.structure;

public class MyDoublyLinkList {

    Node head;
    Node tail;
    int length;

    public MyDoublyLinkList(){

    }

    public MyDoublyLinkList(Object value){
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

            tail = head;

            length++;
            return;
        }

        Node newNode=  new Node(value);



        tail.next=newNode;

        newNode.previous= tail;

        tail = newNode;

        tail.next= null;



        length++;
    }


    public void log(){
        Node itNode= head;
        while(itNode!=null){
            System.out.println(itNode.value);
            itNode= itNode.next;
        }
    }

    private static class Node
    {
        Object value;
        Node next;
        Node previous;

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


    }

    public static void main(String[] args) {
        MyDoublyLinkList myLinkList = new MyDoublyLinkList();

        myLinkList.append("apples");
        myLinkList.append("oranges");
        myLinkList.append("grapes");



        myLinkList.log();

      /*  myLinkList.insert(1, "banana");

        System.out.println("* After Insert **** ");
        myLinkList.log();

        myLinkList.prepend("mangoes");

        System.out.println("* After prepend **** ");
        myLinkList.log();*/
    }
}
