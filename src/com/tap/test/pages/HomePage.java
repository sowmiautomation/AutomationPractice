package com.tap.test.pages;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.tap.test.base.BaseTest;

/**
 * 
 * @author Sowmiya
 *
 */
public class HomePage extends BaseTest{

	/**
	 * WebElements for Header
	 */
	@FindBy(xpath="//h1")
	WebElement header;

	/**
	 * WebElements for Volunteer SignUp
	 */
	@FindBy(xpath="//input[@id='RESULT_TextField-1']")
	WebElement txtboxFirstName;

	@FindBy(xpath="//input[@id='RESULT_TextField-2']")
	WebElement txtboxLastName;

	@FindBy(xpath="//input[@id='RESULT_TextField-3']")
	WebElement txtboxPhone;

	@FindBy(xpath="//input[@id='RESULT_TextField-4']")
	WebElement txtboxCountry;

	@FindBy(xpath="//input[@id='RESULT_TextField-5']")
	WebElement txtboxCity;

	@FindBy(xpath="//input[@id='RESULT_TextField-6']")
	WebElement txtboxEmailAddress;

	@FindBy(xpath="//table/tbody/tr[1]/td/label[text()='Male']")
	WebElement chkboxGenderMale;

	@FindBy(xpath="//table/tbody/tr[2]/td/label[text()='Female']")
	WebElement chkboxGenderFemale;

	@FindBy(xpath="//div[@id='q15']/table/tbody/tr")
	List<WebElement> chkboxDays;

	@FindBy(id="RESULT_RadioButton-9")
	WebElement selectTimeToContact;

	@FindBy(id="RESULT_FileUpload-10")
	WebElement uploadFile;

	@FindBy(id="FSsubmit")
	WebElement btnSubmit;

	@FindBy(xpath="//div[@class='form_table']/div[@class='segment_header']")
	WebElement txtErrorMsg;

	/**
	 * WebElements for New Windows
	 */
	@FindBy(id="Wikipedia1_wikipedia-search-input")
	WebElement txtboxSearch;

	@FindBy(className="wikipedia-search-button")
	WebElement btnGo;

	@FindBy(xpath="//div[@id='wikipedia-search-result-link'][1]/a")
	WebElement linkSearchResult;

	/**
	 * WebElements for Alert
	 */
	@FindBy(xpath="//button[text()='Click Me']")
	WebElement txtAlertMsg;	

	/**
	 * WebElements for Date Picker
	 */
	@FindBy(id="datepicker")
	WebElement txtboxDatePicker;

	/**
	 * WebElements for Select Menu
	 */
	@FindBy(id="speed")
	WebElement selectSpeedText;

	/**
	 * WebElements for Text Labels
	 */
	@FindBy(xpath="//div[@id='Text1']/div")
	WebElement txtLabels;

	/**
	 * WebElements for Double Click
	 */
	@FindBy(id="field1")
	WebElement txtboxFieldOne;

	@FindBy(id="field2")
	WebElement txtboxFieldTwo;

	@FindBy (xpath="//button[text()='Copy Text']")
	WebElement btnCopyText;	

	/**
	 * WebElements for Drag and Drop
	 */
	@FindBy(id="draggable")
	WebElement boxDrag;

	@FindBy(id="droppable")
	WebElement boxDrop;

	@FindBy(xpath="//*[@id='droppable']/p")
	WebElement txtDropBox;

	/**
	 * WebElements for Drag and Drop Images
	 */
	@FindBy(xpath="//*[@id='gallery']/li/img[contains(@src,'male')]")
	WebElement boxDragImageOne;

	@FindBy(xpath="//*[@id='gallery']/li/img[contains(@src,'female')]")
	WebElement boxDragImageTwo;

	@FindBy(id="trash")
	WebElement boxDragTrash;

	@FindBy(xpath="//*[@id='trash']/ul/li/img[contains(@src,'male')]")
	WebElement boxDropImageOne;

	@FindBy(xpath="//*[@id='trash']/ul/li/img[contains(@src,'male')]")
	WebElement boxDropImageTwo;

	/**
	 * WebElements for Slider
	 */
	@FindBy(xpath="//*[@id='slider']/span")
	WebElement sliderCursor;

	/**
	 * WebElements for Resizable
	 */
	@FindBy(id="resizable")
	WebElement boxResize;

	@FindBy(xpath="//*[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']")
	WebElement boxResizeIcon;

	/**
	 * WebElements for HTML Table
	 */
	@FindBy(xpath="//*[@id='HTML1']/div[1]/table/tbody/tr")
	List<WebElement> tableRows;

	@FindBy(xpath="//*[@id='HTML1']/div[1]/table/tbody/tr/th")
	List<WebElement> tableColumns;

	/**
	 * WebElements for Tooltips
	 */
	@FindBy(id="age")
	WebElement txtboxAge;

	/**
	 * Constructor to initialize the Page Objects
	 */
	public HomePage(){
		PageFactory.initElements(driver, this);
	}

	/**
	 * Method to Validate Home Page Title
	 * @return title
	 */
	public String validateHomePageTitle(){
		return driver.getTitle();
	}

	/**
	 * Method to Validate Home Page Header
	 * @return title
	 */
	public String validateHomePageHeader(){
		return header.getText();
	}

	/**
	 * Method to Validate Voulunteer SignUp
	 * @param firstName
	 * @param lastName
	 * @param phone
	 * @param country
	 * @param city
	 * @param email
	 * @param gender
	 * @param days
	 * @param time
	 * @param filePath
	 * @return message
	 * @throws InterruptedException
	 */
	public String validateVoulunteerSignUp(String firstName, String lastName, String phone, String country, String city, String email, String gender, String[] days, String time, String filePath) throws InterruptedException {
		switchFrameByIndex(0);
		txtboxFirstName.sendKeys(firstName);
		txtboxLastName.sendKeys(lastName);
		txtboxPhone.sendKeys(phone);
		txtboxCountry.sendKeys(country);
		txtboxCity.sendKeys(city);
		txtboxEmailAddress.sendKeys(email);

		if(gender.equalsIgnoreCase("Male")) {
			chkboxGenderMale.click();
		}else {
			chkboxGenderFemale.click();
		}

		for (int i = 0; i < days.length; i++) {
			for (int j = 0; j < chkboxDays.size(); j++) {
				String value = chkboxDays.get(j).findElement(By.xpath(".//td//label")).getText();
				if(days[i].equalsIgnoreCase(value)) {
					chkboxDays.get(j).findElement(By.xpath(".//td//label")).click();
					break;
				}
			}
		}

		selectFromDropdownVisibleText(selectTimeToContact, time);
		uploadFile.sendKeys(filePath);
		//btnSubmit.click();
		Thread.sleep(1000);
		String msg = txtErrorMsg.getText();
		switchFrameToDefault();
		return msg;		
	}

	/**
	 * Method to Validate SearchBox
	 * @param searchWord
	 * @return search result
	 * @throws InterruptedException
	 */
	public String validateSearchBox(String searchWord) throws InterruptedException {
		txtboxSearch.sendKeys(searchWord);
		btnGo.click();
		Thread.sleep(1000);
		String result = linkSearchResult.getText();
		return result;  
	}

	/**
	 * Method to Validate Alert Text
	 * @return alert text
	 */
	public String validateAlertText() {
		txtAlertMsg.click();
		Alert alert = switchToAlert();
		String alertText = alert.getText();
		alert.accept();
		return alertText; 
	}

	/**
	 * Method to Validate Date Picker
	 * @param sDate
	 * @return result of entered date
	 * @throws ParseException
	 */
	public boolean validateDatePicker(String sDate) throws ParseException {
		Date dDate = new SimpleDateFormat("dd-MMM-yyyy").parse(sDate);  
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");  
		String strDate = dateFormat.format(dDate);  
		txtboxDatePicker.sendKeys(strDate);
		String enteredDate = txtboxDatePicker.getAttribute("value");
		boolean result = enteredDate.equals(strDate);
		return result; 
	}

	/**
	 * Method to Validate Select Dropdown Text
	 * @param dropdown
	 * @param selectText
	 * @return selected text
	 * @throws InterruptedException
	 */
	public String validateSelectText(String dropdown, String selectText) throws InterruptedException {
		WebElement element = driver.findElement(By.id(dropdown));
		selectFromDropdownVisibleText(element, selectText);
		Thread.sleep(1000);
		String selectedText = getFirstSelectedOptionFromDropdown(element);
		return selectedText;
	}

	/**
	 * Method to Validate Text Labels
	 * @return text of label
	 */
	public String validateTextLabels() {
		String txtLabel = txtLabels.getText();
		return txtLabel;
	}

	/**
	 * Method to Validate XPath Axes
	 * @param empID
	 * @return employee details
	 */
	public List<String> validateXPathAxes(String empID) {
		List<String> empDetails = new ArrayList<String>();
		String name = driver.findElement(By.xpath("//empinfo//empid[text()='"+empID+"']/following::name[1]")).getText();
		String designation = driver.findElement(By.xpath("//empinfo//empid[text()='"+empID+"']/following::designation[1]")).getText();
		String discipline = driver.findElement(By.xpath("//empinfo//empid[text()='"+empID+"']/following::designation[1]")).getAttribute("discipline");
		//String experience = driver.findElement(By.xpath("//empinfo//empid[text()='"+empID+"']/following::designation[1]")).getAttribute("experience");
		String email = driver.findElement(By.xpath("//empinfo//empid[text()='"+empID+"']/following::email[1]")).getText();
		empDetails.add(name);
		empDetails.add(designation);
		empDetails.add(discipline);
		//empDetails.add(experience);
		empDetails.add(email);
		return empDetails;
	}

	/**
	 * Method to Validate Double Click
	 * @param text
	 * @return text after double click
	 * @throws InterruptedException
	 */
	public String validateDoubleClick(String text) throws InterruptedException {
		txtboxFieldOne.clear();
		txtboxFieldOne.sendKeys(text);
		Actions action = new Actions(driver);
		action.doubleClick(btnCopyText).perform();
		Thread.sleep(1000);
		String copyText = txtboxFieldTwo.getAttribute("value");
		return copyText;
	}

	/**
	 * Method to Validate Drag And Drop
	 * @return text of drop
	 * @throws InterruptedException
	 */
	public String validateDragAndDrop() throws InterruptedException {
		Actions action = new Actions(driver);
		action.dragAndDrop(boxDrag,boxDrop).perform();
		Thread.sleep(1000);
		String dropText = txtDropBox.getText();
		return dropText;
	}

	/**
	 * Method to Validate Drag And Drop Images
	 * @return result of drag and drop images
	 * @throws InterruptedException
	 */
	public boolean validateDragAndDropImages() throws InterruptedException {
		Actions action = new Actions(driver);
		action.dragAndDrop(boxDragImageOne,boxDragTrash).perform();
		Thread.sleep(1000);
		action.dragAndDrop(boxDragImageTwo,boxDragTrash).perform();
		Thread.sleep(1000);
		boolean result = boxDropImageOne.isDisplayed() & boxDropImageTwo.isDisplayed();
		return result;
	}

	/**
	 * Method to Validate Slider
	 * @param movePercent
	 * @return slider movement percent
	 * @throws InterruptedException
	 */
	public String validateSlider(String movePercent) throws InterruptedException {		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'left:"+movePercent+"%;')",sliderCursor);
		Thread.sleep(2000);
		String sliderMovementPercent = sliderCursor.getAttribute("style");
		return sliderMovementPercent;
	}

	/**
	 * Method to Validate Resizable
	 * @param width
	 * @param height
	 * @return result of Resizable
	 * @throws InterruptedException
	 */
	public boolean validateResizable(int width, int height) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",boxResize);
		Thread.sleep(1000);
		//Actions action = new Actions(driver);
		//action.clickAndHold(boxResizeIcon).moveByOffset(width, height).release().build().perform();
		//Thread.sleep(2000);
		String dim = "width: "+width+"px; height: "+height+"px;";
		String styleSize = "arguments[0].setAttribute('style','"+ dim + "')";		
		js.executeScript(styleSize,boxResize);
		Thread.sleep(1000);
		Dimension style = boxResize.getSize();
		boolean result = style.width == width & style.height == height;
		return result;
	}

	/**
	 * Method to Validate HTML Table Row and Column Count 
	 * @param row
	 * @param column
	 * @return result of count
	 */
	public boolean validateHtmlTableCount(int row, int column) {
		int rows = tableRows.size();
		int columns = tableColumns.size();
		boolean result = rows == row & columns == column;
		return result;
	}

	/**
	 * Method to Validate HTML Table Specific Content
	 * @param contentText
	 * @return result of content
	 */
	public boolean validateHtmlTableSpecificContent(String contentText) {
		boolean result = false;

		for(int i=2; i<=tableRows.size(); i++) {
			for(int j=1; j<=tableColumns.size(); j++ ) {
				String text = driver.findElement(By.xpath("//*[@id='HTML1']/div/table/tbody/tr["+i+"]/td["+j+"]")).getText();
				if(text.equalsIgnoreCase(contentText)) {
					result = true;
					break;
				}
			}
			if(result)
				break;
		}
		return result;
	}

	/**
	 * Method to Validate Tooltip
	 * @return text of Tooltip
	 */
	public String validatToolTip() {
		String text = txtboxAge.getAttribute("title");
		return text;
	}
}
