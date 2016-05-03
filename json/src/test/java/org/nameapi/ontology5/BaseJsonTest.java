package org.nameapi.ontology5;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import org.jetbrains.annotations.NotNull;

/**
 *
 */
public class BaseJsonTest {

    @NotNull
    protected ObjectMapper mapper() {
        ObjectMapper mapper = new ObjectMapper();

        //special settings for the tests
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true); //enabled for tests to instantly see when something is new or mistypes

        //here come all the standard settings
        mapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
        mapper.enable(SerializationFeature.INDENT_OUTPUT); //that's easier to debug
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        //for Guava Optional:
        GuavaModule module = new GuavaModule();
        mapper.registerModule(module);

        return mapper;
    }

}