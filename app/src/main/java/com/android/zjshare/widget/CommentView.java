package com.android.zjshare.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.zjshare.R;
import com.android.zjshare.adapter.CommentAdapter;
import com.android.zjshare.entity.CommentInfo;
import com.android.zjshare.util.GsonUtils;

import java.util.List;


public class CommentView extends RelativeLayout {
    private TextView mTvCommentTotal;
    private ListView mListView;
//    private View emptyView;
    private LinearLayout mLinearFailContainer;
    private List< CommentInfo.CommentItemBean> mCommentList;
    private CommentAdapter mAdapter;
    private TextView mTvAll, mTvGood, mTvMiddle, mTvBad;
    private String mProductId;
    private ProgressBar mLoadingView;
    private LinearLayout mFlowLayout;
    public CommentView(Context context) {
        this(context, null);
    }

    public CommentView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CommentView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setPadding(0, 0, 0, 0);
        View.inflate(getContext(), R.layout.layout_product_detail_comment, this);

        mTvCommentTotal = (TextView) findViewById(R.id.tv_comment);
        mListView = (ListView) findViewById(R.id.listview);
        mLoadingView = (ProgressBar) findViewById(R.id.comment_loading);
        setListener();

    }

    private void setListener() {
    }

    /**
     * 设置评论数据
     *
     * @param commentInfo
     */
    public void setCommentData(CommentInfo commentInfo) {

        if (commentInfo != null) {
            if (mFlowLayout == null) {
                View headView = View.inflate(getContext(), R.layout.layout_comment_list_head, null);
                mFlowLayout = headView.findViewById(R.id.flowlayout);
                mListView.addHeaderView(headView);
                mTvAll = (TextView) mFlowLayout.findViewById(R.id.tv_all);
                mTvGood = (TextView) mFlowLayout.findViewById(R.id.tv_good);
                mTvMiddle = (TextView) mFlowLayout.findViewById(R.id.tv_middle);
                mTvBad = (TextView) mFlowLayout.findViewById(R.id.tv_bad);

            }
            mAdapter = new CommentAdapter(getContext(), commentInfo.getList(), R.layout.item_listview_comment);
            mAdapter.setNoPic();
            mAdapter.setmShowMaxNum(5);
            mListView.setAdapter(mAdapter);
            mTvAll.setSelected(true);
        }
    }
}
