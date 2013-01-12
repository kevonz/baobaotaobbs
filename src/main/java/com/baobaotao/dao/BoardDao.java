package com.baobaotao.dao;

import com.baobaotao.domain.Board;
import com.baobaotao.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BoardDao extends BaseDao<Board> {

    /**
     * 获取所有版块数量
     * @return
     */
    public int getBoardNum();

    /**
     * 相应版块增加一个管理员
     * @param userBoardMap
     */
    public void addManager(Map<String, Integer> userBoardMap);

    /**
     * 相应版块删除一个管理员
     * @param userBoardMap
     */
    public void removeManager(Map<String, Integer> userBoardMap);

    /**
     * 返回相应版块所有管理员
     * @param board
     * @return
     */
    public List<User> getAllManagerList(int boardId);

    /**
     * 返回用户所管理的版块列表
     * @param username
     * @return
     */
    public List<Board> getAllBoardList(String username);
}
