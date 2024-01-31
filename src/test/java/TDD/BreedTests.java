package TDD;

import core.Hooks;
import endPoints.BreedsEP;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.Breed;

import java.util.List;

import static io.restassured.RestAssured.given;

public class BreedTests extends Hooks {

    @Test(description = "fetches the full list of breeds", priority = 0)
    public void getFullList() {
        Response response = BreedsEP.getList();

        if (response.getStatusCode()==200) {
            List<Breed> _list = response.then().extract().jsonPath().getList("data", Breed.class);
            logger.info("bread list size: " + _list.size());
            Assert.assertTrue(_list.size()>0, "no item in list");

        } else {
            Assert.fail("Failed. can not load the list");
            logger.error("Failed. can not load the list");
        }
    }

    @Test(description = "get 10 items", dependsOnMethods = "getFullList")
    public void get10Items() {
        Response response = BreedsEP.getList(10);

        if (response.getStatusCode()==200) {
            List<Breed> _list = response.then().extract().jsonPath().getList("data", Breed.class);
            logger.info("bread list size: " + _list.size());
            Assert.assertTrue(_list.size()<=10, "more items in list than limit");

        } else {
            Assert.fail("Failed. can not load the list");
            logger.error("Failed. can not load the list");
        }
    }

}
