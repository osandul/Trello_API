package responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)

public class MembershipsBody {

    private String id;
    private String idMember;
    private String memberType;
    private Boolean unconfirmed;
    private Boolean deactivated;
}


