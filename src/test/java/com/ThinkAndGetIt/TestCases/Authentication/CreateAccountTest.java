package com.ThinkAndGetIt.TestCases.Authentication;

import com.ThinkAndGetIt.Base.BaseTest;
import org.testng.annotations.Test;
import static com.ThinkAndGetIt.EndPoints.EndPoints.HOME;
import static com.ThinkAndGetIt.ReusableMethods.CreateAccountMethods.createAccountForm;
import static org.testng.Assert.assertEquals;

public class CreateAccountTest extends BaseTest {
    static String dynamicEmail = "gady_" + System.currentTimeMillis() + "@gmail.com";
    @Test
    public static void createAccountTestSuccessfully(){
        String expectedUrl = properties.getProperty("baseUrl") + HOME;
        createAccountForm(page,"am not", "a human", dynamicEmail, "sjfdlksjfoeuoisf@kdsjf");
        assertEquals(page.url(), expectedUrl);
    }

    @Test
    public static void createAccountTestWithWrongEmail(){
        createAccountForm(page,"am not", "a human", "examplegmailcom", "sjfdlksjfoeuoisf@kdsjf");
    }
}
