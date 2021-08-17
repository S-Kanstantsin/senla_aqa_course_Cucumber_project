import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.*;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "step",
        tags = "@test",
//        dryRun = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class Runner {
}
