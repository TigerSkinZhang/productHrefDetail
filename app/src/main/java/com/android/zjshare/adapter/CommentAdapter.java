package com.android.zjshare.adapter;

import android.content.Context;

import com.android.zjshare.R;
import com.android.zjshare.entity.CommentInfo;
import com.android.zjshare.util.CommonAdapter;
import com.android.zjshare.util.ViewHolder;

import java.util.List;

public class CommentAdapter extends CommonAdapter<CommentInfo.CommentItemBean> {
    private int mShowMaxNum = 0;
    boolean mNoPic;

    public CommentAdapter(Context context, List<CommentInfo.CommentItemBean> datas, int layoutId) {
        super(context, datas, layoutId);
    }

    @Override
    public void convert(ViewHolder holder,  CommentInfo.CommentItemBean item, int position) {
        holder.setText(R.id.tv_name, item.getUserName());
        holder.setText(R.id.tv_time, item.getCreateTime());
        holder.setText(R.id.tv_content, item.getContent());
        holder.setText(R.id.tv_buytime, "购买日期：" + item.getCreateTime());

    }

    @Override
    public int getCount() {
        if (mShowMaxNum != 0) {
            if (mShowMaxNum > super.getCount()) {
                return super.getCount();
            }
            return mShowMaxNum;
        }
        return super.getCount();
    }

    public int getmShowMaxNum() {
        return mShowMaxNum;
    }

    public void setmShowMaxNum(int mShowMaxNum) {
        this.mShowMaxNum = mShowMaxNum;
    }

    public void setNoPic() {
        mNoPic = true;
    }
}
