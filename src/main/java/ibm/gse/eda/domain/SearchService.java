package ibm.gse.eda.domain;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import ibm.gse.eda.app.dto.TrainSearchRequest;
import ibm.gse.eda.app.dto.TrainSearchResponse;
import ibm.gse.eda.infrastructure.MapperClient;
import ibm.gse.eda.infrastructure.OfferRepository;
import io.smallrye.mutiny.Uni;

@ApplicationScoped
public class SearchService {

	@Inject
	@RestClient
	MapperClient mapperClient;
	
	@Inject
	OfferRepository offerRepository;

	public TrainSearchResponse searchService(TrainSearchRequest searchRequest) {
		TrainSearchResponse aggregatedResponse = mapperClient.searchTrainFromConsolidator(searchRequest);
		// TODO get response from kafka
        return aggregatedResponse;
	}

	public Uni<TrainOffer> getOffer(String offerId) {
		return offerRepository.getById(offerId);
	}
    
}
