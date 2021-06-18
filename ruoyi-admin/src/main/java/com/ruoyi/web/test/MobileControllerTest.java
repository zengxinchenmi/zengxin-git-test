package com.ruoyi.web.test;

import com.ruoyi.RuoYiApplication;
import com.ruoyi.system.domain.InterestInfo;
import com.ruoyi.system.service.IInterestInfoService;
import com.ruoyi.system.service.IStudentInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = RuoYiApplication.class)
@RunWith(SpringRunner.class)
public class MobileControllerTest {

    @Autowired
    private IInterestInfoService interestInfoService;
    @Autowired
    private IStudentInfoService studentInfoService;

    @Test
    public void test_selectInterest(){
        List<InterestInfo> lstInfo =  interestInfoService.selectInterestInfoList(new InterestInfo());
        System.err.println(lstInfo);
    }


}
