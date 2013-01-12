package com.baobaotao.dao;

import com.baobaotao.domain.Board;
import com.baobaotao.test.dataset.util.XlsDataSetBeanFactory;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.spring.annotation.SpringBeanByType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
public class BoardDaoTest extends BaseDaoTest {
    @SpringBeanByType
    private BoardDao boardDao;

    @Test
    public void testGet() throws Exception {
        Board board = boardDao.searchById(1);
        assertNotNull(board);
        assertThat(board.getBoardName(), is("育儿"));
    }

    /**
     * 创建一个新的论坛版块
     *
     * @param board
     */

    @Test
    @ExpectedDataSet("BaobaoTao.ExpectedBoards.xls")
    public void addBoard() throws Exception {
        //通过XlsDataSetBeanFactory数据集绑定工厂创建测试实体
        List<Board> boards = XlsDataSetBeanFactory.createBeans(BoardDaoTest.class, "BaobaoTao.SaveBoards.xls", "t_board", Board.class);
        for (Board board : boards) {
            boardDao.save(board);
        }
    }

    /**
     * 删除一个版块
     *
     * @param boardId
     */

    @Test
    @DataSet("BaobaoTao.Boards.xls")//准备数据
    @ExpectedDataSet("BaobaoTao.ExpectedBoards.xls")
    public void removeBoard() {
        Board board = boardDao.searchById(7);
        boardDao.delete(board);
    }

    @Test
    @DataSet("BaobaoTao.Boards.xls")//准备数据
    public void getBoard() {
        Board board = boardDao.searchById(1);
        assertNotNull(board);
        assertThat(board.getBoardName(), Matchers.containsString("育儿"));
    }

    @Test
    @DataSet("BaobaoTao.Boards.xls")//准备数据
    public void getBoardNum() {
        int num = boardDao.getBoardNum();
        assertThat(num, is(6));
    }

    @Test
    @DataSet("BaobaoTao.BoardManagers.xls")//准备数据
    @ExpectedDataSet("BaobaoTao.BoardManagersExpected.xls")
    public void addManager() {
        log.info("-------start method addManager------");
        Map<String, Integer> param = new HashMap<String, Integer>();
        param.put("boardId", 5);
        param.put("userId", 5);
        boardDao.addManager(param);
        log.info("-------end method addManager------");
    }

}
