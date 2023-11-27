package br.gereaulas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.gereaulas.model.ClassSchedule;
import br.gereaulas.model.ReservedTime;
import br.gereaulas.model.Student;
import br.gereaulas.model.Teacher;
import br.gereaulas.repository.ClassScheduleRepository;

@RestController
@RequestMapping("/classes")
public class ClassController {
    @Autowired
    private ClassScheduleRepository repository;

    // GET para obter todos os agendamentos de aula
    @GetMapping
    public ResponseEntity<Iterable<ClassSchedule>> getAllClassSchedules() {
        Iterable<ClassSchedule> classSchedules = repository.findAll();
        return ResponseEntity.ok(classSchedules);
    }

    // POST para criar um agendamento de aula
    @PostMapping
    public ResponseEntity<ClassSchedule> createClassSchedule(@RequestBody ClassSchedule newClassSchedule) {
        // TODO: Adicionar lógica para validar e processar o novo agendamento
    	System.out.println(newClassSchedule.toString());
        ClassSchedule savedClassSchedule = repository.save(newClassSchedule);
        return new ResponseEntity<>(savedClassSchedule, HttpStatus.CREATED);
    }

    // GET para obter um agendamento de aula pelo ID
    @GetMapping("/{classScheduleId}")
    public ResponseEntity<ClassSchedule> getClassScheduleById(@PathVariable Long classScheduleId) {
        ClassSchedule classSchedule = repository.findById(classScheduleId).orElse(null);

        // Verifica se o agendamento de aula com o ID fornecido existe
        if (classSchedule != null) {
            return ResponseEntity.ok(classSchedule);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // GET para obter um agendamento de aula pelo ID do professor
    @GetMapping("/teacher/{teacherId}")
    public ResponseEntity<Iterable<ClassSchedule>> getClassSchedulesByTeacherId(@PathVariable Long teacherId) {
        // TODO: Adicionar lógica para buscar agendamentos de aula por ID do professor
        Iterable<ClassSchedule> classSchedules = repository.findByTeacherId(teacherId);

        return ResponseEntity.ok(classSchedules);
    }

}
