package productsTests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import genericUtilities.BaseClass;
import objectRepository.CreateNewProductPage;
import objectRepository.HomePage;
import objectRepository.ProductInfoPage;
import objectRepository.ProductsPage;

@Listeners(genericUtilities.ListenersImplementation.class)

public class CreateProductTest extends BaseClass {
    
	@Test
	public void createProductWithMandatoryFields() throws Throwable {

		/*Read Data From Excel File*/
		String LASTNAME = eUtil.readDataFromExcelFile("Products", 1, 2);//4.12.1->Selenium //7.4.0->TestNG

		//Step 1:Click on Products link
		HomePage hp = new HomePage(driver);
		hp.clickOnProductsLink();

		//Step 2:Click on Create Product LookUp Image
		ProductsPage pp = new ProductsPage(driver);
		pp.clickOnCreateProductLookupImg();

		//Step 3:Create new Product
		CreateNewProductPage cnpp = new CreateNewProductPage(driver);
		cnpp.createNewProduct(LASTNAME);

		//Step 4:Validate
		ProductInfoPage pip = new ProductInfoPage(driver);
		String productHeader = pip.captureProductHeaderText();
		Assert.assertTrue(productHeader.contains(LASTNAME));
		System.out.println(productHeader);
	}

}
