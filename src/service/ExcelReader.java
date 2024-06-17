/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.ThuHoModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author MY PC
 */
public class ExcelReader {
    
   public ArrayList<ThuHoModel> readExcelFile() {
       //DefaultTableModel model= (DefaultTableModel) boq_jtable.getModel();
       ArrayList<ThuHoModel> data = new ArrayList<>();
       
        File excelFile;
        FileInputStream excelFIS = null;
        BufferedInputStream excelBIS = null;
        XSSFWorkbook excelImportToJTable = null;
        String defaultCurrentDirectoryPath = "C:\\Users\\MY PC\\Desktop";
        JFileChooser excelFileChooser = new JFileChooser(defaultCurrentDirectoryPath);
        excelFileChooser.setDialogTitle("Select Excel File");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
        excelFileChooser.setFileFilter(fnef);
        int excelChooser = excelFileChooser.showOpenDialog(null);
        if (excelChooser == JFileChooser.APPROVE_OPTION) {
            
            
            
            try {
                excelFile = excelFileChooser.getSelectedFile();
                //jExcelFilePath.setText(excelFile.toString());
                excelFIS = new FileInputStream(excelFile);                  
                excelBIS = new BufferedInputStream(excelFIS);                  
                excelImportToJTable = new XSSFWorkbook(excelBIS);                 
                XSSFSheet excelSheet = excelImportToJTable.getSheetAt(0);
                           
                for (int row = 0; row < excelSheet.getLastRowNum(); row++) {
                    
                    ThuHoModel thuho = new ThuHoModel();
                    XSSFRow excelRow = excelSheet.getRow(row);      
                    
                    XSSFCell soNha = excelRow.getCell(0);
                    thuho.setMahokhau((int)Double.parseDouble(String.valueOf(soNha))+"");
                    //rowData.add(String.valueOf(soNha));
                    
                    XSSFCell soTien = excelRow.getCell(1);
                    thuho.setSoTien((int)Double.parseDouble(String.valueOf(soTien)));
                    //rowData.add(String.valueOf(soTien.getNumericCellValue()));

                    XSSFCell suDung = excelRow.getCell(2);
                    thuho.setSuDung(String.valueOf(suDung));
                    //rowData.add(String.valueOf(suDung));

                    data.add(thuho);
                    
                   //model.addRow(new Object[]{excelLineNum, excelItemName, excelDescription, excelServiceDuration,excelQuantity});
                }
                JOptionPane.showMessageDialog(null, "Imported Successfully !!.....");
            } catch (IOException iOException) {
                JOptionPane.showMessageDialog(null, iOException.getMessage());
            } finally {
                try {
                    if (excelFIS != null) {
                        excelFIS.close();
                    }
                    if (excelBIS != null) {
                        excelBIS.close();
                    }
                    if (excelImportToJTable != null) {
                        excelImportToJTable.close();
                    }
                } catch (IOException iOException) {
                    JOptionPane.showMessageDialog(null, iOException.getMessage());
                }
            }
        }
        return data;
    } 
}