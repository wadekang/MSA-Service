package com.wadekang.EurekaClient2.repository;

import com.wadekang.EurekaClient2.VO.CountVO;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MessageRepository {

    private static Map<Long, CountVO> store = new HashMap<>();

    public void save(CountVO countVO) {
        store.put(countVO.getReqId(), countVO);
    }

    public Optional<CountVO> findByReqId(Long reqId) {
        return Optional.ofNullable(store.get(reqId));
    }

    public List<CountVO> findAll() {
        return new ArrayList<>(store.values());
    }

}
