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
                    employee.ajustePorDepartamento(isEndOfYear);
                }

                //Ajustes por impuestos
                if (applyTax) {
                    employee.ajustePorImpuestos();
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
