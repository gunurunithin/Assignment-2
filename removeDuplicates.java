package Herovired_2;

import java.util.ArrayList;
import java.util.Scanner;

class Node{
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next=null;
    }
}
public class removeDuplicates {
    public static Node insert(Node head,int k){
        Node j=new Node(k);
        if(head==null){
            head=j;
        }
        else {
            Node p=head;
            while (p.next!=null){
                p=p.next;
            }
            p.next=j;
        }
        return head;
    }
    public static Node duplicate(Node l1){
        ArrayList<Integer>A=new ArrayList<>();
        Node ptr=l1;
        Node prev = null;
        while (ptr.next!=null){
            if(!A.contains(ptr.data)){
                A.add(ptr.data);
                prev=ptr;
                ptr=ptr.next;
            }
            else{
                prev.next=ptr.next;
                ptr=prev.next;
            }
        }
        return l1;
    }
    private static void displayll(Node l1) {
        while(l1!=null){
            System.out.print(l1.data+" ");
            l1=l1.next;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Node l1=null;
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int k=sc.nextInt();
            l1=insert(l1,k);
        }
        displayll(l1);
        System.out.println();
        l1=duplicate(l1);

        displayll(l1);

    }


}
