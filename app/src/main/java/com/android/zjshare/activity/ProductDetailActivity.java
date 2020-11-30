package com.android.zjshare.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;

import androidx.databinding.DataBindingUtil;

import com.android.zjshare.R;
import com.android.zjshare.databinding.ActivityProductTdetailBinding;
import com.android.zjshare.entity.CommentInfo;
import com.android.zjshare.entity.ProductDescData;
import com.android.zjshare.entity.ProductDetailBean;
import com.android.zjshare.util.GsonUtils;
import com.android.zjshare.widget.CommentView;
import com.android.zjshare.widget.CustomScrollView;
import com.android.zjshare.widget.ProductDetailView;
import com.android.zjshare.widget.ProductIntroduceView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailActivity extends Activity {
    //判读是否是scrollview主动引起的滑动，true-是，false-否，由tablayout引起的
    private boolean isScroll;
    //记录上一次位置，防止在同一内容块里滑动 重复定位到tablayout
    private int lastPos = 0;
    private ActivityProductTdetailBinding mBinding;
    public static final String PRODUCT_ID = "product_id";
    private List<View> anchorList = new ArrayList<>();
    String mProductId;
    ProductDetailBean productDetailBean;
    ProductDetailView detailView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.activity_product_tdetail, null, false);
        setContentView(mBinding.getRoot());
        bindData();
    }
    public   int dip2px(float dpValue) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
    public void setListener() {
        mBinding.magicIndicator.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //点击标签，使scrollview滑动，isScroll置false
                isScroll = false;
                int pos = tab.getPosition();
                if (pos <= anchorList.size() - 1) {
                    int top = anchorList.get(pos).getTop() - dip2px(65);
                    mBinding.scrollView.smoothScrollTo(0, top);
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        mBinding.scrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //当滑动由scrollview触发时，isScroll 置true
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    isScroll = true;
                }
                return false;
            }
        });

        mBinding.scrollView.setOnScrollChanged(new CustomScrollView.Callbacks() {

            @Override
            public void onScrollChanged(int l, int t, int oldl, int oldt) {
                if (isScroll) {
                    for (int i = anchorList.size() - 1; i >= 0; i--) {
                        //根据滑动距离，对比各模块距离父布局顶部的高度判断
                        if (t > anchorList.get(i).getTop() - 10) {
                            setScrollPos(i);
                            break;
                        }
                    }
                }
                setTitleLayout((int) mBinding.scrollView.getScrollY());
            }
        });

    }

    public void setTitleLayout(int scrollY) {
        int mTitleBarColor = Color.parseColor("#242321");
        //0到255 的渐变 banner高度
        float alpha = (float) scrollY / dip2px(300-65);
        if (alpha > 1) {
            alpha = 1;
        } else if (alpha < 0) {
            alpha = 0;
        }
        boolean isBig = alpha > 0.5;
        mBinding.back.setImageResource(isBig ? R.mipmap.ic_back_common : R.mipmap.ic_round_back);
        mBinding.vLine.setVisibility(isBig ? View.VISIBLE : View.GONE);
        mBinding.magicIndicator.setVisibility(isBig ? View.VISIBLE : View.GONE);
        mBinding.rvTitle.setBackgroundColor(Color.argb((int) (alpha * 255),
                Color.red(mTitleBarColor), Color.green(mTitleBarColor), Color.blue(mTitleBarColor)));
    }

    public void bindData() {
        setListener();
        String proJson = "{\n" +
                "\t\t\"id\": 9035,\n" +
                "\t\t\"userId\": 49,\n" +
                "\t\t\"userName\": null,\n" +
                "\t\t\"catCode\": \"101103100\",\n" +
                "\t\t\"brandId\": null,\n" +
                "\t\t\"goodsCode\": \"491837579\",\n" +
                "\t\t\"goodsName\": \"温氏矮脚黄鸡（彩袋装）800g\",\n" +
                "\t\t\"goodsTitle\": \"温氏矮脚黄鸡\",\n" +
                "\t\t\"salesVolume\": 0,\n" +
                "\t\t\"marketPrice\": 29.50,\n" +
                "\t\t\"costPrice\": null,\n" +
                "\t\t\"defaultImg\": \"2020/11/23/0677a242-22d2-48cb-a048-354429859de7.jpg\",\n" +
                "\t\t\"imgs\": [\"2020/11/23/0677a242-22d2-48cb-a048-354429859de7.jpg\", \"2020/11/23/8fc6eaef-6e06-4575-af2f-12fb3903d3e8.jpg\", \"2020/11/23/9dfe6ad0-be10-4bea-87c5-17da8f188653.jpg\", \"2020/11/23/4f324834-eb8b-4909-813b-df5a72f98d37.jpg\"],\n" +
                "\t\t\"goodsPcDesc\": null,\n" +
                "\t\t\"salesNumber\": 1,\n" +
                "\t\t\"isOnSale\": \"1\",\n" +
                "\t\t\"isBest\": \"0\",\n" +
                "\t\t\"isHot\": \"0\",\n" +
                "\t\t\"isPromote\": \"0\",\n" +
                "\t\t\"isDelete\": \"0\",\n" +
                "\t\t\"deliveryWay\": \"1\",\n" +
                "\t\t\"status\": \"1\",\n" +
                "\t\t\"typeId\": \"0\",\n" +
                "\t\t\"typeValue\": \"1\",\n" +
                "\t\t\"postagId\": 1,\n" +
                "\t\t\"limitNumber\": -1,\n" +
                "\t\t\"totalGoodsStock\": 14,\n" +
                "\t\t\"goodsType\": \"0\",\n" +
                "\t\t\"createTime\": \"2020-11-23T06:45:46.000+0000\",\n" +
                "\t\t\"updateTime\": \"2020-11-23T06:45:46.000+0000\",\n" +
                "\t\t\"auditUserName\": \"sp002\",\n" +
                "\t\t\"auditStatus\": \"1\",\n" +
                "\t\t\"auditOpinion\": \"\",\n" +
                "\t\t\"auditTime\": null,\n" +
                "\t\t\"goodsSpecList\": [{\n" +
                "\t\t\t\"id\": 10392,\n" +
                "\t\t\t\"goodsId\": 9035,\n" +
                "\t\t\t\"specGoodsCode\": \"178940\",\n" +
                "\t\t\t\"specValues\": \"800g/袋\",\n" +
                "\t\t\t\"specGoodsStock\": 14,\n" +
                "\t\t\t\"specSellingPrice\": 29.50,\n" +
                "\t\t\t\"specType\": \"0\",\n" +
                "\t\t\t\"userId\": null,\n" +
                "\t\t\t\"createTime\": \"2020-11-23T06:45:46.000+0000\",\n" +
                "\t\t\t\"updateTime\": \"2020-11-23T06:45:46.000+0000\",\n" +
                "\t\t\t\"isDel\": \"0\",\n" +
                "\t\t\t\"isOnSale\": \"1\",\n" +
                "\t\t\t\"sapGoodsStock\": null,\n" +
                "\t\t\t\"sapGoodsPrice\": null,\n" +
                "\t\t\t\"salesNumber\": null,\n" +
                "\t\t\t\"limitNumber\": null\n" +
                "\t\t}],\n" +
                "\t\t\"goodsAttrList\": [{\n" +
                "\t\t\t\"id\": 8065,\n" +
                "\t\t\t\"goodsId\": 9035,\n" +
                "\t\t\t\"attributeTypeId\": 4,\n" +
                "\t\t\t\"attributeId\": 1,\n" +
                "\t\t\t\"attributeValues\": \"广东\",\n" +
                "\t\t\t\"sort\": 0,\n" +
                "\t\t\t\"attributeName\": \"产地\",\n" +
                "\t\t\t\"isSellerMust\": true,\n" +
                "\t\t\t\"isBuyersMust\": false,\n" +
                "\t\t\t\"remarks\": \"\",\n" +
                "\t\t\t\"inputMode\": 4,\n" +
                "\t\t\t\"optionalValue\": \"中国大陆;外国;广东;广西;北京;上海;天津;重庆;湖北;湖南;河北;河南;浙江;江苏;江西;山西;山东;四川;贵州;云南;辽宁;吉林;黑龙江;安徽;福建;海南;陕西;甘肃;宁夏;青海;新疆;西藏;内蒙古;香港;澳门;台湾\",\n" +
                "\t\t\t\"attShow\": null,\n" +
                "\t\t\t\"status\": true,\n" +
                "\t\t\t\"isDelete\": false\n" +
                "\t\t}, {\n" +
                "\t\t\t\"id\": 8066,\n" +
                "\t\t\t\"goodsId\": 9035,\n" +
                "\t\t\t\"attributeTypeId\": 4,\n" +
                "\t\t\t\"attributeId\": 2,\n" +
                "\t\t\t\"attributeValues\": \"12个月\",\n" +
                "\t\t\t\"sort\": 1,\n" +
                "\t\t\t\"attributeName\": \"保质期\",\n" +
                "\t\t\t\"isSellerMust\": true,\n" +
                "\t\t\t\"isBuyersMust\": false,\n" +
                "\t\t\t\"remarks\": \"\",\n" +
                "\t\t\t\"inputMode\": 4,\n" +
                "\t\t\t\"optionalValue\": \"3-7天;15天;30天;75天;2个月;3个月;6个月;7个月;8个月;9个月;10个月;12个月;15个月;18个月;24个月;36个月;5年;10年\",\n" +
                "\t\t\t\"attShow\": null,\n" +
                "\t\t\t\"status\": true,\n" +
                "\t\t\t\"isDelete\": false\n" +
                "\t\t}, {\n" +
                "\t\t\t\"id\": 8067,\n" +
                "\t\t\t\"goodsId\": 9035,\n" +
                "\t\t\t\"attributeTypeId\": 4,\n" +
                "\t\t\t\"attributeId\": 3,\n" +
                "\t\t\t\"attributeValues\": \"冷藏、冷冻储存\",\n" +
                "\t\t\t\"sort\": 2,\n" +
                "\t\t\t\"attributeName\": \"储存方式\",\n" +
                "\t\t\t\"isSellerMust\": true,\n" +
                "\t\t\t\"isBuyersMust\": false,\n" +
                "\t\t\t\"remarks\": \"\",\n" +
                "\t\t\t\"inputMode\": 4,\n" +
                "\t\t\t\"optionalValue\": \"常温阴凉干燥、通风处;冷藏、冷冻储存\",\n" +
                "\t\t\t\"attShow\": null,\n" +
                "\t\t\t\"status\": true,\n" +
                "\t\t\t\"isDelete\": false\n" +
                "\t\t}, {\n" +
                "\t\t\t\"id\": 8068,\n" +
                "\t\t\t\"goodsId\": 9035,\n" +
                "\t\t\t\"attributeTypeId\": 4,\n" +
                "\t\t\t\"attributeId\": 4,\n" +
                "\t\t\t\"attributeValues\": \"普通包装\",\n" +
                "\t\t\t\"sort\": 3,\n" +
                "\t\t\t\"attributeName\": \"包装方式\",\n" +
                "\t\t\t\"isSellerMust\": true,\n" +
                "\t\t\t\"isBuyersMust\": false,\n" +
                "\t\t\t\"remarks\": \"\",\n" +
                "\t\t\t\"inputMode\": 4,\n" +
                "\t\t\t\"optionalValue\": \"普通包装;真空包装;礼盒装\",\n" +
                "\t\t\t\"attShow\": null,\n" +
                "\t\t\t\"status\": true,\n" +
                "\t\t\t\"isDelete\": false\n" +
                "\t\t}],\n" +
                "\t\t\"remarks\": null,\n" +
                "\t\t\"shopDto\": {\n" +
                "\t\t\t\"id\": 1,\n" +
                "\t\t\t\"userId\": 49,\n" +
                "\t\t\t\"shopName\": \"绿之选自营\",\n" +
                "\t\t\t\"shopLogo\": null,\n" +
                "\t\t\t\"shopBannerImg\": \"2020/11/10/c79778af-32ee-4da7-9ebf-29749461dc55.jpg\",\n" +
                "\t\t\t\"shopVideo\": \"http://www.greenchoicechina.com/upload/video/202008/1597720917942546.mp4\",\n" +
                "\t\t\t\"shopTemplate\": null,\n" +
                "\t\t\t\"isClose\": \"0\",\n" +
                "\t\t\t\"goodsCount\": 1285,\n" +
                "\t\t\t\"companyName\": \"广东犇牛农业科技有限公司\",\n" +
                "\t\t\t\"shopType\": \"0\",\n" +
                "\t\t\t\"oldShopType\": null,\n" +
                "\t\t\t\"createTime\": \"2020-10-24T08:10:32.000+0000\",\n" +
                "\t\t\t\"createUser\": \"182265668038\",\n" +
                "\t\t\t\"updateTime\": \"2020-11-25T06:36:40.000+0000\",\n" +
                "\t\t\t\"updateUser\": \"49\",\n" +
                "\t\t\t\"operationUser\": \"admin\",\n" +
                "\t\t\t\"operationRemarks\": \"\",\n" +
                "\t\t\t\"operationTime\": \"2020-10-24T08:24:38.000+0000\",\n" +
                "\t\t\t\"imgUrl1\": null,\n" +
                "\t\t\t\"imgUrl2\": null,\n" +
                "\t\t\t\"imgUrl3\": null,\n" +
                "\t\t\t\"imgLink1\": null,\n" +
                "\t\t\t\"imgLink2\": null,\n" +
                "\t\t\t\"imgLink3\": null,\n" +
                "\t\t\t\"shopNotice\": null,\n" +
                "\t\t\t\"shopProfile\": null\n" +
                "\t\t},\n" +
                "\t\t\"ip\": null,\n" +
                "\t\t\"goodsId\": null\n" +
                "\t}";

        setDataForView(GsonUtils.parseFromString(proJson, ProductDetailBean.class));

        String desc = "{\n" +
                "\t\t\"id\": 8036,\n" +
                "\t\t\"goodsId\": 9035,\n" +
                "\t\t\"goodsPcDesc\": \"<p><span style=\\\"background-color: rgb(23, 21, 24); color: rgb(153, 152, 150);\\\"><img src=\\\"http://image.greenchoicechina.com/2020/03/17/8bfc893a-c007-40f6-baf8-8695cda88c83.jpg\\\"></span><img src=\\\"https://image.greenchoicechina.com//2020/11/23/9999599a-7fe6-4919-821b-8a66f5ee997d.jpg\\\"><img src=\\\"https://image.greenchoicechina.com//2020/11/23/bdf417ee-0457-4db8-a345-a40b23d7b12c.jpg\\\"><img src=\\\"https://image.greenchoicechina.com//2020/11/23/7adc51f1-63e9-4d58-a5b1-74fc9fa3f76e.jpg\\\"><img src=\\\"https://image.greenchoicechina.com//2020/11/23/2173871e-78d3-42f6-8046-a1832a24325a.jpg\\\"><img src=\\\"https://image.greenchoicechina.com//2020/11/23/66096085-ddca-4c2e-9b8a-0e64702339fe.jpg\\\"><span style=\\\"background-color: rgb(23, 21, 24); color: rgb(153, 152, 150);\\\"><img src=\\\"http://image.greenchoicechina.com/2020/03/17/2eae158f-ad10-435f-aa05-a904825a2a3d.jpg\\\"></span></p>\"\n" +
                "\t}";

        setDetailDesc(GsonUtils.parseFromString(desc, ProductDescData.class));

    }


    //tablayout对应标签的切换
    private void setScrollPos(int newPos) {
        if (lastPos != newPos) {
            //该方法不会触发tablayout 的onTabSelected 监听
            mBinding.magicIndicator.setScrollPosition(newPos, 0, true);
        }
        lastPos = newPos;
    }

    public void setDataForView(final ProductDetailBean bean) {

        this.productDetailBean = bean;
        detailView = new ProductDetailView(ProductDetailActivity.this);
        detailView.setProductDetailData(bean);
        mBinding.container.addView(detailView);
        anchorList.add(detailView);
    }

    ProductIntroduceView introduceView;

    public void setDetailDesc(ProductDescData bean) {
        introduceView = new ProductIntroduceView(ProductDetailActivity.this);
        introduceView.requestContent(bean.getGoodsPcDesc());
        mBinding.container.addView(introduceView);
        anchorList.add(introduceView);
        CommentView commentView = new CommentView(ProductDetailActivity.this);
        String json= "{\n" +
                "    \"total\":1,\n" +
                "    \"list\":[\n" +
                "        {\n" +
                "            \"id\":353,\n" +
                "            \"goodsId\":82,\n" +
                "            \"userId\":39,\n" +
                "            \"satisfiedPoint\":\"1\",\n" +
                "            \"content\":\"差评\",\n" +
                "            \"createUser\":\"26\",\n" +
                "            \"createTime\":\"2020-11-03T03:22:59.000+0000\",\n" +
                "            \"specGoodsId\":null,\n" +
                "            \"imgList\":[],\n" +
                "            \"isShow\":\"1\",\n" +
                "            \"avatarImage\":\"2020/10/14/1726fe63-c8c1-43f5-b9dc-76cc41f3b2ee.png\",\n" +
                "            \"goodsName\":\"粤盐牌井矿盐精制盐（500g*40包/箱）\",\n" +
                "            \"userName\":\"13450266107\",\n" +
                "            \"orderNo\":null,\n" +
                "            \"shopName\":null,\n" +
                "            \"goodsImg\":null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\":353,\n" +
                "            \"goodsId\":82,\n" +
                "            \"userId\":39,\n" +
                "            \"satisfiedPoint\":\"1\",\n" +
                "            \"content\":\"差评\",\n" +
                "            \"createUser\":\"26\",\n" +
                "            \"createTime\":\"2020-11-03T03:22:59.000+0000\",\n" +
                "            \"specGoodsId\":null,\n" +
                "            \"imgList\":[\n" +
                "\n" +
                "            ],\n" +
                "            \"isShow\":\"1\",\n" +
                "            \"avatarImage\":\"2020/10/14/1726fe63-c8c1-43f5-b9dc-76cc41f3b2ee.png\",\n" +
                "            \"goodsName\":\"粤盐牌井矿盐精制盐（500g*40包/箱）\",\n" +
                "            \"userName\":\"13450266107\",\n" +
                "            \"orderNo\":null,\n" +
                "            \"shopName\":null,\n" +
                "            \"goodsImg\":null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\":353,\n" +
                "            \"goodsId\":82,\n" +
                "            \"userId\":39,\n" +
                "            \"satisfiedPoint\":\"1\",\n" +
                "            \"content\":\"差评\",\n" +
                "            \"createUser\":\"26\",\n" +
                "            \"createTime\":\"2020-11-03T03:22:59.000+0000\",\n" +
                "            \"specGoodsId\":null,\n" +
                "            \"imgList\":[\n" +
                "\n" +
                "            ],\n" +
                "            \"isShow\":\"1\",\n" +
                "            \"avatarImage\":\"2020/10/14/1726fe63-c8c1-43f5-b9dc-76cc41f3b2ee.png\",\n" +
                "            \"goodsName\":\"粤盐牌井矿盐精制盐（500g*40包/箱）\",\n" +
                "            \"userName\":\"13450266107\",\n" +
                "            \"orderNo\":null,\n" +
                "            \"shopName\":null,\n" +
                "            \"goodsImg\":null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\":353,\n" +
                "            \"goodsId\":82,\n" +
                "            \"userId\":39,\n" +
                "            \"satisfiedPoint\":\"1\",\n" +
                "            \"content\":\"差评\",\n" +
                "            \"createUser\":\"26\",\n" +
                "            \"createTime\":\"2020-11-03T03:22:59.000+0000\",\n" +
                "            \"specGoodsId\":null,\n" +
                "            \"imgList\":[\n" +
                "\n" +
                "            ],\n" +
                "            \"isShow\":\"1\",\n" +
                "            \"avatarImage\":\"2020/10/14/1726fe63-c8c1-43f5-b9dc-76cc41f3b2ee.png\",\n" +
                "            \"goodsName\":\"粤盐牌井矿盐精制盐（500g*40包/箱）\",\n" +
                "            \"userName\":\"13450266107\",\n" +
                "            \"orderNo\":null,\n" +
                "            \"shopName\":null,\n" +
                "            \"goodsImg\":null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\":353,\n" +
                "            \"goodsId\":82,\n" +
                "            \"userId\":39,\n" +
                "            \"satisfiedPoint\":\"1\",\n" +
                "            \"content\":\"差评\",\n" +
                "            \"createUser\":\"26\",\n" +
                "            \"createTime\":\"2020-11-03T03:22:59.000+0000\",\n" +
                "            \"specGoodsId\":null,\n" +
                "            \"imgList\":[\n" +
                "\n" +
                "            ],\n" +
                "            \"isShow\":\"1\",\n" +
                "            \"avatarImage\":\"2020/10/14/1726fe63-c8c1-43f5-b9dc-76cc41f3b2ee.png\",\n" +
                "            \"goodsName\":\"粤盐牌井矿盐精制盐（500g*40包/箱）\",\n" +
                "            \"userName\":\"13450266107\",\n" +
                "            \"orderNo\":null,\n" +
                "            \"shopName\":null,\n" +
                "            \"goodsImg\":null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\":353,\n" +
                "            \"goodsId\":82,\n" +
                "            \"userId\":39,\n" +
                "            \"satisfiedPoint\":\"1\",\n" +
                "            \"content\":\"差评\",\n" +
                "            \"createUser\":\"26\",\n" +
                "            \"createTime\":\"2020-11-03T03:22:59.000+0000\",\n" +
                "            \"specGoodsId\":null,\n" +
                "            \"imgList\":[\n" +
                "\n" +
                "            ],\n" +
                "            \"isShow\":\"1\",\n" +
                "            \"avatarImage\":\"2020/10/14/1726fe63-c8c1-43f5-b9dc-76cc41f3b2ee.png\",\n" +
                "            \"goodsName\":\"粤盐牌井矿盐精制盐（500g*40包/箱）\",\n" +
                "            \"userName\":\"13450266107\",\n" +
                "            \"orderNo\":null,\n" +
                "            \"shopName\":null,\n" +
                "            \"goodsImg\":null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\":353,\n" +
                "            \"goodsId\":82,\n" +
                "            \"userId\":39,\n" +
                "            \"satisfiedPoint\":\"1\",\n" +
                "            \"content\":\"差评\",\n" +
                "            \"createUser\":\"26\",\n" +
                "            \"createTime\":\"2020-11-03T03:22:59.000+0000\",\n" +
                "            \"specGoodsId\":null,\n" +
                "            \"imgList\":[\n" +
                "\n" +
                "            ],\n" +
                "            \"isShow\":\"1\",\n" +
                "            \"avatarImage\":\"2020/10/14/1726fe63-c8c1-43f5-b9dc-76cc41f3b2ee.png\",\n" +
                "            \"goodsName\":\"粤盐牌井矿盐精制盐（500g*40包/箱）\",\n" +
                "            \"userName\":\"13450266107\",\n" +
                "            \"orderNo\":null,\n" +
                "            \"shopName\":null,\n" +
                "            \"goodsImg\":null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\":353,\n" +
                "            \"goodsId\":82,\n" +
                "            \"userId\":39,\n" +
                "            \"satisfiedPoint\":\"1\",\n" +
                "            \"content\":\"差评\",\n" +
                "            \"createUser\":\"26\",\n" +
                "            \"createTime\":\"2020-11-03T03:22:59.000+0000\",\n" +
                "            \"specGoodsId\":null,\n" +
                "            \"imgList\":[\n" +
                "\n" +
                "            ],\n" +
                "            \"isShow\":\"1\",\n" +
                "            \"avatarImage\":\"2020/10/14/1726fe63-c8c1-43f5-b9dc-76cc41f3b2ee.png\",\n" +
                "            \"goodsName\":\"粤盐牌井矿盐精制盐（500g*40包/箱）\",\n" +
                "            \"userName\":\"13450266107\",\n" +
                "            \"orderNo\":null,\n" +
                "            \"shopName\":null,\n" +
                "            \"goodsImg\":null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\":353,\n" +
                "            \"goodsId\":82,\n" +
                "            \"userId\":39,\n" +
                "            \"satisfiedPoint\":\"1\",\n" +
                "            \"content\":\"差评\",\n" +
                "            \"createUser\":\"26\",\n" +
                "            \"createTime\":\"2020-11-03T03:22:59.000+0000\",\n" +
                "            \"specGoodsId\":null,\n" +
                "            \"imgList\":[\n" +
                "\n" +
                "            ],\n" +
                "            \"isShow\":\"1\",\n" +
                "            \"avatarImage\":\"2020/10/14/1726fe63-c8c1-43f5-b9dc-76cc41f3b2ee.png\",\n" +
                "            \"goodsName\":\"粤盐牌井矿盐精制盐（500g*40包/箱）\",\n" +
                "            \"userName\":\"13450266107\",\n" +
                "            \"orderNo\":null,\n" +
                "            \"shopName\":null,\n" +
                "            \"goodsImg\":null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\":353,\n" +
                "            \"goodsId\":82,\n" +
                "            \"userId\":39,\n" +
                "            \"satisfiedPoint\":\"1\",\n" +
                "            \"content\":\"差评\",\n" +
                "            \"createUser\":\"26\",\n" +
                "            \"createTime\":\"2020-11-03T03:22:59.000+0000\",\n" +
                "            \"specGoodsId\":null,\n" +
                "            \"imgList\":[\n" +
                "\n" +
                "            ],\n" +
                "            \"isShow\":\"1\",\n" +
                "            \"avatarImage\":\"2020/10/14/1726fe63-c8c1-43f5-b9dc-76cc41f3b2ee.png\",\n" +
                "            \"goodsName\":\"粤盐牌井矿盐精制盐（500g*40包/箱）\",\n" +
                "            \"userName\":\"13450266107\",\n" +
                "            \"orderNo\":null,\n" +
                "            \"shopName\":null,\n" +
                "            \"goodsImg\":null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\":353,\n" +
                "            \"goodsId\":82,\n" +
                "            \"userId\":39,\n" +
                "            \"satisfiedPoint\":\"1\",\n" +
                "            \"content\":\"差评\",\n" +
                "            \"createUser\":\"26\",\n" +
                "            \"createTime\":\"2020-11-03T03:22:59.000+0000\",\n" +
                "            \"specGoodsId\":null,\n" +
                "            \"imgList\":[\n" +
                "\n" +
                "            ],\n" +
                "            \"isShow\":\"1\",\n" +
                "            \"avatarImage\":\"2020/10/14/1726fe63-c8c1-43f5-b9dc-76cc41f3b2ee.png\",\n" +
                "            \"goodsName\":\"粤盐牌井矿盐精制盐（500g*40包/箱）\",\n" +
                "            \"userName\":\"13450266107\",\n" +
                "            \"orderNo\":null,\n" +
                "            \"shopName\":null,\n" +
                "            \"goodsImg\":null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\":353,\n" +
                "            \"goodsId\":82,\n" +
                "            \"userId\":39,\n" +
                "            \"satisfiedPoint\":\"1\",\n" +
                "            \"content\":\"差评\",\n" +
                "            \"createUser\":\"26\",\n" +
                "            \"createTime\":\"2020-11-03T03:22:59.000+0000\",\n" +
                "            \"specGoodsId\":null,\n" +
                "            \"imgList\":[\n" +
                "\n" +
                "            ],\n" +
                "            \"isShow\":\"1\",\n" +
                "            \"avatarImage\":\"2020/10/14/1726fe63-c8c1-43f5-b9dc-76cc41f3b2ee.png\",\n" +
                "            \"goodsName\":\"粤盐牌井矿盐精制盐（500g*40包/箱）\",\n" +
                "            \"userName\":\"13450266107\",\n" +
                "            \"orderNo\":null,\n" +
                "            \"shopName\":null,\n" +
                "            \"goodsImg\":null\n" +
                "        }\n" +
                "    ],\n" +
                "    \"pageNum\":1,\n" +
                "    \"pageSize\":20,\n" +
                "    \"size\":1,\n" +
                "    \"startRow\":1,\n" +
                "    \"endRow\":1,\n" +
                "    \"pages\":1,\n" +
                "    \"prePage\":0,\n" +
                "    \"nextPage\":0,\n" +
                "    \"isFirstPage\":true,\n" +
                "    \"isLastPage\":true,\n" +
                "    \"hasPreviousPage\":false,\n" +
                "    \"hasNextPage\":false,\n" +
                "    \"navigatePages\":8,\n" +
                "    \"navigatepageNums\":[\n" +
                "        1\n" +
                "    ],\n" +
                "    \"navigateFirstPage\":1,\n" +
                "    \"navigateLastPage\":1,\n" +
                "    \"firstPage\":1,\n" +
                "    \"lastPage\":1\n" +
                "}";
        CommentInfo commentInfo = GsonUtils.parseFromString(json, CommentInfo.class);
        commentView.setCommentData(commentInfo);
        mBinding.container.addView(commentView);
        anchorList.add(commentView);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (introduceView != null) {
            introduceView.onDestry();
            mBinding.container.removeAllViews();
        }

    }
}
