package com.devlogs.masa_backend.appointment;

import javax.inject.Inject;

public class RemindMeetingTime {
    public int MIN_30 = 1000 * 60 * 30;

    @Inject
    public RemindMeetingTime () {

    }

    public Long getRemindTime (long startTime) {
        return startTime - MIN_30;
    }
}
