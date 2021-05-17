package com.company;

import org.jetbrains.annotations.NotNull;

enum Shift {EARLY, STANDARD, LATE}

public class DutyExecutant {
    private Responsibility responsibility;
    private final Shift shift;


    public DutyExecutant(@NotNull Responsibility responsibility, @NotNull Shift shift) throws Exception {
        if (responsibility.getDutyExpectantResponsibility() != null || responsibility.getDutyManagerResponsibility() != null) {
            throw new Exception("Responsibility already defined");
        }

        this.shift = shift;
        setResponsibility(responsibility);
        responsibility.addDutyExpectantResponsibility(this);
    }

    public Shift getShift() {
        return shift;
    }

    private void setResponsibility(@NotNull Responsibility responsibility) {
        this.responsibility = responsibility;
    }
}
