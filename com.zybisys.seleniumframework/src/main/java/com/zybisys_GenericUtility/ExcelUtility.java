package com.zybisys_GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * its developed using Apache POI libraries , which used to handle MicroSoft ExcelSheet 
 * @author Tulasiram
 *
 */
public class ExcelUtility {
	
	/**
	 * its used to read the data from excel based DOM below argument
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getDataFromExcel(String sheetName ,int rowNum ,int celNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(IPathConstants.EXCELFILE_PATH);
		Workbook book=WorkbookFactory.create(fis);
		DataFormatter format=new DataFormatter();
		String Data=format.formatCellValue(book.getSheet(sheetName).getRow(rowNum).getCell(celNum));
		return Data;
	}
	/**
	 * used to get the last row number on specific sheet
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(IPathConstants.EXCELFILE_PATH);
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet(sheetName);
		return sh.getLastRowNum();
	}
	public void setDataExcel(String sheetName , int rowNum , int cellNum , String Data) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(IPathConstants.EXCELFILE_PATH);
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet(sheetName);
		Row row=sh.getRow(rowNum);
		Cell cel=row.getCell(cellNum);
		cel.setCellValue(Data);
		FileOutputStream fos=new FileOutputStream(IPathConstants.EXCELFILE_PATH);
        book.write(fos);
        book.close();
	}
}
