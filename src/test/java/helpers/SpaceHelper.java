package helpers;

import domain.ClickUpSpace;
import domain.Space;
import clients.ClickUpClient;

import java.lang.reflect.Type;


public class SpaceHelper {

    private static final ClickUpClient CLICK_UP_CLIENT = new ClickUpClient();

    public static ClickUpSpace getClickUpSpace(String spaceId) {
        return CLICK_UP_CLIENT.fetchSpace(spaceId)
                .extract()
                .response()
                .as((Type) Space.class);
    }

}