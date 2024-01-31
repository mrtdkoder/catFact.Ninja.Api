package core;

import io.restassured.response.Response;
import org.apache.log4j.Logger;

public class BaseClass {
    public final Logger logger = Logger.getLogger(this.getClass());
    public static Response response;
}
