package com.co.qvision.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {
    public static final Target TXT_USERNAME = Target.the("enter username")
            .locatedBy("//*[@id='user-name']");
    public static final Target TXT_PASSWORD = Target.the("enter username")
            .locatedBy("//*[@id='password']");

    public static final Target BTN_LOGIN = Target.the("enter username")
            .locatedBy("//*[@id='login-button']");

  public static final Target LBL_VALIDATION = Target.the("enter username")
            .locatedBy("//*[text()='Sauce Labs Backpack']");


}
