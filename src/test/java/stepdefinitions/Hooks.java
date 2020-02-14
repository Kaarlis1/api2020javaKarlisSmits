package stepdefinitions;

import clients.ClickUpClient;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import helpers.TestCaseContext;

public class Hooks {

    private static final ClickUpClient CLICK_UP_CLIENT = new ClickUpClient();

    @Before
    public void beforeAll() {
        TestCaseContext.init();
    }

}
