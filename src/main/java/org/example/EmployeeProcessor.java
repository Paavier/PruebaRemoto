package org.example;

import java.util.EnumMap;
import java.util.List;

public class EmployeeProcessor extends Employee {

    public Object[] calculateSalaries(List<Object[]> employees, boolean applyBonus, boolean applyTax, boolean isEndOfYear) {
        Object[] result = new Object[employees.size()];

        for (int i = 0; i < employees.size(); i++) {
            Object[] emp = employees.get(i);
            String id = (String) emp[0];
            String name = (String) emp[1];
            double baseSalary = (double) emp[2];
            int years = (int) emp[3];
            String department = (String) emp[4];
            boolean isFullTime = (boolean) emp[5];

            double salary = baseSalary;

            if (isFullTime) {
                if (years > 5) {
                    salary += salary * 0.1;
                } else if (years > 2) {
                    salary += salary * 0.05;
                }

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
