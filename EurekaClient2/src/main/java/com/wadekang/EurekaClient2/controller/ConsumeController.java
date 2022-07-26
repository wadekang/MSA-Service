package com.wadekang.EurekaClient2.controller;

import com.wadekang.EurekaClient2.VO.CountVO;
import com.wadekang.EurekaClient2.VO.MessageVO;
import com.wadekang.EurekaClient2.service.KafkaConsumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequiredArgsConstructor
public class ConsumeController {

    private final KafkaConsumerService kafkaService;

    @GetMapping("/hello")
    public String printHello() {
        return "Hello World from ConsumeController!";
    }

    @GetMapping("/message-test")
    public Map<Object, Object> printWords() {
        Map<Object, Object> ret = new HashMap<>();
        List<MessageVO> list = new ArrayList<>();

        list.add(new MessageVO(0L, "Hello"));
        list.add(new MessageVO(1L, "World!"));

        ret.put("messages", list);

        return ret;
    }

    @GetMapping("/all")
    public Map<String, Object> messageList() {
        Map<String, Object> ret = new HashMap<>();

        List<CountVO> messageList = kafkaService.getAllMessages();

        if (messageList.isEmpty()) {
            ret.put("messages", "No Messages!");
        }
        else {
            ret.put("messages", messageList);
        }

        return ret;
    }

    @GetMapping("/{reqId}")
    public CountVO getMessage(@PathVariable("reqId") Long reqId) {
        Optional<CountVO> message = kafkaService.getMessage(reqId);

        return message.orElseGet(() -> new CountVO(0L, "No Message!", 0));
    }
}
