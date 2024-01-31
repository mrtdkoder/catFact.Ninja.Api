package core;

import io.restassured.RestAssured;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Hooks extends BaseClass{
    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "https://catfact.ninja";
        logger.info("Base URL:" + RestAssured.baseURI);
    }

    @AfterClass
    public  void tearDown(){

    }
}
