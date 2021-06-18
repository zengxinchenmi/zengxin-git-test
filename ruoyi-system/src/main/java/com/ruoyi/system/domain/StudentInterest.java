package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生兴趣关联对象 stu_interest
 * 
 * @author ruoyi
 * @date 2021-06-03
 */
public class StudentInterest extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String intSid;

    /** 外键兴趣 */
    @Excel(name = "外键兴趣")
    private String intInterest;

    /** 学生id */
    @Excel(name = "学生id")
    private String fstusid;

    /** 排序号 */
    @Excel(name = "排序号")
    private String spxh;

    public void setIntSid(String intSid) 
    {
        this.intSid = intSid;
    }

    public String getIntSid() 
    {
        return intSid;
    }
    public void setIntInterest(String intInterest) 
    {
        this.intInterest = intInterest;
    }

    public String getIntInterest() 
    {
        return intInterest;
    }
    public void setFstusid(String fstusid) 
    {
        this.fstusid = fstusid;
    }

    public String getFstusid() 
    {
        return fstusid;
    }
    public void setSpxh(String spxh) 
    {
        this.spxh = spxh;
    }

    public String getSpxh() 
    {
        return spxh;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("intSid", getIntSid())
            .append("intInterest", getIntInterest())
            .append("fstusid", getFstusid())
            .append("spxh", getSpxh())
            .toString();
    }
}
