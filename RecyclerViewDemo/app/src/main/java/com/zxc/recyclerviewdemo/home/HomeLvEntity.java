package com.zxc.recyclerviewdemo.home;

import android.content.Context;
import android.content.Intent;

import java.io.Serializable;

/**
 * @author zxc
 *         on 2017/3/12.
 */

public class HomeLvEntity implements Serializable {

	private String title;

	private Class clazz;


	public void startActivity(Context context){
		Intent intent = new Intent(context,getClazz());
		context.startActivity(intent);
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Class getClazz() {
		return clazz;
	}

	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}
}
