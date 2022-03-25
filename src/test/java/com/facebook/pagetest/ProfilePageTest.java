package com.facebook.pagetest;

import com.facebook.base.TestBase;
import com.facebook.page.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfilePageTest extends TestBase {

    LoginPage loginPage;
    Homepage homepage;
    ProfilePage profilePage;
    AboutPage aboutPage;
    FriendsPage friendsPage;
    PhotosPage photosPage;
    VideosPage videosPage;
    CheckPage checkPage;

    public ProfilePageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        homepage = new Homepage();
        homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        profilePage = homepage.clickOnProfile();
    }

    @Test(priority = 1)
    public void verifyProfilePageTitleTest() {
        String profilePageTitle = profilePage.verifyProfilePageTitle();
        Assert.assertEquals(profilePageTitle, "Surjyamani Duan", "ProfilePage is not matched");
    }

    @Test(priority = 2)
    public void verifyClickOnAbout() {
        aboutPage = profilePage.clickOnAbout();

    }

    @Test(priority = 3)
    public void verifyClickOnFriends() {
        friendsPage = profilePage.clickOnFriends();

    }

    @Test(priority = 4)
    public void verifyClickOnPhotos() {
        photosPage = profilePage.clickOnPhotos();

    }

    @Test(priority = 5)
    public void verifyClickOnVideos() {
        videosPage = profilePage.clickOnVideos();

    }

    @Test(priority = 6)
    public void verifyClickOnCheck() {
        checkPage = profilePage.clickOnCheck();

    }

    @AfterMethod
    public void tearDown() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}