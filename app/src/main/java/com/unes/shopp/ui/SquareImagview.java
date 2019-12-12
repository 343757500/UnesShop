package com.unes.shopp.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;


//在iOS中可以设置一个控件的宽高比，比如说一个ImageView的宽设置为屏幕的宽度，高等于宽度，即这个ImageView是正方形，而且适配所有机型。
//在Android的xml怎么设置呢？重写一个view extends Imageview，然后
//
//  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        int width = MeasureSpec.getSize(widthMeasureSpec);
//        int height = Math.round(width*ratio);
//        setMeasuredDimension(width,height);
//    }
//这个ratio设置成1
public class SquareImagview extends ImageView {
    public SquareImagview(Context context) {
        super(context);
    }

    public SquareImagview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareImagview(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public SquareImagview(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = Math.round(width*1);
        setMeasuredDimension(width,height);
    }
}
