package com.exercise.rocketmq;

import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.exception.RemotingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: zhiqiang.pan
 * @Date: 2019/7/22 11:18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTest {

    private static final Logger logger = LoggerFactory.getLogger(ProductTest.class);

    /**使用RocketMq的生产者*/
    @Autowired
    private DefaultMQProducer defaultMQProducer;

    /**
     * 发送消息
     *
     * 2018年3月3日 zhaowg
     * @throws InterruptedException
     * @throws MQBrokerException
     * @throws RemotingException
     * @throws MQClientException
     */
    @Test
    public void send() throws MQClientException, RemotingException, MQBrokerException, InterruptedException{
        String msg = "demo msg test";
        logger.info("开始发送消息："+msg);
        Message sendMsg = new Message("DemoTopic","DemoTag",msg.getBytes());
        //默认3秒超时
        SendResult sendResult = defaultMQProducer.send(sendMsg);
        logger.info("消息发送响应信息："+sendResult.toString());
    }
}
