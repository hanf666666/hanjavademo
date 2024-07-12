package com.date.DesignPattern.��Ϊ��ģʽ.����ģʽ.test2;

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

    //ע���Ӧ�Ĳ�����
//    @Autowired
    WeiXinPayStrategy weiXinPayStrategy=new WeiXinPayStrategy();
//    @Autowired
    AliPayStrategy aliPayStrategy=new AliPayStrategy();

    public StrategyContext() {
        strategyContextMap.put(1,weiXinPayStrategy);
        strategyContextMap.put(2,aliPayStrategy);
    }
    //���ݳ������ò�ͬ�ķ���
    public String operate(Integer type){
        Strategy strategy = strategyContextMap.get(type);
        return strategy.operate();
    }

}
