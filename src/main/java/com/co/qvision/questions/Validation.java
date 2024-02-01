package com.co.qvision.questions;

import com.co.qvision.userinterfaces.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.statematchers.IsEnabledMatcher;
import net.serenitybdd.screenplay.questions.Enabled;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Visibility;

public class Validation implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        //return Visibility.of(LoginPage.LBL_VALIDATION).viewedBy(actor).asBoolean();
        return Enabled.of(LoginPage.LBL_VALIDATION).viewedBy(actor).asBoolean();
    }

    public static Validation compare(){
        return new Validation();
    }
}
