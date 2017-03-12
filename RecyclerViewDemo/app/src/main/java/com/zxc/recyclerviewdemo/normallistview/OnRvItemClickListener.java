package com.zxc.recyclerviewdemo.normallistview;

import android.support.v7.widget.RecyclerView;

/**
 * @author zxc
 *         on 2017/3/12.
 */

public interface OnRvItemClickListener<VH extends RecyclerView.ViewHolder> {

	void onItemClickListener(VH holder, int position);


}
