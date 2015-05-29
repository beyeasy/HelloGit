package com.beyeasy.hellogit.pojo;

import com.beyeasy.hellogit.pojo.base.BasePO;

public class UserPO extends BasePO {

	private String user = "USER";

	public UserPO(BasePO base) {
		super(base);
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return super.toString() + "-" + getUser();
	}

}
