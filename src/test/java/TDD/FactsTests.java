package TDD;

import core.Hooks;
import endPoints.FactEP;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.Fact;

import java.util.List;

public class FactsTests extends Hooks {
    @Test(description = "fetches a random fact")
    public void getaRandomFact() {
        Response response = FactEP.getRandomFact();
        if (response.getStatusCode()==200) {
           Fact _fact = response.then().extract().jsonPath().getObject(".", Fact.class);
           Assert.assertTrue(_fact.fact.length()>0, "couldnt get a fact");
        } else {
            Assert.fail("Failed. can not load the list");
            logger.error("Failed. can not load the list");
        }
    }

    @Test(description = "fetches a random fact with max length")
    public void getaRandomFactByMaxLen() {
        int maxLen = 100;
        Response response = FactEP.getRandomFact(maxLen);
        if (response.getStatusCode()==200) {
            Fact _fact = response.then().extract().jsonPath().getObject(".", Fact.class);
            Assert.assertTrue(_fact.length <=maxLen, "fact is too long");
        } else {
            Assert.fail("Failed. can not load the list");
            logger.error("Failed. can not load the list");
        }
    }

    @Test(description = "fetches list of facts that is smaller than 100 chars and 10 item max")
    public void getFactsList() {
        int maxLen = 100; int limit=10;
        Response response = FactEP.getCustomFactList(maxLen, limit );
        if (response.getStatusCode()==200) {
            List<Fact> _factList = response.then().extract().jsonPath().getList("data", Fact.class);
            Assert.assertTrue(_factList.size()<=limit, "too many items in the list");

            _factList.forEach(f-> {
                Assert.assertTrue(f.fact.length()<=maxLen, "fact is too long");
            });

        } else {
            Assert.fail("Failed. can not load the list");
            logger.error("Failed. can not load the list");
        }
    }


}
