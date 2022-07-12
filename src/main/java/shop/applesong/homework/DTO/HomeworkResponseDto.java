package shop.applesong.homework.DTO;

import lombok.Getter;
import shop.applesong.homework.model.Homework;
import shop.applesong.homework.model.Timestamped;

@Getter
public class HomeworkResponseDto extends Timestamped {

    private Long id;
    private String username;
    private String contents;
    private String title;
    private String password;

    public HomeworkResponseDto(Homework entity){
        this.id = entity.getId();
        this.username = entity.getUsername();
        this.contents = entity.getContents();
        this.title = entity.getTitle();
        this.password = entity.getPassword();
        this.getCreatedAt();
    }
}
