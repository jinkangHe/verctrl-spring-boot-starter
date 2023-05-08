package com.hczq.verctrl;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


/**
 * @Description
 * @Author hejinkang
 * @Date 2023/4/17 14:51
 * @Version 1.0
 */
@Component("PARAM")
public class ParamApiVerPredicate extends AbstractApiVerPredicate{
    @Override
    public boolean predicate(ApiVerDefinition apiVerDefinition, HttpServletRequest request,VerComparator verComparator) {
        String parameter = request.getParameter(apiVerDefinition.getVerKey());
        return doPredicate(apiVerDefinition, verComparator, parameter);
    }
}