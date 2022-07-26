package com.wadekang.EurekaClient1.controller;

import com.wadekang.EurekaClient1.VO.MessageVO;
import com.wadekang.EurekaClient1.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ProduceController {

    private final KafkaProducerService kafkaProducer;

    @GetMapping("/hello")
    public String printHello() {
        return "Hello World from ProduceController!";
    }

    @PostMapping("/message")
    public MessageVO produceMessage(@RequestBody MessageVO messageVO) {
        log.info("{}, {}", messageVO.getReqId(), messageVO.getMessage());

        kafkaProducer.sendMessage(messageVO);

        return new MessageVO(messageVO.getReqId(), "Success");
    }
}
