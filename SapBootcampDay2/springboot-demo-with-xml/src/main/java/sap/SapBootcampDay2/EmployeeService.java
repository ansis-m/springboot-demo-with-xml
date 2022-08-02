package sap.SapBootcampDay2;

import java.util.List;

public interface EmployeeService {

    void addEmployee(Employee employee);
    void deleteEmployee(int id);
    void updateEmployee(int id, Employee employee);
    List<Employee> getEmployees();
}
