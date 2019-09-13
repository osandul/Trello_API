package responses.enclosedParametres;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class BackgroundImageScaled {
    private Integer width;
    private Integer height;
    private String url;
}
