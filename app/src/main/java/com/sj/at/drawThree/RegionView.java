package com.sj.at.drawThree;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.view.View;

import android.graphics.Rect;

/**
 * 作者： Shaojia on 2015/8/25.
 * 邮箱： 309814872@qq.com
 *
 * http://blog.csdn.net/harvic880925/article/details/39056701
 *
 * postInvalidate重绘方法
 *
 * 区域（Range）
 * 假设用region1  去组合region2
 * public enum Op {
 *      DIFFERENCE(0), //最终区域为region1 与 region2不同的区域
 *      INTERSECT(1), // 最终区域为region1 与 region2相交的区域
 *      UNION(2),      //最终区域为region1 与 region2组合一起的区域
 *      XOR(3),        //最终区域为region1 与 region2相交之外的区域
 *      REVERSE_DIFFERENCE(4), //最终区域为region2 与 region1不同的区域
 *      REPLACE(5); //最终区域为为region2的区域
 *      }
 *
 *
 *      几个判断方法
 *          public native boolean isEmpty();//判断该区域是否为空
 *          public native boolean isRect(); //是否是一个矩阵
 *          public native boolean isComplex();//是否是多个矩阵组合
 *
 *     一系列的getBound方法，返回一个Region的边界
 *          public Rect getBounds()
 *          public boolean getBounds(Rect r)
 *          public Path getBoundaryPath()
 *          public boolean getBoundaryPath(Path path)
 *
 *
 *     一系列的判断是否包含某点 和是否相交
 *          public native boolean contains(int x, int y);//是否包含某点
 *          public boolean quickContains(Rect r)   //是否包含某矩阵
 *          public native boolean quickContains(int left, int top, int right,int bottom) //是否没有包含某矩阵
 *          public boolean quickReject(Rect r) //是否没和该矩阵相交
 *          public native boolean quickReject(int left, int top, int right, int bottom); //是否没和该矩阵相交
 *          public native boolean quickReject(Region rgn);  //是否没和该矩阵相交
 *
 *      几个平移变换的方法
 *          public void translate(int dx, int dy)
 *          public native void translate(int dx, int dy, Region dst);
 *          public void scale(float scale) //hide
 *          public native void scale(float scale, Region dst);//hide
 */
public class RegionView extends View {

    private Region.Op style_Region = Region.Op.INTERSECT;


    public RegionView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //构造两个矩形
        Rect rect1 = new Rect(100,100,400,200);
        Rect rect2 = new Rect(200,0,300,300);

        //构造一个画笔，画出矩形轮廓
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);

        canvas.drawRect(rect1, paint);
        canvas.drawRect(rect2, paint);

        //构造两个Region
        Region region1 = new Region(rect1);
        Region region2 = new Region(rect2);

        //取两个区域的交集
        region1.op(region2, style_Region);

        //再构造一个画笔,填充Region操作结果
        Paint paint_fill = new Paint();
        paint_fill.setColor(Color.BLUE);
        paint_fill.setStyle(Paint.Style.FILL);
        paint_fill.setStrokeWidth(2);
        drawRegion(canvas,region1,paint_fill);
    }

    private void drawRegion(Canvas canvas,Region rgn,Paint paint)
    {
        RegionIterator iter = new RegionIterator(rgn);
        Rect r = new Rect();

        while (iter.next(r)) {
            canvas.drawRect(r, paint);
        }
    }


    /*DIFFERENCE(0), //最终区域为region1 与 region2不同的区域
    *      INTERSECT(1), // 最终区域为region1 与 region2相交的区域
    *      UNION(2),      //最终区域为region1 与 region2组合一起的区域
    *      XOR(3),        //最终区域为region1 与 region2相交之外的区域
    *      REVERSE_DIFFERENCE(4), //最终区域为region2 与 region1不同的区域
    *      REPLACE(5); //最终区域为为region2的区域
    */
    public void change(int which){
        switch (which){
            case 0:
                style_Region = Region.Op.DIFFERENCE;
                break;
            case 1:
                style_Region = Region.Op.INTERSECT;
                break;
            case 2:
                style_Region = Region.Op.UNION;
                break;
            case 3:
                style_Region = Region.Op.XOR;
                break;
            case 4:
                style_Region = Region.Op.REVERSE_DIFFERENCE;
                break;
            case 5:
                style_Region = Region.Op.REPLACE;
                break;
            default:
                style_Region = Region.Op.INTERSECT;
        }
        postInvalidate();
    }
}
