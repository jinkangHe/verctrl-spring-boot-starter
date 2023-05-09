package com.hczq.verctrl;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


/**
 * @Description
 * @Author hejinkang
 * @Date 2023/4/17 14:49
 * @Version 1.0
 */
@Component("HEADER")
public class HeaderApiVerPredicate extends AbstractApiVerPredicate {
    @Override
    public boolean predicate(ApiVerDefinition apiVerDefinition, HttpServletRequest request, VerComparator verComparator) {
        String verKey = apiVerDefinition.getVerKey();
        String header = request.getHeader(verKey);
        return doPredicate(apiVerDefinition, verComparator, header);
    }


}
