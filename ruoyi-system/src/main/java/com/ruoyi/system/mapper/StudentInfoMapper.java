package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.StudentInfo;

/**
 * 学生信息管理Mapper接口
 * 
 * @author ruoyi
 * @date 2021-06-03
 */
public interface StudentInfoMapper 
{
    /**
     * 查询学生信息管理
     * 
     * @param chstuSid 学生信息管理ID
     * @return 学生信息管理
     */
    public StudentInfo selectStudentInfoById(String chstuSid);

    /**
     * 查询学生信息管理列表
     * 
     * @param studentInfo 学生信息管理
     * @return 学生信息管理集合
     */
    public List<StudentInfo> selectStudentInfoList(StudentInfo studentInfo);

    /**
     * 新增学生信息管理
     * 
     * @param studentInfo 学生信息管理
     * @return 结果
     */
    public int insertStudentInfo(StudentInfo studentInfo);

    /**
     * 修改学生信息管理
     * 
     * @param studentInfo 学生信息管理
     * @return 结果
     */
    public int updateStudentInfo(StudentInfo studentInfo);

    /**
     * 删除学生信息管理
     * 
     * @param chstuSid 学生信息管理ID
     * @return 结果
     */
    public int deleteStudentInfoById(String chstuSid);

    /**
     * 批量删除学生信息管理
     * 
     * @param chstuSids 需要删除的数据ID
     * @return 结果
     */
    public int deleteStudentInfoByIds(String[] chstuSids);
}
