package com.example.demo.reponsitory;

import com.example.demo.model.Community;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author luogeng.szq
 * @version $$Id:CommentJpaRepository.java, v0.1 2018/2/6 下午4:55 Exp$$
 **/
public interface CommunityJpaRepository extends JpaRepository<Community, Long> {
}
