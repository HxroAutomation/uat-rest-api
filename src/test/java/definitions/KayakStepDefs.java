package definitions;

import cucumber.api.java.en.Given;
import pages.KeyakPage;
import pages.Page;

public class KayakStepDefs {
    @Given("I open {string}")
    public void iOpenKayak(String page) {
        if("kayak".equals(page)) {
            new KeyakPage().open(page);
        } else {
            throw new RuntimeException("Unsupported page " + page);
        }

    }
}
