package endPoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class FactEP {
    private static final String GET_RANDOM_FACT = "/fact/";
    private static final String GET_RANDOM_FACT_BY_MAXLIMIT = "/fact?max_length={ml}";
    private static final String GET_FACT_FULL_LIST = "/facts?max_length=50&limit=3";
    private static final String GET_FACT_COSTUM_LIST = "/facts?max_length={ml}&limit={lmt}";


    public static Response getRandomFact(int maxLen) {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .pathParam("ml", maxLen)
                .when()
                .get(GET_RANDOM_FACT_BY_MAXLIMIT);
        return response;
    }

    public static Response getRandomFact() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get(GET_RANDOM_FACT);
        return response;
    }

    public static Response getFullListOfFacts() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get(GET_FACT_FULL_LIST);
        return response;
    }

    public static Response getCustomFactList(int maxLen, int limit) {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .queryParam("ml", maxLen)
                .queryParam("lmt", limit)
                .when()
                .get(GET_FACT_FULL_LIST);
        return response;
    }



}
