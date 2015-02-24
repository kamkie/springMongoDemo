package net.devops.demo.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.LongStream;

@RestController
public class Controller {

    @Autowired
    ModelRepository modelRepository;

    @RequestMapping("/findAll")
    public List<Model> findAll() {
        return modelRepository.findAll();
    }

    @RequestMapping("/create")
    public List<Model> create() {
        LongStream.range(0, 1000).parallel().forEach(i -> {
            Model model = Model.builder()
                    .firstName("first" + i)
                    .secondName("second" + i)
                    .lastName("last" + i)
                    .socialNumber(i * 1000)
                    .build();

            modelRepository.save(model);
        });

        return modelRepository.findAll();
    }

    @RequestMapping("/update")
    public List<Model> update() {
        List<Model> models = modelRepository.findAll();

        models.parallelStream().forEach(model -> {
            model.setLastName(model.getLastName() + "adsad");
            model.setFirstName(model.getFirstName() + "uhbed");
            model.setSecondName(model.getSecondName() + "mnbvc");
            model.setSocialNumber(model.getSocialNumber() + 1);

            modelRepository.save(model);
        });

        return models;
    }
}
