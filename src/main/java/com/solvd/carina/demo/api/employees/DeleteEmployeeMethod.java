package com.solvd.carina.demo.api.employees;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.Configuration;

@Endpoint(url = "${base_url}/delete/1", methodType = HttpMethodType.DELETE)
@RequestTemplatePath(path = "api/employees/_delete/rq.json")
@ResponseTemplatePath(path = "api/employees/_delete/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class DeleteEmployeeMethod extends AbstractApiMethodV2 {

    public DeleteEmployeeMethod() {
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("dummy_api_url"));
    }
}
