package sap.SapBootcampDay2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

    @Autowired
    EmployeeService employeeService;

//    @Autowired
//    LocalDate currentDate;


    @GetMapping("")
    public ResponseEntity viewEmployees() {


        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        LocalDate local = context.getBean("currentDate", java.time.LocalDate.class);

        System.out.println("bean:   " + local);
        return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public void addEmployee(@RequestBody Employee employee) {

        System.out.println("adding new employee!");
        System.out.println("name: " + employee.getName());
        System.out.println("date: " + employee.getDateOfJoining());

        employeeService.addEmployee(employee);

    }

    @DeleteMapping("/delete/{employeeId}")
    public void deleteEmployee(@PathVariable String employeeId) {

        int id = -1;
        try{
            id = Integer.valueOf(employeeId);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        if(id >= 0)
            employeeService.deleteEmployee(id);

    }

    @PostMapping("/edit/{employeeId}")
    public void editEmployee(@PathVariable String employeeId, @RequestBody Employee updatedEmployee) {


        try{
            System.out.println("updating employee: " + updatedEmployee.getName());
            employeeService.updateEmployee(Integer.valueOf(employeeId), updatedEmployee);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
