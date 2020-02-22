package com.tc;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCart {
	
	WebDriver driver;
	
	@BeforeMethod
	public void Setup() {
	System.setProperty("webdriver.chrome.driver", "D:\\QaTestProject\\TestMGfw_Proj_Batch_8\\src\\test\\java\\config\\chromedriver.exe");
	
	driver=new ChromeDriver();
	
	driver.get("http://demo.cs-cart.com/");
	driver.manage().window().maximize();
	
	}
	@Test(enabled=false)
	public void searchProduct()
	{
		WebElement txtSearxhBox=driver.findElement(By.xpath("//*[@name='hint_q']"));
		WebElement btnSearch= driver.findElement(By.xpath("//*[@title='Search']"));
	
		txtSearxhBox.sendKeys("Mobile");
		btnSearch.click();
		
		WebElement totalProdCount=driver.findElement(By.id("products_search_total_found_11"));
		String productcount=totalProdCount.getText();
		Assert.assertEquals(productcount, "Products found: 14");	
		
	}
	
	
	
	@Test
	public void verifyAddedProductCodeAndPrice() throws InterruptedException
	{
		searchProduct();
		WebElement mobproduct=driver.findElement(By.id("det_img_73"));
		mobproduct.click();
		
		WebElement productCode=driver.findElement(By.id("product_code_73"));
		String mobProductCode=productCode.getText();
		
		WebElement productPrice=driver.findElement(By.id("sec_discounted_price_73"));
		String mobProductPrice=productPrice.getText();
		System.out.println("product Price Before product added to cart" +mobProductPrice );
		
		
		WebElement btnAddToCart=driver.findElement(By.xpath("//*[@name='dispatch[checkout.add..73]']"));
		btnAddToCart.click();
		
		Thread.sleep(10000);
		
		
		WebElement viewCart=driver.findElement(By.xpath("//*[@class='ty-minicart__icon ty-icon-moon-commerce filled']"));
		viewCart.click();
		
		WebElement SecviewCart=driver.findElement(By.xpath("//*[@class='ty-btn ty-btn__secondary']"));
		SecviewCart.click();
		
		WebElement Added_Product_code=driver.findElement(By.id("product_code_update_1846465501"));
		String actualProductCode=Added_Product_code.getText();
		System.out.println("Actual product code =" +actualProductCode);
		
		WebElement cartproductPrice= driver.findElement(By.id("sec_product_price_1846465501"));
		String actualProductPrice=cartproductPrice.getText();
		
		Assert.assertEquals(actualProductCode, mobProductCode);
		
		
		WebElement incressProduct= driver.findElement(By.xpath("//*[@class='cm-increase ty-value-changer__increase']"));
		incressProduct.click();
		
//		WebElement msg_productAdded=driver.findElement(By.xpath("//*[@class='cm-notification-content notification-content alert alert-success cm-auto-hide']"));
		
		Alert alert=driver.switchTo().alert();
		System.out.println("Alert msg text =" +alert.getText());
		
		
		//String msg=msg_productAdded.getText();
		//SSystem.out.println("product added msg====" +msg);
		
		
		
		
		
		
		

		
		
		
		

		
		
		
		


		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
