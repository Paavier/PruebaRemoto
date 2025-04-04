package org.example;

import java.util.List;

public class EmployeeProcessor {

    public void calculateSalaries(List<Employee> employees, boolean applyBonus, boolean applyTax, boolean isEndOfYear) {
        for (Employee employee : employees) {
            double newSalary;

            if (employee.isFullTime()) {
                //Ajustes por antiguedad
                employee.ajustePorAntiguedad();

                //Ajustes por bonus de departamento
                if (applyBonus) {
                    ajustePorDepartamento(employee, isEndOfYear);
                }

                //Ajustes por impuestos
                if (applyTax) {
                    ajustePorImpuestos(employee);
                }

            } else {
                if (applyBonus && isEndOfYear) {
                    newSalary = employee.getCurrentSalary() + 200;
                    employee.setCurrentSalary(newSalary);
                }
            }
        }
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

    private void ajustePorImpuestos (Employee employee){
        double currentSalary = employee.getCurrentSalary();
        double newSalary = employee.getCurrentSalary();

        if (currentSalary > 50000) {
            newSalary -= currentSalary * 0.3;
        } else if (currentSalary > 30000) {
            newSalary -= currentSalary * 0.2;
        } else {
            newSalary -= currentSalary * 0.1;
        }

        employee.setCurrentSalary(newSalary);
    }
}
