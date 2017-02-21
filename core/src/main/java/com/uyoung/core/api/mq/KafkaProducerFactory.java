package com.uyoung.core.api.mq;

//import com.uyoung.core.api.constant.KafkaConstant;

import com.uyoung.core.api.constant.KafkaConstant;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Desc:
 * <p/>Date: 2016-03-03
 * <br/>Time: 18:09
 * <br/>User: ylzhu
 */
public class KafkaProducerFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerFactory.class);
    private static final String DEFAULT_TOPIC = "default";
    private static final String CONFIG_NAME = "kafka.properties";
    private static KafkaProducerFactory instance = new KafkaProducerFactory();
    private Producer<String, String> producer;
    private volatile static boolean isInit = false;


    private KafkaProducerFactory() {

    }

    public static KafkaProducerFactory getInstance() {
        instance.init();
        return instance;
    }

    private void init() {
        if (isInit) {
            LOGGER.info("#Kafka config inited.");
            return;
        }
        LOGGER.info("#Begin to init kafka config.");
        Properties properties = new Properties();
        try {
            String filePath = KafkaProducerFactory.class.getClassLoader().getResource(KafkaConstant.CONFIG_DIR).getPath();
            filePath = filePath + "/" + CONFIG_NAME;
            properties.load(new FileInputStream(filePath));
        } catch (Exception e) {
            LOGGER.error("create kafka producer error!use default setting!", e);
            return;
        }
        ProducerConfig config = new ProducerConfig(properties);
        producer = new Producer<String, String>(config);
    }

    /**
     * @param topic
     * @param msg
     */
    public void sendMsg(String topic, String msg) {
        sendMsg(topic, msg, null);
    }

    /**
     * 卡夫卡会根据zone来对消息进行分区。一个分区内的消息是可以保证顺序的
     */
    public void sendMsg(String topic, String msg, String zone) {
        if (StringUtils.isBlank(zone)) {
            zone = msg;
        }
        if (StringUtils.isBlank(topic)) {
            topic = DEFAULT_TOPIC;
        }
        if (StringUtils.isNotBlank(msg)) {
            KeyedMessage<String, String> data = new KeyedMessage<String, String>(topic, zone, msg);
            producer.send(data);
        }
    }
}
