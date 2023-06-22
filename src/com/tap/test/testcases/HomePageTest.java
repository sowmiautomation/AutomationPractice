package com.tap.test.testcases;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.tap.test.base.BaseTest;
import com.tap.test.pages.HomePage;
import com.tap.test.util.Utilities;

/**
 * Test class to write all TestNG tests
 * @author Sowmiya
 *
 */
public class HomePageTest extends BaseTest{
	HomePage homePage;
	Utilities utilities;

	/**
	 * Constructor to initialize BaseTest class
	 */
	public HomePageTest(){
		super();
	}

	/**
	 * Before Test Method to run before every test for initialization of
	 * BaseTest class and HomePage
	 */
	@BeforeMethod
	public void setUp(){
		initialization();
		utilities = new Utilities();
		homePage = new HomePage();		
	}

	/**
	 * Test Method for Title
	 */
	@Test()
	public void validateTitleTest() {		
		String title = homePage.validateHomePageTitle();
		Assert.assertEquals(title, "Automation Testing Practice");
	}

	/**
	 * Test Method for Header
	 */
	@Test()
	public void validateHeaderTest() {
		String header = homePage.validateHomePageHeader();
		Assert.assertEquals(header, "Automation Testing Practice");
	}

	/**
	 * Test Method for Voulunteer SignUp
	 * @throws InterruptedException
	 */
	@Test()
	public void voulteerSignUpTest() throws InterruptedException{
		String uploadFilePath = System.getProperty("user.dir")+ "\\upload\\uploadsample.jpg";
		String[] days = {"Sunday", "Tuesday", "Friday"};
		String msg = homePage.validateVoulunteerSignUp("Sowmiya", "Chinnasamy", "253-487-9828", "United States", "Kent", "sowmi3535@gmail.com", "Male", days, "Evening", uploadFilePath);
		Assert.assertEquals(msg, "An error has occurred");
	}

	/**
	 * Test Method for New Windows
	 * @throws InterruptedException
	 */
	@Test
	public void validateNewWindowsTest() throws InterruptedException {
		String searchResult = homePage.validateSearchBox("automation");
		Assert.assertEquals(searchResult.toUpperCase(), ("automation").toUpperCase());
	}

	/**
	 * Test Method for Alert
	 */
	@Test
	public void validateAlertTest() {
		String alertText = homePage.validateAlertText();
		Assert.assertEquals(alertText, "Press a button!");
	}

	/**
	 * Test Method for Date Picker
	 * @throws ParseException
	 */
	@Test
	public void validateDatePickerTest() throws ParseException {
		boolean date = homePage.validateDatePicker("25-Feb-2023");
		Assert.assertTrue(date);
	}

	/**
	 * Test Method for Select Menu
	 * @throws InterruptedException
	 */
	@Test
	public void validateSelectMenuTest() throws InterruptedException {
		String selectedSpeedText = homePage.validateSelectText("speed", "Medium");
		Assert.assertEquals(selectedSpeedText.toUpperCase(), ("Medium").toUpperCase());
		String selectedFileText = homePage.validateSelectText("files", "DOC file");
		Assert.assertEquals(selectedFileText.toUpperCase(), ("Doc File").toUpperCase());
		String selectedNumberText = homePage.validateSelectText("number", "4");
		Assert.assertEquals(selectedNumberText, "4");
		String selectedProductText = homePage.validateSelectText("products", "Bing");
		Assert.assertEquals(selectedProductText.toUpperCase(), ("Bing").toUpperCase());
		String selectedAnimalText = homePage.validateSelectText("animals", "Big Baby Cat");
		Assert.assertEquals(selectedAnimalText.toUpperCase(), ("Big Baby Cat").toUpperCase());		
	}

	/**
	 * Test Method for Text Labels
	 */
	@Test
	public void validateTextLabelsTest() {
		String txtLabels = homePage.validateTextLabels();
		Assert.assertTrue(txtLabels.equals("Message_12\n" + "Message-123\n" + "Message $ 1234\n" + "Message **** 12345\n" + "Message &&&123456\n" + "Message#### 1234567"));
	}

	/**
	 * Test Method for XPath Axes
	 */
	@Test()
	public void validateXPathAxesTest() {
		List<String> expectedEmployeeDetails1 = Arrays.asList("David", "Senior Engineer", "web", "david@myemail.com");
		List<String> actualEmployeeDetails1 = homePage.validateXPathAxes("101");
		Assert.assertTrue(utilities.validateList(actualEmployeeDetails1, expectedEmployeeDetails1));
		List<String> expectedEmployeeDetails2 = Arrays.asList("John", "DBA Engineer", "DBA", "john@email.com");
		List<String> actualEmployeeDetails2 = homePage.validateXPathAxes("102");
		Assert.assertTrue(utilities.validateList(actualEmployeeDetails2, expectedEmployeeDetails2));
		List<String> expectedEmployeeDetails3 = Arrays.asList("Marry", "Application Developer", "appdev", "marry@email.com");
		List<String> actualEmployeeDetails3 = homePage.validateXPathAxes("103");
		Assert.assertTrue(utilities.validateList(actualEmployeeDetails3, expectedEmployeeDetails3));
	}

	/**
	 * Test Method for Double Click
	 * @throws InterruptedException
	 */
	@Test
	public void validateDoubleClickTest() throws InterruptedException {
		String copiedText = homePage.validateDoubleClick("Sowmiya");
		Assert.assertEquals(copiedText, "Sowmiya" );
	}

	/**
	 * Test Method for Drag And Drop
	 * @throws InterruptedException
	 */
	@Test
	public void validateDragAndDropTest() throws InterruptedException {		
		String droppedText = homePage.validateDragAndDrop();
		Assert.assertEquals(droppedText, "Dropped!");
	}

	/**
	 * Test Method for Drag And Drop Images
	 * @throws InterruptedException
	 */
	@Test
	public void validateDragAndDropImagesTest() throws InterruptedException {
		boolean verifyDroppedImages = homePage.validateDragAndDropImages();
		Assert.assertTrue(verifyDroppedImages);
	}

	/**
	 * Test Method for Slider
	 * @throws InterruptedException
	 */
	@Test
	public void validateSlideTest() throws InterruptedException {
		String sliderMovedPercent = homePage.validateSlider("100");
		Assert.assertEquals("left: 100%;", sliderMovedPercent);		
	}

	/**
	 * Test Method for Resizable
	 * @throws InterruptedException
	 */
	@Test
	public void validateResizableTest() throws InterruptedException {
		boolean verifyResizableBox = homePage.validateResizable(300,250);
		Assert.assertTrue(verifyResizableBox);
	}

	/**
	 * Test Method for HTML Table
	 */
	@Test
	public void validateHTMLTableTest() {
		boolean verifyCount = homePage.validateHtmlTableCount(7, 4);
		Assert.assertTrue(verifyCount);
		boolean verifyContent = homePage.validateHtmlTableSpecificContent("Master In JS");
		Assert.assertTrue(verifyContent);
	}

	/**
	 * Test Method for Tooltip
	 */
	@Test
	public void validateToolTipsTest() {
		String tooltipText = homePage.validatToolTip();
		Assert.assertEquals("We ask for your age only for statistical purposes.", tooltipText);		
	}

	/**
	 * After Test Method to run after every test to quit WebDriver
	 */
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
