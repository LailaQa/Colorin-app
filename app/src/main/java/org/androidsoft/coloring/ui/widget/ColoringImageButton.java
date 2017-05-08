
package org.androidsoft.coloring.ui.widget;

import org.androidsoft.coloring.util.DrawUtils;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import org.androidsoft.coloring.R;

public class ColoringImageButton extends ColoringButton
{

    public static final int PADDING_NORMAL_PERCENT = 15;
    public static final int PADDING_PUSHED_PERCENT = 5;

    public ColoringImageButton(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);

        _originalBitmap = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.palette);
        _paint = new Paint(Paint.DITHER_FLAG);
    }

    public ColoringImageButton(Context context, AttributeSet attrs)
    {
        this(context, attrs, R.attr.coloringButtonStyle);
    }

    public ColoringImageButton(Context context)
    {
        this(context, null);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        int w = getWidth();
        int h = getHeight();
        int p = Math.min(w, h)
                * (isPushedDown() ? PADDING_PUSHED_PERCENT : PADDING_NORMAL_PERCENT)
                / 100;

        w -= 2 * p;
        h -= 2 * p;
        if ((_resizedBitmap == null) || (_resizedBitmap.getWidth() != w)
                || (_resizedBitmap.getHeight() != h))
        {
            _resizedBitmap = Bitmap.createBitmap(w, h, _originalBitmap.getConfig());
            DrawUtils.convertSizeFill(_originalBitmap, _resizedBitmap);
        }

        canvas.drawBitmap(_resizedBitmap, p, p, _paint);
    }
    private Bitmap _originalBitmap;
    private Bitmap _resizedBitmap;
    private Paint _paint;
}
