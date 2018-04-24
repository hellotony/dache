package com.example.demo.reponsitory;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

/**
 * @author luogeng.szq
 * @version $$Id:UserRepository.java, v0.1 2018/2/6 下午6:02 Exp$$
 **/
public interface UserRepository extends Repository<User, Long> {

    @Query(value = "from User u where u.username=:username")
    User findByName(@Param("username")String username);
}
