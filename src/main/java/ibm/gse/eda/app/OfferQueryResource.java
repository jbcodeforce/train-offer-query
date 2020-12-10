package ibm.gse.eda.app;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.logging.annotations.Param;

import ibm.gse.eda.app.dto.TrainSearchRequest;
import ibm.gse.eda.app.dto.TrainSearchResponse;
import ibm.gse.eda.domain.OfferService;
import ibm.gse.eda.domain.SearchService;
import ibm.gse.eda.domain.TrainOffer;
import io.smallrye.mutiny.Uni;

@Path("/search")
public class OfferQueryResource {

    @Inject
    public SearchService searchService;

    @Inject
    public OfferService offerService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<TrainSearchResponse> searchRouters(TrainSearchRequest searchRequest){
        return searchService.searchService(searchRequest);
        
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/offers/{offerId}")
    public Uni<TrainOffer> getOffer(@Param String offerId){
        return offerService.getOffer(offerId);
        
    }

}