package ibm.gse.eda.domain;

import java.util.HashMap;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import ibm.gse.eda.app.dto.TrainSearchRequest;
import ibm.gse.eda.app.dto.TrainSearchResponse;
import ibm.gse.eda.infrastructure.MapperClient;
import io.smallrye.mutiny.Uni;

@ApplicationScoped
public class SearchService {

	private int idx = 0;
	private HashMap<String,TrainSearchResponse> cachedResponses = new  HashMap<String,TrainSearchResponse>();
	
	@Inject
	@RestClient
	MapperClient mapperClient;
	
	

	public Uni<TrainSearchResponse> searchService(TrainSearchRequest searchRequest) {
		if (searchRequest.userId == null) {
			searchRequest.userId = "SearchQuery_" + idx;
			idx++;
		}
		mapperClient.searchTrainFromConsolidator(searchRequest);
		return Uni.createFrom().item(cachedResponses.get(searchRequest.userId));
	}

	

	@Incoming("search")
    public void processSearchResponse(TrainSearchResponse resp) {
		cachedResponses.put(resp.userId,resp);
	}
}
