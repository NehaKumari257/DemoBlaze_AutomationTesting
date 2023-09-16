package BaseClass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import Utility.Utils;

public class BaseClass extends Utils{
	
	@BeforeMethod
	public void start() throws Exception {
		
		browserLaunch(getpropvalue("browser"));
		launchUrl(getpropvalue("url"));
		driver.manage().window().maximize();
	
	}
	
	@DataProvider
	public Object[][] getExcelData() throws Exception{
		Object[][] data = dataReader(sheetName);
		return data;
	}
    
		
	@AfterMethod
	public void closeUp() throws Exception {
		
		//Thread.sleep(7);
		//driver.quit();

}

}
