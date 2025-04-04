package org.example;

import java.util.List;

public class EmployeeProcessor {

    public Object[] calculateSalaries(List<Employee> employees, boolean applyBonus, boolean applyTax, boolean isEndOfYear) {
        for (Employee employee : employees) {

            double newSalary;

            if (employee.isFullTime()) {
                //Ajustes por antiguedad
                if (employee.getYearsWorked() > 5) {
                    newSalary = employee.getCurrentSalary() * 0.1;
                    employee.setCurrentSalary(newSalary);
                } else if (employee.getYearsWorked() > 2) {
                    newSalary = employee.getCurrentSalary() * 0.05;
                    employee.setCurrentSalary(newSalary);
                }

                //Ajustes por bonus de departamento
                if (applyBonus) {
                    if (department.equals("IT")) {
                        if (isEndOfYear) {
                            salary += 1000;
                        } else {
                            salary += 500;
                        }
                    } else if (department.equals("HR")) {
                        salary += 300;
                    }
                }

                //Ajustes por impuestos
                if (applyTax) {
                    if (salary > 50000) {
                        salary -= salary * 0.3;
                    } else if (salary > 30000) {
                        salary -= salary * 0.2;
                    } else {
                        salary -= salary * 0.1;
                    }
                }
            } else {
                if (applyBonus && isEndOfYear) {
                    salary += 200;
                }
            }

            Object[] processedEmp = new Object[3];
            processedEmp[0] = id;
            processedEmp[1] = name;
            processedEmp[2] = salary;

            result[i] = processedEmp;
        }

        return result;
    }
}
