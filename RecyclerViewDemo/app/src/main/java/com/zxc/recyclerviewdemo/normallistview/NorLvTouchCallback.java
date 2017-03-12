package com.zxc.recyclerviewdemo.normallistview;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * @author zxc
 *         on 2017/3/12.
 */

public class NorLvTouchCallback extends ItemTouchHelper.Callback {

	private ItemTouchHelperListener itemTouchHelperListener;


	@Override
	public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
		return makeMovementFlags(ItemTouchHelper.UP | ItemTouchHelper.DOWN, 0);
	}

	@Override
	public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
		if (itemTouchHelperListener != null){
			return itemTouchHelperListener.onItemMove(viewHolder.getAdapterPosition(),target.getAdapterPosition());
		}
		return false;
	}

	@Override
	public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
	}

	@Override
	public boolean isLongPressDragEnabled() {
		return super.isLongPressDragEnabled();
	}

	public ItemTouchHelperListener getItemTouchHelperListener() {
		return itemTouchHelperListener;
	}

	public void setItemTouchHelperListener(ItemTouchHelperListener itemTouchHelperListener) {
		this.itemTouchHelperListener = itemTouchHelperListener;
	}
}
