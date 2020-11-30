package com.android.zjshare.widget;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.http.SslError;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.android.zjshare.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ProductIntroduceView extends RelativeLayout {
    private ProgressBar mWebProgressBar;
    private WebView mWebView;
    private boolean mIsFirst=true;//是否初次加载
    private boolean mIsLoadSuccess=true;
    //本地js缓存
    private final Set<String> offlineResources = new HashSet<>();


    public ProductIntroduceView(Context context) {
        this(context,null);
    }

    public ProductIntroduceView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ProductIntroduceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    public void hideTitle() {
        findViewById(R.id.tv_title).setVisibility(GONE);
    }

    private void init() {
        View.inflate(getContext(), R.layout.fragment_product_graphic_details,this);
        mWebProgressBar = (ProgressBar) findViewById(R.id.web_progress);
        mWebView = (WebView) findViewById(R.id.webview);
        initWebView();
        setFocusable(false);
        setFocusableInTouchMode(false);
    }
    private void initWebView() {
        WebSettings settings = mWebView.getSettings();
//        if (Build.VERSION.SDK_INT >= 21) {
//            settings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
//        }
        settings.setJavaScriptEnabled(true);
        mWebView.setVerticalScrollBarEnabled(false);
        setListener();
//        mWebView.addJavascriptInterface(new ProductGraphicDetailsFragment.JavascriptInterface(getContext()),"imagelistner");
    }
    private void fetchOfflineResources() {
        AssetManager am = getContext().getAssets();
        try {
            String[] res = am.list("off_line_res/css");
            if (res != null) {
                Collections.addAll(offlineResources, res);
            }
            res = am.list("off_line_res/js");
            if (res != null) {
                Collections.addAll(offlineResources, res);
            }
            res = am.list("off_line_res/font");
            if (res != null) {
                Collections.addAll(offlineResources, res);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void requestContent(String bodyContent){

        fetchOfflineResources();
       /* if(!TextUtils.isEmpty(mUrl)){
            if(mIsFirst&&!TextUtils.isEmpty(mUrl)){
                mWebView.loadUrl(mUrl);
                mIsFirst = false;
            }
            if(!mIsLoadSuccess&& !TextUtils.isEmpty(mUrl)){
                mIsLoadSuccess = true;
                mWebView.loadUrl(mUrl);
            }
        }*/
        String linkCss =
                "  <meta charset=\"utf-8\">\n" +
                        "    <meta name=\"viewport\" content=\"initial-scale=1, maximum-scale=1, user-scalable=no\">\n" +
                        "    <meta name=\"format-detection\" content=\"telephone=no\">"+
                "<style type=\"text/css\"> " +
                "img {" +
                "width:100%;" +
                "height:auto;" +
                "}" + "p { margin: 0;padding: 0; }"+
                "body {" +
                "margin-right:0px;" +
                "margin-left:0px;" +
                "margin-top:0px;" +
                "margin-bottom:0px;" +
                "}" +
                "</style>";
        String html = "<html><head>" + linkCss + "</head>" + bodyContent + "</body></html>";
//        mWebView.loadData(content, "text/html", "UTF-8"); // 加载定义的代码，并设定编码格式和字符集。
        mWebView.loadData(html, "text/html", "uft-8");
    }

    private void setListener() {

        mWebView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if(newProgress<100){
                    mWebProgressBar.setVisibility(View.VISIBLE);
                }else{
                    mWebProgressBar.setVisibility(View.INVISIBLE);
                }
                mWebProgressBar.setProgress(newProgress);
            }
        });

        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if(mWebView==null){
                    return;
                }
                //这段js函数的功能就是注册监听，遍历所有的img标签，并添加onClick函数，函数的功能是在图片点击的时候调用本地java接口并传递url过去
                mWebView.loadUrl("javascript:(function(){"
                        + "var objs = document.getElementsByTagName(\"img\"); "
                        + "for(var i=0;i<objs.length;i++)  " + "{"
                        + "    objs[i].onclick=function()  " + "    {  "
                        + "        window.imagelistner.openImage(this.src);  "
                        + "    }  " + "}" + "})()");
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
                mWebView.loadDataWithBaseURL("","", "text/html", "UTF-8","");
                mIsLoadSuccess = false;
            }
            @Override
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                mWebView.loadDataWithBaseURL("","", "text/html", "UTF-8","");
                mIsLoadSuccess = false;
            }
            @Override
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                sslErrorHandler.proceed();//处理ssl错误
            }

            @Override
            public WebResourceResponse shouldInterceptRequest(WebView webView, String url) {
                int lastSlash = url.lastIndexOf("/");
                if (lastSlash != -1) {
                    String suffix = url.substring(lastSlash + 1);
                    String target = "off_line_res/";
                    if (offlineResources.contains(suffix)) {
                        String mimeType;
                        if (suffix.endsWith(".js")) {
                            mimeType = "application/x-javascript";
                            target += "js/";
                        } else if (suffix.endsWith(".css")) {
                            mimeType = "text/css";
                            target += "css/";
                        } else {
                            mimeType = "text/html";
                            target += "font/";
                        }
                        try {
                            InputStream is = getContext().getAssets().open(target + suffix);
                            return new WebResourceResponse(mimeType, "UTF-8", is);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                return super.shouldInterceptRequest(webView, url);
            }
        });
    }

    public void onDestry(){
        mWebView.stopLoading();
        mWebView.getSettings().setJavaScriptEnabled(false);
        mWebView.clearHistory();
        mWebView.removeAllViews();
        mWebView.destroy();
    }
    public void onResume() {
    }


    public void onPause() {
    }

}
