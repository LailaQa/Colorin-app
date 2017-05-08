
package org.androidsoft.coloring.ui.activity;

import org.androidsoft.coloring.ui.widget.ColorButton;
import java.util.List;

import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import org.androidsoft.utils.ui.NoTitleActivity;

public abstract class AbstractColoringActivity extends NoTitleActivity
{

    public static final String INTENT_START_NEW = "org.androidsoft.coloring.paint.START_NEW";
    public static final String INTENT_START_NEW2 = "org.androidsoft.coloring.paint.START_NEW2";
    public static final String INTENT_PICK_COLOR = "org.androidsoft.coloring.paint.PICK_COLOR";
    public static final String INTENT_ABOUT = "org.androidsoft.coloring.paint.ABOUT";

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        WindowManager w = getWindowManager();
        Display d = w.getDefaultDisplay();
        _displayWidth = d.getWidth();
        _displayHeight = d.getHeight();
        
    }

    public static int getDisplayWitdh()
    {
        return _displayWidth;
    }

    public static int getDisplayHeight()
    {
        return _displayHeight;
    }

    protected void findAllColorButtons(List<ColorButton> result)
    {
        findAllColorButtons((ViewGroup) getWindow().getDecorView(), result);
    }

    protected void findAllColorButtons(ViewGroup g, List<ColorButton> result)
    {
        for (int i = 0; i < g.getChildCount(); i++)
        {
            View v = g.getChildAt(i);
            if (v instanceof ViewGroup)
            {
                findAllColorButtons((ViewGroup) v, result);
            }
            if (v instanceof ColorButton)
            {
                result.add((ColorButton) v);
            }
        }
    }
    protected static int _displayWidth;
    protected static int _displayHeight;
}