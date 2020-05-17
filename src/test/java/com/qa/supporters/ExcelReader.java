package com.qa.supporters;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader  
{

	private String filepath;
	private FileInputStream fip;
	private Workbook workbook;
	private Sheet sheet;
	private Row row;
	private Cell cell;
	private String cellValue;
	private FileOutputStream fout;
	
	public ExcelReader(String filepath) throws EncryptedDocumentException, IOException, InvalidFormatException
	{
	  this.filepath	= filepath;
	  fip = new FileInputStream(filepath);  
	  workbook = WorkbookFactory.create(fip);
	  Optional optional = Optional.ofNullable(workbook);
	  if(optional.isPresent())
	  {
		  // Don't do any thing
	  }
	  
	  else
	  {
		  System.out.println("Workbook is not available");
	  }
	  
	}
	
	
	public Sheet getSheetObj(String sheetName)
	{
		sheet = workbook.getSheet(sheetName);
		return sheet;	
	}
	
	
	public Sheet getSheetObj(int index)
	{
		sheet = workbook.getSheetAt(index);
		return sheet;	
	}
	
	
	@SuppressWarnings("deprecation")
	public String getSingleCellData(String sheetName, int rowNum, int cellNum) 
	{
		
		sheet = getSheetObj(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		
		if(cell.getCellType() == CellType.STRING)
		{
			cellValue = cell.getStringCellValue();
		}
		
		else if(cell.getCellType() == CellType.NUMERIC)
		{
			cellValue = cell.getNumericCellValue()+"";
		}
		
		else if(cell.getCellType() == CellType.BOOLEAN)
		{
			cellValue = cell.getBooleanCellValue()+"";
		}
		
		return cellValue;
	
	}
	
	
	@SuppressWarnings("deprecation")
	public List<String> getSingleRowData(String sheetName, int rowNum)
	{
		List<String> sheetData = new ArrayList<String>(); 
		sheet = getSheetObj(sheetName);

		row = sheet.getRow(rowNum);
			
			for(int j=0; j<row.getLastCellNum();j++)
			{
			  cell = row.getCell(j);

			  if(cell.getCellType() == CellType.STRING)
			  {
				cellValue = cell.getStringCellValue();		
			  }
			
			  else if(cell.getCellType() == CellType.NUMERIC)
			  {
				cellValue = cell.getNumericCellValue()+"";	
			  }
			
			  else if(cell.getCellType() == CellType.BOOLEAN)
			  {
				cellValue = cell.getBooleanCellValue()+"";
			  }
			  sheetData.add(cellValue);	
		}
			
      	return sheetData;
		
	}
	
	
	
	@SuppressWarnings("deprecation")
	public List<String> getTotalSheetData(String sheetName)
	{
		
		List<String> sheetData = new ArrayList<String>(); 
		
		sheet = getSheetObj(sheetName);
		
		for(int i=0; i<=sheet.getLastRowNum();i++)
		{
			row = sheet.getRow(i);
			
			for(int j=0; j<row.getLastCellNum();j++)
			{
				cell = row.getCell(j);
				
				if(cell.getCellType() == CellType.STRING)
				{
					cellValue = cell.getStringCellValue();
				}
				
				else if(cell.getCellType() == CellType.NUMERIC)
				{
					cellValue = cell.getNumericCellValue()+"";
				}
				
				else if(cell.getCellType() == CellType.BOOLEAN)
				{
					cellValue = cell.getBooleanCellValue()+"";
				}
				sheetData.add(cellValue);
			}
			
		}
		return sheetData;
		
	}
	
	public Set<String> getUniqueData(String sheetName)
	{
		List<String> data = getTotalSheetData(sheetName);
		Set<String> uniquedata = new LinkedHashSet<String>(data);
		return uniquedata;
		
	}
	
	
	public int findOccurancesOfaWord(String sheetName, String word)
	{
		int count = 0;
		List<String> data = getTotalSheetData(sheetName);		
		for(String ele : data)
		{
			if(ele.equalsIgnoreCase(word))
			{
			  count++;
			}
		}
		return count;
		
	}

	
	public String writeData(String sheetName, int rowNum, int cellNum, String tcName) throws IOException
	{
		sheet = getSheetObj(sheetName);
		row  = sheet.createRow(rowNum);
		cell = row.createCell(cellNum);
		cell.setCellValue(tcName);
		fout = new FileOutputStream(filepath);
		workbook.write(fout);
		
		return tcName;
		
	}
	
	
	
	
	public String writeDataTwo(String sheetName, int rowNum, int cellNum, String tcName) throws IOException
	{
		sheet = getSheetObj(sheetName);
		row  = sheet.createRow(rowNum);
		cell = row.createCell(cellNum);
		cell.setCellValue(tcName);
		fout = new FileOutputStream(filepath);
		workbook.write(fout);
		
		return tcName;
		
	}
	
	
	/*public static void main(String[] args) throws EncryptedDocumentException, IOException, InvalidFormatException 
	{
		ExcelReader excelReader = new ExcelReader("E:\\E_EclipseWorkSpace\\CucumberJVMReporting\\src\\test\\java\\com\\qa\\datadriven\\TestData.xlsx");
        System.out.println(excelReader.getSingleCellData("Java",1, 1));
        System.out.println("================");
        System.out.println(excelReader.getTotalSheetData("Spring"));
        System.out.println("================");
        System.out.println(excelReader.getSingleRowData("Java",0));
        System.out.println("================");
        Set<String> dataa = excelReader.getUniqueData("Spring");
        System.out.println(dataa);
        System.out.println("================");
        System.out.println(excelReader.findOccurancesOfaWord("Spring","work"));
        System.out.println("================");
        
        
		System.out.println("================");
        String namee = excelReader.writeData("TCName",0,3,"Swiss");
        System.out.println(namee);
         
	}
*/
}
