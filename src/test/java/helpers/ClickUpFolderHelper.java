package helpers;

import clients.ClickUpClient;
import domain.ClickUpFolder;

import java.lang.reflect.Type;

public class ClickUpFolderHelper {
    private static final ClickUpClient CLICKUP_CLIENT = new ClickUpClient();

    public static ClickUpFolder createClickupFolder(String spaceId, String folderName) {
        return CLICKUP_CLIENT.createFolder(spaceId, folderName)
                .extract()
                .response()
                .as(ClickUpFolder.class);
    }

    public static ClickUpFolder getClickupFolder(String folderId) {
        return CLICKUP_CLIENT.fetchFolder(folderId)
                .extract()
                .response()
                .as((Type) ClickUpClient.class);
    }

}
