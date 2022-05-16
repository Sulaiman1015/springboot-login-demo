package com.springboot.logindemo.controller;

import com.springboot.logindemo.entity.Empl;
import com.springboot.logindemo.repository.EmplRepository;
import com.springboot.logindemo.service.EmplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
@RestController
@RequestMapping
public class EmplController {

    @Autowired
    private EmplService emplService;

    @Autowired
    private EmplRepository emplRepository;

    //get all emp list
    @GetMapping("/empls")
    public ResponseEntity<List<Empl>> getEmps() {
        return ResponseEntity.ok().body(emplService.getList());
        //return new ResponseEntity<List<Empl>>(emplService.getList(), HttpStatus.FOUND);
    }

    //add/create new employee
    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<Empl> addEmp(@RequestBody Empl empl){
        //solution 1 ok
        //URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/add").toUriString());
        //return ResponseEntity.created(uri).body(emplService.saveEmp(empl));

        //solution 2 ok
        //Empl empSaved = emplService.saveEmp(empl);
        //return new ResponseEntity<>(empSaved, HttpStatus.CREATED);

        //solution 3 ok
        emplRepository.save(empl);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    //update emp's info
    @PutMapping("/update/{id}")
    @ResponseBody
    public ResponseEntity<String> updateEmp(@PathVariable("id") Integer id, @RequestBody Empl empl) {
        //solution 1 not work
        /*try {
            emplService.updateEmp(empl);
            return new ResponseEntity<String>(HttpStatus.OK);
        }catch(NoSuchElementException ex){
            // log the error message
            System.out.println(ex.getMessage());
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }*/
        //solution 2
        empl.setId(id);
        Empl emp = emplService.updateEmp(empl);
        if (emp == null){
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
            //return ResponseEntity.ok().body(new String("Not Found"));
        }
        return new ResponseEntity<String>(HttpStatus.OK);
        //return ResponseEntity.ok().body(emp);
    }




    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmp(@PathVariable Integer id){
        try{
            emplService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.GONE);
        }catch(NoSuchElementException ex){
            // log the error message
            System.out.println(ex.getMessage());
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
    }

}
