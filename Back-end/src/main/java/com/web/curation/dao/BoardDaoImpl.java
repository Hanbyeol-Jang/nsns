package com.web.curation.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.curation.dto.BoardDto;
import com.web.curation.dto.BoardPK;
import com.web.curation.dto.ReplyDto;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	SqlSession session;

	String ns = "com.web.curation.dao.BoardDao.";

	@Override
	public int goodClick(BoardPK boardPK) {
		return session.update(ns + "goodClick", boardPK);
	}

	@Override
	public int goodClickCancel(BoardPK boardPK) {
		return session.delete(ns + "goodClickCancel", boardPK);
	}

	@Override
	public int goodCount(BoardPK boardPK) {
		return session.selectOne(ns + "goodCount", boardPK);
	}

	@Override
	public int addComment(ReplyDto replyDto) {
		return session.insert(ns + "addcomment", replyDto);
	}
	
	@Override
	public int deleteComment(ReplyDto replyDto) {
		return session.insert(ns + "deletecomment", replyDto);
	}
	
	@Override
	public int commentCount(BoardPK boardPK) {
		return session.selectOne(ns + "commentcount", boardPK);
	}

	@Override
	public List<BoardDto> getList(int b_type) {
		return session.selectList(ns+"getList", b_type);
	}

	@Override
	public List<BoardDto> getSingerlist(BoardDto bdto) {
		return session.selectList(ns+"getList", bdto);
	}

}
