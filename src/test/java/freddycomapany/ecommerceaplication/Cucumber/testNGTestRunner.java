package freddycomapany.ecommerceaplication.Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/java/freddycomapany/ecommerceaplication/Cucumber",
	    glue = "freddycomapany.ecommerceaplication.StepsDefinitions",
	    monochrome = true,
	    tags = "@Regression",
	    plugin = {
	        "pretty", // salida legible en consola
	        "html:target/cucumber-reports.html", // reporte HTML
	        "json:target/cucumber.json",         // reporte JSON
	        "junit:target/cucumber.xml"          // reporte JUnit XML
	    }
	)

public class testNGTestRunner extends AbstractTestNGCucumberTests{


}
