package com.project;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@PropertySource(value = {"aws-database.properties", "google-credintial.properties"})
@Configuration
public class JavaConfiguration {

}
