package com.parser.control;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;

/**
 * Created by brian-kamau on 6/10/17.
 */
public class parser {


    private String file;
    private String school;
    private String unit;
    private XSSFWorkbook table;
    private XSSFSheet Sheet;

    public parser(String file, String school,String unit) {
        this.file = file;
        this.school = school;
        this.unit=unit;
    }
        public void parse() throws Exception{
            System.out.println("Opening File:: "+file);
            FileInputStream str = new FileInputStream(new File(file));
            table = new XSSFWorkbook(str);
            int sheets = table.getNumberOfSheets();
            System.out.println("Sheets:"+sheets);
        }

}
