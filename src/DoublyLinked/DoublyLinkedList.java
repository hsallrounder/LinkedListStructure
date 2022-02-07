package DoublyLinked;

import java.util.Scanner;

public class DoublyLinkedList {
    private int size;
    Node head,tail;

    public DoublyLinkedList() {
        this.size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void add(int val){
        Node newnode = new Node(val);
        if(isEmpty()){
            head = newnode;
        }
        else {
            Node temp = tail;
            newnode.prev=temp;
            temp.next=newnode;
        }
        tail=newnode;
        size++;
    }

    public void insertAtBeginning(int val){
        if(isEmpty()){
            add(val);
            return;
        }
        size++;
        Node newnode=new Node(val);
        newnode.next=head;
        head.prev=newnode;
        head=newnode;
    }

    public void insert(int pos,int val){
        if(isEmpty() || pos>=size){
            add(val);
        }
        else if(pos==1){
            insertAtBeginning(val);
        }
        else if(pos<1){
            System.out.println("Position starts from 1.");
        }
        else {
            Node newnode = new Node(val);
            Node temp = head;
            for (int i=1;i<pos-1;i++) {
                temp = temp.next;
            }
            newnode.next = temp.next;
            temp.next.prev=newnode.next.prev;
            temp.next = newnode;
            newnode.prev=temp;
            size++;
        }
    }

    public void delete(int val){
        if(isEmpty()){
            System.out.println("List is Empty.");
        }
        else{
            Node temp=head;
            if(temp.data==val){
                head=head.next;
                size--;
                return;
            }
            while (temp.next!=null && temp.next.data!=val){
                temp=temp.next;
            }
            if(temp.next==null){
                System.out.println("No such value present.");
            }
            else{
                temp.next.next.prev=temp;
                temp.next=temp.next.next;
                size--;
            }
        }
    }

    public void deleteAtIndex(int ind){
        if(isEmpty()){
            System.out.println("List is Empty.");
        }
        else if(ind>=size){
            System.out.println("Invalid input.");
        }
        else {
            Node temp=head;
            if(ind==0){
                head=head.next;
                head.prev=null;
            }
            else {
                for (int i = 1; i < ind; i++) {
                    temp = temp.next;
                }
                temp.next.next.prev=temp;
                temp.next=temp.next.next;
            }
            size--;
        }
    }

    public void display(){
        if(isEmpty()){
            System.out.println("List is Empty.");
        }
        else {
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.data+"->");
                temp=temp.next;
            }
            System.out.println("null");
        }
    }

    public void displayRev(){
        if(isEmpty()){
            System.out.println("List is Empty.");
        }
        else {
            Node temp=tail;
            while(temp!=null){
                System.out.print(temp.data+"->");
                temp=temp.prev;
            }
            System.out.println("null");
        }
    }
    public static void main(String[] args) {
        //List having name 'list' has been declared with size 0;
        DoublyLinkedList list = new DoublyLinkedList();
        //Functions can be implemented further.
    }
}
