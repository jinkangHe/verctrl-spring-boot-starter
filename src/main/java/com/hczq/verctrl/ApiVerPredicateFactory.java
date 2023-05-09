package com.hczq.verctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description
 * @Author hejinkang
 * @Date 2023/4/17 14:59
 * @Version 1.0
 */
@Component
public class ApiVerPredicateFactory {

    private static Map<String, ApiVerPredicate> apiVerPredicateMap = new ConcurrentHashMap<>();

    public static  ApiVerPredicate getPredicate(String type) {
        return apiVerPredicateMap.get(type);
    }

    @Autowired
    public void setApiVerPredicateMap(Map<String, ApiVerPredicate> apiVerPredicateMap) {
        ApiVerPredicateFactory.apiVerPredicateMap = apiVerPredicateMap;
    }
}
