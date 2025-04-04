package org.example;

public class Employee {

     private final String id;
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

     public String getId() {
          return id;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public double getBaseSalary() {
          return baseSalary;
     }

     public int getYearsWorked() {
          return yearsWorked;
     }

     public void setYearsWorked(int yearsWorked) {
          if (yearsWorked < 0)
               throw new IllegalArgumentException("El tiempo trabajado no puede ser negativo");
          this.yearsWorked = yearsWorked;
     }

     public String getDepartment() {
          return department;
     }

     public void setDepartment(String department) {
          this.department = department;
     }

     public boolean isFullTime() {
          return isFullTime;
     }

     public void setFullTime(boolean fullTime) {
          isFullTime = fullTime;
     }

     public double getCurrentSalary() {
          return currentSalary;
     }

     public void setCurrentSalary(double currentSalary) {
          if (currentSalary < 0)
               throw new IllegalArgumentException("El salario no puede ser negativo");
          this.currentSalary = currentSalary;
     }

     public void ajustePorAntiguedad(){
          double newSalary = this.getCurrentSalary();

          if (this.getYearsWorked() > 5) {
               newSalary += this.getCurrentSalary() * 0.1;
          } else if (this.getYearsWorked() > 2) {
               newSalary += this.getCurrentSalary() * 0.05;
          }

          this.setCurrentSalary(newSalary);
     }

     public void ajustePorDepartamento(boolean isEndOfYear){
          double newSalary = this.getCurrentSalary();

          if (this.getDepartment().equals("IT")) {
               if (isEndOfYear) {
                    newSalary += 1000;
               } else {
                    newSalary += 500;
               }
          } else if (this.getDepartment().equals("HR")) {
               newSalary += 300;
          }

          this.setCurrentSalary(newSalary);
     }
}
