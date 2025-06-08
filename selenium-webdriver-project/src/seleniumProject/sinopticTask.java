package seleniumProject;

import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver; 
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class sinopticTask {
		WebDriver driver;
	
	
	public void launchbrowser() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://sinoptik.bg");
		
        Thread.sleep(2000);
       
		WebElement acceptCookiesButton = driver.findElement(By.id("didomi-notice-agree-button"));
		if (acceptCookiesButton.isDisplayed()) {
		    acceptCookiesButton.click();
		}
			
	}
	
	public void getcity() throws InterruptedException {
		driver.findElement(By.id("searchField")).sendKeys("Одеса");
	
        Thread.sleep(2000);
		
		List<WebElement> list = driver.findElements(By.cssSelector("div[class='autocomplete'] a"));
		
		for(WebElement listitem:list) {
			if (listitem.getText().equalsIgnoreCase("Одеса, Украйна")) {
				listitem.click();
				break;
		}
		}
       
	}
	
	
		public void checkcity() {
			String actualcity = driver.findElement(By.cssSelector("div[class='currentCityHeading'] h1")).getText();
			String expectedcity = "Одеса";
			if(actualcity.equals(expectedcity)) {
				System.out.println("The correct forecast is loaded");
			}
			else {
				System.out.println("The wrong forecast is loaded!");
			}		
			
		}
			
		
		
		public void checkDates() {
			
			driver.findElement(By.cssSelector("li[class='wf10day']")).click();
			
	        LocalDate currentDate = LocalDate.now();
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yy");

	        List<String> formattedDateList = new ArrayList<>();
	        
	        for (int i = 0; i < 10; i++) {
	            LocalDate dateToAdd = currentDate.plusDays(i);
	            String formattedDate = dateFormat.format(java.sql.Date.valueOf(dateToAdd));
	            formattedDateList.add(formattedDate);
	        }

	    
			List<WebElement> dates = driver.findElements(By.cssSelector("span[class='wf10dayRightDate']"));
				
			for (int i = 0; i < dates.size(); i++) {
		         String actualDateFromWeb = dates.get(i).getText();
		         String expectedDate = formattedDateList.get(i);
		            
		         assert actualDateFromWeb.equals(expectedDate) :
		                "Date mismatch for day " + (i + 1) + ": Expected " + expectedDate + ", Actual " + actualDateFromWeb;
		        }

		        System.out.println("Verification passed for all 10 dates!");

			}
		
		
		public void checkWeekdays() {
			
	        LocalDate currentDate = LocalDate.now();
	        DateTimeFormatter bulgarianFormatter = DateTimeFormatter.ofPattern("E.", new Locale("bg", "BG"));

			List<String> bulgarianWeekdays = new ArrayList<>();

	        for (int i = 0; i < 10; i++) {
	            LocalDate dateToAdd = currentDate.plusDays(i);
	            String formattedWeekday = dateToAdd.format(bulgarianFormatter);
	            // Capitalize the first letter
	            formattedWeekday = formattedWeekday.substring(0, 1).toUpperCase() + formattedWeekday.substring(1);
	            bulgarianWeekdays.add(formattedWeekday);
	        }
	        

			List<WebElement> webpageWeekdaysElements = driver.findElements(By.cssSelector("span[class='wf10dayRightDay']"));
			
			for (int i = 0; i < webpageWeekdaysElements.size(); i++) {
		         String actualWeekday = webpageWeekdaysElements.get(i).getText();
		         String expectedWeekday = bulgarianWeekdays.get(i);
		            
		         assert actualWeekday.equals(expectedWeekday) :
		                "Weekday mismatch for day " + (i + 1) + ": Expected " + expectedWeekday + ", Actual " + actualWeekday;
		        }

		        System.out.println("Verification passed for all 10 weekdays!");

		}
	       
	
	
	public static void main(String[] args) throws InterruptedException {
		sinopticTask obj = new sinopticTask();
		obj.launchbrowser();
		obj.getcity();
		obj.checkcity();
		obj.checkDates();
		obj.checkWeekdays();
	
	}

}
