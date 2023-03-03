package com.solvd.carina.demo;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.APIMethodPoller;
import com.solvd.carina.demo.api.employees.DeleteEmployeeMethod;
import com.solvd.carina.demo.api.employees.GetEmployeesMethods;
import com.solvd.carina.demo.api.employees.PostEmployeeMethod;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * This sample shows how create REST API tests.
 *
 * @author qpsdemo
 */
public class DummyRestAPITest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testCreateEmployee() throws Exception {
        PostEmployeeMethod api = new PostEmployeeMethod();
        api.setProperties("api/employees/employee.properties");

        AtomicInteger counter = new AtomicInteger(0);

        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testCreateEmployeeMissingSomeFields() throws Exception {
        PostEmployeeMethod api = new PostEmployeeMethod();
        api.getProperties().remove("name");
        api.getProperties().remove("username");
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testGetEmployees() {
        GetEmployeesMethods getEmployeesMethods = new GetEmployeesMethods();
        getEmployeesMethods.callAPIExpectSuccess();
        getEmployeesMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getEmployeesMethods.validateResponseAgainstSchema("api/employees/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P1)
    public void testDeleteEmployees() {
        DeleteEmployeeMethod deleteEmployeeMethod = new DeleteEmployeeMethod();
        deleteEmployeeMethod.setProperties("api/employees/employee.properties");
        deleteEmployeeMethod.callAPIExpectSuccess();
        deleteEmployeeMethod.validateResponse();
    }
}
