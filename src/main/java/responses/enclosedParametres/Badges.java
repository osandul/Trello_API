package responses.enclosedParametres;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Badges {

    private Boolean location;
    private Integer votes;
    private Boolean viewingMemberVoted;
    private Boolean subscribed;
    private String fogbugz;
    private Integer checkItems;
    private Integer checkItemsChecked;
    private Integer comments;
    private Integer attachments;
    private Boolean description;
    private String due;
    private Boolean dueComplete;
    private List<AttachmentsByType> attachmentsByType;

}
