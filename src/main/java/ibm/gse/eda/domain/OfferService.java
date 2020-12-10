package ibm.gse.eda.domain;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.reactive.messaging.Incoming;

import ibm.gse.eda.infrastructure.OfferRepository;
import io.smallrye.mutiny.Uni;

@ApplicationScoped
public class OfferService {

    @Inject
	OfferRepository offerRepository;
 
    public Uni<TrainOffer> getOffer(String offerId) {
		return offerRepository.getById(offerId);
    }
    
    @Incoming("offers")
    public void processSearchResponse(TrainOffer offer) {
		offerRepository.saveOffer(offer);
	}
}
