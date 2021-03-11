package com.example.model;

import com.example.model.serializer.EmployeeDeserializer;
import com.example.model.serializer.EmployeeSerializer;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@XmlRootElement
@JsonSerialize(using = EmployeeSerializer.class)
@JsonDeserialize(using = EmployeeDeserializer.class)
public class Employee {
    private String id;
    private String name;
    private LocalDate birthDate;

    public Employee() {
    }

    public Employee(String id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}

