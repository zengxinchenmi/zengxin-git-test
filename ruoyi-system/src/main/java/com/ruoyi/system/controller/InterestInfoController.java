package com.ruoyi.system.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.InterestInfo;
import com.ruoyi.system.service.IInterestInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 学生兴趣管理Controller
 * 
 * @author ruoyi
 * @date 2021-06-03
 */
@Controller
@RequestMapping("/system/interestinfo")
public class InterestInfoController extends BaseController
{
    private String prefix = "system/interestinfo";

    @Autowired
    private IInterestInfoService interestInfoService;

    @RequiresPermissions("system:interestinfo:view")
    @GetMapping()
    public String interestinfo()
    {
        return prefix + "/interestinfo";
    }

    /**
     * 查询学生兴趣管理列表
     */
    @RequiresPermissions("system:interestinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(InterestInfo interestInfo)
    {
        startPage();
        List<InterestInfo> list = interestInfoService.selectInterestInfoList(interestInfo);
        return getDataTable(list);
    }

    /**
     * 导出学生兴趣管理列表
     */
    @RequiresPermissions("system:interestinfo:export")
    @Log(title = "学生兴趣管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(InterestInfo interestInfo)
    {
        List<InterestInfo> list = interestInfoService.selectInterestInfoList(interestInfo);
        ExcelUtil<InterestInfo> util = new ExcelUtil<InterestInfo>(InterestInfo.class);
        return util.exportExcel(list, "学生兴趣管理数据");
    }

    /**
     * 新增学生兴趣管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存学生兴趣管理
     */
    @RequiresPermissions("system:interestinfo:add")
    @Log(title = "学生兴趣管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(InterestInfo interestInfo)
    {
        return toAjax(interestInfoService.insertInterestInfo(interestInfo));
    }

    /**
     * 修改学生兴趣管理
     */
    @GetMapping("/edit/{interestId}")
    public String edit(@PathVariable("interestId") Long interestId, ModelMap mmap)
    {
        InterestInfo interestInfo = interestInfoService.selectInterestInfoById(interestId);
        mmap.put("interestInfo", interestInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存学生兴趣管理
     */
    @RequiresPermissions("system:interestinfo:edit")
    @Log(title = "学生兴趣管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(InterestInfo interestInfo)
    {
        return toAjax(interestInfoService.updateInterestInfo(interestInfo));
    }

    /**搞一个测试玩一玩*/

    /**
     * 删除学生兴趣管理
     */
    @RequiresPermissions("system:interestinfo:remove")
    @Log(title = "学生兴趣管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(interestInfoService.deleteInterestInfoByIds(ids));
    }
}
