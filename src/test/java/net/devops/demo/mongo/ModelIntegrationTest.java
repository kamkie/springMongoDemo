package net.devops.demo.mongo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Boot.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class ModelIntegrationTest {

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void testSerialize() throws Exception {
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