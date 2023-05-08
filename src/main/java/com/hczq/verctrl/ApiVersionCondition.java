package com.hczq.verctrl;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;

public class ApiVersionCondition implements RequestCondition<ApiVersionCondition> {




    @Getter
    private final ApiVerDefinition apiVerDefinition;

    public ApiVersionCondition(ApiVerDefinition apiVerDefinition) {

        this.apiVerDefinition = apiVerDefinition;
    }

    // 将不同的筛选条件合并
    @Override
    public ApiVersionCondition combine(ApiVersionCondition apiVersionCondition) {
        // 采用最后定义优先原则，则方法上的定义覆盖类上面的定义
        return new ApiVersionCondition(apiVersionCondition.getApiVerDefinition());
    }

    // 根据request查找匹配到的筛选条件
    @Override
    public ApiVersionCondition getMatchingCondition(HttpServletRequest request) {

        VerCtrlType verCtrlType = apiVerDefinition.getVerCtrlType();
        ApiVerPredicate predicate = ApiVerPredicateFactory.getPredicate(verCtrlType);
        if (predicate.predicate(apiVerDefinition,request,apiVerDefinition.getVerComparator())) {
            return this;
        }
        return null;
    }

    // 不同筛选条件比较，用于排序
    @Override
    public int compareTo(ApiVersionCondition apiVersionCondition, HttpServletRequest httpServletRequest) {
        String thisVerValue = apiVerDefinition.getComparableVerVal();
        String otherVerValue = apiVersionCondition.getApiVerDefinition().getComparableVerVal();
        int i = apiVerDefinition.getVerComparator().versionCompare(otherVerValue, thisVerValue);
        if (i == 0) {
            throw new RuntimeException("重复接口版本！");
        }
        return i;
    }


}
