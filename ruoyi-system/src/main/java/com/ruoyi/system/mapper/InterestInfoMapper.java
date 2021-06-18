package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.InterestInfo;
import org.apache.ibatis.annotations.Param;

/**
 * 学生兴趣管理Mapper接口
 * 
 * @author ruoyi
 * @date 2021-06-03
 */
public interface InterestInfoMapper 
{
    /**
     * 查询学生兴趣管理
     * 
     * @param interestId 学生兴趣管理ID
     * @return 学生兴趣管理
     */
    public InterestInfo selectInterestInfoById(Long interestId);

    /**
     * 查询学生兴趣管理列表
     * 
     * @param interestInfo 学生兴趣管理
     * @return 学生兴趣管理集合
     */
    public List<InterestInfo> selectInterestInfoList(InterestInfo interestInfo);

    /**
     * 新增学生兴趣管理
     * 
     * @param interestInfo 学生兴趣管理
     * @return 结果
     */
    public int insertInterestInfo(InterestInfo interestInfo);

    /**
     * 修改学生兴趣管理
     * 
     * @param interestInfo 学生兴趣管理
     * @return 结果
     */
    public int updateInterestInfo(InterestInfo interestInfo);

    /**
     * 删除学生兴趣管理
     * 
     * @param interestId 学生兴趣管理ID
     * @return 结果
     */
    public int deleteInterestInfoById(Long interestId);

    /**
     * 批量删除学生兴趣管理
     * 
     * @param interestIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteInterestInfoByIds(String[] interestIds);

    /**
     * 根据学生ID查询兴趣
     * @return
     */
    public List<InterestInfo> selectInterestsByStudentId(@Param("studentId") String studentId);
}
