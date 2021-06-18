package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生兴趣管理对象 interest
 * 
 * @author ruoyi
 * @date 2021-06-03
 */
public class InterestInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long interestId;

    /** 兴趣编号 */
    @Excel(name = "兴趣编号")
    private String interestBh;

    /** 兴趣名称 */
    @Excel(name = "兴趣名称")
    private String interestName;

    /** 学生是否存在此兴趣爱好标识 默认不存在 */
    private boolean flag = false;

    public void setInterestId(Long interestId) 
    {
        this.interestId = interestId;
    }

    public Long getInterestId() 
    {
        return interestId;
    }
    public void setInterestBh(String interestBh) 
    {
        this.interestBh = interestBh;
    }

    public String getInterestBh() 
    {
        return interestBh;
    }
    public void setInterestName(String interestName) 
    {
        this.interestName = interestName;
    }

    public String getInterestName() 
    {
        return interestName;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("interestId", interestId)
                .append("interestBh", interestBh)
                .append("interestName", interestName)
                .append("flag", flag)
                .toString();
    }
}
