package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException
	{
		String path = System.getProperty("user.dir")+"\\testData\\Login_Data2.xlsx"; // taking excel file from testdata
		//String path = ".\\testData\\Logindata.xlsx";
		
		ExcelUtility xlutil = new ExcelUtility(path); // creating an object for xlutil
				
		// find total Number of rows and columns in excel sheet
		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcells = xlutil.getCellCount("Sheet1", 1);
		
		// create two dimensional array to store data from excel sheet
		String logindata [][] = new String[totalrows][totalcells];
		
		for(int i = 1;i<=totalrows;i++) //1    // rows
		{
			for(int j = 0;j<totalcells;j++) // 0  // cells
			{
				logindata[i-1][j] = xlutil.getCellData("Sheet1", i, j); // why [i-1] bcoz i  start from 1 but array index start from 0
			}
			
		}
		
		
		return logindata; // return two dimensional Array 
		
	}
	
	
	// DataProvider 2
	/*
	
	@DataProvider(name = "register_Data")
	public String[][] getdata() throws IOException
	{
		String path = System.getProperty("user.dir")+"\\testData\\Logindata";
		
		ExcelUtility xlutil = new ExcelUtility(path);
		
		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcells = xlutil.getCellCount("Sheet1",1);
		
		
		// two dimensional array
		
		String register_data[][] = new String[totalrows][totalcells];
		
		for(int i = 1;i<=totalrows;i++)
		{
			for(int j = 0;j<totalcells;j++)
			{
				register_data[i-1][j] = xlutil.getCellData("Sheet1", i, j);
			}
		}
		
		return register_data;
				
	}
	*/
	
	/*
	
	// Data Provider 3
	
	@DataProvider(name = "rd")
	public String [][] readData() throws IOException
	{
		String path = System.getProperty("user.dir")+"\\testData\\Login_Data2";
		
		ExcelUtility xlutil = new ExcelUtility(path);
		
		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcells = xlutil.getCellCount("Sheet1", 0);
		
		// two dimensional array
		
		String logindata [][] = new String[totalrows][totalcells];
		
		
		for(int i = 1;i<=totalrows;i++)
		{
			for(int j = 0;j<totalcells;j++)
			{
				logindata[i-1][j] = xlutil.getCellData("Sheet1", i, j);
			}
		}
	
		return logindata;
	
	
	}
	
	/*
	// data provider 4
	
	/*
	@DataProvider(name = "Logindata")
	public String[][] Logindata() throws IOException
	{
		String path = System.getProperty("user.dir")+"\\testData\\LoginData2";
		
		ExcelUtility xlutil = new ExcelUtility(path);
		
		int rows = xlutil.getRowCount("Sheet1");
		int cells = xlutil.getCellCount("Sheet1", 0);	
		
		//Two dimensional array
		
		String [][] logindata = new String[rows][cells];
		
		for(int i = 1;i<=rows;i++)
		{
			for(int j = 0;j<cells;j++)
			{
				logindata[i-1][j] = xlutil.getCellData("Sheet1", i, j);
			}
		}
		
		return logindata;
		
	
	}
    */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
}
