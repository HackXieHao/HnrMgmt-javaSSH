package com.hackerxiehao.hnrmgmt.entities;

import java.util.List;

public class ReturnData<T> {
	private List<T> list;
	private int count;
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
