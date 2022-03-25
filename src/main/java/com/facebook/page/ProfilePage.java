package com.facebook.page;

import com.facebook.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends TestBase {

    @FindBy(xpath = "//span[contains(text(),'About')],")
    WebElement about;

    @FindBy(xpath = "//span[contains(text(),'Friends')]")
    WebElement friends;

    @FindBy(xpath = "//span[contains(text(),'Photos')]")
    WebElement photos;

    @FindBy(xpath = "//span[contains(text(),'Videos')]")
    WebElement videos;

    @FindBy(xpath = "//span[contains(text(),'Check-ins')]")
    WebElement check;


    public ProfilePage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyProfilePageTitle() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.getTitle();
    }

    public AboutPage clickOnAbout() {
        about.click();
        return new AboutPage();
    }

    public FriendsPage clickOnFriends() {
        friends.click();
        return new FriendsPage();
    }

    public PhotosPage clickOnPhotos() {
        photos.click();
        return new PhotosPage();
    }

    public VideosPage clickOnVideos() {
        videos.click();
        return new VideosPage();
    }

    public CheckPage clickOnCheck() {
        check.click();
        return new CheckPage();
    }

}