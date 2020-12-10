package ibm.gse.eda.infrastructure;

import ibm.gse.eda.domain.TrainOffer;
import io.quarkus.kafka.client.serialization.JsonbDeserializer;

public class OfferDeserializer extends JsonbDeserializer<TrainOffer> {
    public OfferDeserializer(){
        super(TrainOffer.class);
    }
}
