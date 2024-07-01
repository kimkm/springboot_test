package kim.km.test01.board.model;

import lombok.Data;
import org.apache.commons.lang3.time.FastDateFormat;
import org.springframework.web.multipart.MultipartFile;
import java.util.Date;


@Data
public class BoardModel {
    private int  boardId;
    private Date writeTime;
    private String title;
    private String boardContents;
    private int groupId=0;
    private int depth=0;
    private String sort="";
    private int out_parm;
    private int hit=0;
    private int likes=0;
    private int bads=0;
    private int likeState=0;
    private String memberId;
    private String fileGroudId;
    MultipartFile[] files;

    public String day() {
        FastDateFormat dateFormat = FastDateFormat.getInstance("yyyy-MM-dd EEE");
        String formattedDate = dateFormat.format(this.writeTime);
        return formattedDate;
    }
}
