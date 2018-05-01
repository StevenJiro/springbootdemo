package com.michelle.spirng.boot.blog.springbootstart.repository;

import com.michelle.spirng.boot.blog.springbootstart.domain.User;
import org.springframework.data.repository.CrudRepository;


/**
 * 用户操作资源库接口
 * @author sunzh
 */
public interface UserRepository extends CrudRepository<User, Long> {

}
