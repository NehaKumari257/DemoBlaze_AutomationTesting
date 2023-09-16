package Testcases;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import Pages.LoginPage;
import Pages.ProductPurchase;

public class tc005ProductPurchase extends BaseClass {
    @Test
	public void productOrder() throws Exception {
		LoginPage lp=new LoginPage();
		lp.Clicklogin();
		lp.login("royneha257", "Nehakumari@12345");
		ProductPurchase pp=new ProductPurchase();
		pp.productOrder();
		Thread.sleep(5000);
		pp.fillDetails("Neha", "India", "Chennai", "1234567891234567", "12", "2027");
		
		
	}

}
