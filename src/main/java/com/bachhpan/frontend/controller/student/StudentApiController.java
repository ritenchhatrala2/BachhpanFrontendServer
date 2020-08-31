package com.bachhpan.frontend.controller.student;

import com.bachhpan.frontend.api.StudentApi;
import com.bachhpan.frontend.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentApiController implements StudentApi {

    public static List<Student> students;

    static {
        students = new ArrayList<>();
    }

    @Override
    public ResponseEntity<List<Student>> listStudents(@Valid Integer limit) {
        Student s1 = new Student();
        s1.setId(123L);
        s1.setName("Riten Chhatrala");

        Student s2 = new Student();
        s2.setId(234L);
        s2.setName("Tushar Gupta");

        students.add(s1);
        students.add(s2);

        return ResponseEntity.ok(students);
    }

}
