package com.mycompany.myapp.web.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.mycompany.myapp.Application;

/**
 * Test class for the FibonacciResource REST controller.
 *
 * @see UserResource
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest
public class FibonacciResourceTest {

    private MockMvc restFibMockMvc;

    @Before
    public void setup() {
        FibonacciResource fibResource = new FibonacciResource();
        this.restFibMockMvc = MockMvcBuilders.standaloneSetup(fibResource).build();
    }

    @Test
    public void testGetFibonacci() throws Exception {
    	
    	restFibMockMvc.perform(
    	            post("/api/fibonacci")
    	                .contentType(TestUtil.APPLICATION_JSON_UTF8)
    	                .content(TestUtil.convertObjectToJsonBytes(new Integer(3))))
    	            .andExpect(status().isOk());
       
    }

}
