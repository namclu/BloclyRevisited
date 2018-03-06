package com.namclu.android.bloclyrevisited.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.namclu.android.bloclyrevisited.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by namlu on 06-Mar-18.
 */

public class RobotoTextView extends android.support.v7.widget.AppCompatTextView {

    private static Map<String, Typeface> sTypefaces = new HashMap<>();

    public RobotoTextView(Context context) {
        super(context);
    }

    public RobotoTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RobotoTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    void extractFont(AttributeSet attrs) {
        if (isInEditMode()) {
            return;
        }
        if (attrs == null) {
            return;
        }

        TypedArray typedArray = getContext().getTheme().obtainStyledAttributes(
                attrs, R.styleable.Roboto, 0, 0);

        int robotoFontIndex = typedArray.getInteger(R.styleable.Roboto_robotoFont, -1);

        typedArray.recycle();

        String[] stringArray = getResources().getStringArray(R.array.roboto_font_file_names);
        if (robotoFontIndex < 0 || robotoFontIndex >= stringArray.length) {
            return;
        }
        String robotoFont = stringArray[robotoFontIndex];
        Typeface robotoTypeface = null;

        if (sTypefaces.containsKey(robotoFont)) {
            robotoTypeface = sTypefaces.get(robotoFont);
        } else {

            robotoTypeface = Typeface.createFromAsset(getResources().getAssets(), "fonts/RobotoTTF/" + robotoFont);
            sTypefaces.put(robotoFont, robotoTypeface);
        }

        setTypeface(robotoTypeface);
    }
}
