package com.solvd.carina.demo.api.employees;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.Configuration;

@Endpoint(url = "${base_url}/create", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/employees/_post/rq.json")
@ResponseTemplatePath(path = "api/employees/_post/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PostEmployeeMethod extends AbstractApiMethodV2 {

    public PostEmployeeMethod() {
        super("api/employees/_post/rq.json", "api/employees/_post/rs.json", "api/employees/employee.properties");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("dummy_api_url"));
    }
}
