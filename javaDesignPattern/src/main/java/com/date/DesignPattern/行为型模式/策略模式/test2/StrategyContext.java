package com.date.DesignPattern.行为型模式.策略模式.test2;

import java.util.HashMap;
import java.util.Map;

/**
 * to do
 *
 * @author Hj
 * @date 2024/7/12
 */
public class StrategyContext {
    Map<Integer,Strategy> strategyContextMap = new HashMap<>();

    //注入对应的策略类
//    @Autowired
    WeiXinPayStrategy weiXinPayStrategy=new WeiXinPayStrategy();
//    @Autowired
    AliPayStrategy aliPayStrategy=new AliPayStrategy();

    public StrategyContext() {
        strategyContextMap.put(1,weiXinPayStrategy);
        strategyContextMap.put(2,aliPayStrategy);
    }
    //根据场景调用不同的方法
    public String operate(Integer type){
        Strategy strategy = strategyContextMap.get(type);
        return strategy.operate();
    }

}
