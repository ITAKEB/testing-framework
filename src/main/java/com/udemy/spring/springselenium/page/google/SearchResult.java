package com.udemy.spring.springselenium.page.google;

import com.udemy.spring.springselenium.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchResult extends Base {

    @FindBy(css = "div.MjjYud")
    private List<WebElement> results;

    public int getResultsCount(){
        return results.size();
    }

    @Override
    public boolean isAt() {
        return this.wait.until(driver -> !this.results.isEmpty());
    }
}
