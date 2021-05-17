package com.company;

import org.jetbrains.annotations.NotNull;

public class Responsibility {

    private final Employee employee;

    private DutyExecutant dutyExecutantResponsibility;
    private DutyManager dutyManagerResponsibility;

    public Responsibility(@NotNull Employee employee) throws Exception {
        if (employee.getEmployment() != null) {
            throw new Exception("Waiter already have responsibility");
        }
        assignExpectantResponsibility(Shift.STANDARD);

        this.employee = employee;
    }

    void addDutyExpectantResponsibility(@NotNull DutyExecutant dutyExecutantResponsibility) {
        if (this.dutyExecutantResponsibility == null) {
            this.dutyManagerResponsibility = null;
            this.dutyExecutantResponsibility = dutyExecutantResponsibility;
        }
    }

    void addDutyManagerResponsibility(@NotNull DutyManager dutyManagerResponsibility) {
        if (this.dutyManagerResponsibility == null) {
            this.dutyExecutantResponsibility = null;
            this.dutyManagerResponsibility = dutyManagerResponsibility;
        }
    }

    public DutyExecutant getDutyExpectantResponsibility() {
        return dutyExecutantResponsibility;
    }

    public DutyManager getDutyManagerResponsibility() {
        return dutyManagerResponsibility;
    }

    public void assignManagerResponsibility(String region) throws Exception {
        if (dutyManagerResponsibility == null) {
            dutyExecutantResponsibility = null;
            dutyManagerResponsibility = new DutyManager(this, region);
        }
    }

    public void assignExpectantResponsibility(@NotNull Shift shift) throws Exception {
        if (dutyExecutantResponsibility == null) {
            dutyManagerResponsibility = null;
            dutyExecutantResponsibility = new DutyExecutant(this, shift);
        }
    }

    private boolean isDutyManagerResponsibility() {
        return dutyManagerResponsibility != null;
    }
    @Override
    public String toString() {
        return "Worker '" + employee.getIndividual().getFirstName() + " " + employee.getIndividual().getLastName() +
                (isDutyManagerResponsibility() ? "Has responsibility of manager for " + dutyManagerResponsibility.getRegion() + " region" :
                        "Has responsibility of executant in " + dutyExecutantResponsibility.getShift() + " Shift");
    }

}
