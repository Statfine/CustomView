package com.sj.at.drawTwo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

/**
 * 作者： Shaojia on 2015/8/25.
 * 邮箱： 309814872@qq.com
 */
public class PaintText extends View {

    Context m_context;

    public PaintText(Context context) {
        super(context);
        m_context = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint=new Paint();
        paint.setColor(Color.RED);  //设置画笔颜色

        paint.setStrokeWidth (5);//设置画笔宽度
        paint.setAntiAlias(true); //指定是否使用抗锯齿功能，如果使用，会使绘图速度变慢
        paint.setTextSize(80);//设置文字大小



        /*
          1
         */
        //绘图样式，设置为填充
        paint.setStyle(Paint.Style.FILL);
        canvas.drawText("填充Text", 10,100, paint);

        //绘图样式设置为描边
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawText("描边Text", 10,200, paint);

        //绘图样式设置为填充且描边
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawText("填充且描边Text", 10,300, paint);


        paint.setStyle(Paint.Style.FILL);//绘图样式，设置为填充



        /*
          2
         */
        //样式设置
        paint.setTextSize(36);//设置文字大小
        paint.setFakeBoldText(true);//设置是否为粗体文字
        paint.setUnderlineText(true);//设置下划线
        paint.setStrikeThruText(true);//设置带有删除线效果

        //设置字体水平倾斜度，普通斜体字是-0.25，可见往右斜
        paint.setTextSkewX((float) -0.25);
        canvas.drawText("右倾斜字体", 10,400, paint);

        //水平倾斜度设置为：0.25，往左斜
        paint.setTextSkewX((float) 0.25);
        canvas.drawText("左倾斜字体", 10,500, paint);


        /*
          3
         */
        paint.setFakeBoldText(false);//设置是否为粗体文字
        paint.setUnderlineText(false);//设置下划线
        paint.setStrikeThruText(false);//设置带有删除线效果
        paint.setTextSkewX((float) 0);

        //普通样式字体
        canvas.drawText("普通样式字体", 10,600, paint);

        //水平方向拉伸两倍
        paint.setTextScaleX(2);//只会将水平方向拉伸，高度不会变
        canvas.drawText("水平方向拉伸两倍", 10,700, paint);

        //写在同一位置,不同颜色,看下高度是否看的不变
        paint.setTextScaleX(1);//先还原拉伸效果
        canvas.drawText("写在同一位置", 10,800, paint);

        paint.setColor(Color.GREEN);
        paint.setTextScaleX(2);//重新设置拉伸效果
        canvas.drawText("不同颜色,看下高度是否看的不变", 10,800, paint);


       /*
         4 指定个个文字位置
         void drawPosText (char[] text, int index, int count, float[] pos, Paint paint)
        void drawPosText (String text, float[] pos, Paint paint)
       */
        Paint paintTwo=new Paint();
        paintTwo.setColor(Color.RED);  //设置画笔颜色

        paintTwo.setStrokeWidth (5);//设置画笔宽度
        paintTwo.setAntiAlias(true); //指定是否使用抗锯齿功能，如果使用，会使绘图速度变慢
        paintTwo.setTextSize(36);//设置文字大小
        paintTwo.setStyle(Paint.Style.FILL);//绘图样式，设置为填充

        float []pos=new float[]{80,900,
                80,950,
                120,900,
                120,950};
        canvas.drawPosText("画图示例", pos, paintTwo);//两个构造函数



        /*
         5 沿路径绘制
        void drawTextOnPath (String text, Path path, float hOffset, float vOffset, Paint paint)
        void drawTextOnPath (char[] text, int index, int count, Path path, float hOffset, float vOffset, Paint paint)

        参数说明：

        有关截取部分字体绘制相关参数（index,count），没难度，就不再讲了，下面首重讲hOffset、vOffset
        float hOffset  : 与路径起始点的水平偏移距离
        float vOffset  : 与路径中心的垂直偏移量
       */
        Paint paintOnPath=new Paint();
        paintOnPath.setColor(Color.RED);  //设置画笔颜色

        paintOnPath.setStrokeWidth (5);//设置画笔宽度
        paintOnPath.setAntiAlias(true); //指定是否使用抗锯齿功能，如果使用，会使绘图速度变慢
        paintOnPath.setTextSize(36);//设置文字大小
        paintOnPath.setStyle(Paint.Style.STROKE);//绘图样式，设置为填充

        String string="风萧萧兮易水寒，壮士一去兮不复返";

        //先创建两个相同的圆形路径，并先画出两个路径原图
        Path circlePath=new Path();
        circlePath.addCircle(220,1200, 180, Path.Direction.CCW);//逆向绘制,还记得吗,上篇讲过的
        canvas.drawPath(circlePath, paintOnPath);//绘制出路径原形

        Path circlePath2=new Path();
        circlePath2.addCircle(220,1400, 180, Path.Direction.CCW);
        canvas.drawPath(circlePath2, paintOnPath);//绘制出路径原形

        paintOnPath.setColor(Color.GREEN);
        paintOnPath.setStyle(Paint.Style.FILL);
        //hoffset、voffset参数值全部设为0，看原始状态是怎样的
        canvas.drawTextOnPath(string, circlePath, 0, 0, paintOnPath);
        //第二个路径，改变hoffset、voffset参数值
        canvas.drawTextOnPath(string, circlePath2, 80, 30, paintOnPath);

        /*
        Typeface相关

        概述：Typeface是专门用来设置字体样式的，通过paint.setTypeface()来指定。可以指定系统中的字体样式，也可以指定自定义的样式文件中获取。要构建Typeface时，可以指定所用样式的正常体、斜体、粗体等，如果指定样式中，没有相关文字的样式就会用系统默认的样式来显示，一般默认是宋体。

        创建Typeface：

         Typeface	create(String familyName, int style) //直接通过指定字体名来加载系统中自带的文字样式
         Typeface	create(Typeface family, int style)     //通过其它Typeface变量来构建文字样式
         Typeface	createFromAsset(AssetManager mgr, String path) //通过从Asset中获取外部字体来显示字体样式
         Typeface	createFromFile(String path)//直接从路径创建
         Typeface	createFromFile(File path)//从外部路径来创建字体样式
         Typeface	defaultFromStyle(int style)//创建默认字体

        上面的各个参数都会用到Style变量,Style的枚举值如下:
        Typeface.NORMAL  //正常体
        Typeface.BOLD	 //粗体
        Typeface.ITALIC	 //斜体
        Typeface.BOLD_ITALIC //粗斜体
         */
    }
}
