package com.noobug.Nooblog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class NooblogApplicationTests {

    @Autowired
    private MockMvc mock;

    private MockHttpServletRequestBuilder req;

    private MockHttpServletRequestBuilder GET(String url, Object... uriVars) {
        MockHttpServletRequestBuilder req = get(url, uriVars);
        return req.characterEncoding("utf8");
    }

    private MockHttpServletRequestBuilder POST(String url, Object... uriVars) {
        MockHttpServletRequestBuilder req = post(url, uriVars);
        return req.characterEncoding("utf8");
    }

    /**
     * Admin功能测试
     */
    @Test
    public void AdminTest() throws Exception {

        /*新增管理员接口*/
        req = POST("/api/admin/add")
                .param("account", "Test" + System.currentTimeMillis() % 10000000)
                .param("name", "测试用")
                .param("password", "test123")
                .characterEncoding("utf8");
        mock.perform(req)
                .andExpect(jsonPath("success").value(true));

        req = POST("/api/admin/add")
                .param("account", "admin")
                .param("name", "测试用")
                .param("password", "te");
        mock.perform(req)
                .andExpect(jsonPath("code").value(1));

        req = POST("/api/admin/add")
                .param("account", "adm")
                .param("name", "测试用")
                .param("password", "te");
        mock.perform(req)
                .andExpect(jsonPath("code").value(2));
        //===========================================================
        req = POST("/api/admin/login")
                .param("account", "admin")
                .param("password", "admin123");
        mock.perform(req)
                .andExpect(jsonPath("success").value(true));

        req = POST("/api/admin/logout");
        mock.perform(req)
                .andExpect(jsonPath("$").isNotEmpty());

        req = GET("/api/admin/all");
        mock.perform(req)
                .andExpect(jsonPath("$").isArray());
    }

}
