package steps;

import org.testng.annotations.Test;
import pages.SearchResultsPage;

public class SearchResultsSteps {

    private SearchResultsPage searchResultsPage = new SearchResultsPage();

    public SearchResultsSteps verifyThatTopResultContainsCorrectText(String text) {
        searchResultsPage.assertThatTopResultContainsCorrectText(text);
        return this;
    }

    public SearchResultsSteps verifyThatTopResultContainsProperAttributeText(String text) {
        searchResultsPage.assertThatTopResultContainsProperAttributeText(text);
        return this;
    }



}
