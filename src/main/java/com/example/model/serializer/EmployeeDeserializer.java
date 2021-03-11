package com.example.model.serializer;

import com.example.model.Employee;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDate;

public class EmployeeDeserializer extends JsonDeserializer<Employee> {
    @Override
    public Employee deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {

        ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);
        final String name = node.get("name").getValueAsText();
        final String id = node.get("id").getValueAsText();
        final LocalDate birthDate = LocalDate.parse(node.get("birthdate").getValueAsText());
        return new Employee(id, name, birthDate);
    }
}
