package com.wadekang.EurekaClient2.service;

import com.wadekang.EurekaClient2.VO.CountVO;
import com.wadekang.EurekaClient2.VO.MessageVO;
import com.wadekang.EurekaClient2.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.StringTokenizer;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumerService {

    private final MessageRepository messageRepository;

    @KafkaListener(topics = "topic1", groupId = "foo", containerFactory = "messageListener")
    public void consume(MessageVO messageVO) {
        StringTokenizer stringTokenizer = new StringTokenizer(messageVO.getMessage());

        CountVO countVO = CountVO.builder()
                .reqId(messageVO.getReqId())
                .message(messageVO.getMessage())
                .wordCount(stringTokenizer.countTokens())
                .build();

        log.info("{}, {}, {}", countVO.getReqId(), countVO.getMessage(), countVO.getWordCount());

        messageRepository.save(countVO);
    }

    public List<CountVO> getAllMessages() {
        return messageRepository.findAll();
    }

    public Optional<CountVO> getMessage(Long reqId) {
        return messageRepository.findByReqId(reqId);
    }
}
