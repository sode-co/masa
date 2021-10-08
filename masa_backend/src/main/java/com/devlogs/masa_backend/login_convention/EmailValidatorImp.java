package com.devlogs.masa_backend.login_convention;

import com.devlogs.masa_backend.common.helper.MasaLog;
import com.devlogs.masa_backend.domain.entities.UserRole;

import javax.inject.Inject;

public class EmailValidatorImp implements EmailValidator {

    @Inject
    public EmailValidatorImp () {

    }

    public Result check (String email) {
        String domain = email.substring(email.indexOf("@")+1);
        MasaLog.normalLog("domain: " + domain);

        if (!(domain.equals("fpt.edu.vn") || domain.equals("fe.edu.vn"))) {
            return new Result(null, false);
        }

        int numOfDigit = email.replaceAll("\\D+", "").length();

        UserRole userRole;
        // Student
        if (numOfDigit >= 4) {
            userRole = new UserRole(UserRole.TYPE.STUDENT);
            // Staff or Lecturer
        } else {
            userRole = new UserRole(UserRole.TYPE.MEMBER);
        }

        return new Result(userRole, true);
    }

}
