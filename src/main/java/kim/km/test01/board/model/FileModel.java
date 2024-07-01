package kim.km.test01.board.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FileModel {
    private String fileGroudId;
    private String saveName;
    private String originalName;
    private String fileSize;
}
