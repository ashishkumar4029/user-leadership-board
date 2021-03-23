package com.leadership.user.rank.vo;

public class SearchResultVo {

	String userId;
	String rank;
	String timestamp;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "SearchResultVo [userId=" + userId + ", rank=" + rank + ", timestamp=" + timestamp + "]";
	}
	
	
}
