package com.ruoyi.system.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.InterestInfo;
import com.ruoyi.system.domain.StudentInfo;
import com.ruoyi.system.domain.StudentInterest;
import com.ruoyi.system.service.IInterestInfoService;
import com.ruoyi.system.service.IStudentInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 学生信息管理Controller
 * 
 * @author ruoyi
 * @date 2021-06-03
 */
@Controller
@RequestMapping("/system/studentinfo")
public class StudentInfoController extends BaseController
{
    private String prefix = "system/studentinfo";

    @Autowired
    private IStudentInfoService studentInfoService;
    @Autowired
    private IInterestInfoService interestInfoService;

    @RequiresPermissions("system:studentinfo:view")
    @GetMapping()
    public String studentinfo()
    {
        return prefix + "/studentinfo";
    }

    /**
     * 查询学生信息管理列表
     */
    @RequiresPermissions("system:studentinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(StudentInfo studentInfo)
    {
        startPage();
        List<StudentInfo> list = studentInfoService.selectStudentInfoList(studentInfo);
        return getDataTable(list);
    }

    /**
     * 导出学生信息管理列表
     */
    @RequiresPermissions("system:studentinfo:export")
    @Log(title = "学生信息管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(StudentInfo studentInfo)
    {
        List<StudentInfo> list = studentInfoService.selectStudentInfoList(studentInfo);
        ExcelUtil<StudentInfo> util = new ExcelUtil<StudentInfo>(StudentInfo.class);
        return util.exportExcel(list, "学生信息管理数据");
    }

    /**
     * 新增学生信息管理
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        mmap.put("infos", interestInfoService.selectInterestAll().stream().collect(Collectors.toList()));
        return prefix + "/add";
    }

    /**
     * 新增保存学生信息管理
     */
    @RequiresPermissions("system:studentinfo:add")
    @Log(title = "学生信息管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(StudentInfo studentInfo)
    {
        return toAjax(studentInfoService.insertStudentInfo(studentInfo));
    }

    /**
     * 修改学生信息管理
     */
    @GetMapping("/edit/{chstuSid}")
    public String edit(@PathVariable("chstuSid") String chstuSid, ModelMap mmap)
    {
        List<InterestInfo> infos = interestInfoService.selectInterestsByStudentId(chstuSid);
        StudentInfo studentInfo = studentInfoService.selectStudentInfoById(chstuSid);
        mmap.put("studentInfo", studentInfo);
        mmap.put("infos", infos);
        return prefix + "/edit";
    }

    /**
     * 修改保存学生信息管理
     */
    @RequiresPermissions("system:studentinfo:edit")
    @Log(title = "学生信息管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(StudentInfo studentInfo)
    {
        return toAjax(studentInfoService.updateStudentInfo(studentInfo));
    }

    /**
     * 删除学生信息管理
     */
    @RequiresPermissions("system:studentinfo:remove")
    @Log(title = "学生信息管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(studentInfoService.deleteStudentInfoByIds(ids));
    }
}
