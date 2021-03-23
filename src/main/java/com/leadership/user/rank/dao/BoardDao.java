package com.leadership.user.rank.dao;

import java.util.List;

public interface BoardDao {

	List<Object[]> getTop100Players();

	List<Object[]> getPlayerRankByUID(String uid);

}
