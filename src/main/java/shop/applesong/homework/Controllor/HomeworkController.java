package shop.applesong.homework.Controllor;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import shop.applesong.homework.domain.Homework;
import shop.applesong.homework.domain.HomeworkRepository;
import shop.applesong.homework.domain.HomeworkRequestDto;
import shop.applesong.homework.domain.HomeworkResponseDto;
import shop.applesong.homework.service.HomeworkService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class HomeworkController {

    private final HomeworkRepository homeworkRepository;    //참조변수를 생성해서 리포지토리 클래스 로딩
    private final HomeworkService homeworkService;          //참조변수를 생성해서 서비스 클래스 로딩

    @PostMapping("/api/homeworks")      //작성 Create (Post타입)
    public Homework createHomework(@RequestBody HomeworkRequestDto requestDto) {
        Homework homework = new Homework(requestDto);
        return homeworkRepository.save(homework);
    }

    @GetMapping("/api/homeworks")       //읽기 Read (Get타입) 게시글 목록조회
    public List<Homework> getHomeworksList() {
        return homeworkRepository.findAllByOrderByModifiedAtDesc();
    }

    @GetMapping("/api/homeworks/{id}")       //읽기 Read (Get타입) 게시글 개별조회
    public HomeworkResponseDto detail(@PathVariable Long id) {
        return homeworkService.detail(id);
    }

    @DeleteMapping("/api/homeworks/{id}")
    public Long deleteHomework(@PathVariable Long id) {
        homeworkRepository.deleteById(id);
        return id;
    }
    @PutMapping("/api/homeworks/{id}")
    public Long HomeworkCourse(@PathVariable Long id, @RequestBody HomeworkRequestDto requestDto) {
        return homeworkService.update(id, requestDto);
    }
}