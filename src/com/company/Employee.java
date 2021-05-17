package com.company;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Serhii Krasnoiarskyi s18943
 *
 */
enum EmployeeType {CHEF, WAITER, CHEF_WAITER}

public abstract class Employee {

    private double salary;
    private final Individual individual;

    private static final List<Employee> employees = new ArrayList<>();

    private final Responsibility employment = new Responsibility(this);

    public Employee(@NotNull Individual individual, double salary) throws Exception {
        if (individual.isEmployee()) {
            throw new Exception("Provided person is already has an employee");
        }
        this.individual = individual;
        setSalary(salary);
        individual.addEmployee(this);

        employees.add(this);
    }

    public static void removeEmployee(@NotNull Employee employee) {
        employee.individual.setEmployee(null);
        employees.remove(employee);
    }

    public void assignManagerResponsibility(@NotNull String region) throws Exception {
        employment.assignManagerResponsibility(region);
    }

    public void assignExpectantResponsibility(Shift shift) throws Exception {
        employment.assignExpectantResponsibility(shift);
    }

    public abstract double getSalary();


    // Getters and setters
    private void setSalary(double salary) {
        this.salary = salary;
    }

    public Individual getIndividual() {
        return individual;
    }

    public Responsibility getEmployment() {
        return employment;
    }

    public static List<Employee> getEmployees() {
        return employees;
    }

    public double getRawSalary(){
        return this.salary;
    }
}
