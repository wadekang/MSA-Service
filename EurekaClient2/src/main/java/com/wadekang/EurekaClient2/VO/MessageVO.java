package com.wadekang.EurekaClient2.VO;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MessageVO {

    private Long reqId;
    private String message;

    public MessageVO(Long reqId, String message) {
        this.reqId = reqId;
        this.message = message;
    }
}


