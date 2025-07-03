package com.lld.kafka_batch_processing.models;

import java.util.List;

public record UserDataRequest(List<User> users) { }
