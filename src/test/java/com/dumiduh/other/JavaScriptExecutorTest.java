package com.dumiduh.other;

import com.dumiduh.constants.Constants;
import com.dumiduh.utils.TestBase;
import io.github.handakumbura.EventListener;
import io.github.handakumbura.JavaScriptHelper;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class JavaScriptExecutorTest extends TestBase {
    private static final String OPTIONS_BLOCK = "'<option>papaya</option><option>apple</option>'";
    private static final String DROPDOWN_CSS_SELECTOR = "#dropdown";
    private static final String CALLBACK = "function(){console.log('clicked')}";

    @BeforeClass
    public static void setup() {
        instantiateDriver();
        driver.get(Constants.DROPDOWN_PAGE_URL);
    }

    @Test
    public static void javascriptTest() {
        JavaScriptHelper javaScriptHelper = new JavaScriptHelper(driver);

        //pauses execution up to 2 minutes.
        javaScriptHelper.pauseTheDOMForAGivenDuration(5000);

        //attaches a valid and well-formed HTML block as a child of a given element.
        javaScriptHelper.appendHTMLBlockAsAChild(OPTIONS_BLOCK,DROPDOWN_CSS_SELECTOR);

        //attaches a callback function to a given event in the DOM.
        javaScriptHelper.attachASnippetAsAEventCallBack(DROPDOWN_CSS_SELECTOR, EventListener.CLICK,CALLBACK);
    }


    @AfterClass
    public static void cleanUp() {
        driver.quit();
    }
}
