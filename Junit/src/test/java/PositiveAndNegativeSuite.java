import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by User on 16.11.2017.
 */

@Suite.SuiteClasses({TestFile.class})
@RunWith(Categories.class)
@Categories.IncludeCategory({MyCategories.PositiveTests.class ,MyCategories.NegativeTests.class} )
public class PositiveAndNegativeSuite {

}
