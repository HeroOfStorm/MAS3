package com.company;

public class Main {

    public static void main(String[] args) throws Exception {


        //////////////////////////////// (1)Polymorphic calls  \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        System.out.println("\n ================================= (1)Polymorphic calls ================================= ");

        Individual individual_chef_waiter = new Individual("Gazzo", "Help", "Oscorp@corp.ip", 3500.0,
                "+7899929024", Duty.CLEANING, 2, EmployeeType.CHEF_WAITER);

        Individual individual_chef = new Individual("INsiDe", "Me", "Oscorp@cheefs.st", 3500.0,
                null, null, 4, EmployeeType.CHEF);

        System.out.println(individual_chef_waiter.asEmployee().getSalary());
        System.out.println(individual_chef.asEmployee().getSalary());
        ((Chef)individual_chef.asEmployee()).riseCookMastery();
        System.out.println(individual_chef.asEmployee().getSalary());


        ////////////////////////////////  (2)Dynamic inheritance \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        System.out.println("\n ================================= (2)Dynamic inheritance ================================= ");

        Individual individual_waiter = new Individual("Miku", "Deadlo", "DadINSide@gmail.com",
                1700.0, "+987981437", Duty.TAKE_ORDERS, 0, EmployeeType.WAITER);

        System.out.println(individual_waiter.asEmployee().getEmployment());
        individual_waiter.asEmployee().assignManagerResponsibility("New Burge");

        System.out.println(individual_waiter.asEmployee().getEmployment());
        individual_waiter.asEmployee().assignExpectantResponsibility(Shift.EARLY);

        System.out.println(individual_waiter.asEmployee().getEmployment());

        //////////////////////////////// (3)Overlapping \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        System.out.println(" =================================  (3)Overlapping ================================= ");
        Individual individual_client = new Individual("Miles", "Morales", "Morales35@mail.ru", 3);

        System.out.println("Individual is client: " + individual_client.isClient());
        System.out.println("Individual is employee: " + individual_client.isEmployee());

        individual_client.becomeEmployee(EmployeeType.CHEF, 2000.0, null, null, 2);


        System.out.println("Individual is client: " + individual_client.isClient());
        System.out.println("Individual is employee: " + individual_client.isEmployee());


        //////////////////////////////// (4)Multi \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        System.out.println("\n ================================= (4)Multi ================================= ");
        Individual individual_chef_waiter_2 = new Individual("Garry", "Osborn", "Oscorp@corp.ip", 3030.0,"+4839929024",
                Duty.DISHWASH, 3, EmployeeType.CHEF_WAITER);

        ((ChefWaiter) individual_chef_waiter_2.asEmployee()).doDuty();
        ((ChefWaiter) individual_chef_waiter_2.asEmployee()).riseCookMastery();

        System.out.println(individual_chef_waiter_2.asEmployee());

    }
}
