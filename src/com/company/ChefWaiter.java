package com.company;

import org.jetbrains.annotations.NotNull;
/**
 * @author Serhii Krasnoiarskyi s18943
 *
 */
public class ChefWaiter extends Chef implements IWaiter {

    private final String phone;
    private Duty duty;

    public ChefWaiter(@NotNull Individual individual, double salary, String phone, Duty duty, int stars) throws Exception {
        super(individual, salary, stars);
        this.duty = duty;
        this.phone = phone;
    }


    @Override
    public Duty doDuty() {
        return this.duty;
    }

    @Override
    public void changeDuty(Duty duty) {
        this.duty = duty;
    }

    @Override
    public void riseCookMastery() {
        super.riseCookMastery();
    }

    @Override
    public String toString() {
        return "Instructor_Seller {" +
                "duty = " + duty +
                "Contact phone" + phone +
                ", qualification = " + super.getStars() +
                '}';
    }

    /**
     * Gets the total income of a person.
     * @return
     * double (base salary + bonus from duty)
     */
    @Override
    public double getSalary() {
        return super.getSalary() + (super.getRawSalary() * 0.3 * duty.getNumVal());
    }
}
