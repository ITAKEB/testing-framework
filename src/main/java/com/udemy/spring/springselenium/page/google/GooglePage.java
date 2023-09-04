package com.udemy.spring.springselenium.page.google;

import com.udemy.spring.springselenium.page.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GooglePage extends Base {

    @Autowired
    private SearchResult searchResult;

    @Autowired
    private  SearchComponent searchComponent;

    @Value("${application.url:https://www.google.com}")
    private String url;

    public void goTo(){
        this.driver.get(url);
    }

    public SearchComponent getSearchComponent(){
        return this.searchComponent;
    }

    public SearchResult getSearchResult(){
        return this.searchResult;
    }


    @Override
    public boolean isAt() {
        return this.searchComponent.isAt();
    }
}
