package com.hczq.verctrl;

import lombok.Data;

/**
 * @Description
 * @Author hejinkang
 * @Date 2023/4/13 16:58
 * @Version 1.0
 */
@Data
public class ApiVerDefinition {
    private String uri;
    private String verKey;

    private String verValue;

    private String suffix;

    private VerCtrlType verCtrlType;

    private VerComparator verComparator;

    private String comparableVerVal;


    public void build(VerCtrl verCtrl) {
        this.verKey = verCtrl.key();
        this.verValue = verCtrl.value();
        this.verCtrlType = verCtrl.type();
        this.suffix = verCtrl.suffix();
        try {
            this.verComparator = (VerComparator) verCtrl.verComparator().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("ApiVerDefinition初始化失败：" + verCtrl.verComparator().toString());
        }
    }

}
