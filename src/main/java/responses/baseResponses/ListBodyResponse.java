package responses.baseResponses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import responses.enclosedParametres.Limits;

import java.util.List;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListBodyResponse {
    private String id;
    private String name;
    private Boolean closed;
    private String idBoard;
    private Integer pos;
    private List<Limits> limits;
}
