package com.hczq.verctrl;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

/**
 * 项目启动时会扫描所有Controller类和对应的RequestMapping方法，构造对应的RequestCondition
 */
public class ApiHandlerMapping extends RequestMappingHandlerMapping {

    @Override
    protected RequestCondition<?> getCustomTypeCondition(Class<?> handlerType) {
        com.hczq.verctrl.VerCtrl verCtrl = AnnotationUtils.findAnnotation(handlerType, com.hczq.verctrl.VerCtrl.class);
        return createCondition(verCtrl);
    }
    @Override
    protected RequestCondition<?> getCustomMethodCondition(Method method) {
        com.hczq.verctrl.VerCtrl verCtrl = AnnotationUtils.findAnnotation(method, com.hczq.verctrl.VerCtrl.class);
        return createCondition(verCtrl);
    }
    private RequestCondition<ApiVersionCondition> createCondition(VerCtrl verCtrl) {
        if (verCtrl == null)
            return null;
        ApiVerDefinition apiVerDefinition = new ApiVerDefinition();
        apiVerDefinition.build(verCtrl);
        //todo 最好能在启动时进行相同版本重复报错
        return new ApiVersionCondition(apiVerDefinition);
    }
}

