package com.company;

import org.jetbrains.annotations.NotNull;
/**
 * @author Serhii Krasnoiarskyi s18943
 *
 */
enum Duty {CLEANING(2), SERVING(1), TAKE_ORDERS(2), SORTING(3), DISHWASH(4);
    private int numVal;

    Duty(int numVal) {
        this.numVal = numVal;
    }

    public int getNumVal() {
        return numVal;
    }
}


public class Waiter extends Employee implements IWaiter {
    private Duty duty;
    private final String phone;
//    private Boolean isOnDuty;

    public Waiter(@NotNull Individual individual, double salary, @NotNull String phone, Duty duty)throws Exception{
        super(individual, salary);
        this.phone = phone;
        this.duty = duty;
//        isOnDuty = false;
    }

    public void contact(){
        System.out.println(phone);
    }

    @Override
    public Duty doDuty(){
        System.out.println(duty);
        return duty;
    }

    @Override
    public void changeDuty(Duty duty){
        this.duty = duty;
    }

    @Override
    public double getSalary() {
        return super.getRawSalary() + duty.getNumVal() * 55;
    }

}
