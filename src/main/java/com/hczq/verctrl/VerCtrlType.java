package com.hczq.verctrl;

public enum VerCtrlType {
    /**
     * 根据header信息进行判断
     */
    HEADER,

    /**
     * 根据参数信息进行判断
     */
    PARAM,
    /**
     * 根据请求体进行判断 强烈不建议使用这种类型
     */
    @Deprecated
    BODY
}
