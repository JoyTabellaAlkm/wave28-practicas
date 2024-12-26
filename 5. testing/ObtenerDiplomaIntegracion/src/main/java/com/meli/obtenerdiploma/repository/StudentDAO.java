package com.meli.obtenerdiploma.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

@Repository
public class StudentDAO implements IStudentDAO {

    private Set<StudentDTO> students;


    public StudentDAO() {
        this.loadData();
    }

    @Override
    public void save(StudentDTO stu) {

        students.add(stu);

        this.saveData();
    }

    @Override
    public boolean delete(Long id) {
        boolean ret = false;

        StudentDTO found = this.findById(id);
        if(found != null) {
            students.remove(found);
            ret = true;
            this.saveData();
        }
        else{
        throw new StudentNotFoundException(id) ;
        }

        return ret;
    }

    public void deleteAll(){
        this.students.clear();
    }

    public boolean exists(StudentDTO stu) {
       boolean ret = false;

       try {
           ret  = this.findById(stu.getId()) != null;
       }
       catch (StudentNotFoundException e) {}

       return ret;
    }

    @Override
    public StudentDTO findById(Long id) {
        loadData();
        return students.stream()
                .filter(stu -> stu.getId().equals(id))
                .findFirst().orElseThrow(() -> new StudentNotFoundException(id));
    }

    private void loadData() {
        Set<StudentDTO> loadedData = new HashSet<>();

        ObjectMapper objectMapper = new ObjectMapper();
        File file;
        try {
            file = new ClassPathResource("users.json").getFile();
            loadedData = objectMapper.readValue(file, new TypeReference<Set<StudentDTO>>(){});
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your JSON formatting.");
        }

        this.students = loadedData;
    }

    private void saveData() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new ClassPathResource("users.json").getFile();
            objectMapper.writeValue(file, this.students);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your JSON formatting.");
        }
    }
}
