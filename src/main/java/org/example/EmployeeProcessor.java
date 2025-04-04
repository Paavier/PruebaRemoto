package org.example;

import java.util.List;

public class EmployeeProcessor {

    public void calculateSalaries(List<Employee> employees, boolean applyBonus, boolean applyTax, boolean isEndOfYear) {
        for (Employee employee : employees) {

            double newSalary;

            if (employee.isFullTime()) {
                //Ajustes por antiguedad
                if (employee.getYearsWorked() > 5) {
                    newSalary = employee.getCurrentSalary() + employee.getCurrentSalary() * 0.1;
                    employee.setCurrentSalary(newSalary);
                } else if (employee.getYearsWorked() > 2) {
                    newSalary = employee.getCurrentSalary() + employee.getCurrentSalary() * 0.05;
                    employee.setCurrentSalary(newSalary);
                }

                //Ajustes por bonus de departamento
                if (applyBonus) {
                    if (employee.getDepartment().equals("IT")) {
                        if (isEndOfYear) {
                            newSalary = employee.getCurrentSalary() + 1000;
                            employee.setCurrentSalary(newSalary);
                        } else {
                            newSalary = employee.getCurrentSalary() + 500;
                            employee.setCurrentSalary(newSalary);
                        }
                    } else if (employee.getDepartment().equals("HR")) {
                        newSalary = employee.getCurrentSalary() + 300;
                        employee.setCurrentSalary(newSalary);
                    }
                }

                //Ajustes por impuestos
                if (applyTax) {
                    if (employee.getCurrentSalary() > 50000) {
                        newSalary = employee.getCurrentSalary() - employee.getCurrentSalary() * 0.3;
                        employee.setCurrentSalary(newSalary);
                    } else if (employee.getCurrentSalary() > 30000) {
                        newSalary = employee.getCurrentSalary() - employee.getCurrentSalary() * 0.2;
                        employee.setCurrentSalary(newSalary);
                    } else {
                        newSalary = employee.getCurrentSalary() - employee.getCurrentSalary() * 0.1;
                        employee.setCurrentSalary(newSalary);
                    }
                }
            } else {
                if (applyBonus && isEndOfYear) {
                    newSalary = employee.getCurrentSalary() + 200;
                    employee.setCurrentSalary(newSalary);
                }
            }
        }
    }
}
