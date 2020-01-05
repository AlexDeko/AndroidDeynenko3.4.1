package com.homework1_3.androiddeynenko341;

import android.app.Activity;
import android.content.Intent;

public class Style {
    private static int sTheme;

    public final static int THEME_GREEN = 0;
    public final static int THEME_BLACK = 1;
    public final static int THEME_BLUE = 2;

    public static void changeToTheme(Activity activity, int theme)
    {
        sTheme = theme;
        activity.finish();

        activity.startActivity(new Intent(activity, activity.getClass()));

    }

    public static void onActivityCreateSetTheme(Activity activity)
    {
        switch (sTheme)
        {
            default:
            case THEME_GREEN:
                activity.setTheme(R.style.GreenStyle);
                break;
            case THEME_BLACK:
                activity.setTheme(R.style.BlackStyle);
                break;
            case THEME_BLUE:
                activity.setTheme(R.style.BlueStyle);
                break;
        }
    }
}
