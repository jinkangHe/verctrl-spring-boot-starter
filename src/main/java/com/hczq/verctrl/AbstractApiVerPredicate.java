package com.hczq.verctrl;


/**
 * @Description
 * @Author hejinkang
 * @Date 2023/5/8 9:23
 * @Version 1.0
 */
public abstract class AbstractApiVerPredicate implements ApiVerPredicate{
    protected boolean doPredicate(ApiVerDefinition apiVerDefinition, VerComparator verComparator, String value) {
        if (value == null || value.equals("")) {
            return false;
        }
        String v = apiVerDefinition.getVerValue().replace(apiVerDefinition.getSuffix(), "");
        apiVerDefinition.setComparableVerVal(v);
        int i = verComparator.versionCompare(value, v);
        return i >= 0;
    }
}
