package responses.enclosedParametres;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)

public class Trello {

    private Integer board;
    private Integer card;
}
