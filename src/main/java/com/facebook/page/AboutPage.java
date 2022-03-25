package com.facebook.page;

import com.facebook.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AboutPage extends TestBase {

    @FindBy(xpath = "//span[contains(text(),'Work and education')]")
    WebElement work;

    @FindBy(xpath = "//span[contains(text(),'Places lived')]")
    WebElement place;

    @FindBy(xpath = "//span[contains(text(),'Contact and basic info')]")
    WebElement contacts;

    @FindBy(xpath = "//span[contains(text(),'Family and relationships')]")
    WebElement family;

    @FindBy(xpath = "//span[contains(text(),'Details about you')]")
    WebElement details;

    @FindBy(xpath = "//span[contains(text(),'Life events')]")
    WebElement life;


    public AboutPage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyAboutPageTitle() {
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.getTitle();
    }

    public WorkAndEduacation clickOnWorkAndEduacation() {
        work.click();
        return new WorkAndEduacation();
    }

    public PlacesLived clickOnPlacesLived() {
        place.click();
        return new PlacesLived();
    }

    public ContactAndInfo clickOnContacts() {
        contacts.click();
        return new ContactAndInfo();
    }

    public FamilyAndRelationship clickOnFamilyAndRelationship() {
        family.click();
        return new FamilyAndRelationship();
    }

    public DetailsAboutYou clickOnDetails() {
        details.click();
        return new DetailsAboutYou();
    }

    public LifeEvents clickOnLifeEvents() {
        life.click();
        return new LifeEvents();
    }
}