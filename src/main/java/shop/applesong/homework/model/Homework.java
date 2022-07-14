package shop.applesong.homework.model;

import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.applesong.homework.DTO.HomeworkRequestDto;

import javax.persistence.*;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
@Getter
public class Homework extends Timestamped { // 생성,수정 시간을 자동으로 만들어줍니다.

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String title;

//    public String getContents(){
//        return this.contents;
//    }

//    public Homework(String username, String contents) {
//        this.username = username;
//        this.contents = contents;
//    }       //새로 작성할때 쓸 메소드 인자값을 이 파일 바로위에있는 컬럼들로 받아옴 (테이블생성)

    public Homework(HomeworkRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.title = requestDto.getTitle();
        this.password = requestDto.getPassword();
    }


    public void update(HomeworkRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.title = requestDto.getTitle();
        this.password = requestDto.getPassword();
    }       //수정할때 쓸 메소드 인자값을 Dto에서 생성해둔 getter를 받아온다

//    public String detail(HomeworkRequestDto requestDto) {
//        this.username = requestDto.getUsername();
//        this.contents = requestDto.getContents();
//        this.title = requestDto.getTitle();
//        this.password = requestDto.getPassword();
//        String detail = username + contents + title + password;
//        return detail;
//    }
}