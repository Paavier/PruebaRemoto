package org.example;

public class Employee {

     private String id;
     private String name;
     private final double baseSalary;
     private int yearsWorked;
     private String department;
     private boolean isFullTime;
     private double currentSalary;

     public Employee (String id, String name, double baseSalary, int yearsWorked, String department, boolean isFullTime){
          this.id = id;
          this.name = name;
          this.baseSalary = baseSalary;
          this.yearsWorked = yearsWorked;
          this.department = department;
          this.isFullTime = isFullTime;
          this.currentSalary = baseSalary;
     }
}
