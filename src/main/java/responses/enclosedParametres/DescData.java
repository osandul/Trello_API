package responses.enclosedParametres;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class DescData {
    private List<Emoji> emoji;
}
