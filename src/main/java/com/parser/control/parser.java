package com.parser.control;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


/**
 * Created by brian-kamau on 6/10/17.
 */
public class parser {


    private String file;
    private final String school;
    private String unit;
    private XSSFWorkbook table;
    private XSSFSheet Sheet;
    private DataFormatter formatter;



    public parser(String file, String school,String unit) throws FileNotFoundException {
        this.file = file;
        this.school = school;
        this.unit=unit;
    }
        public void parse() throws Exception{
             FileInputStream str = new FileInputStream(new File(file));

            System.out.println("Opening File:: "+file);
            table = new XSSFWorkbook(str);
            int sheets = table.getNumberOfSheets();
            System.out.println("Sheets:"+sheets);
            System.out.println("School:"+school);
            System.out.println("Processing:"+unit);

            for(int i =0;i < sheets;i++){
                Sheet=table.getSheetAt(i);
                if(Sheet.getSheetName().toLowerCase().contains(school.toLowerCase())){
                    System.out.println("Sheet Found");
                    break;
                }else{
                    System.out.println("Sheet Not Found");
                    break;
                }

            }
        }
        public ArrayList<String> getDetails(String... unit) throws Exception{  /*Can Receive Multiple String Arguments*/
            ArrayList details = new ArrayList();

            boolean found;
            int row, col;
            for(String units : unit) {

                for (Row _row : Sheet) {
                    found=false;
                    for(Cell cell : _row){
                    String text=cell.getStringCellValue();
                        if(!(text==null) && text.toLowerCase().contains(units.toLowerCase())){
                            row=cell.getRowIndex();
                            col=cell.getColumnIndex();
                            System.out.println("Unit Found on:Row"+row+"\nColumn"+col);
                            details.add(row);
                            details.add(col);
                            break;
                        }


                    }

                }
            }
            return details;
        }
        private Date getDate(int row, int col) throws Exception{
            XSSFRow _row;
            XSSFCell cel;
            Calendar date = Calendar.getInstance();





            return date.getTime();
        }
}
