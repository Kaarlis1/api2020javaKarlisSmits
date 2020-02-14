package helpers;

import clients.ClickUpClient;
import domain.ClickUpSpace;

public class ClickUpSpaceHelper {
    private static final ClickUpClient CLICKUP_CLIENT = new ClickUpClient();

    public static ClickUpSpace getClickupSpace(String spaceId) {
        return CLICKUP_CLIENT.fetchSpace(spaceId)
                .extract()
                .response()
                .as(ClickUpSpace.class);
    }

    public static ClickUpSpace updateClickupSpace(String spaceId, String newName) {
        return CLICKUP_CLIENT.updateSpaceName(spaceId, newName)
                .extract()
                .response()
                .as(ClickUpSpace.class);
    }

}
