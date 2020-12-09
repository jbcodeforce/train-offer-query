package ibm.gse.eda.infrastructure;

import java.util.HashMap;

import javax.enterprise.context.ApplicationScoped;

import ibm.gse.eda.domain.TrainOffer;
import io.smallrye.mutiny.Uni;

/**
 * Specific repository for query side of the offer
 */
@ApplicationScoped
public class OfferRepository {
    HashMap<String,TrainOffer> repository = new HashMap<String,TrainOffer>();

    public OfferRepository() {
        super();
    }

	public Uni<TrainOffer> getById(String offerId) {
		return Uni.createFrom().item(repository.get(offerId));
    }
    
    public void saveOffer(TrainOffer offer) {
        repository.put(offer.offerID, offer);
    }
}
