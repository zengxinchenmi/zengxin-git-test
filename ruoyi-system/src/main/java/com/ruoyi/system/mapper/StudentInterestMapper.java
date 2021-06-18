package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.StudentInterest;
import org.apache.ibatis.annotations.Param;

/**
 * 学生兴趣关联Mapper接口
 * 
 * @author ruoyi
 * @date 2021-06-03
 */
public interface StudentInterestMapper 
{
    /**
     * 查询学生兴趣关联
     * 
     * @param intSid 学生兴趣关联ID
     * @return 学生兴趣关联
     */
    public StudentInterest selectStudentInterestById(String intSid);

    /**
     * 查询学生兴趣关联列表
     * 
     * @param studentInterest 学生兴趣关联
     * @return 学生兴趣关联集合
     */
    public List<StudentInterest> selectStudentInterestList(StudentInterest studentInterest);

    /**
     * 新增学生兴趣关联
     * 
     * @param studentInterest 学生兴趣关联
     * @return 结果
     */
    public int insertStudentInterest(StudentInterest studentInterest);

    /**
     * 修改学生兴趣关联
     * 
     * @param studentInterest 学生兴趣关联
     * @return 结果
     */
    public int updateStudentInterest(StudentInterest studentInterest);

    /**
     * 删除学生兴趣关联
     * 
     * @param intSid 学生兴趣关联ID
     * @return 结果
     */
    public int deleteStudentInterestById(String intSid);

    /**
     * 批量删除学生兴趣关联
     * 
     * @param intSids 需要删除的数据ID
     * @return 结果
     */
    public int deleteStudentInterestByIds(String[] intSids);

    /**
     * 批量新增
     * @param list
     * @return
     */
    public int batchStudentInterest(List<StudentInterest> list);

    /**
     * 根据学生DD删除数据
     * @param studentId
     */
    public void deleteStudentInterestByStudentId(@Param("studentId") String studentId);
}
