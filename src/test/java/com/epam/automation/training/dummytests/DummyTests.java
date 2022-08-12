package com.epam.automation.training.dummytests;

import com.epam.automation.training.TestSetup;
import com.epam.automation.training.annotations.CustomAnnotations.UITests;
import com.epam.automation.training.annotations.CustomAnnotations.APITests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class DummyTests extends TestSetup {

    @Test
    @UITests(description = "Verifies that true is true")
    public void dummyUiTest() {
        assertTrue(true);
    }

    @Test
    @APITests(description = "Verifies that false is false")
    public void dummyApiTest() {
        assertFalse(false);
    }
}
