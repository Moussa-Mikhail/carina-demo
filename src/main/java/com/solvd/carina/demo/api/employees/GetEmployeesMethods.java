package com.solvd.carina.demo.api.employees;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.Configuration;

@Endpoint(url = "${base_url}/employees", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/employees/_get/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetEmployeesMethods extends AbstractApiMethodV2 {

    public GetEmployeesMethods() {
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("dummy_api_url"));
    }
}
