package ibm.gse.eda.app;

import org.junit.jupiter.api.Test;

import ibm.gse.eda.app.dto.TrainSearchRequest;
import ibm.gse.eda.app.dto.TrainSearchResponse;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.with;
@QuarkusTest
public class OfferQueryResourceTest {

    @Test
    public void testParisToLondon() {
        TrainSearchRequest req = new TrainSearchRequest();
        req.destinationLocation = "London";
        req.originLocation = "Paris";
        req.outwardDate = "03/01/2021";
    
        Response resp = with().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
          .body(req)
          .when().post("/search")
          .then()
             .statusCode(200)
             .contentType(ContentType.JSON)
        .extract()
        .response();
        TrainSearchResponse searchResp= resp.body().as(TrainSearchResponse.class);
        System.out.println(searchResp.routerList.get(0).supplier);
    
    }

}