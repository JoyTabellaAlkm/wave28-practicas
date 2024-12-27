package com.meli.obtenerdiploma.integrationTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    StudentDTO newStudent = new StudentDTO(
            3L,
            "Bob",
            null,
            null,
            List.of(new SubjectDTO(
                            "Matemática",
                            2.0
                    ), new SubjectDTO(
                            "Física",
                            1.0
                    ), new SubjectDTO(
                            "Química",
                            1.5
                    )
            )
    );

    StudentDTO existingStudent = new StudentDTO(
            1L,
            "Juan",
            null,
            null,
            List.of(new SubjectDTO(
                            "Matemática",
                            9.0
                    ), new SubjectDTO(
                            "Física",
                            7.0
                    ), new SubjectDTO(
                            "Química",
                            6.0
                    )
            )
    );

    // ###########
    // ## TESTS ##
    // ###########

    // -- registerStudent --

    @Test
    @DisplayName("1.1: RegisterStudent OK")
    public void registerStudentOK() throws Exception{

        //ARRANGE
        StudentDTO toRegister = newStudent;
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(toRegister);

        String expectedMessage = "Creado con exito";
        //ACT



        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
        //ASSERT
                .andDo(print()).andExpect(status().isCreated())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string(expectedMessage)); //Esto asume que el response sea solo un string
    }

    @Test
    @DisplayName("1.2: RegisterStudent BadRequest (StudentName null)")
    public void registerStudentBadRequestStudentNameNull() throws Exception{

        //ARRANGE
        StudentDTO toRegister = newStudent;
        toRegister.setStudentName("");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(toRegister);

        //ACT
        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
        //ASSERT
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.description").value("El nombre del estudiante no puede estar vacío."));
        }

    @Test
    @DisplayName("1.3: RegisterStudent BadRequest (StudentName starts in lowercase)")
    public void registerStudentBadRequestStudentNameLowercase() throws Exception{

        //ARRANGE
        StudentDTO toRegister = newStudent;
        toRegister.setStudentName("bob");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(toRegister);

        //ACT
        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
        //ASSERT
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.description").value("El nombre del estudiante debe comenzar con mayúscula."));
        }

    @Test
    @DisplayName("1.4: RegisterStudent BadRequest (StudentName 50+ Chars)")
    public void registerStudentBadRequestStudentName50PlusChars() throws Exception{

        //ARRANGE
        StudentDTO toRegister = newStudent;
        toRegister.setStudentName("Bobbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(toRegister);

        //ACT
        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
        //ASSERT
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.description").value("La longitud del nombre del estudiante no puede superar los 50 caracteres."));
        }

    // -- getStudent --

    @Test
    @DisplayName("2.1: getStudentById OK")
    public void getStudentIdOK() throws Exception{
        // ARRANGE
        Long toFind = 1L;
        String toReceive = "Juan";
        // ACT
        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", toFind))

        // ASSERT
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers
                        .content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.studentName").value(toReceive));
    }

    @Test
    @DisplayName("2.2: getStudentById NotFound")
    public void getStudentIdNotFound() throws Exception{
        // ARRANGE
        Long toFind = 1000L;
        String toReceive = "StudentNotFoundException";
        // ACT
        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", toFind))

        // ASSERT
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers
                        .content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value(toReceive));
    }

    // -- modifyStudent --

    @Test
    @DisplayName("3.1: ModifyStudent OK")
    public void modifyStudentOK() throws Exception{

        //ARRANGE
        StudentDTO toUpdate = existingStudent;
        toUpdate.setStudentName("Dr Ivo Kintobor");
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(toUpdate);

        //ACT
        mockMvc.perform(MockMvcRequestBuilders.put("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
        //ASSERT
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    @DisplayName("3.2: ModifyStudent BadRequest (StudentName empty)")
    public void modifyStudentBadRequestStudentNameEmpty() throws Exception{

        //ARRANGE
        StudentDTO toUpdate = existingStudent;
        toUpdate.setStudentName("");
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(toUpdate);

        //ACT
        mockMvc.perform(MockMvcRequestBuilders.put("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
        //ASSERT
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.description").value("El nombre del estudiante no puede estar vacío."));
    }

    @Test
    @DisplayName("3.3: RegisterStudent BadRequest (StudentName starts in lowercase)")
    public void modifyStudentBadRequestStudentNameLowercase() throws Exception{

        //ARRANGE
        StudentDTO toRegister = existingStudent;
        toRegister.setStudentName("bob");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(toRegister);

        //ACT
        mockMvc.perform(MockMvcRequestBuilders.put("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                //ASSERT
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.description").value("El nombre del estudiante debe comenzar con mayúscula."));
    }

    @Test
    @DisplayName("3.4: RegisterStudent BadRequest (StudentName 50+ Chars)")
    public void modifyStudentBadRequestStudentName50PlusChars() throws Exception{

        //ARRANGE
        StudentDTO toRegister = existingStudent;
        toRegister.setStudentName("Bobbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(toRegister);

        //ACT
        mockMvc.perform(MockMvcRequestBuilders.put("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                //ASSERT
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.description").value("La longitud del nombre del estudiante no puede superar los 50 caracteres."));
    }

    // -- deleteStudent --

    @Test
    @DisplayName("4.1: getStudentById OK")
    public void deleteStudentIdOK() throws Exception{
        // ARRANGE
        Long toDelete = 1L;
        String toReceive = "Juan";
        // ACT
        mockMvc.perform(MockMvcRequestBuilders.delete("/student/removeStudent/{id}", toDelete))

                // ASSERT
                .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("4.2: getStudentById NotFound")
    public void deleteStudentIdNotFound() throws Exception{
        // ARRANGE
        Long toDelete = 10011110L;
        String toReceive = "StudentNotFoundException";
        // ACT
        mockMvc.perform(MockMvcRequestBuilders.delete("/student/removeStudent/{id}", toDelete))

                // ASSERT
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers
                        .content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value(toReceive));
    }

    @Test
    @DisplayName("5.1: listStudents OK")
    public void listStudents() throws Exception{
        // ARRANGE
        int toReceive = 2;
        // ACT
        mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))

                // ASSERT
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers
                        .content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(toReceive));
    }



}
