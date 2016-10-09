package com.ex;

import org.junit.Test;
import org.openqa.selenium.ScreenOrientation;

import static org.junit.Assert.assertEquals;

public class AppTest extends TestBase {

    @Test public void orientationTest() {
        assertEquals(ScreenOrientation.PORTRAIT, driver.getOrientation());
        driver.rotate(ScreenOrientation.LANDSCAPE);
        assertEquals(ScreenOrientation.LANDSCAPE, driver.getOrientation());
        driver.rotate(ScreenOrientation.PORTRAIT);
    }
}
