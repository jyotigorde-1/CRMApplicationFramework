package CRMPages;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import CRMUtil.TestBase;

public class CRMDashboardCreateEventPage extends TestBase {
	Logger log = TestBase.getLogger(TestBase.class);
	WebDriverWait wait = new WebDriverWait(driver, 20);
	@FindBy(xpath = "//a[@class='btn btn-sm btn-ah-green add_event']")
	WebElement btnHeaderCreate;
	// @FindBy(xpath = "//span[@id='select2-chosen-5']")
	@FindBy(xpath = "//div[@id='s2id_event-select2-typedropdown']")
	WebElement createddlEventType;
	// @FindBy(id = "s2id_autogen5_search")
	@FindBy(xpath = "//div[@id='s2id_event-select2-typedropdown']//input")
	WebElement EventTypeVal;
	@FindBy(xpath = "//input[@id='event_first_name']")
	WebElement createTxtFirstName;
	@FindBy(xpath = "//input[@id='event_last_name']")
	WebElement createTxtLastName;
	@FindBy(xpath = "//input[@id='event_mobile']")
	WebElement createTxtMobile;
	@FindBy(xpath = "//input[@id='event_email']")
	WebElement createTxtEmail;
	@FindBy(xpath = "//div[@id='s2id_select2-leadsmethodofcontactdropdown']//ul[@class='select2-choices']")
	WebElement createMethodOfCont;
	@FindBy(xpath = "//div[@id='s2id_select2-leadsmethodofcontactdropdown']//input")
	WebElement createContactType;
	@FindBy(xpath = "//span[@id='select2-chosen-12']")
	WebElement createFromTime;
	@FindBy(xpath = "//div[@id='select2-drop']//div//input")
	WebElement createFromTimeVal;
	@FindBy(id = "s2id_select2-leadsbesttimetocontacttodropdown")
	WebElement createtoTime;
	@FindBy(xpath = "//div[@id='select2-drop']//div//input")
	WebElement createToTimeVal;
	@FindBy(xpath = "//div[@id ='property_selection']/div[1]/div/a")
	WebElement createDDlProperty;
	@FindBy(xpath = "//div[@id='select2-drop']/div/input")
	WebElement createSelectProperty;
	@FindBy(xpath = "//div[@id='floor_plan_selection']//div[contains(@class,'required-field')]//div//input")
	WebElement floorPlanValue;
	@FindBy(xpath = "//div[@id='s2id_event-select2-unitplaninterestdropdown']//input")
	WebElement createUnitDDl;
	@FindBy(xpath = "//div[@id='s2id_selected_origin']//input")
	WebElement createDDlOrigin;
	@FindBy(xpath = "//div[@id='s2id_event-select2-sourcetypedropdown']//input")
	WebElement createDDlSource;
	@FindBy(xpath = "//span[@class='select2-match']")
	WebElement createDDlSourceVal;
	@FindBy(xpath = "//input[@id='guest_desire_move_in_date']")
	WebElement createmoveInDate;
	@FindBy(xpath = "//a[contains(text(),'Guest Desires')]")
	WebElement createTabGuestDesire;
	@FindBy(xpath = "//input[@id='end-slider-value']")
	WebElement createTxtMonthrate;
	@FindBy(xpath = "//span[@id='leaselength_span_id']")
	WebElement createDDLeaseMonth;
	@FindBy(xpath = "//span[@id='noofoccupants_span_id']")
	WebElement createDDLOccupantNo;
	@FindBy(xpath = "//div[@id='noofbedSelectList']")
	WebElement createDDLBed;
	@FindBy(xpath = "//div[@id='noofbathSelectList']")
	WebElement createDDLBaths;
	@FindBy(xpath = "//input[@id='s2id_autogen9']")
	WebElement createDDLWasher;
	@FindBy(xpath = "//textarea[@id='event_notes']")
	WebElement createTxtNotes;
	@FindBy(xpath = "//a[contains(text(),'Additional Info')]")
	WebElement createTabAdditionalInfo;
	@FindBy(xpath = "//div[@id='vehiclecountSelectlist']")
	WebElement createDDlVehicle;
	@FindBy(xpath = "//div[@id='petcountSelectlist']")
	WebElement createDDlPetCount;
	@FindBy(xpath = "//button[@class='btn btn-sm btn-white dropdown-toggle commonTabIndex']")
	WebElement createDDlPetType;
	@FindBy(xpath = "//input[@id='event_breed_name']")
	WebElement createTxtBreed;
	@FindBy(xpath = "//input[@id='event_pet_name']")
	WebElement createTxtPetName;
	@FindBy(xpath = "//div[@id='s2id_select2-reasonformovingdropdowns']")
	WebElement createDDLeavingReason;
	@FindBy(xpath = "//div[@id='s2id_select2-mostimportanthomedropdowns']")
	WebElement mostImpInHome;
	@FindBy(xpath = "//div[@id='affordable_inquirySelectlist']")
	WebElement createDDLAffordInquiry;
	@FindBy(xpath = "//div[@id='realtor_inquirySelectlist']")
	WebElement createDDLRealtorInquiry;
	@FindBy(xpath = "//div[@id='resident_referralSelectlist']")
	WebElement createDDLResidentRefer;
	@FindBy(xpath = "//a[contains(text(),'Pricing & Availability')]")
	WebElement createTabPricingAvail;
	@FindBy(xpath = "//button[@id='save_btn']")
	WebElement btnEventCreate;
	@FindBy(xpath = "//span[contains(text(),'Leads')]")
	WebElement MenuLead;
	@FindBy(xpath = "//div[@class='input-group search datagrid-search m-t-small']//input[@placeholder='Search']")
	WebElement SearchField;
	@FindBy(xpath = "//i[@class='fa fa-search']")
	WebElement SearchIcon;
	@FindBy(xpath = "//table[@id='StretchGrid']//tbody//td[2]")
	List<WebElement> leadTableText;
	@FindBy(xpath = "//i[@class='fa fa-eye']")
	WebElement OpenEyeIcon;
	@FindBy(xpath = "//button[@class='btn btn-white btn-sm font-normal dropdown-toggle lead_status_change_btn']")
	WebElement btnLeadStatus;
	@FindBy(xpath = "//a[contains(text(),'Book Showing')]")
	WebElement createBookShowingTab;
	@FindBy(xpath = "//span[@class='fc-event-title']")
	WebElement eventAvailableMsg;
	@FindBy(xpath = "//td[@class='fc-header-left']//span[@class='fc-button fc-button-next fc-state-default fc-corner-right']//span[@class='fc-text-arrow']")
	WebElement rightNextArrow;
	@FindBy(xpath = "//input[@id='log_showing_date']")
	WebElement logShowDate;
	@FindBy(xpath = "//button[@id='from_time']")
	WebElement EventFromTime;
	@FindBy(xpath = "//button[@id='to_time']")
	WebElement EventToTime;
	@FindBy(xpath = "//div[@class='block log_showing_booking_container m-t']//button[@class='btn btn-sm btn-white dropdown-toggle']")
	WebElement ShowLogStatus;
	@FindBy(xpath = "//input[@id='date']")
	WebElement dateInput;
	@FindBy(xpath = "//span[contains(text(),'Schedule')]")
	WebElement menuSchedule;
	@FindBy(xpath = "//div[1]//article[1]//div[1]//div[3]")
	List<WebElement> allScheduleListing;
	@FindBy(xpath = "//input[@id='event_label']")
	WebElement lblPersonalEvent;
	@FindBy(xpath = "//div[@id='s2id_event-select2-classificationdropdown']//input")
	WebElement ddlSRClassification;
	@FindBy(xpath = "//div[@id='s2id_event-select2-servicerequesttypedropdown']//input")
	WebElement ddlSRType;
	@FindBy(xpath = "//div[@id='s2id_event-select2-roomareainfecteddropdown']//input")
	WebElement ddlImpactedArea;
	@FindBy(xpath = "//textarea[@placeholder='Entry Notes']")
	WebElement txtEntryNotes;
	@FindBy(xpath = "//textarea[@placeholder='Service Request Notes']")
	WebElement txtSRNotes;
	@FindBy(xpath = "//li[@id='servicerequests']//span[contains(text(),'Service Request')]")
	WebElement menuServiceRequest;
	@FindBy(xpath = "//a[contains(text(),'Unassigned Service Requests')]")
	WebElement UnassignSRTab;
	@FindBy(xpath = "//table[@id='unassinged-sr']//thead//tr//th//input[@placeholder='Search']")
	WebElement txtUnassignSRSearch;
	@FindBy(xpath = "//table[@id='unassinged-sr']//thead//tr//th//i[@class='fa fa-search']")
	WebElement IcnUnassignedSRSearch;
	@FindBy(xpath = "//table[@id='unassinged-sr']//tbody//td[5]")
	List<WebElement> propertyUnitData;
	@FindBy(xpath = "//table[@id='unassinged-sr']//tbody//td[3]")
	WebElement Urgency;
	@FindBy(xpath = "//div[@id='unassigned_service_requests']//td[6]")
	WebElement OpenSR;
	@FindBy(xpath = "//div[@class='col-lg-4']")
	WebElement SRResidentInfo;
	@FindBy(xpath = "//button[@class='btn btn-white dropdown-toggle']")
	WebElement SRStatus;
	@FindBy(xpath = "//label[@id='exi_prospect']")
	WebElement btnExistProspect;
	@FindBy(xpath = "//input[@id='Search_Prospect']")
	WebElement txtExistProspectSearch;
	@FindBy(xpath = "//div[@class='prospect_search ssevent_class lsevent_class mievent_class srevent_class col-lg-12 sqevent_class sqevent_class event_common_hide_class block']//a[1]")
	WebElement SelectExistProspectAfterSearch;
	@FindBy(xpath = "//span[@class='h4 prospect-name-panel']")
	WebElement leadName;
	@FindBy(xpath = "//div[@id='c-slide']//p[contains(@class,'h4 text-center next-silder-title')]")
	List<WebElement> SchedulesListing;
	@FindBy(xpath = "//input[@id='schedule_for_another_agent']")
	WebElement chkScheduleAgent;
	@FindBy(xpath = "//div[@id='s2id_selected_prop_agent_id']//input")
	WebElement txtScheduleAgentName;
	@FindBy(xpath = "//div//span[@class='select2-match']")
	WebElement SelectScheduleAgentName;
	
	

	// Page factory initilization
	public CRMDashboardCreateEventPage() {
		PageFactory.initElements(driver, this);
	}

	// Click on create button
	public void clickOnHeaderCreateBtn() throws InterruptedException {
		Thread.sleep(2000);
		btnHeaderCreate.click();
		Thread.sleep(2000);
	}

	// Method for Create event
	public void createEvent(String EType, String FName, String LName, String phoneNo, String Email, String ContactType,
			String fromTime, String ToTime, String propertyName, String floorPlan, String Unit, String Origin,
			String Source, String MoveInDate, String MonthRate, String LeaseMonthLength, String noOfOccupant,
			String NoOfBed, String NoOfBath, String WasherPref, String Notes, String NoOfVehicle, String NoOfPet,
			String PetType, String BreedName, String petName, String LeavingReason, String ImpInHome,
			String AffordEnquiry, String RealtorInquiry, String Residentreferal)
			throws InterruptedException, IOException {

		EventTypeVal.sendKeys(EType + Keys.ENTER);	
		createTxtFirstName.sendKeys(FName);
		Thread.sleep(1000);
		createTxtLastName.sendKeys(LName);
		createTxtMobile.sendKeys(phoneNo);
		createTxtEmail.sendKeys(Email);
		// createMethodOfCont.click();
		createContactType.sendKeys(ContactType + Keys.ENTER);
		createFromTime.click();
		Thread.sleep(1000);
		createFromTimeVal.sendKeys(fromTime + Keys.ENTER);
		createtoTime.click();
		Thread.sleep(1000);
		createToTimeVal.sendKeys(ToTime + Keys.ENTER);
		createDDlProperty.click();
		createSelectProperty.sendKeys(propertyName);
		Thread.sleep(2000);
		createSelectProperty.sendKeys(Keys.DOWN);
		createSelectProperty.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		floorPlanValue.sendKeys(floorPlan);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(text(),'" + floorPlan + "')]")).click();
		Thread.sleep(1000);
		createUnitDDl.sendKeys(Unit);
		driver.findElement(By.xpath("//div[contains(text(),'" + Unit + "')]")).click();
		Thread.sleep(1000);
		createDDlOrigin.sendKeys(Origin + Keys.ENTER);
		Thread.sleep(1000);
		createDDlSource.sendKeys(Source);
		Thread.sleep(1000);
		createDDlSourceVal.click();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", createmoveInDate);
		createmoveInDate.click();
		driver.findElement(By.xpath("//div[20]//tr//td[contains(text(),'" + MoveInDate + "')]")).click();
		createTabGuestDesire.click();
		createTxtMonthrate.sendKeys(MonthRate);
		createDDLeaseMonth.click();
		driver.findElement(By.xpath("//div[@id='leaselengthSelectList']//li[" + LeaseMonthLength + "]//a")).click();
		createDDLOccupantNo.click();
		driver.findElement(By.xpath("//ul[@id='noofoccupants_cnt']//a[contains(text(),'" + noOfOccupant + "')]")).click();
		createDDLBed.click();
		driver.findElement(By.xpath("//div[@id='noofbedSelectList']//li//a[contains(text(),'" + NoOfBed + "')]")).click();
		createDDLBaths.click();
		driver.findElement(By.xpath("//a[@class='no_of_baths no_of_beds_baths'][contains(text(),'" + NoOfBath + "')]")).click();
		createDDLWasher.sendKeys(WasherPref + Keys.ENTER);
		createTxtNotes.sendKeys(Notes);
		createTabAdditionalInfo.click();
		createDDlVehicle.click();
		driver.findElement(By.xpath("//ul[@id='event_vehicle_cnt']//a[contains(text(),'" + NoOfVehicle + "')]")).click();
		createDDlPetCount.click();
		driver.findElement(By.xpath("//ul[@id='event_pet_cnt']//a[contains(text(),'" + NoOfPet + "')]")).click();
		createDDlPetType.click();
		driver.findElement(By.xpath("//a[contains(text(),'" + PetType + "')]")).click();
		createTxtBreed.sendKeys(BreedName);
		createTxtPetName.sendKeys(petName);
		createDDLeavingReason.click();
		driver.findElement(By.xpath("//div[contains(text(),'" + LeavingReason + "')]")).click();
		mostImpInHome.click();
		driver.findElement(By.xpath("//div[contains(text(),'" + ImpInHome + "')]")).click();
		createDDLAffordInquiry.click();
		driver.findElement(By.xpath("//ul[@id='event_affordable_inquiry']//a[contains(text(),'" + AffordEnquiry + "')]")).click();
		createDDLRealtorInquiry.click();
		driver.findElement(By.xpath("//ul[@id='event_realtor_inquiry']//a[contains(text(),'" + RealtorInquiry + "')]")).click();
		createDDLResidentRefer.click();
		driver.findElement(By.xpath("//ul[@id='event_resident_referral']//a[contains(text(),'" + Residentreferal + "')]")).click();
		createTabPricingAvail.click();
	}

	// Method for Create showing like log schedule for existing lead
	public void createShowingForExistLead(String EType, String FName, String LName, String ContactType, String fromTime,
			String ToTime, String propertyName, String floorPlan, String Unit, String MoveInDate)
			throws InterruptedException {
		String LeadToSearch = FName + " " + LName;
		EventTypeVal.sendKeys(EType + Keys.ENTER);
		btnExistProspect.click();
		txtExistProspectSearch.sendKeys(LeadToSearch + Keys.ENTER);
		SelectExistProspectAfterSearch.click();
		createContactType.sendKeys(ContactType + Keys.ENTER);
		createFromTime.click();
		Thread.sleep(1000);
		createFromTimeVal.sendKeys(fromTime + Keys.ENTER);
		createtoTime.click();
		Thread.sleep(1000);
		createToTimeVal.sendKeys(ToTime + Keys.ENTER);
		createDDlProperty.click();
		createSelectProperty.sendKeys(propertyName);
		Thread.sleep(2000);
		createSelectProperty.sendKeys(Keys.DOWN);
		createSelectProperty.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		floorPlanValue.sendKeys(floorPlan);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(text(),'" + floorPlan + "')]")).click();
		Thread.sleep(1000);
		createUnitDDl.sendKeys(Unit);
		driver.findElement(By.xpath("//div[contains(text(),'" + Unit + "')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='guest_desire_move_in_date']")).click();
		createmoveInDate.click();
		driver.findElement(By.xpath("//div[20]//tr//td[contains(text(),'" + MoveInDate + "')]")).click();

	}

	// Method for Create books showing in schedule showing

	public void ScheduleBookShowing(String scheduleTime) throws InterruptedException {
		createBookShowingTab.click();
		rightNextArrow.click();
		Thread.sleep(1000);
		eventAvailableMsg.click();
		driver.findElement(By.xpath("//label[text()='" + scheduleTime + "']")).click();
	}

	// Method for Create button click after filling all data
	public void clickOnCreateBtn() throws InterruptedException {
		Thread.sleep(1000);
		btnEventCreate.click();
	}

	// Method for validation after lead created
	public void leadCreateValidation(String FName, String LName, String leadStatus) throws InterruptedException {
		Thread.sleep(3000);
		MenuLead.click();
		Thread.sleep(2000);
		String ExpectedLeadToSearch = FName + " " + LName;
		// String expectedLeadStatus="Inquiry";
		SearchField.sendKeys(ExpectedLeadToSearch);
		SearchIcon.click();
		Thread.sleep(1000);
		String allLeadsAfterSearch = "";
		for (int i = 0; i < leadTableText.size(); i++) {
			String LeadNames = leadTableText.get(i).getText();
			allLeadsAfterSearch = allLeadsAfterSearch + LeadNames;
		}
		System.out.println("Lead Name " + allLeadsAfterSearch);
		if (allLeadsAfterSearch.contains(ExpectedLeadToSearch)) {
			OpenEyeIcon.click();
			Thread.sleep(1000);
			String actualStatus = btnLeadStatus.getText();
			Assert.assertEquals(leadStatus, actualStatus);
			log.info("Test Pass-Lead Sucessfully Created With Status As " + leadStatus);

		} else {
			log.info("Test Fail-Lead Is not Created");
		}
	}

	// Method for Create log book showing

	public void logBookShowing(String logDate, String logFromtime, String logToTime, String logShowStatus)
			throws InterruptedException {
		// System.out.println("Log date " +logDate);
		createBookShowingTab.click();
		logShowDate.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[23]//tr//td[@class='day '][contains(text(),'" + logDate + "')]")).click();
		EventFromTime.click();
		driver.findElement(By.xpath("//ul[@id='select_from']//a[@name='tab'][contains(text(),'" + logFromtime + "')]")).click();
		EventToTime.click();
		driver.findElement(By.xpath("//ul[@id='select_to']//a[@name='tab'][contains(text(),'" + logToTime + "')]")).click();
		ShowLogStatus.click();
		driver.findElement(By.xpath("//ul[@id='prospectResolutionStatusDropdown']//a[contains(text(),'" + logShowStatus + "')]")).click();

	}

	// Method for replace AM & PM by a.m. p.m.

	public String ReplaceAMPM(String StringContainAMPM) {
		String replaceString = "";
		if (StringContainAMPM.contains("AM")) {
			replaceString = StringContainAMPM.replace("AM", "a.m.");

		}
		if (StringContainAMPM.contains("PM")) {
			replaceString = StringContainAMPM.replace("PM", "p.m.");

		}
		return replaceString;

	}

	// Method for Create Schedule showing for existing lead
	public void ScheduleShowCreateExistLeadValidation(String FName, String LName, String propertyName,
			String leadStatus, String Scheduletime, String ScheduleDate) throws InterruptedException, ParseException {
		LocalDate currentdate = LocalDate.now();
		int currentDay = currentdate.getDayOfMonth();
		Month currentMonth = currentdate.getMonth();
		int currentYear = currentdate.getYear();
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int month = localDate.getMonthValue();
		String[] tokens = Scheduletime.split("-");
		String NewETime = tokens[0];

		String ExpectedName = FName + " " + LName;
		String expectedScheduleText = "A showing is scheduled for " + month + "/" + ScheduleDate + "/" + currentYear + " @ " + NewETime + " PDT";
		// System.out.println("E" +expectedScheduletext);
		Thread.sleep(3000);

		String LeadName = leadName.getText();
		// WebElement
		// propertyToScheduleShow=driver.findElement(By.xpath("//tr[@class='td-ah-green
		// property-of-interest']//td"));
		// String PropertyForShow=propertyToScheduleShow.getText();
		// System.out.println("Lead Name " +LeadName + "Property= " +PropertyForShow);
		String actualStatus = btnLeadStatus.getText();
		if (ExpectedName.equals(LeadName) && leadStatus.equals(actualStatus)) {

			for (int i = 0; i < SchedulesListing.size(); i++) {
				String AllScheduleInfos = SchedulesListing.get(i).getText();
				String NewStr = ReplaceAMPM(AllScheduleInfos);
				String FinalSceduleString = NewStr.replace("\n", " ");
				// System.out.println("A " +FinalSceduleString);
				// System.out.println("E" +expectedScheduleText);
				if (expectedScheduleText.equalsIgnoreCase(FinalSceduleString)) {
					log.info("Test Pass-Schedule Showing For Exist Lead " + ExpectedName + " Is Created Sucessfully");
				}

			}

		} else {
			System.out.println("Test Fail-Something Wrong");
		}

	}

	// Method for Create Open House Event
	public void OpenHouseEvent(String EType, String propertyName, String ScheduleDate, String SceheduleFromtime,
			String ScheduleToTime) throws InterruptedException {

		EventTypeVal.sendKeys(EType + Keys.ENTER);
		createDDlProperty.click();
		createSelectProperty.sendKeys(propertyName);
		Thread.sleep(1000);
		createSelectProperty.sendKeys(Keys.DOWN);
		createSelectProperty.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		dateInput.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[21]//tr//td[@class='day '][contains(text(),'" + ScheduleDate + "')]")).click();
		EventFromTime.click();
		driver.findElement(By.xpath("//ul[@id='select_from']//a[@name='tab'][contains(text(),'" + SceheduleFromtime + "')]")).click();
		EventToTime.click();
		driver.findElement(By.xpath("//ul[@id='select_to']//a[@name='tab'][contains(text(),'" + ScheduleToTime + "')]")).click();

	}

	// Method for validation of schedule after creation

	public void scheduleValidation(String EType, String scheduleddate, String SceheduleFromtime, String ScheduleToTime)
			throws InterruptedException, ParseException {
		String expectedEventNameTime = SceheduleFromtime + " - " + ScheduleToTime + " PDT " + EType;
		// System.out.println(expectedEventNameTime);
		Thread.sleep(3000);
		menuSchedule.click();
		Thread.sleep(4000);
		for (int i = 0; i < allScheduleListing.size(); i++) {
			String eventName = allScheduleListing.get(i).getText();
			// System.out.println(eventName);
			String EscapedString = eventName.replaceAll("\n", ",");
			// System.out.println("B" +EscapedString);
			String[] tokens = EscapedString.split(",");
			String EventTimeName = tokens[0] + " " + tokens[1];
			// System.out.println("A" +EventTimeName);
			System.out.println("E" +expectedEventNameTime);
			System.out.println("A" +EventTimeName);
			if (expectedEventNameTime.equals(EventTimeName)) {
				log.info("Test Pass- " + EType + " Created Sucessfully @ " + SceheduleFromtime + " To " + ScheduleToTime + " On " + scheduleddate);
			}

		}
	}

	// Method for Create Personal event

	public void PersonalEvent(String EType, String personalEventDate, String SceheduleFromtime, String ScheduleToTime,
			String eventName, String Notes) throws InterruptedException {

		EventTypeVal.sendKeys(EType + Keys.ENTER);
		Thread.sleep(1000);
		dateInput.click();
		driver.findElement(By.xpath("//div[21]//tr//td[@class='day '][contains(text(),'" + personalEventDate + "')]")).click();
		EventFromTime.click();
		driver.findElement(By.xpath("//ul[@id='select_from']//a[@name='tab'][contains(text(),'" + SceheduleFromtime + "')]")).click();
		EventToTime.click();
		driver.findElement(By.xpath("//ul[@id='select_to']//a[@name='tab'][contains(text(),'" + ScheduleToTime + "')]")).click();
		lblPersonalEvent.sendKeys(eventName);
		createTxtNotes.sendKeys(Notes);
	}

	// Method For Select another agent for an Event
	public void SelectAnotherAgentEvent(String agentName) {		
		chkScheduleAgent.click();		
		txtScheduleAgentName.sendKeys(agentName);
		SelectScheduleAgentName.click();

	}

	// Method for Create Service Request for new resident

	public void createServiceRequest(String EType, String Classification, String FName, String LName, String phoneNo,
			String Email, String ContactType, String fromTime, String ToTime, String propertyName, String Unit,
			String SRType, String areaImpacted, String ENotes, String SRNotes) throws InterruptedException {
		EventTypeVal.sendKeys(EType + Keys.ENTER);
		ddlSRClassification.sendKeys(Classification + Keys.ENTER);
		createTxtFirstName.sendKeys(FName);
		Thread.sleep(1000);
		createTxtLastName.sendKeys(LName);
		createTxtMobile.sendKeys(phoneNo);
		createTxtEmail.sendKeys(Email);
		// createMethodOfCont.click();
		createContactType.sendKeys(ContactType + Keys.ENTER);
		createFromTime.click();
		Thread.sleep(1000);
		createFromTimeVal.sendKeys(fromTime + Keys.ENTER);
		createtoTime.click();
		Thread.sleep(1000);
		createToTimeVal.sendKeys(ToTime + Keys.ENTER);
		createDDlProperty.click();
		createSelectProperty.sendKeys(propertyName);
		Thread.sleep(2000);
		createSelectProperty.sendKeys(Keys.DOWN);
		createSelectProperty.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		createUnitDDl.sendKeys(Unit);
		driver.findElement(By.xpath("//div[contains(text(),'" + Unit + "')]")).click();
		Thread.sleep(1000);
		ddlSRType.sendKeys(SRType);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[contains(text(),'" + SRType + "')]")).click();
		ddlImpactedArea.sendKeys(areaImpacted + Keys.ENTER);
		txtEntryNotes.sendKeys(ENotes);
		txtSRNotes.sendKeys(SRNotes);
	}

	// Method for validation of SR after creation
	public void ServiceRequestValidation(String Classification, String propertyName, String Unit, String FName,
			String LName, String SRType) throws InterruptedException {
		Thread.sleep(5000);
		String propertyUnitToSearch = propertyName + " / " + Unit;
		String ExpectedName = FName + " " + LName;
		String ExpectedSRStatus = "Open";
		menuServiceRequest.click();
		Thread.sleep(3000);
		UnassignSRTab.click();
		txtUnassignSRSearch.sendKeys(propertyUnitToSearch);
		IcnUnassignedSRSearch.click();
		Thread.sleep(1000);
		String allPropUnitsAfterSearch = "";
		String urgencyValue = "";
		for (int i = 0; i < propertyUnitData.size(); i++) {
			String PropUnit = propertyUnitData.get(i).getText();
			allPropUnitsAfterSearch = allPropUnitsAfterSearch + PropUnit;
			urgencyValue = Urgency.getText();
			// System.out.println("Urgency" +urgencyValue);
		}
		if (allPropUnitsAfterSearch.contains(propertyUnitToSearch) && urgencyValue.equals(Classification)) {
			OpenSR.click();
			Thread.sleep(1000);
			String AllInfo = SRResidentInfo.getText();
			WebElement SRTypes = driver.findElement(By.xpath("//p[contains(text(),'Type(s):')]"));
			String ASRType = SRTypes.getText();
			// System.out.println("A" +ASRType);
			if (AllInfo.contains(ExpectedName) && ASRType.contains(SRType)) {
				String ActualSRStatus = SRStatus.getText();
				Assert.assertEquals(ExpectedSRStatus, ActualSRStatus);
				log.info("Test Pass-Service Request Is Created Sucessfully For Resident " + ExpectedName);

			}

		} else
			log.info("No SR Created");

	}

	// Method for Create SR for existing resident
	public void createServiceRequestForExistResident(String EType, String Classification, String FName, String LName,
			String ContactType, String fromTime, String ToTime, String propertyName, String Unit, String SRType,
			String areaImpacted, String ENotes, String SRNotes) throws InterruptedException {
		String ResidentToSearch = FName + " " + LName;
		EventTypeVal.sendKeys(EType + Keys.ENTER);
		ddlSRClassification.sendKeys(Classification + Keys.ENTER);
		btnExistProspect.click();
		txtExistProspectSearch.sendKeys(ResidentToSearch);
		SelectExistProspectAfterSearch.click();
		createContactType.sendKeys(ContactType + Keys.ENTER);
		createFromTime.click();
		Thread.sleep(1000);
		createFromTimeVal.sendKeys(fromTime + Keys.ENTER);
		createtoTime.click();
		Thread.sleep(1000);
		createToTimeVal.sendKeys(ToTime + Keys.ENTER);
		createDDlProperty.click();
		createSelectProperty.sendKeys(propertyName);
		Thread.sleep(2000);
		createSelectProperty.sendKeys(Keys.DOWN);
		createSelectProperty.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		createUnitDDl.sendKeys(Unit);
		driver.findElement(By.xpath("//div[contains(text(),'" + Unit + "')]")).click();
		Thread.sleep(1000);
		ddlSRType.sendKeys(SRType);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[contains(text(),'" + SRType + "')]")).click();
		ddlImpactedArea.sendKeys(areaImpacted + Keys.ENTER);
		txtEntryNotes.sendKeys(ENotes);
		txtSRNotes.sendKeys(SRNotes);

	}
}
