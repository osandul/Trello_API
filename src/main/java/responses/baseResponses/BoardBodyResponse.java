package responses.baseResponses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Data;
import responses.enclosedParametres.*;

import java.util.List;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(as = BoardBodyResponse.class )


public class BoardBodyResponse {
    private String id;
    private String name;
    private String desc;
    private String descData;
    private Boolean closed;
    private String idOrganization;
    private Boolean pinned;
    private String url;
    private String shortUrl;
    private Prefs prefs;
    private LabelNames labelNames;
    private Limits limits;
    private String shortLink;
    private String dateLastActivity;
    private String datePluginDisable;
    private String creationMethod;
    private String ixUpdate;
    private Boolean starred;
    private Boolean subscribed;
    private List<Memberships> memberships;
    private List<PowerUps> powerUps;
    private List<IdTags> idTags;
}

