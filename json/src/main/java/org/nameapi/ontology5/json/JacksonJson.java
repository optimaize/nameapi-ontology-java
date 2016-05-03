package org.nameapi.ontology5.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class JacksonJson {

    private final ObjectMapper mapper;

    public JacksonJson() {
        this(mapper());
    }
    public JacksonJson(ObjectMapper mapper) {
        this.mapper = mapper;
    }


    @NotNull
    private static ObjectMapper mapper() {
        ObjectMapper mapper = new ObjectMapper();

        mapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
        mapper.enable(SerializationFeature.INDENT_OUTPUT); //that's easier to debug
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        //for Guava Optional:
        GuavaModule module = new GuavaModule();
        mapper.registerModule(module);

        return mapper;
    }

    public ObjectMapper getMapper() {
        return mapper;
    }

    /**
     * Serialize the given Java object into JSON string.
     */
    public String serialize(Object obj) throws JsonProcessingException {
        if (obj != null)
            return mapper.writeValueAsString(obj);
        else
            return null;
    }

    /**
     * Deserialize the given JSON string to Java object.
     *
     * @param body       The JSON string
     * @param returnType The type to deserialize inot
     * @return The deserialized Java object
     */
    public <T> T deserialize(String body, TypeRef returnType) throws IOException {
        JavaType javaType = mapper.constructType(returnType.getType());
        try {
            return mapper.readValue(body, javaType);
        } catch (IOException e) {
            if (returnType.getType().equals(String.class))
                return (T) body;
            else
                throw e;
        }
    }
}
