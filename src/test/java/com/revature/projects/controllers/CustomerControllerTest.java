package com.revature.projects.controllers;

import com.revature.projects.services.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@WebMvcTest(value = CustomerController.class)
public class CustomerControllerTest {

    @MockBean
    private CustomerService customerService;

    @MockBean
    private  CustomerController customerController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void welcomeCustomerTest() throws Exception {
//        when(customerService.welcomeCustomer()).thenReturn("Welcome!");
//        when(customerController.welcomeCustomer()).thenReturn(new ResponseEntity<String>("Welcome, Phong!", HttpStatus.OK));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/RevBankAPI/v2/welcome");

        ResultActions perform = mockMvc.perform(requestBuilder);
        MvcResult mvcResult = perform.andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        int status = response.getStatus();

        assertEquals(200, status);
    }


}