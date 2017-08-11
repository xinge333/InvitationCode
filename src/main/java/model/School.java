package model;

import java.io.Serializable;

/**
 * Created by zxy on 2017/8/11.
 */
public class School implements Serializable{

    //学校名称,主键
    private String schoolName;

    //四位邀请码
    private String code;

    public School(){}

    public School(String schoolName, String code){
        this.schoolName = schoolName;
        this.code = code;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code){
        this.code = code;
    }

    public String getSchoolName()
    {
        return schoolName;
    }

    public void setSchoolName(String schoolName){
        this.schoolName = schoolName;
    }

    @Override
    public String toString() {
        return (this.getSchoolName() + ","  + this.getCode());
    }
}
