package com.wadekang.EurekaClient2.VO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CountVO {

    private Long reqId;
    private String message;
    private int wordCount;

    @Builder
    public CountVO(Long reqId, String message, int wordCount) {
        this.reqId = reqId;
        this.message = message;
        this.wordCount = wordCount;
    }
}
