package pageObjects.businessObject;

import pageObjects.MainPage;

public class SupportPageBO {
    MainPage mainPage = new MainPage();

    public SupportPageBO getToSupportPage() {
        mainPage
                .proceedToMainPage()
                .scrollToTextSupport()
                .proceedToSupportPage();
        return this;
    }
}
