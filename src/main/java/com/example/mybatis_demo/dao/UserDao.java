package com.example.mybatis_demo.dao;

import com.example.mybatis_demo.entity.Role;
import com.example.mybatis_demo.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Mapper
public interface UserDao {

    @Select(" select * from a left join d on a.UID = d.UID where a.UID = #{id} ")
    @Results(id = "userMap", value = {
            @Result(property = "id", column = "UID", jdbcType = JdbcType.BIGINT, id = true),
            @Result(property = "description", column = "UDESC", jdbcType = JdbcType.VARCHAR),
            @Result(
                    property = "roleList",
                    column = "UID",
                    many = @Many(select = "com.example.mybatis_demo.dao.UserDao.getRole")
            )
    })
    User getUserById(long id);

    @Select("select * from C where RID in (select RID from B where UID = #{uId})")
    @Results(id = "roleMap", value = {
            @Result(property = "roleId", column = "RID", jdbcType = JdbcType.BIGINT, id = true),
            @Result(property = "roleName", column = "RNAME", jdbcType = JdbcType.VARCHAR),
            @Result(property = "roleDesc", column = "RDESC", jdbcType = JdbcType.VARCHAR)
    })
    List<Role> getRole(long uId);

    @SelectProvider(type = UserDaoSql.class, method = "getRoleById")
    @ResultMap("roleMap")
    Role getRoleById(long rId);

    @Select(" select * from a left join d on a.UID = d.UID ")
    @ResultMap(value = "userMap")
    @ResultType(User.class)
    List<User> getUser();

    @Select(" select * from a left join d on a.UID = d.UID where a.UID = #{id} ")
    @Results({
            @Result(property = "id", column = "UID", jdbcType = JdbcType.BIGINT, id = true),
            @Result(property = "username", column = "USERNAME", jdbcType = JdbcType.VARCHAR),
            @Result(property = "description", column = "UDESC", jdbcType = JdbcType.VARCHAR),
            @Result(property = "address", column = "ADDRESS", jdbcType = JdbcType.VARCHAR)
    })
    Map<String, Object> getUserMap(long id);

    @Select(" select * from a left join d on a.UID = d.UID where a.UID = #{id} ")
    @ResultMap("userMap")
    @MapKey("id")
    Map<Long, User> getUserMaps(long id);


    @Select(" select * from a left join d on a.UID = d.UID ")
    @ResultMap(value = "userMap")
    Set<User> getUserSet();
}
