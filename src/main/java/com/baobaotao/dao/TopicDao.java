package com.baobaotao.dao;

import com.baobaotao.domain.Topic;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * topic 的DAO类
 */
@Repository
public interface TopicDao extends BaseDao<Topic> {

    /**
     * 获取论坛版块某一页的精华主题帖，按最后回复时间以及精华级别 降序排列
     *
     * @param boardId 论坛版块ID
     * @return 该论坛下的所有精华主题帖
     */
    public List<Topic> getBoardDigestTopics(int boardId, RowBounds rowBounds);

    @Select("SELECT COUNT(*) FROM t_topic WHERE board_id=#{boardId} AND digest=1")
    public int countBoardDigestTopics(int boardId);

    /**
     * 获取论坛版块分页的主题帖子
     *
     * @param boardId 论坛版块ID
     * @return 获取论坛版块分页的主题帖子
     */
    public List<Topic> getPagedTopics(int boardId, RowBounds rowBounds);

    @Select("SELECT COUNT(*) FROM t_topic WHERE board_id=#{boardId}")
    int countPagedTopics(int boardId);

    /**
     * 根据主题帖标题查询所有模糊匹配的主题帖
     *
     * @param title 标题的查询条件
     * @return 根据主题帖标题查询所有模糊匹配的主题帖
     */
    public List<Topic> queryTopicByTitle(String title, RowBounds rowBounds);

    @Select("SELECT COUNT(*) FROM t_topic WHERE topic_title LIKE '%'||#{title}||'%'")
    int countTopicByTitle(String title);
}
