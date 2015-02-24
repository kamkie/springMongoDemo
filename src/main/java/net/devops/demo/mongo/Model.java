package net.devops.demo.mongo;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "models")
@Builder
public class Model {

    @Id
    private String id;
    private String firstName;
    private String secondName;
    private String lastName;
    private Long socialNumber;
}
