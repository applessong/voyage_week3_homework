package shop.applesong.homework.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.applesong.homework.domain.Homework;
import shop.applesong.homework.domain.HomeworkRepository;
import shop.applesong.homework.domain.HomeworkRequestDto;
import shop.applesong.homework.domain.HomeworkResponseDto;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class HomeworkService {

    private final HomeworkRepository homeworkRepository;

    @Transactional
    public Long update(Long id, HomeworkRequestDto requestDto) {
        Homework homework =homeworkRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("게시물이 존재하지 않습니다.")
        );
        homework.update(requestDto);
        return homework.getId();
    }

    @Transactional
    public HomeworkResponseDto detail(Long id) {
        Homework entity =homeworkRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException(id+"번 게시물이 존재하지 않습니다.")
        );
        return new HomeworkResponseDto(entity);
    }

}