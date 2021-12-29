package com.example.sb_korea.controller;

import com.example.sb_korea.vo.UserDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hao.wong
 * @date 2021/12/14
 */
@RestController
public class MyController {

    public String name;

    @RequestMapping("/my")
    public String my(){
        return "[{\n" +
                "\t\"rewardType\": 2,\n" +
                "\t\"levelLimitAfterRewardNum\": \"12\",\n" +
                "\t\"taskCode\": \"three_level\"\n" +
                "}, {\n" +
                "\t\"rewardType\": 3,\n" +
                "\t\"levelLimitAfterRewardNum\": \"15000\",\n" +
                "\t\"taskCode\": \"remote_buyxiangcun1000yuan\",\n" +
                "\t\"quaCode\": \"V2G20211119174049868Q02\",\n" +
                "\t\"isLiCaiTask\": true\n" +
                "}, {\n" +
                "\t\"rewardType\": 3,\n" +
                "\t\"levelLimitAfterRewardNum\": \"1500\",\n" +
                "\t\"taskCode\": \"remote_accessForConvenienceScene\",\n" +
                "\t\"quaCode\": \"V2G20211111113112115Q01\"\n" +
                "}, {\n" +
                "\t\"rewardType\": 3,\n" +
                "\t\"levelLimitAfterRewardNum\": \"1500\",\n" +
                "\t\"taskCode\": \"remote_buyapennybus\",\n" +
                "\t\"quaCode\": \"V2G20211122151845768Q01\"\n" +
                "}, {\n" +
                "\t\"rewardType\": 3,\n" +
                "\t\"levelLimitAfterRewardNum\": \"2000\",\n" +
                "\t\"taskCode\": \"remote_buychaobao100yuan\",\n" +
                "\t\"quaCode\": \"V2G20211119173737538Q01\"\n" +
                "}, {\n" +
                "\t\"ifLevelLimit\": true,\n" +
                "\t\"levelLimit\": 10,\n" +
                "\t\"rewardType\": 2,\n" +
                "\t\"levelLimitBeforeRewardNum\": \"1\",\n" +
                "\t\"levelLimitAfterRewardNum\": \"2\",\n" +
                "\t\"taskCode\": \"browse_visitconvenientscenes\",\n" +
                "\t\"quaCode\": \"V2G20211111115058727Q01\"\n" +
                "}, {\n" +
                "\t\"ifLevelLimit\": true,\n" +
                "\t\"levelLimit\": 10,\n" +
                "\t\"rewardType\": 2,\n" +
                "\t\"levelLimitBeforeRewardNum\": \"1\",\n" +
                "\t\"levelLimitAfterRewardNum\": \"2\",\n" +
                "\t\"taskCode\": \"browse_experienceMMembers\",\n" +
                "\t\"quaCode\": \"V2G20211111111414892Q01\"\n" +
                "}, {\n" +
                "\t\"ifLevelLimit\": true,\n" +
                "\t\"levelLimit\": 10,\n" +
                "\t\"rewardType\": 2,\n" +
                "\t\"levelLimitBeforeRewardNum\": \"1\",\n" +
                "\t\"levelLimitAfterRewardNum\": \"2\",\n" +
                "\t\"taskCode\": \"browse_focusononlinestores\",\n" +
                "\t\"quaCode\": \"V2G20211111142716972Q01\"\n" +
                "}, {\n" +
                "\t\"rewardType\": 3,\n" +
                "\t\"levelLimitAfterRewardNum\": \"2000\",\n" +
                "\t\"taskCode\": \"remote_successfullypurchasedmealticket\",\n" +
                "\t\"quaCode\": \"V2G20211111115643240Q01\"\n" +
                "}, {\n" +
                "\t\"rewardType\": 2,\n" +
                "\t\"levelLimitAfterRewardNum\": \"15\",\n" +
                "\t\"taskCode\": \"remote_openfixedinvestment\",\n" +
                "\t\"quaCode\": \"V2G20211111115302146Q01\",\n" +
                "\t\"isLiCaiTask\": true\n" +
                "}, {\n" +
                "\t\"rewardType\": 3,\n" +
                "\t\"levelLimitAfterRewardNum\": \"10000\",\n" +
                "\t\"taskCode\": \"remote_buychaobao10000yuan\",\n" +
                "\t\"quaCode\": \"V2G20211119173933801Q01\",\n" +
                "\t\"isLiCaiTask\": true\n" +
                "}, {\n" +
                "\t\"rewardType\": 3,\n" +
                "\t\"levelLimitAfterRewardNum\": \"15000\",\n" +
                "\t\"taskCode\": \"remote_upgradegoldcard\",\n" +
                "\t\"quaCode\": \"V2G20211111140139070Q02\",\n" +
                "\t\"isLiCaiTask\": true\n" +
                "}, {\n" +
                "\t\"rewardType\": 3,\n" +
                "\t\"levelLimitAfterRewardNum\": \"75000\",\n" +
                "\t\"taskCode\": \"remote_upgradesunflowercard\",\n" +
                "\t\"quaCode\": \"V2G20211111142537851Q02\",\n" +
                "\t\"isLiCaiTask\": true\n" +
                "}, {\n" +
                "\t\"rewardType\": 3,\n" +
                "\t\"levelLimitAfterRewardNum\": \"30000\",\n" +
                "\t\"taskCode\": \"remote_transfer50000\",\n" +
                "\t\"quaCode\": \"V2G20211203143115229Q02\",\n" +
                "\t\"isLicaiTask\": \"true\"\n" +
                "}, {\n" +
                "\t\"rewardType\": 3,\n" +
                "\t\"levelLimitAfterRewardNum\": \"30000\",\n" +
                "\t\"taskCode\": \"remote_zzb_Buy50000\",\n" +
                "\t\"quaCode\": \"V2G20211203141335113Q01\",\n" +
                "\t\"isLicaiTask\": \"true\"\n" +
                "}, {\n" +
                "\t\"rewardType\": 3,\n" +
                "\t\"levelLimitAfterRewardNum\": \"2000\",\n" +
                "\t\"taskCode\": \"remote_carCode\",\n" +
                "\t\"quaCode\": \"V2G20211203141545814Q01\",\n" +
                "\t\"isLicaiTask\": \"false\"\n" +
                "}, {\n" +
                "\t\"rewardType\": 3,\n" +
                "\t\"levelLimitAfterRewardNum\": \"7500\",\n" +
                "\t\"taskCode\": \"remote_zj_buy1000\",\n" +
                "\t\"quaCode\": \"V2G20211203142208315Q01\",\n" +
                "\t\"isLicaiTask\": \"true\"\n" +
                "}, {\n" +
                "\t\"rewardType\": 3,\n" +
                "\t\"levelLimitAfterRewardNum\": \"7500\",\n" +
                "\t\"taskCode\": \"remote_ktsdf\",\n" +
                "\t\"quaCode\": \"V2G20211207095222591Q01\",\n" +
                "\t\"isLicaiTask\": \"true\"\n" +
                "}]";
    }
    /**
     * 测试用户
     * @param dto
     * @return
     */
    @RequestMapping("/test")
    public String test(@RequestBody UserDTO dto){
        return "success";
    }
}
