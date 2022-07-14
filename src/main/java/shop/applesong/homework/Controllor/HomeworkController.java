package shop.applesong.homework.Controllor;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import shop.applesong.homework.model.Homework;
import shop.applesong.homework.repository.HomeworkRepository;
import shop.applesong.homework.DTO.HomeworkRequestDto;
import shop.applesong.homework.service.HomeworkService;

import java.util.List;
import java.util.Optional;

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
    public Optional<Homework> detail(@PathVariable Long id) {
        return homeworkRepository.findById(id);
    }
//    @GetMapping("/api/homeworks/{id}")       //읽기 Read (Get타입) 게시글 개별조회
//    public HomeworkResponseDto detail(@PathVariable Long id) {
//        return homeworkService.detail(id);
//    }         //Dto 새로만들어서 불러오는방법. 작성시간을 불러오는 방버을 도저히 못찾겠어서 포기

    @DeleteMapping("/api/homeworks/{id}")
    public Long deleteHomework(@PathVariable Long id)  {
        homeworkRepository.deleteById(id);
        return id;
    }
    @PutMapping("/api/homeworks/{id}")
    public Long HomeworkCourse(@PathVariable Long id, @RequestBody HomeworkRequestDto requestDto) {
        return homeworkService.update(id, requestDto);
    }
}