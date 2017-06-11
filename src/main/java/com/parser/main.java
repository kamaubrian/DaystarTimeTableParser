package com.parser;
import java.util.Scanner;
import com.parser.control.parser;
/**
 * Created by brian-kamau on 6/10/17.
 */
public class main {
    public main(){
        super();
    }


    public static void main(String []args){
        String path;
        String unit;
        String school; //Sheet Either Athi-River/ Nairobi.

        System.out.println("***************\nTimeTableParser\n***************");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Path to Excel Timetable File");
        path=scanner.nextLine();
        System.out.println("Enter Unit Name");
        unit=scanner.nextLine();
        System.out.println("Enter Campus[Athi Or Nairobi]");
        school=scanner.nextLine();

        try{
            parser par = new parser(path,unit,school);
            par.parse();

        }catch(Exception ex){
            System.out.println(ex.getClass());
            ex.printStackTrace();
        }

    }


}
