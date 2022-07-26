package com.wadekang.EurekaClient1.VO;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MessageVO {

    private int reqId;
    private String message;

    public MessageVO(int reqId, String message) {
        this.reqId = reqId;
        this.message = message;
    }
}


