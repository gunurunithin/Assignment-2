package Tasks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

class Node{
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next=null;
    }
}
public class mergeSort {
    public static Node insert(Node head, int k){
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
    public static Node merge(Node l1,Node l2){
        Node p=l1;
        Node q=l2;
        ArrayList<Integer>A=new ArrayList<>();
        while (p.next!=null){
            A.add(p.data);
            p=p.next;
        }
        A.add(p.data);
        while (q!=null){
            A.add(q.data);
            q=q.next;
        }
        Collections.sort(A);
        p.next=l2;
        Node ptr=l1;
        for(int i=0;i<A.size();i++){
            ptr.data=A.get(i);
            ptr=ptr.next;
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
        Node l2=null;

        int n=sc.nextInt();
        for(int i=0;i<n;i++) {
            int k = sc.nextInt();
            l1 = insert(l1, k);
        }

        int m=sc.nextInt();
        for(int i=0;i<m;i++){
            int k=sc.nextInt();
            l2=insert(l2,k);
        }

        l1=merge(l1,l2);
        displayll(l1);

    }


}
