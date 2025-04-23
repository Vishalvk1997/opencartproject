package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Dataprovider
{
    @DataProvider(name="logindata")
	public String[][] getdata() throws IOException 
	{
		String path = ".//Testdata//logindata.xlsx";

		Excelutils xlutil = new Excelutils(path);
		int totalrows = xlutil.getrowcount("sheet1");
		int totalcol = xlutil.getcellcount("sheet1", 1);
		String logindata[][] = new String[totalrows][totalcol];

		for (int i = 1; i < totalrows; i++) 
		{
			for (int j = 0; i < totalcol; i++)
			{
				logindata[1 - i][j] = xlutil.getcelldata(path, i, j);
			}
		}
		return logindata;
	}

}
