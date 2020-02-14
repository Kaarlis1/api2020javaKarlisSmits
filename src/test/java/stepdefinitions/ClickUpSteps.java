package stepdefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.ClickUpFolderHelper;
import helpers.SpaceHelper;
import helpers.TestCaseContext;

public class ClickUpSteps {

    @When("User creates new folder in space with id {string} and name {string}")
    public void userCreatesNewFolderInSpaceWithIdAndName(String spaceId, String folderName) {
        TestCaseContext.get().setClickupFolder(ClickUpFolderHelper.createClickupFolder(spaceId, folderName));
        TestCaseContext.get().setClickupSpace(SpaceHelper.getClickUpSpace(spaceId));

    }
}
