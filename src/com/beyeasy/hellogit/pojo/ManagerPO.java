package com.beyeasy.hellogit.pojo;

import com.beyeasy.hellogit.pojo.base.BasePO;

public class ManagerPO extends BasePO {

	private String manager = "MANAGER";

	public ManagerPO(BasePO base) {
		super(base);
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return super.toString() + "-" + manager;
	}

}
