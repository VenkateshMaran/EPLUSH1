package pages;

import org.openqa.selenium.WebDriver;

public class PageFactoryManager {

   private static LoginPage loginPage;
    private static MemberSearchPage memberSearch;
    private static MemberVerificationPage memberVerification;

    private static AGInquiry angInquiry;

    private static AuthorizationInquiryPage authInquiry;

    public static LoginPage getLoginPage(WebDriver driver)
    {
        return loginPage == null ? new LoginPage(driver) : loginPage;
    }


    public static MemberSearchPage getMemberSearchPage(WebDriver driver)
    {
        return memberSearch == null ? new MemberSearchPage(driver) : memberSearch;
    }

    public static MemberVerificationPage getMemberVerificationPage(WebDriver driver)
    {
        return memberVerification == null ? new MemberVerificationPage(driver) : memberVerification;
    }

    public static AGInquiry getAGInquiry(WebDriver driver)
    {
        return angInquiry == null ? new AGInquiry(driver) : angInquiry;
    }

    public static AuthorizationInquiryPage getAuthInquiry(WebDriver driver)
    {
        return authInquiry == null ? new AuthorizationInquiryPage(driver) : authInquiry;
    }

}
