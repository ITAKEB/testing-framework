package com.udemy.spring.springselenium.page.google;

import com.udemy.spring.springselenium.page.Base;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchComponent extends Base {

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(name = "btnK")
    private List<WebElement> searchBtn;

    public void search(final String keyboard){
        this.searchBox.sendKeys(keyboard);
        this.searchBox.sendKeys(Keys.TAB);
//        this.searchBox.sendKeys(Keys.ENTER);
        this.searchBtn
                .stream()
                .filter(e-> e.isDisplayed() && e.isEnabled())
                .findFirst()
                .ifPresent(WebElement::click);
    }


    @Override
    public boolean isAt() {
        return this.wait.until(driver -> this.searchBox.isDisplayed());
    }
}
