package br.gereaulas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.gereaulas.model.ClassSchedule;
import br.gereaulas.model.ReservedTime;
import br.gereaulas.repository.ReservedTimeRepository;

import java.util.List;

@RestController
@RequestMapping("/times")
public class ReservedTimeController {

    @Autowired
    private ReservedTimeRepository reservedTimeRepository;

    @GetMapping
    public ResponseEntity<List<ReservedTime>> getAllReservedTimes() {
        List<ReservedTime> reservedTimes = reservedTimeRepository.findAll();
        return ResponseEntity.ok(reservedTimes);
    }

    @PostMapping
    public ResponseEntity<ReservedTime> createReservedTime(@RequestBody ReservedTime newReservedTime) {

        ReservedTime savedReservedTime = reservedTimeRepository.save(newReservedTime);
        return new ResponseEntity<>(savedReservedTime, HttpStatus.CREATED);
    }

    @GetMapping("/{reservedTimeId}")
    public ResponseEntity<ReservedTime> getReservedTimeById(@PathVariable Long reservedTimeId) {
        ReservedTime reservedTime = reservedTimeRepository.findById(reservedTimeId).orElse(null);

        if (reservedTime != null) {
            return ResponseEntity.ok(reservedTime);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/teacher/{tId}")
    public ResponseEntity<Iterable<ReservedTime>> getByTeacherId(@PathVariable Long tId) {
    	Iterable<ReservedTime> reservedTimes = reservedTimeRepository.findByTeacherId(tId);
        
            return ResponseEntity.ok(reservedTimes);

    }
    
    @DeleteMapping("/{reservedTimeId}")
    public ResponseEntity<Boolean> delete(@PathVariable Long reservedTimeId) {
        reservedTimeRepository.deleteById(reservedTimeId);

        if (reservedTimeRepository.findById(reservedTimeId) == null) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
