package bodies;

//import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class BoardBody {
    private String name;
    private Boolean defaultLabels;
    private Boolean defaultLists;
    private String desc;
    private String idOrganization;
    private String idBoardSource;
    private String keepFromSource;
    private String powerUps;
    private String prefs_permissionLevel;
    private String prefs_voting;
    private String prefs_comments;
    private String prefs_invitations;
    private Boolean prefs_selfJoin;
    private Boolean prefs_cardCovers;
    private String prefs_background;
    private String prefs_cardAging;

}
