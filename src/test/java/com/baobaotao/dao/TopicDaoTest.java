package com.baobaotao.dao;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.unitils.UnitilsJUnit4;
import org.unitils.database.DatabaseUnitils;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBean;

import com.baobaotao.domain.Topic;
import com.baobaotao.test.dataset.util.XlsDataSetBeanFactory;

/**
 * topic 的DAO类
 */
public class TopicDaoTest extends BaseDaoTest {
    private static final Logger log = LoggerFactory.getLogger(TopicDaoTest.class);
    @SpringBean("topicDao")
    private TopicDao topicDao;

    @Test
    @ExpectedDataSet("BaobaoTao.ExpectedTopics.xls")
    public void addTopic() throws Exception {
        log.info("------------start addTopic method test ------------");
        List<Topic> topics = XlsDataSetBeanFactory.createBeans(TopicDaoTest.class, "BaobaoTao.SaveTopics.xls", "t_topic", Topic.class);
        for (Topic topic : topics) {
            topicDao.save(topic);
        }
    }
}
