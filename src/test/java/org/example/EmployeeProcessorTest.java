package org.example;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class EmployeeProcessorTest {

    @Test
    public void testCalculateSalaries_FullTime_IT_WithBonusAndTax() {
        EmployeeProcessor processor = new EmployeeProcessor();
        List<Object[]> employees = new ArrayList<>();

        // [id, name, baseSalary, years, department, isFullTime]
        employees.add(new Object[]{"001", "John Doe", 60000.0, 6, "IT", true});

        Object[] result = processor.calculateSalaries(employees, true, true, false);
        Object[] processedEmp = (Object[]) result[0];

        // 60000 + 10% (6000) = 66000
        // + 500 bonus (IT, not end of year) = 66500
        // - 30% tax (19950) = 46550
        assertEquals(46550.0, (double) processedEmp[2], 0.001);
    }

    @Test
    public void testCalculateSalaries_PartTime_EndOfYear() {
        EmployeeProcessor processor = new EmployeeProcessor();
        List<Object[]> employees = new ArrayList<>();

        employees.add(new Object[]{"002", "Jane Smith", 30000.0, 1, "HR", false});

        Object[] result = processor.calculateSalaries(employees, true, false, true);
        Object[] processedEmp = (Object[]) result[0];

        // 30000 + 200 bonus (part-time, end of year) = 30200
        assertEquals(30200.0, (double) processedEmp[2], 0.001);
    }

    @Test
    public void testCalculateSalaries_MultipleEmployees() {
        EmployeeProcessor processor = new EmployeeProcessor();
        List<Object[]> employees = new ArrayList<>();

        employees.add(new Object[]{"003", "Mike Johnson", 40000.0, 3, "IT", true});
        employees.add(new Object[]{"004", "Sarah Williams", 25000.0, 1, "HR", true});

        Object[] result = processor.calculateSalaries(employees, false, true, false);

        Object[] emp1 = (Object[]) result[0];
        // 40000 + 5% (2000) = 42000
        // - 20% tax (8400) = 33600
        assertEquals(33600.0, (double) emp1[2], 0.001);

        Object[] emp2 = (Object[]) result[1];
        // 25000 (no bonus, years < 2)
        // - 10% tax (2500) = 22500
        assertEquals(22500.0, (double) emp2[2], 0.001);
    }
}