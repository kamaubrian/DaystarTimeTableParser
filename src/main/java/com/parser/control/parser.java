package com.parser.control;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


/**
 * Created by brian-kamau on 6/10/17.
 */
public class parser {


    private String file;
    private String school;
    private String unit;
    private XSSFWorkbook table;
    private XSSFSheet Sheet;



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
            boolean schol = true;
            for(int i =0;i < sheets;i++){
                Sheet=table.getSheetAt(i);
                Sheet = table.getSheetAt(i);
                if(Sheet.getSheetName().toLowerCase().contains(school.toLowerCase())){
                    schol= true;
               }

            }


        }
        private static int findRow(XSSFSheet sheet, String cellCont){
            int rownum=0;
            for(Row row : sheet){
                for(Cell cell : row){
                    if (cell.getCellType() ==Cell.CELL_TYPE_STRING){
                        if(cell.getRichStringCellValue().getString().trim()==cellCont){
                            return row.getRowNum();
                        }
                    }
                }
            }
            return 0;
        }


}
