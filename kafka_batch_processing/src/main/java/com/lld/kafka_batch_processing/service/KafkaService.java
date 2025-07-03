package com.lld.kafka_batch_processing.service;

import com.lld.kafka_batch_processing.models.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;


@Service
@Slf4j
public class KafkaService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String topic = "user-topic";

    public KafkaService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishUsersSync(List<User> users) throws Exception {
        long start = System.currentTimeMillis();
        for (User user : users) {
            SendResult<String, String> result = kafkaTemplate
                    .send(topic, user.userId(), user.toString())
                    .get(2, TimeUnit.SECONDS);  // Blocks synchronously

            RecordMetadata metadata = result.getRecordMetadata();
            System.out.printf("Sent userId=%s to partition=%d offset=%d%n",
                    user.userId(), metadata.partition(), metadata.offset());
        }
        log.info("Time taken : {}",System.currentTimeMillis() - start);
    }
}