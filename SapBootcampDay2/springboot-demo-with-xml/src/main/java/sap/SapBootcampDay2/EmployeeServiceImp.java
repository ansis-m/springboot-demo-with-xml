package sap.SapBootcampDay2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImp implements EmployeeService{


    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void updateEmployee(int id, Employee newEmployee) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if(employee == null)
            return;

        employee.setDateOfJoining(newEmployee.getDateOfJoining());
        employee.setName(newEmployee.getName());
        employeeRepository.save(employee);

    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }
}
