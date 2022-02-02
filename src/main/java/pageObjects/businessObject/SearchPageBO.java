package pageObjects.businessObject;

import pageObjects.FilterPage;
import pageObjects.MainPage;
import pageObjects.SearchPage;
import pageObjects.SortPage;

public class SearchPageBO {
    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();
    FilterPage filterPage = new FilterPage();
    SortPage sortPage = new SortPage();


    public SearchPageBO typeCategory(String commodity){
        mainPage
                .proceedToMainPage()
                .clickSearchField();
        searchPage
                .enterCommodity(commodity);
        return this;
    }

    public SearchPageBO selectBrand(String brand){
        searchPage
                .clickFilter();
        filterPage
                .typeBrand(brand)
                .clickCheckboxBrand()
                .shutFilter();
        return this;
    }

    public SearchPageBO throwCheapestToBucket(){
        searchPage
                .clickSortButton();
        sortPage
                .selectFromCheaper();
        searchPage
                .clickElementsBucket()
                .clickMainBucket();
        return this;
    }

}
