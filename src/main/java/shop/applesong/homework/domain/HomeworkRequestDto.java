package shop.applesong.homework.domain;

import lombok.Getter;

@Getter
public class HomeworkRequestDto {
    private Long id;
    private String username;
    private String contents;
    private String title;
    private String password;
}
