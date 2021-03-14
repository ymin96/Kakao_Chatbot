package com.ymin.chatbot.mapper;


import com.ymin.chatbot.dto.User;
import org.apache.ibatis.annotations.*;
import org.apache.naming.java.javaURLContextFactory;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    @Select("SELECT * FROM user where id = #{id}")
    User findUserById(@Param("id") String id);

    @Insert("INSERT INTO user(id, blockId) VALUES (#{id}, #{blockId})")
    boolean insertUser(@Param("id") String id,@Param("blockId") String blockId);

    @Update("UPDATE user SET blockId=#{blockId} WHERE id = #{id}")
    boolean updateBlockId(@Param("id") String id,@Param("blockId") String blockId);

    @Update("UPDATE user SET year=#{year} WHERE id = #{id}")
    boolean updateYear(@Param("id") String id, @Param("year") int year);

    @Update("UPDATE user SET ${column} = #{answer} WHERE id = #{id}")
    boolean updateAnswer(@Param("id")String id, @Param("column") String column, @Param("answer") boolean answer);

    @Delete("DELETE FROM user WHERE id = #{id}")
    boolean deleteUser(@Param("id")String id);
}
