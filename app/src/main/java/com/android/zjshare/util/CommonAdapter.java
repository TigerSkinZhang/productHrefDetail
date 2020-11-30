package com.android.zjshare.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * ListView、GridView的万能适配器
 * 
 * @author pts80
 * 
 * @param <T>
 */
public abstract class CommonAdapter<T> extends BaseAdapter {
	protected Context mContext;
	protected List<T> mDatas;
	protected LayoutInflater mInflater;
	private int layoutId;

	public CommonAdapter(Context context, List<T> datas, int layoutId) {
		this.mContext = context;
		mInflater = LayoutInflater.from(context);
		this.mDatas = datas;
		this.layoutId = layoutId;
	}

	@Override
	public int getCount() {
		return mDatas!=null?mDatas.size():0;
	}

	@Override
	public T getItem(int position) {
		return mDatas.get(position);
	}

	/**
	 * 加载更多 
	 * @param datas
	 */
	public void addMore(List<T> datas){
		if(datas==null){
			return;
		}
		if(mDatas==null){
			mDatas = new ArrayList<T>();
		}
		mDatas.addAll(datas);
		notifyDataSetChanged();
	}
	/**
	 * 重新加载 
	 * @param datas
	 */
	public void reload(List<T> datas){
		if(datas==null){
			return;
		}
		if(mDatas!=null){
			mDatas.clear();
		}else{
			mDatas = new ArrayList<T>();
		}
		mDatas.addAll(datas);
		notifyDataSetChanged();
	}
	public List<T> getAll(){
		return  mDatas;
	}
	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = ViewHolder.get(mContext, convertView, parent,
				layoutId, position);
		convert(holder, getItem(position), position);
		return holder.getConvertView();
	}

	public abstract void convert(ViewHolder holder, T item, int position);

	
}
