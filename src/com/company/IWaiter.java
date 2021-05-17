package com.company;
/**
 * @author Serhii Krasnoiarskyi s18943
 *
 */
public interface IWaiter {
    Duty duty = null;

    Duty doDuty();

    void changeDuty(Duty duty);
}