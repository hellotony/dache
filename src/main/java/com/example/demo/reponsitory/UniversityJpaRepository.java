package com.example.demo.reponsitory;

import com.example.demo.model.University;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author luogeng.szq
 * @version $$Id:UniversityJpaRepository.java, v0.1 2018/1/3 下午3:14 Exp$$
 **/
public interface UniversityJpaRepository extends JpaRepository<University, Long> {


}
