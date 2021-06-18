package com.ruoyi.system.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.StudentInterest;
import com.ruoyi.system.domain.SysUserRole;
import com.ruoyi.system.mapper.StudentInterestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.StudentInfoMapper;
import com.ruoyi.system.domain.StudentInfo;
import com.ruoyi.system.service.IStudentInfoService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 学生信息管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-06-03
 */
@Service
public class StudentInfoServiceImpl implements IStudentInfoService 
{
    @Resource
    private StudentInfoMapper studentInfoMapper;
    @Resource
    private StudentInterestMapper studentInterestMapper;

    /**
     * 查询学生信息管理
     * 
     * @param chstuSid 学生信息管理ID
     * @return 学生信息管理
     */
    @Override
    public StudentInfo selectStudentInfoById(String chstuSid)
    {
        return studentInfoMapper.selectStudentInfoById(chstuSid);
    }

    /**
     * 查询学生信息管理列表
     * 
     * @param studentInfo 学生信息管理
     * @return 学生信息管理
     */
    @Override
    public List<StudentInfo> selectStudentInfoList(StudentInfo studentInfo)
    {
        return studentInfoMapper.selectStudentInfoList(studentInfo);
    }

    /**
     * 新增学生信息管理
     * 
     * @param studentInfo 学生信息管理
     * @return 结果
     */
    @Override
    @Transactional
    public int insertStudentInfo(StudentInfo studentInfo)
    {
        // 新增学生信息
        studentInfo.setChstuSid(UUID.randomUUID().toString().replace("-", ""));
        int rows = studentInfoMapper.insertStudentInfo(studentInfo);
        // 新增学生与兴趣管理
        insertStudentInterest(studentInfo.getChstuSid(), studentInfo.getInterestIds());
        return rows;
    }

    /**
     * 修改学生信息管理
     * 
     * @param studentInfo 学生信息管理
     * @return 结果
     */
    @Override
    @Transactional
    public int updateStudentInfo(StudentInfo studentInfo)
    {
        String studentId = studentInfo.getChstuSid();
        // 删除学生与兴趣关联
        studentInterestMapper.deleteStudentInterestByStudentId(studentId);
        // 新增生与兴趣管理
        insertStudentInterest(studentId, studentInfo.getInterestIds());
        return studentInfoMapper.updateStudentInfo(studentInfo);
    }

    /**
     * 删除学生信息管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteStudentInfoByIds(String ids)
    {
        return studentInfoMapper.deleteStudentInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除学生信息管理信息
     * 
     * @param chstuSid 学生信息管理ID
     * @return 结果
     */
    @Override
    public int deleteStudentInfoById(String chstuSid)
    {
        return studentInfoMapper.deleteStudentInfoById(chstuSid);
    }

    /**
     * 新增学生兴趣管理信息
     *
     */
    public void insertStudentInterest(String studentId, Long[] interestIds)
    {
        if (StringUtils.isNotNull(interestIds))
        {
            List<StudentInterest> list = new ArrayList<StudentInterest>();
            for (Long interestId : interestIds)
            {
                StudentInterest si = new StudentInterest();
                si.setIntSid(UUID.randomUUID().toString().replace("-", ""));
                si.setFstusid(studentId);
                si.setIntInterest(interestId.toString());
                list.add(si);
            }
            if (list.size() > 0)
            {
                studentInterestMapper.batchStudentInterest(list);
            }
        }
    }
}
