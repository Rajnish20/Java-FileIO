import com.magic.filesio.EmployeeData;
import com.magic.filesio.EmployeePayrollService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class EmployeePayRollServiceTest {
    @Test
    public void given3EmployeeWhenWrittenToFile_ShouldMatchEmployeesEntry() {
        EmployeeData[] employeeData = {
                new EmployeeData(1, "Daniel", 2000000),
                new EmployeeData(2, "Bella", 120000),
                new EmployeeData(3, "Rose", 90000)
        };
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(Arrays.asList(employeeData));
        employeePayrollService.writeEmployeeData(EmployeePayrollService.IOService.FILE_IO);
        employeePayrollService.printData(EmployeePayrollService.IOService.FILE_IO);
        List<String> lines = employeePayrollService.readEmployee(EmployeePayrollService.IOService.FILE_IO);
        long entries = employeePayrollService.countEntries(EmployeePayrollService.IOService.FILE_IO);
        Assertions.assertEquals(3, entries);
        Assertions.assertEquals(3, lines.size());
    }


}
