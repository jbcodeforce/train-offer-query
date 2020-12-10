package ibm.gse.eda.infrastructure;

import ibm.gse.eda.app.dto.TrainSearchResponse;
import io.quarkus.kafka.client.serialization.JsonbDeserializer;

public class SearchResponseDeserializer extends JsonbDeserializer<TrainSearchResponse> {
    public SearchResponseDeserializer(){
        super(TrainSearchResponse.class);
    }
}
