package com.example.sessionfactory.controller;

import com.example.sessionfactory.domain.Panchayat;
import com.example.sessionfactory.service.PanchayatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/panchayat")
public class PanchayatController {

    @Autowired
    private PanchayatService panchayatService;

    @PostMapping("/createTable")
    public ResponseEntity<String> createPanchayatJSONTable()
    {
        panchayatService.createPanchayatTable();
        return new ResponseEntity<>("Panchayat JSON Data table created", HttpStatus.OK);
    }

    @PostMapping("/insertPanchayatInfo")
    public String insertPanchayat(@RequestBody Panchayat panchayat) {
        System.out.println(panchayat+"--------------------------------");
        panchayatService.insertPanchayat(panchayat);
        return "Panchayat inserted successfully!";
    }
    @GetMapping("/allPanchayat")
    public List<Panchayat> getAllPanchayatInfo(){
       return panchayatService.getAllPanchayatDetails();
    }
    @GetMapping("/getSinglePanchayat/{id}")
    public Panchayat getSinglePanchayat(@PathVariable("id") int id)
    {
        Panchayat panchayat=panchayatService.getPanchayatById(id);
        System.out.println(panchayat+"++++++++++++++++++++++++++++++++++++++++++");
        return panchayat;
    }

    // It's not working properly
    @PatchMapping("/updatePanchayatDetails")
    public String updatePanchayat(@RequestBody Panchayat panchayat)
    {
        panchayatService.updatePanchayat(panchayat);
        return "Panchayat updated successfully!";
    }
    @GetMapping("/cerateDeleteRecordTable")
    public ResponseEntity<String> createTableForDeletedRecord(){
        panchayatService.createDeletedRecordTable();
        return new ResponseEntity<>("Daleted Record Table Created",HttpStatus.OK);
    }
    @DeleteMapping("/deletePanchayatById/{id}")
    public ResponseEntity<String> deleteRecord(@PathVariable int id){
        String mass=panchayatService.deletePanchayatById(id);
        return new ResponseEntity<>(mass,HttpStatus.OK);
    }
}
