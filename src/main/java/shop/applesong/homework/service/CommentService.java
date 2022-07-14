package shop.applesong.homework.service;


import java.util.List;

import shop.applesong.homework.DTO.CommentDTO;

public interface CommentService {

    public boolean registerComment(CommentDTO params);

    public boolean deleteComment(Long idx);

    public List<CommentDTO> getCommentList(CommentDTO params);

}