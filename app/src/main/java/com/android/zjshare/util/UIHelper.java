//package com.android.zjshare.util;
//
//import android.content.Context;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.graphics.drawable.Drawable;
//import android.util.DisplayMetrics;
//import android.view.WindowManager;
//
//import com.benniu.greenChoice.app_manager.ApplicationHelper;
//
//import java.lang.reflect.Field;
//
//public class UIHelper {
//
//    public static int getStatusBarHeight() {
//        if (ApplicationHelper.getInstance().getContext() == null)
//            return 0;
//        Class<?> c = null;
//        Object obj = null;
//        Field field = null;
//        int x = 0, statusBarHeight = 0;
//        try {
//            c = Class.forName("com.android.internal.R$dimen");
//            obj = c.newInstance();
//            field = c.getField("status_bar_height");
//            x = Integer.parseInt(field.get(obj).toString());
//            statusBarHeight = ApplicationHelper.getInstance().getContext().getResources().getDimensionPixelSize(x);
//        } catch (Exception e1) {
//            e1.printStackTrace();
//        }
//        return statusBarHeight;
//    }
//
//
//    /**
//     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
//     */
//    public static int dip2px(float dpValue) {
//        if (ApplicationHelper.getInstance().getContext() == null)
//            return 0;
//        final float scale = ApplicationHelper.getInstance().getContext().getResources().getDisplayMetrics().density;
//        return (int) (dpValue * scale + 0.5f);
//    }
//
//    /**
//     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
//     */
//    public static int px2dip(Context context, float pxValue) {
//        if (context == null)
//            return 0;
//        final float scale = context.getResources().getDisplayMetrics().density;
//        return (int) (pxValue / scale + 0.5f);
//    }
//
//    /**
//     * 将px值转换为sp值，保证文字大小不变
//     */
//    public static int px2sp(float pxValue) {
//        if (ApplicationHelper.getInstance().getContext() == null)
//            return 0;
//        final float fontScale = ApplicationHelper.getInstance().getContext().getResources().getDisplayMetrics().scaledDensity;
//        return (int) (pxValue / fontScale + 0.5f);
//    }
//
//    /**
//     * 将sp值转换为px值，保证文字大小不变
//     */
//    public static int sp2px(float spValue) {
//        if (ApplicationHelper.getInstance().getContext() == null)
//            return 0;
//        final float fontScale = ApplicationHelper.getInstance().getContext().getResources().getDisplayMetrics().scaledDensity;
//        return (int) (spValue * fontScale + 0.5f);
//    }
//
//    /**
//     * 获取屏幕宽度
//     */
//    public static int getDisplayWidth() {
//        if (ApplicationHelper.getInstance().getContext() == null)
//            return 0;
//        WindowManager manage = (WindowManager) ApplicationHelper.getInstance().getContext().getSystemService(Context.WINDOW_SERVICE);
//        return manage.getDefaultDisplay().getWidth();
//    }
//
//    /**
//     * 获取屏幕高度
//     */
//    public static int getDisplayHeight() {
//        if (ApplicationHelper.getInstance().getContext() == null)
//            return 0;
//        WindowManager manage = (WindowManager) ApplicationHelper.getInstance().getContext().getSystemService(Context.WINDOW_SERVICE);
//        return manage.getDefaultDisplay().getHeight();
//    }
//
//    public static int getDeviceDpi(){
//        if (ApplicationHelper.getInstance().getContext() == null)
//            return 0;
//        DisplayMetrics dis= ApplicationHelper.getInstance().getContext().getResources().getDisplayMetrics();
//        return dis.densityDpi;
//    }
//}
