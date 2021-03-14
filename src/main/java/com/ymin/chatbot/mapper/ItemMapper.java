package com.ymin.chatbot.mapper;

import com.ymin.chatbot.dto.Item;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ItemMapper {

    @Select("SELECT * FROM item WHERE userId=#{id} AND name=#{name}")
    public Item findItem(@Param("id") String userId, @Param("name") String name);

    @Insert("INSERT INTO item(userId, name, url) VALUES (#{userId}, #{name}, #{url})")
    public boolean insertItem(@Param("userId")String userId,@Param("name") String name,@Param("url") String url);

    @Select("SELECT * FROM item WHERE userId = #{userId}")
    public List<Item> getItemList(@Param("userId") String userId);

    @Delete("DELETE FROM item WHERE userId = #{userId} AND name = #{name}")
    public boolean deleteItem(@Param("userId") String userId, @Param("name") String name);
}
