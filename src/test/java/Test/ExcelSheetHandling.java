package Test;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelSheetHandling{

    public void readData(String path,String sheetName) throws IOException {
        FileInputStream file=new FileInputStream(System.getProperty("user.dir")+path);
        XSSFWorkbook workbook=new XSSFWorkbook(file);
        XSSFSheet sheet=workbook.getSheet(sheetName);
        int totalRows=sheet.getLastRowNum();
        int totalCells=sheet.getRow(1).getLastCellNum();
        System.out.println("Total rows: "+totalRows);
        System.out.println("Total cells: "+totalCells);
        for(int r=0;r<=totalRows;r++){
            XSSFRow currentRow=sheet.getRow(r);
            for(int c=0;c<totalCells;c++){
                //XSSFCell currentCell=currentRow.getCell(c);
                //String cellValue=currentCell.toString();
                String cellValue=sheet.getRow(r).getCell(c).toString();
                System.out.print("\t"+cellValue+"\t");
            }
            System.out.print('\n');
        }
        //Memory will clear
        workbook.close();
        file.close();
    }


    @Test(enabled = false)
    public void readFromExcel() throws IOException {
        //Day 32|00:00:00
        FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"//testdata/Book.xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook(file);
        XSSFSheet sheet=workbook.getSheet("Sheet1");
        int totalRows=sheet.getLastRowNum();
        int totalCells=sheet.getRow(1).getLastCellNum();
        System.out.println("Total rows: "+totalRows);
        System.out.println("Total cells: "+totalCells);
        for(int r=0;r<=totalRows;r++){
            XSSFRow currentRow=sheet.getRow(r);
            for(int c=0;c<totalCells;c++){
                //XSSFCell currentCell=currentRow.getCell(c);
                //String cellValue=currentCell.toString();
                String cellValue=sheet.getRow(r).getCell(c).toString();
                System.out.print("\t"+cellValue+"\t");
            }
            System.out.print('\n');
        }
    //Memory will clear
        workbook.close();
        file.close();
    }

    @Test(enabled = false)
    public void writeToExcel() throws IOException {
        //Day 32|00:50:00
        String path="//testdata/myFile.xlsx";
        String sheetName="Sheet5";
        FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+path);
        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet=workbook.createSheet(sheetName);
        /*XSSFCell cell=sheet.createRow(0).createCell(1);
        cell.setCellValue("Welcome");*/
        XSSFRow row1= sheet.createRow(0);
        XSSFRow row2= sheet.createRow(1);
        row1.createCell(0).setCellValue("A1_Text");
        row1.createCell(1).setCellValue("B1_Text");
        row2.createCell(0).setCellValue("A2_Text");
        row2.createCell(1).setCellValue("B2_Text");

        workbook.write(file);
        workbook.close();
        file.close();
        System.out.println("Writing is done..!!");
    //Showing the written data
        readData(path,sheetName);


    }
}
