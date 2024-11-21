package com.MagadhUniversity.HRMS_MU.service;

import com.MagadhUniversity.HRMS_MU.model.Attendance;
import com.MagadhUniversity.HRMS_MU.model.Student;
import com.MagadhUniversity.HRMS_MU.repository.AttendanceRepository;
import com.MagadhUniversity.HRMS_MU.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    @Override
    public void updateStudent(Long studentId, String name, String department, String year, String email) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student != null) {
            student.setName(name);
            student.setDepartment(department);
            student.setYear(year);
            student.setEmail(email);
            studentRepository.save(student);
        }
    }

    @Override
    public void deleteStudent(Long studentId) {
        List<Attendance> attendances = attendanceRepository.findByStudentStudentId(studentId); // Corrected method name
        attendanceRepository.deleteAll(attendances);
        studentRepository.deleteById(studentId);
    }

    @Override
    public Page<Student> getStudentsByDepartment(String department, Pageable pageable) {
        return studentRepository.findByDepartment(department, pageable);
    }
}
