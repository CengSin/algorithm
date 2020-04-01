package com.company.simple;

import java.util.*;

/**
 * @description: 员工的重要性
 * @author: 15262
 * @date: 2020/4/1
 */

class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;

    public Employee(int id, int importance, List<Integer> subordinates) {
        this.id = id;
        this.importance = importance;
        this.subordinates = subordinates;
    }
}

class LeetCode_690_Solution {
    public int getImportance(List<Employee> employees, int id) {
        for (Employee employee : employees) {
            if (employee.id == id) {
                if (employee.subordinates == null || employee.subordinates.size() == 0) return employee.importance;
                else {
                    for (Integer id1 : employee.subordinates) {
                        employee.importance += getImportance(employees, id1);
                    }
                }
                return employee.importance;
            }
        }
        return 0;
    }
}

public class LeetCode_690_EmployeeImportance {

    public static void main(String[] args) {
        LeetCode_690_Solution solution = new LeetCode_690_Solution();
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, 5, Arrays.asList(2, 3)));
        employees.add(new Employee(2, 3, null));
        employees.add(new Employee(3, 3, null));
        System.out.println(solution.getImportance(employees, 1));
    }

}
