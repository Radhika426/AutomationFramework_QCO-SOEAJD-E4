package campaignsTests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import genericUtilities.BaseClass;
import objectRepository.CampaignInfoPage;
import objectRepository.CampaignsPage;
import objectRepository.CreateNewCampaignPage;
import objectRepository.HomePage;

@Listeners(genericUtilities.ListenersImplementation.class)

public class CreateCampaignTest extends BaseClass {
    
	@Test(groups = "SmokeSuite")
	public void createCampaignWithMandatoryFields() throws Throwable {

		/*Read Data From Excel File*/
		String CAMPAIGNNAME = eUtil.readDataFromExcelFile("Campaigns", 1, 2);

		//Step 1:Click on Campaigns link
		HomePage hp = new HomePage(driver);
		hp.clickOnCampaignsLink(driver);

		//Step 2:Click on Create Campaign LookUp Image
		CampaignsPage cp = new CampaignsPage(driver);
		cp.clickOnCreateCampaignLookupImg();

		//Step 3:Create new Campaign
		CreateNewCampaignPage cncp = new CreateNewCampaignPage(driver);
		cncp.createNewCampaign(CAMPAIGNNAME);

		//Step 4:Validate
		CampaignInfoPage cip = new CampaignInfoPage(driver);
		String campaignHeader = cip.captureCampaignHeaderText();
        Assert.assertTrue(campaignHeader.contains(CAMPAIGNNAME));
        System.out.println(campaignHeader);

	}

}
