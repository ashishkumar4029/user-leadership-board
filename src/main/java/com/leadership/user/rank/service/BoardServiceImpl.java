package com.leadership.user.rank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leadership.user.rank.dao.BoardDao;
import com.leadership.user.rank.vo.SearchResultVo;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public List<SearchResultVo> getTop100Players() {
		List<Object[] > objResult = boardDao.getTop100Players();
		List<SearchResultVo> resultList = new ArrayList<SearchResultVo>();
		int rank = 1;
		for(Object[] obj:objResult) {
			SearchResultVo resultVo = new SearchResultVo();
			resultVo.setUserId((String) obj[0]);
			resultVo.setRank(String.valueOf(rank));
			rank++;
			
			resultList.add(resultVo);
		}
		return resultList;
	}

	@Override
	public List<SearchResultVo> getPlayerRankByUID(String uid) {
		List<Object[] > objResult = boardDao.getPlayerRankByUID(uid);
		List<SearchResultVo> resultList = new ArrayList<SearchResultVo>();
		int rank = 1;
		for(Object[] obj:objResult) {
			if(uid.equalsIgnoreCase((String) obj[0])) {
				SearchResultVo resultVo = new SearchResultVo();
				resultVo.setUserId((String) obj[0]);
				resultVo.setRank(String.valueOf(rank));
				resultList.add(resultVo);
				break;
			}
			rank++;
		}
		return resultList;
	}
	
}
