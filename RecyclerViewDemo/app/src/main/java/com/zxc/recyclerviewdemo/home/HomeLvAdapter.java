package com.zxc.recyclerviewdemo.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zxc.recyclerviewdemo.R;

import java.util.List;

/**
 * @author zxc
 *         on 2017/3/12.
 */

public class HomeLvAdapter extends BaseAdapter {
	private Context context;
	private List<HomeLvEntity> dataList;
	private LayoutInflater inflater;

	public HomeLvAdapter(Context context, List<HomeLvEntity> dataList) {
		this.context = context;
		this.dataList = dataList;
		this.inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return dataList == null ? 0 : dataList.size();
	}

	@Override
	public Object getItem(int i) {
		return dataList.get(i);
	}

	@Override
	public long getItemId(int i) {
		return i;
	}

	@Override
	public View getView(int i, View convertView, ViewGroup viewGroup) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder(convertView = inflater.inflate(R.layout.home_lv_item,null));
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		holder.tv_title.setText(dataList.get(i).getTitle());
		return convertView;
	}


	private class ViewHolder {
		public TextView tv_title;

		public ViewHolder(View rootView) {
			tv_title = (TextView) rootView.findViewById(R.id.home_lv_tv_title);
		}
	}


}
