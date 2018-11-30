package com.shine.storage.dao.mapper;

import com.shine.storage.dao.entity.Person;
import com.shine.storage.dao.enums.GenderEnum;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : shine
 * @Project: Storage
 * @Description: 用户
 * @date: 2018年09月21日 18:18
 */
@Mapper
@Repository
public interface PersonMapper {

    @Select("select person_id,person_name,gender from person")
    @Results({@Result(property = "personId", column = "person_id"),
            @Result(property = "personName", column = "person_name"),
            @Result(property = "gender", column = "gender", javaType = GenderEnum.class)})
    List<Person> findAllPerson();

    @Select("select * from user where personId=#{id}")
    Person findPersonByPersonId(@Param("id") Integer personId);

    @Insert("insert into person(person_name,gender) values(#{name},#{gender})")
    boolean insertPerson(@Param("name") String personName, @Param("gender") int gender);


}
