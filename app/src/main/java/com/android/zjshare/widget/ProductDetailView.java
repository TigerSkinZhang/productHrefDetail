package com.android.zjshare.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.zjshare.R;
import com.android.zjshare.entity.ProductDetailBean;
import com.android.zjshare.entity.ProductDetailDataBean;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailView extends RelativeLayout  {
    private TextView mTvSubTitle, mTvPrice, mTvTitle;
    private List<String> mBannerUrls = new ArrayList<>();
    ProductDetailBean productDetailBean;
    private int mInventory;//库存 最大购买
    private int minBuy;//起批

    public ProductDetailView(Context context) {
        this(context, null);
    }

    public ProductDetailView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ProductDetailView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        View.inflate(getContext(), R.layout.fragment_product_introduce, this);
        mTvSubTitle = (TextView) findViewById(R.id.tv_sub_title);
        mTvPrice = findViewById(R.id.tv_price);
        mTvTitle = findViewById(R.id.tv_title);
    }



    /**
     * 商品详情
     *
     * @param bean
     */
    public void setProductDetailData(final ProductDetailBean bean) {
        if (bean == null) {
            return;
        }
        mBannerUrls.clear();

        setProductData(bean);
    }


    /**
     * 商品信息
     *
     * @param bean
     */
    private void setProductData(ProductDetailBean bean) {
        if (bean == null) {
            return;
        }
        this.productDetailBean = bean;
        if (productDetailBean.getLimitNumber() > 0)
            mInventory = productDetailBean.getLimitNumber();
        else
            mInventory = productDetailBean.getTotalGoodsStock();

        if (productDetailBean.getSalesNumber() > 0)
            minBuy = productDetailBean.getSalesNumber();
        else
            minBuy = 1;

        if (mInventory < minBuy) {
            mInventory = minBuy;
        }

        mTvTitle.setText(productDetailBean.getGoodsName());
        mTvSubTitle.setText(productDetailBean.getGoodsTitle());
    }

}
