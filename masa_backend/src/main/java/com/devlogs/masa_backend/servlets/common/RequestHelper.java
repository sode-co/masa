package com.devlogs.masa_backend.servlets.common;

import com.google.gson.Gson;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

public class RequestHelper {
    private HttpServletRequest currentRequest;
    private Validator validator;

    public RequestHelper(HttpServletRequest currentRequest, Validator validator) {
        this.currentRequest = currentRequest;
        this.validator = validator;
    }

    public <T> ValidateResult<T> getRequestBody  (Class<T> clazz) throws IOException {
        String requestData = currentRequest.getReader().lines().collect(Collectors.joining());
        T bean = new Gson().fromJson(requestData, clazz);
        Set<ConstraintViolation<T>> violations = validator.validate(bean);
        if (violations.isEmpty()) {
            return new ValidateResult.Valid<T>(bean);
        }
        return new ValidateResult.InValid<T>(violations);
    }

    public static class ValidateResult<T>  {
        public static class Valid <T> extends ValidateResult<T> {
            private T body;

            public Valid(T body) {
                this.body = body;
            }

            public T getBody() {
                return body;
            }
        }

        public static class InValid<T> extends ValidateResult<T> {
            private Set<ConstraintViolation<T>> violations;

            public InValid(Set<ConstraintViolation<T>> violations) {
                this.violations = violations;
            }

            public Set<ConstraintViolation<T>> getViolations() {
                return violations;
            }

            public String getMessage() {
                String invalidMessage = "";
                for (ConstraintViolation<T> violation : violations) {
                    invalidMessage += violation.getMessage() + ", \n";
                }
                return invalidMessage;
            }
        }
    }
}
