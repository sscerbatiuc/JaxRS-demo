package com.example.model.serializer;

import com.example.model.Employee;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import java.io.IOException;

public class EmployeeSerializer extends JsonSerializer<Employee> {

    public EmployeeSerializer() {
        super();
    }

    @Override
    public void serialize(Employee value, JsonGenerator json, SerializerProvider provider) throws IOException {
        json.writeStartObject();
        json.writeStringField("id", value.getId());
        json.writeStringField("itemName", value.getName());
        json.writeStringField("birthDate", value.getBirthDate().toString());
        json.writeEndObject();
    }
}
