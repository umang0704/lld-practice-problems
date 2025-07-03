package com.lld.kafka_batch_processing.controllers;

import com.lld.kafka_batch_processing.models.UserDataRequest;
import com.lld.kafka_batch_processing.service.KafkaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserDataController {

    private final KafkaService kafkaService;

    public UserDataController(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publishUsers(@RequestBody UserDataRequest request) {
        try {
            kafkaService.publishUsersSync(request.users());
            return ResponseEntity.ok("All messages sent successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Failed to send messages: " + e.getMessage());
        }
    }
}