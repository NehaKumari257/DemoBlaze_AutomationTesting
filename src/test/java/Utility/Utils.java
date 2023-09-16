package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
	
	public static WebDriver driver;
	public String sheetName;

	public static void launchUrl(String url) {
		
		try 
        {
          
          
         HttpURLConnection httpConnection = (HttpURLConnection) new URL(url).openConnection();
           
         httpConnection.setConnectTimeout(3000);
           
         httpConnection.connect();
           
           if(httpConnection.getResponseCode()==200)
           {
               System.out.println(url+" - "+httpConnection.getResponseMessage());
            }
          if(httpConnection.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)  
           {
               System.out.println(url+" - "+httpConnection.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
            }
        } catch (Exception e) {
           
        }
		
		driver.get(url);
	}

	public static String getpropvalue(String key) {
		String value = null;
		try {
			Properties prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "//config.properties");
			prop.load(ip);
			value = prop.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public static void browserLaunch(String browser) throws Exception {
		if (browser.equalsIgnoreCase("chrome")) {
			 driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			//WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("edge")) {
			//WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//driver.manage().window().fullscreen();

	}
	
	public void verifyLink(String url)
	{
        try 
        {
          
          
         HttpURLConnection httpConnection = (HttpURLConnection) new URL(url).openConnection();
           
         httpConnection.setConnectTimeout(3000);
           
         httpConnection.connect();
           
           if(httpConnection.getResponseCode()==200)
           {
               System.out.println(url+" - "+httpConnection.getResponseMessage());
            }
          if(httpConnection.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)  
           {
               System.out.println(url+" - "+httpConnection.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
            }
        } catch (Exception e) {
           
        }
    } 
	public static String getScreenshot(String testCaseName) throws Exception, IOException{
		String time=GetDateandTime();
		String path=System.getProperty("user.dir")+"/screenshot/"+testCaseName+time+".png";
		FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE),new File(path));
		return path;
	}
	
	public static String GetDateandTime() {
		DateFormat dateFormat = null;
		Date date = null;
		try {
			dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
			date = new Date();
		} catch (Exception e) {
			System.out.println("Error in Getdateandtime : " + e.getMessage());
		}

		return dateFormat.format(date);
	}
	
	
	public static Object[][] dataReader(String sheetName) throws Exception {
		String excelPath = System.getProperty("user.dir");
		XSSFWorkbook workBook = new XSSFWorkbook(excelPath + "/Excel/blazedemo1.xlsx");
		XSSFSheet sheet = workBook.getSheet(sheetName);
		int row = sheet.getPhysicalNumberOfRows();
		int column = sheet.getRow(0).getPhysicalNumberOfCells();
		Object[][] data = new Object[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				
				data[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		workBook.close();
		return data;
	}
	
	
	
	  public void waitForElement(WebElement ele, int timeout) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
				wait.until(ExpectedConditions.visibilityOf(ele));
				//wait.until(ExpectedConditions.elementToBeClickable(ele));
				
			} catch (Exception ex) {

				ex.printStackTrace();
			}

		}
       

	public void clickElement(WebElement element) {
		try {
			element.click();

							
		} catch (Exception e) {
			System.out.println("Error in clicking the webelement :" + e.getMessage());
			// test.log(Status.FAIL, "Failed to click the element :" + id);
		}

	}

	public boolean validateElement(WebElement element) {

		if (element.isDisplayed()) {
			
			return true;
			// test.log(Status.PASS, id + "is clicked ");
		}

		else
			return false;

	}
	public String textgetmethod(WebElement element) {
		
		return element.getText(); 
		
		
	}
	
	
	

}
