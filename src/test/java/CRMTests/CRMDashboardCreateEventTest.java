package CRMTests;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CRMPages.CRMDashboardCreateEventPage;
import CRMPages.CRMLoginPage;
import CRMUtil.TestBase;

public class CRMDashboardCreateEventTest extends TestBase {
	Logger log = TestBase.getLogger(TestBase.class);
	public static String browserName;

	@BeforeMethod
	public void launchBrowser() throws InterruptedException {
		TestBase.initializBrowser(browserName);
		CRMLoginPage CP = new CRMLoginPage();
		CP.testLogin("rohan.patil@anyonehome.com", "@123");
	}

	@Test(dataProvider = "dataToLeadCreate", enabled = false)

	public void createLeadTest(String EType, String FName, String LName, String phoneNo, String Email,
			String ContactType, String fromTime, String ToTime, String propertyName, String floorPlan, String Unit,
			String Origin, String Source, String MoveInDate, String MonthRate, String LeaseMonthLength,
			String noOfOccupant, String NoOfBed, String NoOfBath, String WasherPref, String Notes, String NoOfVehicle,
			String NoOfPet, String PetType, String BreedName, String petName, String LeavingReason, String ImpInHome,
			String AffordEnquiry, String RealtorInquiry, String Residentreferal)
			throws InterruptedException, IOException {
		log.info("Create Lead Test");
		CRMDashboardCreateEventPage CD = new CRMDashboardCreateEventPage();
		CD.clickOnHeaderCreateBtn();
		CD.createEvent(EType, FName, LName, phoneNo, Email, ContactType, fromTime, ToTime, propertyName, floorPlan,
				Unit, Origin, Source, MoveInDate, MonthRate, LeaseMonthLength, noOfOccupant, NoOfBed, NoOfBath,
				WasherPref, Notes, NoOfVehicle, NoOfPet, PetType, BreedName, petName, LeavingReason, ImpInHome,
				AffordEnquiry, RealtorInquiry, Residentreferal);
		CD.clickOnCreateBtn();
		CD.leadCreateValidation(FName, LName, "Inquiry");
	}

	@DataProvider(name = "dataToLeadCreate")
	public Object[][] dataToLead() throws IOException {
		return new Object[][] { { "Lead", "Kiaran", "Lead", "9850025668", "jyotigorde18@gmail.com", "Phone", "8:30",
				"9:00", "Sitka Meadows", "floorplan MI test 1", "UM test 01", "Phone", "Mitch Moody", "24", "4000", "4",
				"6", "4", "3", "In Unit", "Test data to create lead", "7", "2", "Dog", "BreedTest", "Tommy",
				"Better Location & cheap Rent", "Important Account", "Yes", "No", "No" }

		};
	}

	@Test(dataProvider = "dataToScheduleShowingCreate", enabled = false)

	public void createSceheduleShow(String EType, String FName, String LName, String phoneNo, String Email,
			String ContactType, String fromTime, String ToTime, String propertyName, String floorPlan, String Unit,
			String Origin, String Source, String MoveInDate, String scheduleTime, String MonthRate,
			String LeaseMonthLength, String noOfOccupant, String NoOfBed, String NoOfBath, String WasherPref,
			String Notes, String NoOfVehicle, String NoOfPet, String PetType, String BreedName, String petName,
			String LeavingReason, String ImpInHome, String AffordEnquiry, String RealtorInquiry, String Residentreferal)
			throws InterruptedException, IOException {
		log.info("Create Schedule Show Test");
		CRMDashboardCreateEventPage CD = new CRMDashboardCreateEventPage();
		CD.clickOnHeaderCreateBtn();
		CD.createEvent(EType, FName, LName, phoneNo, Email, ContactType, fromTime, ToTime, propertyName, floorPlan,
				Unit, Origin, Source, MoveInDate, MonthRate, LeaseMonthLength, noOfOccupant, NoOfBed, NoOfBath,
				WasherPref, Notes, NoOfVehicle, NoOfPet, PetType, BreedName, petName, LeavingReason, ImpInHome,
				AffordEnquiry, RealtorInquiry, Residentreferal);
		CD.ScheduleBookShowing(scheduleTime);
		CD.clickOnCreateBtn();
		CD.leadCreateValidation(FName, LName, "Showing Set");
	}

	@DataProvider(name = "dataToScheduleShowingCreate")
	public Object[][] dataToSchedule() throws IOException {
		return new Object[][] { { "Schedule Showing", "Sams", "Agarwal", "9850025668", "jyotigorde@gmail.com", "Phone",
				"8:30", "9:00", "Sitka Meadows", "floorplan MI test 1", "UM test 01", "Phone", "Mitch Moody", "24",
				"1:00 p.m.-2:00 p.m.", "4000", "4", "6", "4", "3", "In Unit", "Test data to create lead", "7", "2",
				"Dog", "BreedTest", "Tommy", "Better Location & cheap Rent", "Important Account", "Yes", "No", "No" }

		};
	}

	@Test(dataProvider = "dataToScheduleShowingCreateForExistLead", enabled = false)

	public void createSceheduleShowForexistLead(String EType, String FName, String LName, String ContactType,
			String fromTime, String ToTime, String propertyName, String floorPlan, String Unit, String MoveInDate,
			String scheduleTime, String ScheduleDate) throws InterruptedException, IOException, ParseException {
		log.info("Create Schedule Show Test For Existing Lead");
		CRMDashboardCreateEventPage CD = new CRMDashboardCreateEventPage();
		CD.clickOnHeaderCreateBtn();
		CD.createShowingForExistLead(EType, FName, LName, ContactType, fromTime, ToTime, propertyName, floorPlan, Unit,
				MoveInDate);
		CD.ScheduleBookShowing(scheduleTime);
		CD.clickOnCreateBtn();
		CD.ScheduleShowCreateExistLeadValidation(FName, LName, propertyName, "Showing Completed", scheduleTime,
				ScheduleDate);
	}

	@DataProvider(name = "dataToScheduleShowingCreateForExistLead")
	public Object[][] dataToScheduleShowExistLead() throws IOException {
		return new Object[][] { { "Schedule Showing", "Kione", "Finch", "Phone", "8:30", "9:00", "Sitka Meadows",
				"floorplan MI test 1", "UM test 01", "24", "11:00 a.m.-12:00 p.m.", "24" }

		};
	}

	@Test(dataProvider = "dataToLogShowingCreate", enabled = false)

	public void createLogShow(String EType, String FName, String LName, String phoneNo, String Email,
			String ContactType, String fromTime, String ToTime, String propertyName, String floorPlan, String Unit,
			String Origin, String Source, String MoveInDate, String MonthRate, String LeaseMonthLength,
			String noOfOccupant, String NoOfBed, String NoOfBath, String WasherPref, String Notes, String NoOfVehicle,
			String NoOfPet, String PetType, String BreedName, String petName, String LeavingReason, String ImpInHome,
			String AffordEnquiry, String RealtorInquiry, String Residentreferal, String logDate, String logFromtime,
			String logToTime, String logShowStatus) throws InterruptedException, IOException {
		log.info("Create Log Showing Test");
		CRMDashboardCreateEventPage CD = new CRMDashboardCreateEventPage();
		CD.clickOnHeaderCreateBtn();
		CD.createEvent(EType, FName, LName, phoneNo, Email, ContactType, fromTime, ToTime, propertyName, floorPlan,
				Unit, Origin, Source, MoveInDate, MonthRate, LeaseMonthLength, noOfOccupant, NoOfBed, NoOfBath,
				WasherPref, Notes, NoOfVehicle, NoOfPet, PetType, BreedName, petName, LeavingReason, ImpInHome,
				AffordEnquiry, RealtorInquiry, Residentreferal);
		CD.logBookShowing(logDate, logFromtime, logToTime, logShowStatus);
		CD.clickOnCreateBtn();
		CD.leadCreateValidation(FName, LName, "Showing Completed");
	}

	@DataProvider(name = "dataToLogShowingCreate")
	public Object[][] dataToLogShowing() throws IOException {
		return new Object[][] { { "Log Showing", "Kione", "Finch", "9850025668", "jyotig@gmail.com", "Phone", "8:30",
				"9:00", "Sitka Meadows", "floorplan MI test 1", "UM test 01", "Phone", "Mitch Moody", "24", "4000", "4",
				"6", "4", "3", "In Unit", "Test data to create lead", "7", "2", "Dog", "BreedTest", "Tommy",
				"Better Location & cheap Rent", "Important Account", "Yes", "No", "No", "13", "8:30 a.m.", "9:00 a.m.",
				"Completed - Interested" }

		};
	}

	@Test(dataProvider = "dataToLogCreateForExistLead", enabled = false)

	public void createLogShowForexistLead(String EType, String FName, String LName, String ContactType, String fromTime,
			String ToTime, String propertyName, String floorPlan, String Unit, String MoveInDate, String scheduleTime,
			String logDate, String logFromtime, String logToTime, String logShowStatus)
			throws InterruptedException, IOException, ParseException {
		log.info("Create Schedule Show Test For Existing Lead");
		CRMDashboardCreateEventPage CD = new CRMDashboardCreateEventPage();
		CD.clickOnHeaderCreateBtn();
		CD.createShowingForExistLead(EType, FName, LName, ContactType, fromTime, ToTime, propertyName, floorPlan, Unit,
				MoveInDate);
		CD.logBookShowing(logDate, logFromtime, logToTime, logShowStatus);
		// CD.clickOnCreateBtn();

	}

	@DataProvider(name = "dataToLogCreateForExistLead")
	public Object[][] dataToLogShowExistLead() throws IOException {
		return new Object[][] { { "Log Showing", "Kione", "Finch", "Phone", "8:30", "9:00", "Sitka Meadows",
				"floorplan MI test 1", "UM test 01", "24", "11:00 a.m.-12:00 p.m.", "17", "8:30 a.m.", "9:00 a.m.",
				"Completed - Interested" }

		};
	}

	@Test(dataProvider = "dataToOpenHouse", enabled = false)

	public void createOpenHouse(String EType, String propertyName, String scheduleEventDate, String SceheduleFromtime,
			String ScheduleToTime) throws InterruptedException, IOException, ParseException {
		log.info("Create Open House Test");
		CRMDashboardCreateEventPage CD = new CRMDashboardCreateEventPage();
		CD.clickOnHeaderCreateBtn();
		CD.OpenHouseEvent(EType, propertyName, scheduleEventDate, SceheduleFromtime, ScheduleToTime);
		CD.clickOnCreateBtn();
		CD.scheduleValidation(EType, scheduleEventDate, SceheduleFromtime, ScheduleToTime);
	}

	@DataProvider(name = "dataToOpenHouse")
	public Object[][] dataToOpenHouse() throws IOException {
		return new Object[][] { { "Open House", "Sitka Meadows", "30", "5:30 p.m.", "6:30 p.m." }

		};
	}

	@Test(dataProvider = "dataToOpenHouseForAnotherAgent", enabled = false)

	public void createOpenHouseAnotherAgent(String EType, String propertyName, String scheduleEventDate,
			String SceheduleFromtime, String ScheduleToTime,String agentName) throws InterruptedException, IOException, ParseException {
		log.info("Create Open House Test For Another Agent");
		CRMDashboardCreateEventPage CD = new CRMDashboardCreateEventPage();
		CD.clickOnHeaderCreateBtn();
		CD.OpenHouseEvent(EType, propertyName, scheduleEventDate, SceheduleFromtime, ScheduleToTime);
		CD.SelectAnotherAgentEvent(agentName);
		 CD.clickOnCreateBtn();
		CRMLoginPage CP = new CRMLoginPage();
		CP.testLogout();
		CP.testLogin("jyoti.gorde@anyonehome.com", "@123");			
	    CD.scheduleValidation(EType,scheduleEventDate,SceheduleFromtime,ScheduleToTime);
	}

	@DataProvider(name = "dataToOpenHouseForAnotherAgent")
	public Object[][] dataToOpenHouseOtherAgent() throws IOException {
		return new Object[][] { { "Open House", "Sitka Meadows", "28", "5:30 p.m.", "6:30 p.m.","Jyoti Gorde" }

		};
	}

	@Test(dataProvider = "dataToPersonalEvent", enabled = false)

	public void createPersonalEvent(String EType, String personalEventDate, String SceheduleFromtime,
			String ScheduleToTime, String eventName, String Notes)
			throws InterruptedException, IOException, ParseException {
		log.info("Create Personal Event Test");
		CRMDashboardCreateEventPage CD = new CRMDashboardCreateEventPage();
		CD.clickOnHeaderCreateBtn();
		CD.PersonalEvent(EType, personalEventDate, SceheduleFromtime, ScheduleToTime, eventName, Notes);
		CD.clickOnCreateBtn();
		CD.scheduleValidation(eventName, personalEventDate, SceheduleFromtime, ScheduleToTime);
	}

	@DataProvider(name = "dataToPersonalEvent")
	public Object[][] dataToPersonalEvent() throws IOException {
		return new Object[][] {
				{ "Personal Event", "30", "8:30 a.m.", "9:00 a.m.", "TestPersonal Event", "Personal Event Testing" }

		};
	}
	
	@Test(dataProvider = "dataToPersonalEventForAnotherAgent", enabled = true)

	public void createPersonalEventForAnotherAgent(String EType, String personalEventDate, String SceheduleFromtime,
			String ScheduleToTime, String eventName, String Notes,String agentName)
			throws InterruptedException, IOException, ParseException {
		log.info("Create Personal Event Test For Another Agent");
		CRMDashboardCreateEventPage CD = new CRMDashboardCreateEventPage();
		CD.clickOnHeaderCreateBtn();
		CD.PersonalEvent(EType, personalEventDate, SceheduleFromtime, ScheduleToTime, eventName, Notes);
		CD.SelectAnotherAgentEvent(agentName);	
		CD.clickOnCreateBtn();
		CRMLoginPage CP = new CRMLoginPage();
		CP.testLogout();
		CP.testLogin("jyoti.gorde@anyonehome.com", "@123");		
		CD.scheduleValidation(eventName, personalEventDate, SceheduleFromtime, ScheduleToTime);
	}

	@DataProvider(name = "dataToPersonalEventForAnotherAgent")
	public Object[][] dataToPersonalEventForAnotherAgent() throws IOException {
		return new Object[][] {
				{ "Personal Event", "30", "12:30 p.m.", "1:00 p.m.", "Another Agent Test Personal Event", "Personal Event Testing","Jyoti Gorde" }

		};
	}

	@Test(dataProvider = "dataToServiceRequestCreate", enabled = false)

	public void createServiceRequest(String EType, String Classification, String FName, String LName, String phoneNo,
			String Email, String ContactType, String fromTime, String ToTime, String propertyName, String Unit,
			String SRType, String areaImpacted, String ENotes, String SRNotes)
			throws InterruptedException, IOException {
		log.info("Create Service Request Test");
		CRMDashboardCreateEventPage CD = new CRMDashboardCreateEventPage();
		CD.clickOnHeaderCreateBtn();
		CD.createServiceRequest(EType, Classification, FName, LName, phoneNo, Email, ContactType, fromTime, ToTime,
				propertyName, Unit, SRType, areaImpacted, ENotes, SRNotes);
		CD.clickOnCreateBtn();
		CD.ServiceRequestValidation(Classification, propertyName, Unit, FName, LName, SRType);
	}

	@DataProvider(name = "dataToServiceRequestCreate")
	public Object[][] dataToSR() throws IOException {
		return new Object[][] { { "Service Request", "Emergency", "Kione", "Finch", "9850025668", "jyotig@gmail.com",
				"Phone", "8:30", "9:00", "Sitka Meadows", "UM test 01", "SR-Fire/Injury-Sitka", "Backyard",
				"Entry Notes", "Service Notes" }

		};
	}

	@Test(dataProvider = "dataToServiceRequestCreateForExistResident", enabled = false)

	public void createServiceRequestForExistResident(String EType, String Classification, String FName, String LName,
			String ContactType, String fromTime, String ToTime, String propertyName, String Unit, String SRType,
			String areaImpacted, String ENotes, String SRNotes) throws InterruptedException, IOException {
		log.info("Create Service Request Test For Existing Resident");
		CRMDashboardCreateEventPage CD = new CRMDashboardCreateEventPage();
		CD.clickOnHeaderCreateBtn();
		CD.createServiceRequestForExistResident(EType, Classification, FName, LName, ContactType, fromTime, ToTime,
				propertyName, Unit, SRType, areaImpacted, ENotes, SRNotes);
		CD.clickOnCreateBtn();
		CD.ServiceRequestValidation(Classification, propertyName, Unit, FName, LName, SRType);
	}

	@DataProvider(name = "dataToServiceRequestCreateForExistResident")
	public Object[][] dataToSRExistResident() throws IOException {
		return new Object[][] { { "Service Request", "Emergency", "Clara", "Vanmatre", "Phone", "8:30", "9:00",
				"Nevermore Homes", "Unit 10", "SR-Gas Leak-Emergency", "Backyard", "Entry Notes", "Service Notes" }

		};
	}

	@AfterMethod
	public void driverClose() {
		// driver.close();
	}

}
