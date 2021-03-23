package com.leadership.user.rank.vo;

public class SearchVo {

	String userId;
	String searchType;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	@Override
	public String toString() {
		return "SearchVo [userId=" + userId + ", searchType=" + searchType + "]";
	}
	
	
	
}
