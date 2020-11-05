package com.ilcarro.qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    //tests for logintn
    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.session().isLoginFormPresent()) {
            if(app.session().isUserLoggedIn()){
                app.header().clickLogout();
            }
        }
    }

    @Test
    public void loginRegisteredUserPositiveTest() throws InterruptedException {

        app.session().login("zz@zz20.com","Aa1234567");
        Assert.assertTrue(app.session().isUserLoggedIn());


    }

}
