package cukeTest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //features="CucumberJVM/src/test/java/resources/features/GitHubTest.feature",
        //features = "src/test/java/features/mercury.feature",
        // facing issue with feature file location
        features="src/test/java/features/GitHubTest.feature",
        glue = "stepDef",
        plugin = {"pretty", "html:target/cucumber-reports"}
        // use plugin instead, as format has been deprecated
        /*plugin = {"pretty", "json:FolderName/cucumber.json"}
        plugin= {"pretty", "junit:FolderNam0e/cucumber.xml"}
        plugin= {"pretty", "html:FolderName/cucumber.html"}
        plugin=
        {
                "pretty"
                , "json:FolderName/cucumber.json"
                , "junit:FolderNam0e/cucumber.xml"
                , "html:FolderName/cucumber.html"
        }*/
        //tags={"@mercury"}
)
public class GitHub_CukeTest {
}