package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.entity.SysRole;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.List;

/**
 * 学生信息管理对象 chstu
 * 
 * @author ruoyi
 * @date 2021-06-03
 */
public class StudentInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private String chstuSid;

    /** 姓名 */
    @Excel(name = "姓名")
    private String chstuSname;

    /** 性别 */
    @Excel(name = "性别")
    private String chstuSex;

    /** 年龄 */
    @Excel(name = "年龄")
    private String chstuAge;

    private List<InterestInfo> infos;

    /** 角色组 */
    private Long[] interestIds;

    public void setChstuSid(String chstuSid)
    {
        this.chstuSid = chstuSid;
    }

    public String getChstuSid() 
    {
        return chstuSid;
    }
    public void setChstuSname(String chstuSname) 
    {
        this.chstuSname = chstuSname;
    }

    public String getChstuSname() 
    {
        return chstuSname;
    }
    public void setChstuSex(String chstuSex) 
    {
        this.chstuSex = chstuSex;
    }

    public String getChstuSex() 
    {
        return chstuSex;
    }
    public void setChstuAge(String chstuAge) 
    {
        this.chstuAge = chstuAge;
    }

    public String getChstuAge() 
    {
        return chstuAge;
    }

    public List<InterestInfo> getInfos() {
        return infos;
    }

    public void setInfos(List<InterestInfo> infos) {
        this.infos = infos;
    }

    public Long[] getInterestIds() {
        return interestIds;
    }

    public void setInterestIds(Long[] interestIds) {
        this.interestIds = interestIds;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("chstuSid", chstuSid)
                .append("chstuSname", chstuSname)
                .append("chstuSex", chstuSex)
                .append("chstuAge", chstuAge)
                .append("infos", infos)
                .append("interestIds", interestIds)
                .toString();
    }
}
