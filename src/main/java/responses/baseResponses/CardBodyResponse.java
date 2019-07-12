package responses.baseResponses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import responses.enclosedParametres.Badges;
import responses.enclosedParametres.DescData;
import responses.enclosedParametres.Limits;

import java.util.List;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)

public class CardBodyResponse {

    private String id;
    private List<Badges> badges;
    private Boolean closed;
    private Boolean dueComplete;
    private String dateLastActivity;
    private String desc;
    private List<DescData> descData;
    private String due;
    private String dueReminder;
    private String email;
    private String idBoard;
    private String idList;
    private Integer idShort;
    private String idAttachmentCover;
    private Boolean manualCoverAttachment;
    private String name;
    private Integer pos;
    private String shortLink;
    private String shortUrl;
    private Boolean subscribed;
    private String url;
    private List<Limits> limits;

}