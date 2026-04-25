package FreddyCompany.DataBaseTestingTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class AppTest {
    
  @Test
  public void shouldAnswerWithTrue() throws SQLException {
	  String url = "jdbc:mysql://localhost:3306/prueba";
	  String user = "root";
	  String password = "1234";
	  String userSystem = "freddy";
	  String passwordSystem = "1234";
	  String userDatabase = "";
	  String passwordDabase = "";
	  
	  WebDriver driver = new ChromeDriver();
	  Connection con =  DriverManager.getConnection(url, user, password);
	  Statement stm = con.createStatement();
	  ResultSet rs = stm.executeQuery("Select u.* from Users u where u.user = '"+userSystem+"';");
	  
	  while(rs.next()) {
		  userDatabase = rs.getString("user");
		  passwordDabase = rs.getString("password");	  
	  }
	 
	  driver.get("https://test.salesforce.com/");
	  
	  driver.findElement(By.id("username")).sendKeys(userDatabase);
	  driver.findElement(By.id("password")).sendKeys(passwordDabase);
	  
  }
}
