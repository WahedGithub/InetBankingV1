package com.inetbanking.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;


//This file if from Pavan this one is also giving java.lang.RuntimeException: java.lang.NoSuchMethodError:
public class XLUtils2 {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRowCount(String xlfile, String xlsheet) throws Exception
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		int rowcount=ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
		
	}
	
	public static int getCellCount(String xlfile, String xlsheet, int rownum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row= ws.getRow(rownum);
		int cellcount=row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
		
	}
	
	public static String getCellData(String xlfile, String xlsheet, int rownum, int colnum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row= ws.getRow(rownum);
		cell=row.getCell(colnum);
		String data;
		
		try {
			DataFormatter formatter = new DataFormatter();
			String cellData= formatter.formatCellValue(cell);
			return cellData;
		}
		catch(Exception e)
		{
			data="";
		}
		wb.close();
		fi.close();
		return data;
		
	}
	
	public static void setCellData(String xlfile, String xlsheet, int rownum, int colnum, String data) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row= ws.getRow(rownum);
		cell=row.getCell(colnum);
		fo=new FileOutputStream(xlfile);
		wb.write(fo);;
		wb.close();
		fi.close();
		fo.close();
		
	}
	
}
