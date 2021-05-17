package com.company;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author Serhii Krasnoiarskyi s18943
 *
 */
enum IndividualType {CLIENT, EMPLOYEE}

public class Individual {

    private static final Pattern EMAIL_REGEX = Pattern.compile("[0-9a-z_]+@\\w+\\.\\w+", Pattern.CASE_INSENSITIVE);
    private String email;

    private String firstName;
    private String lastName;

    private Client client;
    private Employee employee;

    private static final List<Individual> people = new ArrayList<>();


    public Individual(@NotNull String firstName, @NotNull String lastName, @NotNull String email, int loyalty) throws Exception {
        setFirstName(firstName);
        setLastName(lastName);

        if (!EMAIL_REGEX.matcher(email).find()) {
            throw new Exception("Wrong email");
        }
        setEmail(email);

        new Client(this, loyalty);
        people.add(this);
    }


    public Individual(@NotNull String firstName, @NotNull String lastName, @NotNull String email, @NotNull Double salary,
                      String phone, Duty duty, int stars , @NotNull EmployeeType employeeType) throws Exception {
        setFirstName(firstName);
        setLastName(lastName);

        if (!EMAIL_REGEX.matcher(email).find()) {
            throw new Exception("Wrong email");
        }
        setEmail(email);

        if (salary <= 0) {
            throw new Exception("salary must be grater than zero");
        }

        switch (employeeType) {
            case WAITER -> {
                if (duty == null && phone == null) {
                    throw new Exception("To create waiter you must pass phone and duty for ");
                }
                this.employee = new Waiter(this, salary, phone, duty);

            }
            case CHEF -> {
                if (stars < 0) {
                    throw new Exception("To create chef you must qualification for creating ");
                }
                this.employee = new Chef(this, salary, stars);
            }
            case CHEF_WAITER -> {
                if (stars < 0) {
                    throw new Exception("You must provide qualification for creating instructor");
                }
                this.employee = new Chef_Waiter(this, salary, phone, duty, stars);
            }
        }

        people.add(this);
    }


    public void addClient(@NotNull Client client) {
        if (this.client == null && client.getIndividual() == this) {
            this.client = client;
        }
    }

    public void addEmployee(@NotNull Employee employee) {
        if (this.employee == null && employee.getIndividual() == this) {
            this.employee = employee;
        }
    }

    public void becomeClient(int loyalty) throws Exception {
        if (this.client != null) {
            throw new Exception("This person is already being a client");
        }
        new Client(this, loyalty);
    }

    public void becomeEmployee(@NotNull EmployeeType employeeType, @NotNull Double salary, String phone, Duty duty, int stars ) throws Exception {
        if (this.employee != null) {
            throw new Exception("This person is already being an employee");
        }

        switch (employeeType) {
            case WAITER -> {
                if (duty == null && phone == null) {
                    throw new Exception("Waiter should have duty and phone");
                }
                this.employee = new Waiter(this, salary, phone, duty);
            }
            case CHEF -> {
                if (stars < 0) {
                    throw new Exception("Chef should have stars (rating of mastery) 0 or higher");
                }
                this.employee = new Chef(this, salary, stars);
            }
            case CHEF_WAITER -> {
                if (stars < 0) {
                    throw new Exception("Chef should have stars (rating of mastery) 0 or higher");
                }
                this.employee = new Chef_Waiter(this, salary, phone, duty, stars);
            }
        }
    }

    public void stopBeingClient() {
        Client.removeClient(this.client);
    }

    public void stopBeingEmployee() {
        Employee.removeEmployee(this.employee);
    }

    public boolean isClient() {
        return this.client != null;
    }

    public boolean isEmployee() {
        return this.employee != null;
    }

    public Employee asEmployee() throws Exception {
        if (this.employee == null) {
            throw new Exception("This person is not an employee");
        }
        return this.employee;
    }

    public Client asClient() throws Exception {
        if (this.client == null) {
            throw new Exception("This person is not a client");
        }
        return this.client;
    }

    // Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(@NotNull String email) {
        this.email = email;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public static List<Individual> getPeople() {
        return people;
    }
}
