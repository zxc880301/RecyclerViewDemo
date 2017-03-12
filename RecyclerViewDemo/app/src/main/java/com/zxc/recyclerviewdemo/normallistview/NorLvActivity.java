package com.zxc.recyclerviewdemo.normallistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Toast;

import com.zxc.recyclerviewdemo.R;

import java.util.ArrayList;
import java.util.List;

public class NorLvActivity extends AppCompatActivity {

	private RecyclerView recyclerView;
	private ItemTouchHelper touchHelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nor_lv_activity);
		initView();

	}

	private void initView() {
		recyclerView = (RecyclerView) findViewById(R.id.nor_lv_rv);
		recyclerView.setHasFixedSize(true);

		NorLvAdapter adapter = new NorLvAdapter(this, initData());
		adapter.setOnItemClicklistener(onRvItemClickListener);
		adapter.setStartDragListener(startDragListener);
		recyclerView.setAdapter(adapter);

		NorLvTouchCallback touchCallback = new NorLvTouchCallback();
		touchCallback.setItemTouchHelperListener(adapter);
		touchHelper = new ItemTouchHelper(touchCallback);
		touchHelper.attachToRecyclerView(recyclerView);

	}

	private OnRvItemClickListener<NorLvAdapter.NorLvViewHolder> onRvItemClickListener = new OnRvItemClickListener<NorLvAdapter.NorLvViewHolder>() {
		@Override
		public void onItemClickListener(NorLvAdapter.NorLvViewHolder holder, int position) {
			Toast.makeText(NorLvActivity.this, "Item被点击： " + position, Toast.LENGTH_SHORT).show();
		}
	};

	private StartDragListener startDragListener = new StartDragListener() {
		@Override
		public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
			touchHelper.startDrag(viewHolder);
		}
	};

	private List<String> initData() {
		List<String> resultList = new ArrayList<>();
		for (int i = 0; i < 15; i++) {
			resultList.add("列表项-" + i);
		}
		return resultList;
	}


}
