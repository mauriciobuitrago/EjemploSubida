package com.co.qvision.tasks;

import com.co.qvision.models.Credentials;
import com.co.qvision.userinterfaces.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import javax.swing.*;

public class Login implements Task {
    Credentials credentials;

    public Login(Credentials credentials) {
        this.credentials = credentials;
    }

   // private String user = System.getProperty("username");
 //   private String password = System.getProperty("password");

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(credentials.getUsername()).into(LoginPage.TXT_USERNAME),
                Enter.theValue(credentials.getPassword()).into(LoginPage.TXT_PASSWORD),
                Click.on(LoginPage.BTN_LOGIN));
    }

    public static Login enter(Credentials credentials) {
        return Tasks.instrumented(Login.class,credentials);
    }
}
