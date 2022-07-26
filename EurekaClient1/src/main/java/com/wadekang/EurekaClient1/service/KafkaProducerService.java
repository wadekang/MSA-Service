package com.wadekang.EurekaClient1.service;

import com.wadekang.EurekaClient1.VO.MessageVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    @Value("${spring.kafka.template.default-topic}")
    private String topicName = "topic1";

    private final KafkaTemplate<String, MessageVO> kafkaTemplate;

    public void sendMessage(MessageVO messageVO) {
        kafkaTemplate.send(topicName, messageVO);
    }
}
