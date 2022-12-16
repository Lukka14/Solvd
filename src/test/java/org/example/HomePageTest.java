package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class HomePageTest {
    private static final Logger LOGGER = LogManager.getLogger(HomePageTest.class);
    @Test
    public void testPage(){
        HomePage homePage = new HomePage();
        homePage.openPage();
        homePage.search("Training shoes");
        homePage.printAllItemInfo();
        homePage.close();
    }


}
