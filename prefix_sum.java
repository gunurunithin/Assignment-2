package Herovired_2;

import java.util.Scanner;

public class prefix_sum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int ps[]=new int[n];
        ps[0]=arr[0];
        System.out.print(ps[0]+" ");
        for(int i=1;i<n;i++){
            ps[i]=ps[i-1]+arr[i];
            System.out.print(ps[i]+" ");
        }

    }
}
