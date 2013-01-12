package com.baobaotao.dao;

import com.baobaotao.domain.Post;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Post的DAO类
 */
@Repository
public interface PostDao extends BaseDao<Post> {
    /**
     * 分页查询函数.
     */
    public List<Post> getPagedPosts(int topicId, RowBounds rowBounds);

    @Select("SELECT COUNT(*) FROM t_post WHERE topic_id=#{topicId}")
    int countPagedPosts(int topicId);

    /**
     * 删除主题下的所有帖子
     *
     * @param topicId 主题ID
     */
    public void deleteTopicPosts(int topicId);
}
