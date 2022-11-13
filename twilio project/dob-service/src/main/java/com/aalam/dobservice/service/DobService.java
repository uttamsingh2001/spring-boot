package com.aalam.dobservice.service;

import com.aalam.dobservice.entity.EmployeeEntity;
import com.aalam.dobservice.repository.EmployeeRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
@Log4j2
public class DobService {
    private final EmployeeRepository employeeRepository;
    private final KafkaTemplate<String, EmployeeEntity> kafkaTemplate;
    @Value("${spring.kafka.topic.name}")
    private String topicName;

    @Autowired
    public DobService(EmployeeRepository employeeRepository, KafkaTemplate<String, EmployeeEntity> kafkaTemplate) {
        this.employeeRepository = employeeRepository;

        this.kafkaTemplate = kafkaTemplate;
    }


    @Scheduled(cron = "2 * * * * *")
    public void send() {
        LocalDate localDate = LocalDate.now();
        for (EmployeeEntity employeeEntity : employeeRepository.findAll()) {
            LocalDate date = LocalDate.parse(employeeEntity.getDob());
            if (date.getDayOfMonth() == localDate.getDayOfMonth() && date.getMonth() == localDate.getMonth()) {
                kafkaTemplate.send(topicName, employeeEntity);
                log.info(employeeEntity);
                String s = employeeEntity.toString();
            }


        }


    }
}
