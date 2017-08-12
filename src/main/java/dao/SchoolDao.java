package dao;

import model.School;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by zxy on 2017/8/11.
 */
public class SchoolDao {

    //根据名称判断某个学校是否申请过
    public boolean isRegisted(String schoolName) throws SQLException {
        Connection conn = DBschool.getConnection();

        String sql = " select * from School " + " where schoolName=? ";

        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setString(1,schoolName);

        ResultSet rs = ptmt.executeQuery();

        if(rs.next()){
            return true;
        }
        else {
            return false;
        }
    }

    //添加某个学校
    public void addSchool(School school)throws SQLException{
        Connection conn = DBschool.getConnection();

        String sql = "insert into School(schoolName,code) values(?,?)";

        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setString(1,school.getSchoolName());
        ptmt.setString(2,school.getCode());

        ptmt.execute();

    }

    //删除某个学校
    public void deleteSchool(String schoolName) throws SQLException {
        Connection conn = DBschool.getConnection();

        String sql = "delete from School where schoolName=?";

        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setString(1,schoolName);

        ptmt.execute();
    }

    //修改某个学校
    public void updateSchool(School school) throws SQLException {
        Connection conn = DBschool.getConnection();

        String sql = "update School set schoolName=?,code=? where schoolName=?";

        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setString(1,school.getSchoolName());
        ptmt.setString(2,school.getCode());
        ptmt.setString(3,school.getSchoolName());

        ptmt.execute();
    }

    //根据名称查询某个学校的邀请码
    public School queryByName(String schoolName) throws SQLException {

        School school = null;
        Connection conn = DBschool.getConnection();

        String sql = " select * from School " + " where schoolName=? ";

        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setString(1,schoolName);

        ResultSet rs = ptmt.executeQuery();
        while (rs.next()) {
            school = new School();
            //school.setSchoolName(rs.getString("schoolName"));
            school.setCode(rs.getString("code"));
        }
        return school;
    }

}
