package com.devlogs.masa_backend.servlets.common;

import com.devlogs.masa_backend.common.helper.MasaLog;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

public class RequestHelper {
    @FunctionalInterface
    public interface ValidateTailParam {
        boolean isValid(String param);
    }

    private HttpServletRequest currentRequest;
    private Validator validator;

    public RequestHelper(HttpServletRequest currentRequest, Validator validator) {
        this.currentRequest = currentRequest;
        this.validator = validator;
    }

    public String getTailRequestParam (ValidateTailParam validator) {
        String url = currentRequest.getRequestURL().toString();
        try {
            String result = url.substring(url.lastIndexOf("/") +1);
            if (validator == null) {
                return result;
            }
            if (validator.isValid(result)) {
                return result;
            }
        } catch (IndexOutOfBoundsException ex) {
            MasaLog.warningLog("Tail param is missing while it is required: " + ex.getMessage());
        }
        return null;
    }

    public <T> ValidateResult<T> getRequestBody  (Class<T> clazz) throws IOException {
        try {
            String requestData = currentRequest.getReader().lines().collect(Collectors.joining());
        T bean = new Gson().fromJson(requestData, clazz);
            Set<ConstraintViolation<T>> violations = validator.validate(bean);
            if (violations.isEmpty()) {
                return new ValidateResult.Valid<T>(bean);
            }
            return new ValidateResult.InValid<T>(violations);
        } catch (com.google.gson.stream.MalformedJsonException ex) {
            return new ValidateResult.InValid<T>(ex.getMessage());
        }
        catch (JsonSyntaxException ex) {
            return new ValidateResult.InValid<T>(ex.getMessage());
        }
        catch (IllegalArgumentException ex) {
            return new ValidateResult.InValid<T>(ex.getMessage());
        }

    }

    public static abstract class ValidateResult<T>  {

        public abstract boolean isValid ();

        public abstract T getValidReqBody ();

        public abstract String getFailMessage ();

        final public static class Valid <T> extends ValidateResult<T> {
            private T body;

            public Valid(T body) {
                this.body = body;
            }

            public T getBody() {
                return body;
            }

            @Override
            public boolean isValid() {
                return true;
            }

            @Override
            public T getValidReqBody() {
                return body;
            }

            @Override
            public String getFailMessage() {
                throw new RuntimeException("Validate result is success, can not get failed result");
            }

        }

        final public static class InValid<T> extends ValidateResult<T> {
            private Set<ConstraintViolation<T>> violations;
            private String invalidMessage;

            public InValid (String message) {
                invalidMessage = message;
            }

            public InValid(Set<ConstraintViolation<T>> violations) {
                this.violations = violations;
                for (ConstraintViolation<T> violation : violations) {
                    invalidMessage += violation.getMessage() + ", \n";
                }
            }

            public Set<ConstraintViolation<T>> getViolations() {
                return violations;
            }

            public String getMessage() {
                return invalidMessage;
            }

            @Override
            public boolean isValid() {
                return false;
            }

            @Override
            public T getValidReqBody() {
                throw new RuntimeException("Validate result is failed, can not get success result");
            }

            @Override
            public String getFailMessage() {
                return getMessage();
            }

        }
    }
}
