package com.example.sb_korea;

import com.alibaba.fastjson.JSON;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
class SbKoreaApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(SbKoreaApplicationTests.class);

    @Autowired
    private WebApplicationContext context ;
    private MockMvc mvc ;

    /**
     * @Description 初始化
     */
    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mvc = MockMvcBuilders.webAppContextSetup(context).build();  //构造MockMvc
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
            MvcResult mvcResult =
                    this.mvc.perform(MockMvcRequestBuilders.post(url)
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
            MvcResult mvcResult =
                    this.mvc.perform(MockMvcRequestBuilders.post(url)
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
        //实际请求
//        MvcResult mvcResult = this.doJson(setPaperNameWindow, getAdminToken(1), vo);
    }

}
