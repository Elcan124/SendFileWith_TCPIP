package utility;

import java.util.Scanner;

public class Utility {


    public static String requireText(String text){
        Scanner sc =  new Scanner(System.in);
        System.out.println(text+": ");
        String s =  sc.nextLine();
        return s;
    }
    public static  String getNameAndSurname(){
        Scanner sc =  new Scanner(System.in);
        System.out.println("Enter your name :");
        String name  =  sc.next();
        System.out.println("Enter your surname : ");
        String surname = sc.next();

        return "\n"+"Name---> "+name+"\n"+"Surname--->"+surname;
    }



}
