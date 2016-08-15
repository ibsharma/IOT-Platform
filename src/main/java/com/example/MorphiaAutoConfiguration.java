package com.example;

import com.example.rules.Overweight;
import com.example.rules.Underweight;
import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.annotations.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.filter.AnnotationTypeFilter;

/**
 * @author Ishaan
 */
@Configuration
public class MorphiaAutoConfiguration {

    @Bean
    public Datastore datastore() {
        Morphia morphia = new Morphia();

        ClassPathScanningCandidateComponentProvider entityScanner = new ClassPathScanningCandidateComponentProvider(true);
        entityScanner.addIncludeFilter(new AnnotationTypeFilter(Entity.class));
        for (BeanDefinition candidate : entityScanner.findCandidateComponents("com.example.dto")) {
            try {
                morphia.map(Class.forName(candidate.getBeanClassName()));
            } catch(ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return morphia.createDatastore(new MongoClient(), "db");
    }

    @Bean
    public Overweight overweightBean() {
        return new Overweight();
    }

    @Bean
    public Underweight underweightBean() {
        return new Underweight();
    }
}
