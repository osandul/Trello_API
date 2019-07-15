package responses.enclosedParametres;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LabelNames {
    private String green;
    private String yellow;
    private String orange;
    private String red;
    private String purple;
    private String blue;
    private String sky;
    private String lime;
    private String pink;
    private String black;
}
