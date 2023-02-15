package Herovired_2;

import java.util.Scanner;
import java.io.*;

class ResidentialSociety{
    String societyName;
    String location;
    String SecretoryName;

    void ViewDetails(){
        System.out.println("societyName : "+societyName);
        System.out.println("location : "+location);
        System.out.println("SecretoryName : "+SecretoryName);
    }
}
class Buildings extends ResidentialSociety{
    String buildingName;
    int totalNumberOfApartments;

    public Buildings(String buildingName) {
        this.buildingName = buildingName;
    }

    public Buildings(int totalNumberOfApartments) {
        this.totalNumberOfApartments = totalNumberOfApartments;
    }
}
class Apartment extends Buildings{
    int apartmentNumber;
    String ownerName;
    String electricMeterNumber;

    public Apartment(int apartmentNumber,String buildingName,String ownerName, String electricMeterNumber) {
        super(buildingName);
        this.apartmentNumber = apartmentNumber;
        this.ownerName = ownerName;
        this.electricMeterNumber = electricMeterNumber;
    }
}

public class CSV_task4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        ResidentialSociety RS = new ResidentialSociety();
        RS.societyName = "Galaxy_Apartment";
        RS.location ="Banjara Hills, Hyderabad";
        RS.SecretoryName = "Rajesh";
        ResidentialSociety r1=new ResidentialSociety();

        Buildings b1=new Buildings(10);
        Buildings b2=new Buildings(10);
        Buildings b3=new Buildings(10);

        Apartment a1[]=new Apartment[10];
        Apartment a2[]=new Apartment[10];
        Apartment a3[]=new Apartment[10];


        try{
            BufferedReader br=new BufferedReader(new FileReader("Details.csv"));
            String newline;
            int cnt=0;
            int i=0;
            while ((newline=br.readLine())!=null){
                String a[]=newline.split(",");
                if(cnt%10==0)
                    i=0;
                if(cnt<10){
                    a1[i]=new Apartment(Integer.parseInt(a[0]),a[1],a[2],a[3]);
                } else if (cnt<20) {
                    a2[i]=new Apartment(Integer.parseInt(a[0]),a[1],a[2],a[3]);
                }else if (cnt<30) {
                    a3[i]=new Apartment(Integer.parseInt(a[0]),a[1],a[2],a[3]);
                }
                i++;
                cnt++;
            }
            while(true){
                display();
                int n=sc.nextInt();
                sc.nextLine();
                if(n==1){
                    for(int j=0;j<10;j++){
                        System.out.println(a1[j].apartmentNumber+" "+a1[j].buildingName+" "+a1[j].ownerName+" "+a1[j].electricMeterNumber
                        );
                    }
                    for(int j=0;j<10;j++){
                        System.out.println(a2[j].apartmentNumber+" "+a2[j].buildingName+" "+a2[j].ownerName+" "+a2[j].electricMeterNumber
                        );
                    }
                    for(int j=0;j<10;j++){
                        System.out.println(a3[j].apartmentNumber+" "+a3[j].buildingName+" "+a3[j].ownerName+" "+a3[j].electricMeterNumber
                        );
                    }
                }
                else if(n==2){
                    System.out.println("Building a1");
                    System.out.println("Building a2");
                    System.out.println("Building a3");
                }
                else if(n==3){
                    RS.ViewDetails();
                    System.out.println("Enter 1 to continue : ");
                    char ch=sc.nextLine().charAt(0);
                    if(ch=='1'){
                        continue;
                    }
                    else System.exit(0);
                }

            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void display(){
        System.out.println("1. Show Apartment details");
        System.out.println("2. Show Building Details");
        System.out.println("3. Show Society Details");
        System.out.println("Select the option");

    }
}
