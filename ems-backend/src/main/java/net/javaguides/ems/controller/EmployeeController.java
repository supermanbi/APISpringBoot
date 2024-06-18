package net.javaguides.ems.controller;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")

public class EmployeeController {
    private EmployeeService employeeService;

    //Build Add Employee REST API
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee (@RequestBody EmployeeDto employeeDto) {
        EmployeeDto saveEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
    }

    //Build Get Employee REST API
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto>getEmployeeById(@PathVariable("id") Long employeeID) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeID);

        return ResponseEntity.ok(employeeDto);
    }

    //Build Get All Employee Rest API
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> employee = employeeService.getAllEmployees();
        return ResponseEntity.ok(employee);
    }

    //Build Update Employee REST API
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee (@PathVariable("id") Long employeeId,@RequestBody EmployeeDto updateEmployee) {
        EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, updateEmployee);
        return ResponseEntity.ok(employeeDto);
    }

    // Build Delete Employee REST API
    @DeleteMapping("/employees/{id}") // Sửa lại đường dẫn của @DeleteMapping
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted successfully");
    }
}
