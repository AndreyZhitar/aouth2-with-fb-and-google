package com.zhitar.oauth2social.mapper;

import com.zhitar.oauth2social.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Select("select * from users where email = #{email}")
    User findByEmail(String email);

    @Select("select * from users where id = #{id}")
    User findBYId(Long id);

    @Insert("insert into users values (#{name}, #{email}, #{image_url}, #{password}, #{provider})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(User user);


    @Update("update users set name = #{name}, email = #{email}, imageUrl = #{image_url}, password = #{password}, provider = #{provider}")
    int update(User user);
}
