package net.devops.demo.mongo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "models")
public class Model {

    @Id
    private String id;
    private String firstName;
    private String secondName;
    private String lastName;
    private Long socialNumber;
    private LocalDateTime created;
    private LocalDateTime modified;

}
