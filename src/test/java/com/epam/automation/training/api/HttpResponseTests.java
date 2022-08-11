package com.epam.automation.training.api;

import com.epam.automation.training.TestSetup;
import com.epam.automation.training.annotations.CustomAnnotations.APITests;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HttpResponseTests extends TestSetup {

    private final Logger logger = Logger.getLogger(HttpResponseTests.class.getName());

    @BeforeMethod
    public void setUp() {
        RestAssured.baseURI = "http://jsonplaceholder.typicode.com";
    }

    @Test
    @APITests(description = "Verify that Content-Type header is present")
    public void verifyContentTypeHeaderPresence() {
        Response response = RestAssured
                .when()
                .get("/users")
                .andReturn();
        assertTrue(response.getHeader("Content-Type").length() > 0);
    }

    @Test
    @APITests(description = "Verify that Content-Type header value is \"application/json; charset=utf-8\"")
    public void verifyContentTypeHeaderValue() {
        Response response = RestAssured
                .when()
                .get("/users")
                .andReturn();
        String actualResponseHeader = response.getHeader("Content-Type");
        logger.log(Level.INFO, String.valueOf(response.getHeader("Content-Type")));
        assertEquals(actualResponseHeader, "application/json; charset=utf-8");
    }
}
