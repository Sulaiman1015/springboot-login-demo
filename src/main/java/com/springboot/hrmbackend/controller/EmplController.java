package com.springboot.hrmbackend.controller;

import com.springboot.hrmbackend.model.Employee;
import com.springboot.hrmbackend.repository.EmplRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@CrossOrigin(origins = "http://localhost:8081/")
@RestController
@RequestMapping("/api")
public class EmplController {
  @Autowired
  private EmplRepository emplRepository;

  //get all emp list
  @GetMapping("/emplist")
  public List<Employee> getEmps(){
    return new ArrayList<>(emplRepository.findAll());
  }

  //delete emp by id
  @DeleteMapping("/delete/{id}")
  public String deleteEmp(@PathVariable Long id){
    emplRepository.deleteById(id);
    return "Deleted successful";
  }

  //post new emp
  @PostMapping("/create")
  public void addEmp(@RequestBody Employee emp){
    emplRepository.save(emp);
  }

  @PutMapping("/update/{id}")
  public Employee updateEmp(@PathVariable Long id, @RequestBody Employee employee){
    Employee emp = emplRepository.findById(id).get();

    emp.setName(employee.getName());
    emp.setSex(employee.getSex());
    emp.setAge(employee.getAge());
    emp.setEmail(employee.getEmail());
    emp.setPhone(employee.getPhone());
    emp.setAddress(employee.getAddress());
    emp.setJoin_date(employee.getJoin_date());

    return emplRepository.save(emp);

  }





/*
  //get all emp list
  @GetMapping("/emplist")
  public List<Employee> getEmps(){
    return employeeService.getList();
  }

  //post new emp
  @PostMapping("/add")
  public void addEmp(@RequestBody Employee emp){
    employeeService.addEmp(emp);
  }

  //delete emp by name
  @DeleteMapping("/delete")
  public ResponseEntity<String> deleteEmp(@RequestParam String name){
    employeeService.deleteEmpByName(name);
    return new ResponseEntity<>("emp is deleted successful", HttpStatus.OK);
  }

  //delete one emp by id
  @DeleteMapping("/delete")
  public ResponseEntity<String> deleteEmp(@RequestParam Long id){
    employeeService.deleteEmpById(id);
    return new ResponseEntity<>("emp is deleted successful", HttpStatus.OK);
  }*/

  /*@PutMapping("/update/{id}")
  public ResponseEntity<String> updateEmp(
          @PathVariable Long id,
          @RequestBody EmpList emp){
    empListService.updateEmp(id);
    return new ResponseEntity<>("emp is deleted successful", HttpStatus.OK);
  }

  @PutMapping("/update/{name}")
  public ResponseEntity<String> updateEmp(
          @PathVariable String name,
          @RequestBody EmpList emp){
    empListService.updateEmp(name);
    return new ResponseEntity<>("emp is deleted successful", HttpStatus.OK);
  }*/


  /*@PutMapping("/emplist/{id}")
  public ResponseEntity<EmpList> updateInfo(
    @PathVariable Integer id,
    @RequestBody EmpList empInfo)
  {
    EmpList emp = empListRepository.findById(id)
      .orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id: "+id));
    emp.setName(empInfo.getName());
    emp.setSex(empInfo.getSex());
    emp.setAge(empInfo.getAge());
    emp.setEmail(empInfo.getEmail());
    emp.setPhone(empInfo.getPhone());
    emp.setAddress(empInfo.getAddress());
    emp.setSalary(empInfo.getSalary());
    emp.setEntry_date(empInfo.getEntry_date());

    final EmpList updatedEmp = empListRepository.save(emp);
    return ResponseEntity.ok(updatedEmp);
  }

  //delete one emp by id
  @DeleteMapping("/emplist/{id}")
  public ResponseEntity<String> deleteEmp(@PathVariable("id") Integer id){
    empListRepository.deleteById(id);
    return new ResponseEntity<>("emp is deleted", HttpStatus.OK);
  }*/
}
