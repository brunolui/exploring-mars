package br.com.elo7.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.com.elo7.ExploringMarsApplication;

import static org.junit.Assert.assertEquals;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ExploringMarsApplication.class)
@WebAppConfiguration
public class ExplorerApiControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setUp() {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Test
    public void testPostOneSpaceProbe() throws Exception {
        MvcResult mvcResult = mvc.perform(post("/probes/")
                                              .contentType(APPLICATION_JSON)
                                              .content("{\"plateau\":{\"coordinates\": \"5 5\"},\"spaceProbes\":[{\"coordinates\": \"3 3\",\"direction\": \"E\",\"instructions\": \"MMRMMRMRRM\"}]}"))
            .andExpect(status().isCreated())
            .andReturn();

        assertEquals("[{\"position\":\"5 1 E\"}]", mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void testPostTwoSpaceProbes() throws Exception {
        MvcResult mvcResult = mvc.perform(post("/probes/")
                                              .contentType(APPLICATION_JSON)
                                              .content("{\"plateau\":{\"coordinates\": \"5 5\"},\"spaceProbes\":[{\"coordinates\": \"1 2\",\"direction\": \"N\",\"instructions\": \"LMLMLMLMM\"},{\"coordinates\": \"3 3\",\"direction\": \"E\",\"instructions\": \"MMRMMRMRRM\"}]}"))
            .andExpect(status().isCreated())
            .andReturn();

        assertEquals("[{\"position\":\"1 3 N\"},{\"position\":\"5 1 E\"}]", mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void testPostWithoutSpaceProbe() throws Exception {
        MvcResult mvcResult = mvc.perform(post("/probes/")
                                              .contentType(APPLICATION_JSON)
                                              .content("{\"plateau\":{\"coordinates\": \"5 5\"}}"))
            .andExpect(status().isBadRequest())
            .andReturn();

        assertEquals("{\"errors\":[{\"field\":\"spaceProbes\",\"message\":\"At least one space probe is required\"}]}", mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void testPostWithoutPlateau() throws Exception {
        MvcResult mvcResult = mvc.perform(post("/probes/")
                                              .contentType(APPLICATION_JSON)
                                              .content("{\"spaceProbes\":[{\"coordinates\": \"3 3\",\"direction\": \"E\",\"instructions\": \"MMRMMRMRRM\"}]}"))
            .andExpect(status().isBadRequest())
            .andReturn();

        assertEquals("{\"errors\":[{\"field\":\"plateau\",\"message\":\"Plateau are required\"}]}", mvcResult.getResponse().getContentAsString());
    }
}
