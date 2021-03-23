package com.leadership.user.rank.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class BoardDaoImpl implements BoardDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Object[]> getTop100Players() {

		String str= "select top 100 a.uid,a.total_coins_after from  dbo.LUDO_USER_SCORECARD a join (select uid,max(time_stamp) as time_stamp FROM dbo.LUDO_USER_SCORECARD group by uid)b on a.uid=b.uid and a.time_stamp=b.time_stamp order by total_coins_after desc";
		 return entityManager.createNativeQuery(str).getResultList();
		
	}
	
	@Override
	public List<Object[]> getPlayerRankByUID(String uid) {

		String str= "select a.uid,a.total_coins_after from  dbo.LUDO_USER_SCORECARD a join (select uid,max(time_stamp) as time_stamp FROM dbo.LUDO_USER_SCORECARD group by uid)b on a.uid=b.uid and a.time_stamp=b.time_stamp order by total_coins_after desc";
		 return entityManager.createNativeQuery(str).getResultList();
		
	}
	
}
