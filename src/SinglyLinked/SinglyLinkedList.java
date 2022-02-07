package SinglyLinked;

import java.util.Scanner;

public class SinglyLinkedList {
    private int size;
    Node head;

    public SinglyLinkedList() {
        this.size=0;
    }

    public int getSize() {
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
            Node temp = head;
            while(temp.next!=null) {
                temp = temp.next;
            }
            temp.next=newnode;
        }
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
        head=newnode;
    }

    public void insert(int pos,int val){
        size++;
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
            temp.next = newnode;
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
                return;
            }
            while (temp.next!=null && temp.next.data!=val){
                temp=temp.next;
            }
            if(temp.next==null){
                System.out.println("No such value present.");
            }
            else{
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
            }
            else {
                for (int i = 1; i<ind; i++) {
                    temp = temp.next;
                }
                temp.next=temp.next.next;
            }
        }
        size--;
    }

    public void deleteAtIndex(){
        Scanner sc = new Scanner(System.in);
        int ind = sc.nextInt();
        sc.close();
        deleteAtIndex(ind);
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

    public static void main(String[] args) {
        //List having name 'list' has been declared with size 0;
        SinglyLinkedList list = new SinglyLinkedList();
        //Functions can be implemented further.
    }
}
