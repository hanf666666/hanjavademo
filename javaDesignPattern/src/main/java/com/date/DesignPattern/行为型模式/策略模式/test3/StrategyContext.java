package com.date.DesignPattern.行为型模式.策略模式.test3;

import com.date.DesignPattern.行为型模式.策略模式.test3.AliPayStrategy;

import com.date.DesignPattern.行为型模式.策略模式.test3.WeiXinPayStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * to do
 *
 * @author Hj
 * @date 2024/7/12
 */
public class StrategyContext {
    Map<PayTypeEnum, Function<Void, String>> strategyContextMap = new HashMap<>();

    //注入对应的策略类
//    @Autowired
    WeiXinPayStrategy weiXinPayStrategy=new WeiXinPayStrategyImpl();
//    @Autowired
    AliPayStrategy aliPayStrategy=new AliPayStrategy();

    public StrategyContext() {
        strategyContextMap.put(PayTypeEnum.CARD_PAY,(param)->weiXinPayStrategy.CARD_PAY());
        strategyContextMap.put(PayTypeEnum.H5,(param)->weiXinPayStrategy.H5Pay());
        strategyContextMap.put(PayTypeEnum.NO_SENSE,(param)->weiXinPayStrategy.NO_SENSE());
    }
    //根据场景调用不同的方法
    public String pay(PayTypeEnum payTypeEnum){
        Function<Void, String> strategy = strategyContextMap.get(payTypeEnum);
        return strategy.apply(null);
    }

}
