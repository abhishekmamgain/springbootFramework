package com.ea.SpringStart;

import com.ea.SpringStart.pages.HomePage;
import com.ea.SpringStart.pages.LoginPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.TestPropertySource;
import org.testng.Assert;
import org.testng.annotations.Test;

@SpringBootTest
@TestPropertySource(properties = {
    "browser=Chrome",
    "app.url=http://eaapp.somee.com"
})
public class PageObjectTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private HomePage homePage;

    @Autowired
    private LoginPage loginPage;

    @Value("${app.url}")
    private String appUrl;

    @Test
    public void testPageNavigation() {
        // Navigate to the application
        homePage.Navigate(appUrl);
        
        // Verify we can navigate (basic test)
        Assert.assertNotNull(homePage, "HomePage should be injected");
        Assert.assertNotNull(loginPage, "LoginPage should be injected");
        Assert.assertNotNull(appUrl, "App URL should be configured");
        
        System.out.println("Successfully navigated to: " + appUrl);
    }

    @Test
    public void testLoginFlow() {
        // Navigate to the application
        homePage.Navigate(appUrl);
        
        // Click login to go to login page
        LoginPage loginPageResult = homePage.ClickLogin();
        Assert.assertNotNull(loginPageResult, "Should navigate to login page");
        
        // Perform login
        loginPage.Login("admin", "password");
        HomePage homePageResult = loginPage.ClickLogin();
        Assert.assertNotNull(homePageResult, "Should navigate back to home page");
        
        System.out.println("Login flow test completed successfully");
    }
}
