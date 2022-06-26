package com.block.delayQueue;

import java.util.Date;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * to do
 *
 * @author Hj
 * @date 2022/6/7
 */
public class Message implements Delayed {
    public Message(String body, long delayTime) {
        this.body = body;
        this.delayTime = delayTime;
        this.putTime = new Date().getTime();
    }


    private String body;
    //��ʱʱ��
    private long delayTime;
    //����ʱ��
    private long putTime;

    /**
     * ���ڷ���ʣ��ʱ��
     * ��Ϣ�Ƿ�������ͨ���˷����ж�
     * ����С�ڵ���0����
     */
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(putTime + delayTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    /**
     * ��ΪDelayed�̳���Comparable
     * ������Ҫʵ��compareTo����,��������
     * �ö���(this)С�ڡ����ڻ����ָ������(o)����ֱ𷵻ظ������������������
     */
    @Override
    public int compareTo(Delayed o) {
        long result = this.getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS);
        if (result < 0) {
            return -1;
        } else if (result > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    // getter/setter
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
