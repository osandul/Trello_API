package responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)

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
    private PrefsBody prefs;
    private LabelsNameBody labelsName;
    private String limits;
    private String shortLink;
    private String dateLastActivity;
    private String datePluginDisable;
    private String creationMethod;
    private String ixUpdate;
    private Boolean starred;
    private Boolean subscribed;
    private List<MembershipsBody> memberships;
    private List<PoverUpsBody> powerUps;
    private List<IdTagsBody> idTags;
}

