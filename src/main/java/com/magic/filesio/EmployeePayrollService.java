package com.magic.filesio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {

    private List<EmployeeData> employeeDataList;

    public EmployeePayrollService(List<EmployeeData> employeeDataList) {
        this.employeeDataList = employeeDataList;
    }

    public static void main(String[] args) {
        ArrayList<EmployeeData> employeeDataList = new ArrayList<>();
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeeDataList);
        Scanner consoleInputReader = new Scanner(System.in);
        employeePayrollService.readEmployeeData(consoleInputReader);
        employeePayrollService.writeEmployeeData();
    }

    public void readEmployeeData(Scanner consoleInputReader) {
        System.out.println("Enter Employee Id");
        int id = consoleInputReader.nextInt();
        System.out.println("Enter Employee Name");
        String name = consoleInputReader.next();
        System.out.println("Enter Employee Salary");
        double salary = consoleInputReader.nextDouble();
        employeeDataList.add(new EmployeeData(id, name, salary));
    }

    public void writeEmployeeData() {
        System.out.println(employeeDataList);
    }

}
