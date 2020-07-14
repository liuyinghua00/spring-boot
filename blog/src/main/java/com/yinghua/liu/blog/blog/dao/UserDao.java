package com.yinghua.liu.blog.blog.dao;

import com.yinghua.liu.blog.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDao  extends JpaRepository<User,Long> {
    /**
     * 通过用户名称查询User对象
     * @param userName
     * @return
     */
    User findByUserName(String userName);

    @Modifying
    @Query(value="update user set userName=:userName where id=:id",nativeQuery=true)
    void updateNameById(@Param("id")Long id, @Param("userName")String userName);
}
