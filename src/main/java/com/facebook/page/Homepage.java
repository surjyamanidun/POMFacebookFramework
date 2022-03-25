package com.facebook.page;

import com.facebook.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class Homepage extends TestBase {

    @FindBy(xpath = "//span[contains(text(),'Surjyamani Duan')]")
    WebElement userProfile;

 //  @FindBy(xpath = "//td[contains(text(),'login')]")
   // WebElement login;
    @FindBy(xpath = "//span[contains(text(), 'Friends')]")
    WebElement findFriend;

    @FindBy(xpath = "//span[contains(text(),'Groups')]")
    WebElement groups;


    public Homepage() {

        PageFactory.initElements(driver, this);
    }

    public String verifyHomePagePageTitle() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.getTitle();
    }

    public ProfilePage clickOnProfile() {
        userProfile.click();
        return new ProfilePage();
    }

    public FindFriendsPage clickOnFriends() {
        findFriend.click();
        return new FindFriendsPage();
    }

    public GroupsPage clickOnGroups() {
        groups.click();
        return new GroupsPage();
    }

}




