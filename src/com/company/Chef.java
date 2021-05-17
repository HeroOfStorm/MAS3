package com.company;

import org.jetbrains.annotations.NotNull;

/**
 * @author Serhii Krasnoiarskyi s18943
 *
 */
public class Chef extends Employee {

    private int stars;

    public Chef(@NotNull Individual individual, double salary, int stars) throws Exception {
        super(individual, salary);
        this.stars = stars;
    }

    public void riseCookMastery() {
        if(stars < 5)
            stars++;
        else
            System.out.println("Chef already has *****(5 stars)");


    }

    public int getStars() {
        return stars;
    }

    @Override
    public double getSalary() {
        return super.getRawSalary() + 55 * stars;
    }
}