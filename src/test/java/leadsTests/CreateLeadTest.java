package leadsTests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import genericUtilities.BaseClass;
import objectRepository.CreateNewLeadPage;
import objectRepository.HomePage;
import objectRepository.LeadInfoPage;
import objectRepository.LeadsPage;

@Listeners(genericUtilities.ListenersImplementation.class)

public class CreateLeadTest extends BaseClass {
    
	@Test(groups = "RegressionSuite")
	public void createLeadWithMandatoryFields() throws Throwable {

		/*Read Data From Excel File*/
		String LASTNAME = eUtil.readDataFromExcelFile("Leads", 1, 2);
		String COMPANY = eUtil.readDataFromExcelFile("Leads", 1, 3);

		//Step 1:Click on Leads link
		HomePage hp = new HomePage(driver);
		hp.clickOnLeadsLink();

		//Step 2:Click on Create Lead LookUp Image
		LeadsPage ldp = new LeadsPage(driver);
		ldp.clickOnCreateLeadLookupImg();

		//Step 3:Create new Lead
		CreateNewLeadPage cnlp = new CreateNewLeadPage(driver);
		cnlp.createNewLead(LASTNAME, COMPANY);
		
		//Step 4:Validate
		LeadInfoPage lip = new LeadInfoPage(driver);
		String leadHeader = lip.captureLeadHeaderText();
	    Assert.assertTrue(leadHeader.contains(LASTNAME));
	    System.out.println(leadHeader);

	}

}
