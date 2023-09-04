package com.udemy.spring.springselenium.googletest;


import com.udemy.spring.springselenium.page.google.GooglePage;
import com.udemy.spring.springselenium.util.ScreenshotUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;

import java.io.IOException;

@SpringBootTest

public class GoogleTest {

    @Autowired
    private GooglePage googlePage;

    @Lazy
    @Autowired
    private ScreenshotUtil screenshotUtil;


    @Test
    public void googleTest() throws IOException {
        this.googlePage.goTo();
        Assertions.assertTrue(this.googlePage.isAt());

        this.googlePage.getSearchComponent().search("spring boot");
        Assertions.assertTrue(this.googlePage.getSearchResult().isAt());
        Assertions.assertTrue(this.googlePage.getSearchResult().getResultsCount() > 2);

        this.screenshotUtil.takeScreenshot("springBootSearched.png");
    }

}
