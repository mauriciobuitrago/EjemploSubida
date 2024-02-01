package com.co.qvision.stepsdefinitions;

import com.co.qvision.exceptions.MessageException;
import com.co.qvision.models.Credentials;
import com.co.qvision.models.builders.DataBuilder;
import com.co.qvision.questions.Validation;
import com.co.qvision.tasks.Login;
import com.co.qvision.utils.Constants;
import com.co.qvision.utils.Url;
import com.co.qvision.utils.reader.PropsCsv;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.util.EnvironmentVariables;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public class LoginStepdefinition {
    @Managed(driver = "chrome",options = "--start-maximized")
    WebDriver hisDriver;
    private EnvironmentVariables environmentVariables;

    @Before
    public void setUp(){
        OnStage.setTheStage(Cast.ofStandardActors());
        OnStage.theActorCalled("user");
        OnStage.theActorInTheSpotlight().can(BrowseTheWeb.with(hisDriver));
    }


    @Given("^he user is on the page$")
    public void heUserIsOnThePage() {
        String webServiceEndpoint = EnvironmentSpecificConfiguration.from(environmentVariables)
                        .getProperty("environments.default.webdriver.base.url");
        String URL = webServiceEndpoint.toString();
        OnStage.theActorInTheSpotlight().wasAbleTo(Open.url(URL));
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("^el usuario ve los productos$")
    public void elUsuarioVeLosProductos(List<Map<String,String>>filtro) throws IOException {
        Credentials credentials;
        credentials = DataBuilder.dataInformation(PropsCsv.getDataCsv("login",
               filtro.get(0).get("people"))).build();
        OnStage.theActorInTheSpotlight().attemptsTo(Login.enter(credentials));
    }

    @Then("^he user could see products$")
    public void heUserCouldSeeProducts() {
       OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(Validation.compare()
       , Matchers.equalTo(Constants.EXCEPTION_PRODUCT))
               .orComplainWith(MessageException.class,Constants.MESSAGE_EXCEPTION_PRODUCT));

    }

}
