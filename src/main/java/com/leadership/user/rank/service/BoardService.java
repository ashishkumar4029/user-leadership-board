package com.leadership.user.rank.service;

import java.util.List;

import com.leadership.user.rank.vo.SearchResultVo;

public interface BoardService {

	List<SearchResultVo> getTop100Players();

	List<SearchResultVo> getPlayerRankByUID(String uid);

}
