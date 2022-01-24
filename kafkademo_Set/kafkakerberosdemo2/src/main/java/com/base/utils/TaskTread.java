package com.base.utils;

import java.io.Serializable;
import java.util.List;

public class TaskTread implements Runnable, Serializable {
	private static final long serialVersionUID = 1L;
	private List<Object> list;

	public TaskTread(List<Object> list) {
		this.list = list;	}

	@Override
	public void run() {
		list.add(1);
		list.add(2);
		list.add(3);
	}

}
