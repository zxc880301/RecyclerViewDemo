package com.zxc.recyclerviewdemo.normallistview;

/**
 * @author zxc
 *         on 2017/3/12.
 */

public interface ItemTouchHelperListener {

	boolean onItemMove(int fromPosition, int toPosition);

	void onItemDismiss(int position);

}
