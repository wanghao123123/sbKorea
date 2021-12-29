package com.example.sb_korea;

import com.alibaba.fastjson.JSON;
import com.example.sb_korea.mapper.UserMapper;
import com.example.sb_korea.utils.BeanUtil;
import com.example.sb_korea.vo.UserDTO;
import com.example.sb_korea.vo.UserVO;
import com.power.common.enums.HttpCodeEnum;
import com.power.doc.builder.HtmlApiDocBuilder;
import com.power.doc.constants.DocGlobalConstants;
import com.power.doc.model.ApiConfig;
import com.power.doc.model.ApiErrorCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest
class SbKoreaApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(SbKoreaApplicationTests.class);

    @Autowired
    private WebApplicationContext context ;
    private MockMvc mvc ;

    /**
     * 在Junit4下使用@Before和@After
     * 而在Junit5下使用@BeforeEach和@AfterEach
     * @Description 初始化
     */
    @BeforeEach
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    /**
     * @Description 发送json请求
     * @param url           访问地址
     * @param authorization 所需要的权限
     * @param obj           参数
     * @return MvcResult    返回值
     */
    public MvcResult doJson(String url, String authorization, Object obj){
        try {
            MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(url)
                                    .header("Authorization", authorization)
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(JSON.toJSONString(obj)))
                            .andExpect(status().isOk())
                            .andDo(print()).andReturn();
            return mvcResult;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * @Description 发送from请求
     * @param url           访问地址
     * @param authorization 所需要的权限
     * @param params        参数
     * @return MvcResult    返回值
     */
    public MvcResult doFrom(String url, String authorization,  MultiValueMap<String, String> params){
        try {
            MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(url)
                                    .header("Authorization", authorization)
                                    .contentType(MediaType.ALL)
                                    .params(params))
                            .andExpect(status().isOk())
                            .andDo(print()).andReturn();
            return mvcResult;
        } catch (Exception e) {
            logger.info("Please check the parameter or call mode");
            e.printStackTrace();
            return null;
        }
    }


    @Test
    public void setPaperNameWindow(){
        MvcResult mvcResult = this.doFrom("/my", "", new LinkedMultiValueMap<>());
        System.err.println();
    }

    @Autowired
    private UserMapper mapper;

    @Test
    public void mapStruct(){

        UserDTO userDTO = new UserDTO();
        userDTO.setName("wanghao");
        userDTO.setAge("1");
        userDTO.setTime("2021-12-21 10:00:00");

        List<UserDTO> dtos =new ArrayList<>();
        dtos.add(userDTO);
        dtos.add(BeanUtil.deepClone(userDTO));
        List<UserVO> userVOS = mapper.toVO(dtos);
        List<UserVO> userVOS2 = BeanUtil.deepClone(userVOS);
        System.err.println();
    }

}
