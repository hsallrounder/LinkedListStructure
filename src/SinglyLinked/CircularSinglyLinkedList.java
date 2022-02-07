package SinglyLinked;

import java.util.Scanner;

public class CircularSinglyLinkedList {
    private int size;
    Node head;

    public CircularSinglyLinkedList() {
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
            while(temp.next!=head) {
                temp = temp.next;
            }
            temp.next=newnode;
        }
        newnode.next=head;
        size++;
    }

    public void insertAtBeginning(int val){
        if(isEmpty()){
            add(val);
            return;
        }
        size++;
        Node newnode=new Node(val);
        Node temp=head;
        while(temp.next!=head){
            temp=temp.next;
        }
        temp.next=newnode;
        newnode.next=head;
        head=newnode;
    }

    public void insert(int pos,int val){
        if(pos>size) {
            if(pos%size==0){
                pos=size;
            }
            else {
                pos = pos % size;
            }
        }
        if(isEmpty()){
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
                size--;
                return;
            }
            while (temp.next!=head && temp.next.data!=val){
                temp=temp.next;
            }
            if(temp.next==head){
                System.out.println("No such value present.");
            }
            else{
                temp.next=temp.next.next;
                size--;
            }
        }
    }

    public void deleteAtIndex(int ind){
        if(ind>size) {
            if(ind%size==0){
                ind=size;
            }
            else {
                ind=ind % size;
            }
        }
        if(isEmpty()){
            System.out.println("List is Empty.");
        }
        else {
            Node temp=head;
            if(ind==0){
                head=head.next;
            }
            else {
                for (int i = 1; i < ind; i++) {
                    temp = temp.next;
                }
                temp.next=temp.next.next;
            }
        }
        size--;
    }

    public void display(){
        if(isEmpty()){
            System.out.println("List is Empty.");
        }
        else {
            Node temp=head;
            while(temp.next!=head){
                System.out.print(temp.data+"->");
                temp=temp.next;
            }
            System.out.println(temp.data+"->first-element");
        }
    }

    public static void main(String[] args) {
        //List having name 'list' has been declared with size 0;
        CircularSinglyLinkedList list = new CircularSinglyLinkedList();
        //Functions can be implemented further.
    }
}
