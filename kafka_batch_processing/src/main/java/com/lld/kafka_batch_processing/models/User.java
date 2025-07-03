package com.lld.kafka_batch_processing.models;

public record User(
        String userId,
        String firstName,
        String lastName,
        String email,
        String phoneNumber,
        String address,
        String city,
        String state,
        String country
) { }