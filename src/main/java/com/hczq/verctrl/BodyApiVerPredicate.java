package com.hczq.verctrl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author hejinkang
 * @Date 2023/4/17 14:50
 * @Version 1.0
 */
@Component("BODY")
@Deprecated
public class BodyApiVerPredicate extends AbstractApiVerPredicate{
    @Override
    public boolean predicate(ApiVerDefinition apiVerDefinition, HttpServletRequest request,VerComparator verComparator) {
        Map<String, Object> bodyMap = getBodyMap(request);
        String value = (String)bodyMap.get(apiVerDefinition.getVerKey());
        return doPredicate(apiVerDefinition, verComparator, value);
    }



    private Map<String, Object> getBodyMap(HttpServletRequest request) {
        Map<String, Object> bodyMap = new HashMap<>();
        try {
            BufferedReader reader = request.getReader();
            String input = null;
            StringBuilder requestBody = new StringBuilder();
            while ((input = reader.readLine()) != null) {
                requestBody.append(input);
            }
            ObjectMapper objectMapper = new ObjectMapper();
            bodyMap = objectMapper.readValue(requestBody.toString(), Map.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bodyMap;
    }
}