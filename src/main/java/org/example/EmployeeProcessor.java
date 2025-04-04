package org.example;

import java.util.List;

public class EmployeeProcessor {

    public void calculateSalaries(List<Employee> employees, boolean applyBonus, boolean applyTax, boolean isEndOfYear) {
        for (Employee employee : employees) {

            double newSalary;

            if (employee.isFullTime()) {
                //Ajustes por antiguedad
                ajustePorAntiguedad(employee);

                //Ajustes por bonus de departamento
                if (applyBonus) {
                    ajustePorDepartamento(employee, isEndOfYear);
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

    private void ajustePorAntiguedad(Employee employee){
        double newSalary = employee.getCurrentSalary();

        if (employee.getYearsWorked() > 5) {
            newSalary += employee.getCurrentSalary() * 0.1;
        } else if (employee.getYearsWorked() > 2) {
            newSalary += employee.getCurrentSalary() * 0.05;
        }

        employee.setCurrentSalary(newSalary);
    }

    private void ajustePorDepartamento(Employee employee, boolean isEndOfYear){
        double newSalary = employee.getCurrentSalary();

        if (employee.getDepartment().equals("IT")) {
            if (isEndOfYear) {
                newSalary += 1000;
            } else {
                newSalary += 500;
            }
        } else if (employee.getDepartment().equals("HR")) {
            newSalary += 300;
        }

        employee.setCurrentSalary(newSalary);
    }
}
