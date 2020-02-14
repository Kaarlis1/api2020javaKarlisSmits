package clients;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import javax.ws.rs.core.Response;

import static io.restassured.RestAssured.given;

public class ClickUpClient {

    private static final String API_TOKEN = "pk_4532463_BPEVCIWYQEOY6B9XMRLP8ANF823M8CTL";
    private static final String CLICKUP_GET_FOLDER_URL = "%s/folder/%s";
    private static final String CLICKUP_CREATE_FOLDER_URL = "%s/folder/%s";
    private static final String CLICKUP_GET_SPACE_URL = "%s/space/%s";
    private static final String CLICKUP_BASE_URL = "https://api.clickup.com/api/v2";




    public ValidatableResponse createFolder(String spaceId, String name) {
        return given().
                header("Authorization", API_TOKEN).
                body("{\"name\": \"" + name + "\"}").
                contentType(ContentType.JSON).
                when().
                post(String.format(CLICKUP_CREATE_FOLDER_URL, CLICKUP_BASE_URL, spaceId)).
                then().
                log().
                ifValidationFails().
                statusCode(Response.Status.OK.getStatusCode());
    }

    public void deleteFolder(String folderId) {
        given().
                header("Authorization", API_TOKEN).
                when().
                delete(String.format(CLICKUP_GET_FOLDER_URL, CLICKUP_BASE_URL, folderId)).
                then().
                log().
                ifValidationFails().
                statusCode(Response.Status.OK.getStatusCode());
    }

    public ValidatableResponse fetchFolder(String folderId) {
        return given().
                header("Authorization", API_TOKEN).
                when().
                get(String.format(CLICKUP_GET_FOLDER_URL, CLICKUP_BASE_URL, folderId)).
                then().
                log().
                ifValidationFails().
                statusCode(Response.Status.OK.getStatusCode());
    }

    public ValidatableResponse fetchSpace(String spaceId){
        return given().
                header("Authorization", API_TOKEN).
                when().
                get(String.format(CLICKUP_GET_SPACE_URL, CLICKUP_BASE_URL, spaceId)).
                then().
                log().
                ifValidationFails().
                statusCode(Response.Status.OK.getStatusCode());
    }


    public ValidatableResponse updateSpaceName(String spaceId, String spaceName){
        return given().
                param("name",  spaceName).
                header("Authorization", API_TOKEN).
                when().
                put(String.format(CLICKUP_GET_SPACE_URL, CLICKUP_BASE_URL, spaceId)).
                then().
                log().
                ifValidationFails().
                statusCode(Response.Status.OK.getStatusCode());
    }
}