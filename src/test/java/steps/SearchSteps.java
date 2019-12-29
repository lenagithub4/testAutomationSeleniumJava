package steps;

import pages.SearchPage;

public class SearchSteps {

    private SearchPage searchPage = new SearchPage();

    public SearchResultsSteps executeSearchByKeyword(String keyword) throws InterruptedException {
        searchPage.pasteToSearchField(keyword);
        searchPage.clickSearchButtonOrPressEnter();
        return new SearchResultsSteps();
    }

    public SearchSteps openTooltip() {
        searchPage.moveToVoiceSearchButton();
        return this;
    }

    public SearchSteps verifyThatTooltipContainsProperText(String text) {
        searchPage.assertThatVoiceSearchTooltipContainsText(text);
        return this;
    }

}
