package com.baobaotao.dao;

import com.baobaotao.domain.Board;
import com.baobaotao.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User对象Dao
 */
@Repository
public interface UserDao extends BaseDao<User> {
    /**
     * 根据用户名查询User对象
     *
     * @param userName 用户名
     * @return 对应userName的User对象，如果不存在，返回null。
     */
    public User getUserByUserName(String userName);

    /**
     * 根据用户名为模糊查询条件，查询出所有前缀匹配的User对象
     *
     * @param userName 用户名查询条件
     * @return 用户名前缀匹配的所有User对象
     */
    public List<User> queryUserByUserName(String userName);

}
