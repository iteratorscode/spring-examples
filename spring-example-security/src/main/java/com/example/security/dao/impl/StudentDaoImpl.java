package com.example.security.dao.impl;

import com.example.security.dao.StudentDao;
import com.example.security.entity.Student;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author iterators
 * @date 2021.04.18
 */
@Repository
public class StudentDaoImpl implements StudentDao {

    private final ConcurrentHashMap<String, Student> students = new ConcurrentHashMap<>();

    {
        Student student = new Student();
        student.setUserName("iterators");
        student.setPassword("123");
        students.put(student.getUserName(), student);
    }

    @Override
    public Student loadEntityByUsername(String userName) {
        return students.get(userName);
    }
}
