package com.magic.filesio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {

    public enum IOService {CONSOLE_IO, FILE_IO, DB_IO, REST_IO}

    private List<EmployeeData> employeeDataList;

    public EmployeePayrollService(List<EmployeeData> employeeDataList) {
        this.employeeDataList = employeeDataList;
    }

    public static void main(String[] args) {
        ArrayList<EmployeeData> employeeDataList = new ArrayList<>();
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeeDataList);
        Scanner consoleInputReader = new Scanner(System.in);
        employeePayrollService.readEmployeeData(consoleInputReader);
        employeePayrollService.writeEmployeeData(IOService.CONSOLE_IO);
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

    public void writeEmployeeData(IOService ioService) {
        if (ioService.equals(IOService.CONSOLE_IO))
            System.out.println(employeeDataList);
        else if (ioService.equals(IOService.FILE_IO))
            new EmployeePayrollFilesIOService().writeData(employeeDataList);
    }

    public void printData(IOService ioService) {
        if (ioService.equals(IOService.FILE_IO))
            new EmployeePayrollFilesIOService().printData();
    }

    public long countEntries(IOService ioService) {
        if (ioService.equals(IOService.FILE_IO))
            return new EmployeePayrollFilesIOService().countEntries();
        return 0;
    }

}
