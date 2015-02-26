package net.devops.demo.mongo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.convert.CustomConversions;

import java.time.LocalDateTime;
import java.util.Arrays;

@Configuration
public class MongoConfiguration {

    @Bean
    public CustomConversions customConversions() {
        return new CustomConversions(Arrays.asList(
                new LocalDateTimeToStringConverter(),
                new StringToLocalDateTimeConverter()
        ));
    }

    public class LocalDateTimeToStringConverter implements Converter<LocalDateTime, String> {
        @Override
        public String convert(LocalDateTime localDate) {
            return localDate.toString();
        }
    }

    public class StringToLocalDateTimeConverter implements Converter<String, LocalDateTime> {
        @Override
        public LocalDateTime convert(String source) {
            return LocalDateTime.parse(source);
        }
    }
}
