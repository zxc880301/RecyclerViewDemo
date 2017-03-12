package com.zxc.recyclerviewdemo.normallistview;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zxc.recyclerviewdemo.R;

import java.util.Collections;
import java.util.List;

/**
 * @author zxc
 *         on 2017/3/12.
 */

public class NorLvAdapter extends RecyclerView.Adapter<NorLvAdapter.NorLvViewHolder> implements ItemTouchHelperListener {
	private Context context;
	private List<String> dataList;
	private LayoutInflater inflater;
	private OnRvItemClickListener<NorLvViewHolder> onItemClicklistener;
	private StartDragListener startDragListener;

	public NorLvAdapter(Context context, List<String> dataList) {
		this.context = context;
		this.dataList = dataList;
		this.inflater = LayoutInflater.from(context);
	}

	@Override
	public NorLvViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		// TODO: 2017/3/12 这里需要熟悉一下inflate为什么要传parent和false
		return new NorLvViewHolder(inflater.inflate(R.layout.nor_lv_item, parent, false));
	}

	@Override
	public void onBindViewHolder(final NorLvViewHolder holder, final int position) {
		holder.rootView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (onItemClicklistener != null) {
					onItemClicklistener.onItemClickListener(holder, position);
				}
			}
		});
		holder.iv_handle.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				// TODO: 2017/3/12 这里需要看一下 MotionEventCompat.getActionMasked的具体原理
				if (MotionEventCompat.getActionMasked(motionEvent) == MotionEvent.ACTION_DOWN) {
					startDragListener.onStartDrag(holder);
				}
				return false;
			}
		});
		holder.tv_item.setText(dataList.get(position));
	}

	@Override
	public int getItemCount() {
		return dataList == null ? 0 : dataList.size();
	}

	@Override
	public boolean onItemMove(int fromPosition, int toPosition) {
		Collections.swap(dataList, fromPosition, toPosition);
		notifyItemMoved(fromPosition, toPosition);
		return true;
	}

	@Override
	public void onItemDismiss(int position) {
	}

	public class NorLvViewHolder extends RecyclerView.ViewHolder {
		public View rootView;
		public TextView tv_item;
		public ImageView iv_handle;

		public NorLvViewHolder(View itemView) {
			super(itemView);
			//添加点击效果
//			TypedValue typedValue = new TypedValue();
//			context.getTheme().resolveAttribute(R.attr.selectableItemBackground, typedValue, true);
//			itemView.setBackgroundResource(typedValue.resourceId);
			this.rootView = itemView;
			tv_item = (TextView) itemView.findViewById(R.id.norlv_tv_item);
			iv_handle = (ImageView) itemView.findViewById(R.id.norlv_iv_handle);
		}
	}

	public OnRvItemClickListener<NorLvViewHolder> getOnItemClicklistener() {
		return onItemClicklistener;
	}

	public void setOnItemClicklistener(OnRvItemClickListener<NorLvViewHolder> onItemClicklistener) {
		this.onItemClicklistener = onItemClicklistener;
	}

	public StartDragListener getStartDragListener() {
		return startDragListener;
	}

	public void setStartDragListener(StartDragListener startDragListener) {
		this.startDragListener = startDragListener;
	}
}
