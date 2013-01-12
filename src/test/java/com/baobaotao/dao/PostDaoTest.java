package com.baobaotao.dao;

import com.baobaotao.domain.Post;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.spring.annotation.SpringBeanByType;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Post的DAO类
 */
public class PostDaoTest extends BaseDaoTest {

    @SpringBeanByType
    private PostDao postDao;

    @Test
    @DataSet("BaobaoTao.Posts.xls")
    public void getPagedPosts() {
        List<Post> list = postDao.getPagedPosts(1, new RowBounds(0, 10));
        assertThat(list.size(), is(2));
    }
}
