package com.ruoyi.system.service.impl;

import java.rmi.server.UID;
import java.util.List;
import java.util.UUID;

import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.utils.spring.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.InterestInfoMapper;
import com.ruoyi.system.domain.InterestInfo;
import com.ruoyi.system.service.IInterestInfoService;
import com.ruoyi.common.core.text.Convert;

import javax.annotation.Resource;

/**
 * 学生兴趣管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-06-03
 */
@Service
public class InterestInfoServiceImpl implements IInterestInfoService 
{
    @Resource
    private InterestInfoMapper interestInfoMapper;

    /**
     * 查询学生兴趣管理
     * 
     * @param interestId 学生兴趣管理ID
     * @return 学生兴趣管理
     */
    @Override
    public InterestInfo selectInterestInfoById(Long interestId)
    {
        return interestInfoMapper.selectInterestInfoById(interestId);
    }

    /**
     * 查询学生兴趣管理列表
     * 
     * @param interestInfo 学生兴趣管理
     * @return 学生兴趣管理
     */
    @Override
    public List<InterestInfo> selectInterestInfoList(InterestInfo interestInfo)
    {
        return interestInfoMapper.selectInterestInfoList(interestInfo);
    }

    /**
     * 新增学生兴趣管理
     * 
     * @param interestInfo 学生兴趣管理
     * @return 结果
     */
    @Override
    public int insertInterestInfo(InterestInfo interestInfo)
    {
        return interestInfoMapper.insertInterestInfo(interestInfo);
    }

    /**
     * 修改学生兴趣管理
     * 
     * @param interestInfo 学生兴趣管理
     * @return 结果
     */
    @Override
    public int updateInterestInfo(InterestInfo interestInfo)
    {
        return interestInfoMapper.updateInterestInfo(interestInfo);
    }

    /**
     * 删除学生兴趣管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteInterestInfoByIds(String ids)
    {
        return interestInfoMapper.deleteInterestInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除学生兴趣管理信息
     * 
     * @param interestId 学生兴趣管理ID
     * @return 结果
     */
    @Override
    public int deleteInterestInfoById(Long interestId)
    {
        return interestInfoMapper.deleteInterestInfoById(interestId);
    }

    @Override
    public List<InterestInfo> selectInterestAll() {
        return selectInterestInfoList(new InterestInfo());
    }

    @Override
    public List<InterestInfo> selectInterestsByStudentId(String studentId) {

        List<InterestInfo> interestInfos = interestInfoMapper.selectInterestsByStudentId(studentId);
        List<InterestInfo> infos = selectInterestAll();
        for (InterestInfo info : infos)
        {
            for (InterestInfo interestInfo : interestInfos)
            {
                if (info.getInterestId().equals(interestInfo.getInterestId()))
                {
                    info.setFlag(true);
                    break;
                }
            }
        }
        return infos;
    }
}
