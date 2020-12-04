package org.zerock.mapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
    @Setter(onMethod=@__({@Autowired}))
    private BoardMapper mapper;

    @Test
    public void testGetList(){
        mapper.getList().forEach(board -> log.info(board));
    }

    @Test
    public void testInsert(){
        BoardVO board = new BoardVO();
        board.setTitle("새로 작성하는 글");
        board.setContent("새로 작성하는 내용");
        board.setWriter("newbie");

        mapper.insert(board);

        log.info(board);
    }

    @Test
    public void testInsertSelectKey(){
        BoardVO board = new BoardVO();
        board.setTitle("한글추가2");
        board.setContent("하고싶어2 selectKey");
        board.setWriter("newbie");

        mapper.insertSelectKey(board);

        log.info(board);
    }

    @Test
    public void testRead(){
        BoardVO board = mapper.read(1L);
        log.info(board);
    }

    @Test
    public void testDelete(){
        log.info("Delete" + mapper.delete(3L));
    }

    @Test
    public void testUpdate(){
        BoardVO board = new BoardVO();
        board.setBno(5L);
        board.setTitle("after update");
        board.setContent("oh yeah update yeah");
        board.setWriter("user99");
        int count = mapper.update(board);
        log.info("count");
    }
}
