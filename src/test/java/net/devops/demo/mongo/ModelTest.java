package net.devops.demo.mongo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Slf4j
public class ModelTest {

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testSerialize() throws Exception {
        objectMapper.registerModule(new JSR310Module());
        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();

        Model model = Model.builder()
                .firstName("aaaa")
                .secondName("bbb")
                .lastName("ccccc")
                .socialNumber(11111L)
                .created(LocalDateTime.now(ZoneOffset.UTC))
                .modified(LocalDateTime.now(ZoneOffset.UTC))
                .build();

        String modelAsString = objectWriter.writeValueAsString(model);
        Assert.assertNotNull(modelAsString);
        log.info(modelAsString);

        Model modelAsObject = objectMapper.readValue(modelAsString, Model.class);

        Assert.assertNotNull(modelAsObject);
        Assert.assertEquals(model, modelAsObject);
    }
}