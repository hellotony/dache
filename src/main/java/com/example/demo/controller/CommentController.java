package com.example.demo.controller;

import com.example.demo.model.Comment;
import com.example.demo.model.Result;
import com.example.demo.reponsitory.CommentJpaRepository;
import com.example.demo.reponsitory.CommentRepository;
import com.example.demo.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author luogeng.szq
 * @version $$Id:CommentController.java, v0.1 2018/2/6 下午4:39 Exp$$
 **/
@RestController
@RequestMapping("/comment")
public class CommentController {


    @Autowired
    private ICommentService commentService;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentJpaRepository commentJpaRepository;


    @RequestMapping("/queryList")
    public List<Comment> queryList(@Param("id")Long communityId) {
        if (communityId == null || communityId <= 0) {
            return null;
        }
        return commentRepository.queryByCommunityId(communityId);
    }


    @RequestMapping("/add")
    public Result add(@RequestBody Comment comment) {
        if (comment == null) {
            return Result.paramError();
        }
        if (StringUtils.isEmpty(comment.getContent()) || comment.getCommunityId() == null) {
            return Result.paramError();
        }
        comment.setGmtCreate(new Date());
        comment.setGmtModify(new Date());
        Comment c = commentJpaRepository.save(comment);
        if (c == null) {
            return Result.executeError();
        }
        return Result.isOk();
    }



}
