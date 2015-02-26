package net.devops.demo.mongo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.LongStream;

@Slf4j
@RestController
@RequestMapping("/mongo")
public class Controller {

    @Autowired
    ModelRepository modelRepository;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    MongoTemplate mongoTemplate;

    private String collectionName;

    @PostConstruct
    void init() {
        collectionName = mongoTemplate.getCollectionName(Model.class);
    }

    @RequestMapping("/list")
    public ResponseEntity list() {
        Instant start = Instant.now();
        List<Model> list = modelRepository.findAll();

        Instant stop = Instant.now();
        Duration duration = Duration.between(start, stop);
        log.info("list took {}", duration);
        return ResponseEntity.ok(list);
    }

    @RequestMapping("/count")
    public ResponseEntity count() {
        Instant start = Instant.now();
        long count = mongoTemplate.getCollection(collectionName).count();

        Instant stop = Instant.now();
        Duration duration = Duration.between(start, stop);
        log.info("caunt took {}", duration);
        return ResponseEntity.ok(count);
    }

    @RequestMapping("/create")
    public ResponseEntity create(@RequestParam(defaultValue = "1000", value = "limit") long limit) {
        Instant start = Instant.now();
        LongStream.range(0, limit).parallel().forEach(i -> {
            Model model = Model.builder()
                    .firstName("first" + i)
                    .secondName("second" + i)
                    .lastName("last" + i)
                    .socialNumber(i * 100)
                    .created(LocalDateTime.now(ZoneOffset.UTC))
                    .modified(LocalDateTime.now(ZoneOffset.UTC))
                    .build();

            modelRepository.save(model);
        });

        Instant stop = Instant.now();
        Duration duration = Duration.between(start, stop);
        log.info("create took {}", duration);
        return ResponseEntity.ok(mongoTemplate.getCollection(collectionName).count());
    }

    @RequestMapping("/update")
    public ResponseEntity update() {
        Instant start = Instant.now();
        List<Model> models = modelRepository.findAll();

        models.stream().forEach(model -> {
            Long socialNumber = model.getSocialNumber();
            model.setFirstName("first" + socialNumber + "uhbed");
            model.setSecondName("second" + socialNumber + "mnbvc");
            model.setLastName("last" + socialNumber + "adsad");
            model.setSocialNumber(socialNumber + 1);
            model.setModified(LocalDateTime.now(ZoneOffset.UTC));

            modelRepository.save(model);
        });

        Instant stop = Instant.now();
        Duration duration = Duration.between(start, stop);
        log.info("update took {}", duration);
        return ResponseEntity.ok(mongoTemplate.getCollection(collectionName).getStats().ok());
    }

    @RequestMapping("/delete")
    public ResponseEntity delete() {
        Instant start = Instant.now();
        modelRepository.deleteAll();

        Instant stop = Instant.now();
        Duration duration = Duration.between(start, stop);
        log.info("delete took {}", duration);
        return ResponseEntity.ok(mongoTemplate.getCollection(collectionName).getStats().ok());
    }
}
