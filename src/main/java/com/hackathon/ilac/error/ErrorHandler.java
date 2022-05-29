package com.hackathon.ilac.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@RestController
//@ApiIgnore
public class ErrorHandler implements ErrorController {
    @Autowired
    private ErrorAttributes errorAttributes;
    private final Logger LOGGER= LoggerFactory.getLogger(ErrorHandler.class);

    @RequestMapping("/error")
    ApiError handleError(WebRequest webRequest) {
        Map<String, Object> attributes = this.errorAttributes.getErrorAttributes(webRequest,
                ErrorAttributeOptions.of(ErrorAttributeOptions.Include.MESSAGE, ErrorAttributeOptions.Include.BINDING_ERRORS));
        String message = (String)attributes.get("message");
        int status = (Integer) attributes.get("status");
        ApiError error = new ApiError();
        error.setMessage(message);
        if (status==401)
            error.setMessage(ErrorConstans.UNAUTHORIZD.getCodes());
        else if(status==403)
            error.setMessage(ErrorConstans.FORBIDDN.getCodes());
        else if (status==500)
            LOGGER.error((String)attributes.get("message"));
        //error.setMessage();
        if(attributes.containsKey("errors")) {
            error.setMessage(ErrorConstans.VALIDATION.getCodes());
        }
        return error;
    }

}