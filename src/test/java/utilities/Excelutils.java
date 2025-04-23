package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutils {
	
	
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
    public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;
	public static String path;
	
	public Excelutils(String path)
	{
		this.path=path;
	}
	
	
	public static int getrowcount( String sheet1) throws IOException
	{
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(sheet1);
	    int rowcount=	ws.getLastRowNum();
	   fi.close();
	   wb.close();
	  return rowcount;
	  
	}
	public static int getcellcount( String sheet1,int rownum) throws IOException 
	{
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(sheet1);
	   row=ws.getRow(rownum);
	    int cellcount=  row.getLastCellNum();
	   
	   
	   fi.close();
	   wb.close();
	   
	   return cellcount;
	 
	 }
	
	public static String getcelldata( String sheet1,int rownum,int colnum) throws IOException
	{
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(sheet1);
	   row=ws.getRow(rownum);
	 cell=  row.getCell(colnum);
	 
	 
	 String  data;
	 
	   try
	   {
		   data=  cell.toString();
	   }
	   catch(Exception e)
	   {
		   data="";
	   }
	   fi.close();
	   wb.close();
	    
	   return data;
	  	
	  }
	
	public static void setcelldata( String sheet1,int rownum,int colnum,String data) throws IOException
	{
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(sheet1);
	   row=ws.getRow(rownum);
	   
	  cell= row.createCell(colnum);
	  cell.setCellValue(data);
	  fo = new FileOutputStream(path);
	  wb.write(fo);
	  wb.close();
	  fo.close();
	  fi.close();   
	   
	   
	}
	
	public static void fillGreenColour( String sheet1,int rownum,int colnum) throws IOException
	{
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(sheet1);
	   row=ws.getRow(rownum);
	   cell= row.getCell(colnum);
	   
	 style=  wb.createCellStyle();
	   
	 style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
	 style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	 
	 fo=new FileOutputStream(path);
	  wb.write(fo);
	  wb.close();
	  fo.close();
	  fi.close();
	
	}
	
	public static void fillredColour( String sheet1,int rownum,int colnum) throws IOException
	{
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(sheet1);
	   row=ws.getRow(rownum);
	   cell= row.getCell(colnum);
	   
	 style=  wb.createCellStyle();
	   
	 style.setFillForegroundColor(IndexedColors.RED.getIndex());
	 style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	 
	 fo=new FileOutputStream(path);
	  wb.write(fo);
	  wb.close();
	  fo.close();
	  fi.close();
	  
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
