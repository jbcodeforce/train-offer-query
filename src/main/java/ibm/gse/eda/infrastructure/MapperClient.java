package ibm.gse.eda.infrastructure;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import ibm.gse.eda.app.dto.TrainSearchRequest;
import ibm.gse.eda.app.dto.TrainSearchResponse;

@Path("/consolidatorA")
@RegisterRestClient
public interface MapperClient {
   
    @POST
    TrainSearchResponse searchTrainFromConsolidator(TrainSearchRequest searchRequest);
}
