package endPoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BreedsEP {
    private static final String GET_LIST_OF_BREEDS = "/breeds/";
    private static final String GET_LIST_OF_BREEDS_BY_LIMIT = "/breeds?limit={lmt}";


    public static Response getList() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get(GET_LIST_OF_BREEDS);
        return response;
    }

    public static Response getList(int limit) {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .pathParam("lmt", limit)
                .when()
                .get(GET_LIST_OF_BREEDS_BY_LIMIT);
        return response;
    }


}
