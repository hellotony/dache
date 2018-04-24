package com.example.demo.reponsitory;

import com.example.demo.model.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author luogeng.szq
 * @version $$Id:CommentRepository.java, v0.1 2018/2/6 下午8:01 Exp$$
 **/
public interface CommentRepository extends Repository<Comment, Long> {

    @Query(value = "from Comment u where u.communityId=:communityId")
    List<Comment> queryByCommunityId(@Param("communityId")Long communityId);

}
