package sap.SapBootcampDay2;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter

@Entity
@Table(name = "employee")
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int employeeId;

    @Column
    private String name;

    @Column
    private String role;

    @Column
    @Value("${date}")
    private int dateOfJoining;

    public Employee(String name) {
        this.name = name;
        //this.dateOfJoining = LocalDateTime.now().getDayOfMonth();
    }

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
        //this.dateOfJoining = LocalDateTime.now().getDayOfMonth();
    }

    public Employee() {
        //this.dateOfJoining = LocalDateTime.now().getDayOfMonth();
    }
}
