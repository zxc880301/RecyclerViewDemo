package com.zxc.recyclerviewdemo.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.zxc.recyclerviewdemo.R;
import com.zxc.recyclerviewdemo.normallistview.NorLvActivity;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
	private ListView lv;
	private HomeLvAdapter adapter;
	private List<HomeLvEntity> itemList = new ArrayList<>();

	{
		initData("ListView形式的RecyclerView", NorLvActivity.class);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		initView();
	}

	private void initView() {
		lv = (ListView) findViewById(R.id.home_lv);
		adapter = new HomeLvAdapter(this, itemList);
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(onItemClickListener);
	}

	private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
			HomeLvEntity entity = (HomeLvEntity) adapter.getItem(i);
			entity.startActivity(HomeActivity.this);
		}
	};


	private void initData(String title, Class clazz) {
		HomeLvEntity entity = new HomeLvEntity();
		entity.setTitle(title);
		entity.setClazz(clazz);
		itemList.add(entity);
	}


}
