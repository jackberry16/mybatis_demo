package com.example.mybatis_demo.dao;

import org.apache.ibatis.jdbc.SQL;

public class UserDaoSql {
    public String getRoleById(long rId){
        SQL sql = new SQL();
        sql.SELECT("*");
        sql.FROM("C");
        sql.WHERE("RID = #{rId}");
        return sql.toString();
    }
}
