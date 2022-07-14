package shop.applesong.homework.DTO;

import lombok.Getter;
import lombok.Setter;
import shop.applesong.homework.model.Timestamped;

@Getter
@Setter
public class CommentDTO extends Timestamped {

    private Long idx;

    private Long boardIdx;

    private String content;

    private String writer;

}