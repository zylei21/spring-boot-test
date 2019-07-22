package com.cibei.springbootrestdocs;

import com.cibei.springbootrestdocs.controller.HomeController;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * .@RunWith(SpringRunner.class)
 * .@WebMvcTest(HomeController.class)
 * .@AutoConfigureRestDocs(outputDir = "target/snippets")
 * public class WebLayerTest {
 *
 *     .@Autowired
 *     private MockMvc mockMvc;
 *
 *     .@Test
 *     public void shouldReturnDefaultMessage() throws Exception {
 *         this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
 *                 .andExpect(content().string(containsString("Hello World")))
 *                 .andDo(document("home"));
 *     }
 * }
 */
@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class SpringbootRestdocsApplicationTests {

    @Autowired
    private MockMvc mockMvc;
    @Test
    public void contextLoads() {
    }
    @Test
    public void shouldReturnDefalutMessage()throws Exception{
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello World"))).andDo(document("home"));
    }

}
