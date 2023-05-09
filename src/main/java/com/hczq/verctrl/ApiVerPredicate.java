package com.hczq.verctrl;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description
 * @Author hejinkang
 * @Date 2023/4/17 14:36
 * @Version 1.0
 */
public interface ApiVerPredicate {
    /**
     * 判断当前版本是否成功匹配当前请求
     * @param apiVerDefinition 版本信息
     * @param request 请求信息
     * @return 是否成功匹配
     */
    boolean predicate(ApiVerDefinition apiVerDefinition, HttpServletRequest request, VerComparator verComparator);


}
