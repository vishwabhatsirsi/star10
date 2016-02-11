package utils.res.vb;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

/**
 * The helper class.
 * Depends only on Android API.
 *
 * Created by VB on 20-Jan-2016.
 */
public class helper {

    public static void Request_Fullscreen(Activity activity)
    {
        // Remove the title bar from the activity
        activity.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // Remove the notification bar
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public static Point Get_Screen_Size(Context context)
    {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        Point size = new Point(metrics.widthPixels, metrics.heightPixels);

        return (size);
    }

    public static View Get_Current_Layout(Activity activity)
    {
        View view = (View) ( (ViewGroup) activity.
                findViewById(android.R.id.content) ).getChildAt(0);

        return (view);
    }

    public static void Show_Exception(Exception e, Context context)
    {
        /// \fn  Show the exception message as a dialog.
        /// To be used in the catch block.
        ///

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("It is " + e.getCause())
                .setTitle("Oops");
        AlertDialog dialog = builder.create();
        dialog.show();

        e.printStackTrace();
    }

    public  static PointF Scale_Resolution(PointF value, Point baseRes, Point targetRes)
    {
        /// \fn Scale the given value from the known base resolution
        /// to the target resolution.
        ///
        /// \param value - Value to be scaled, specified in base resolution
        /// \param baseRes - The base resolution (X= Total Width, Y= Total Height)
        /// \param targetRes - Target resolution (X= Total Width, Y= Total Height)
        ///

        float xMul = targetRes.x / (float)baseRes.x;
        float yMul = targetRes.y / (float)baseRes.y;

        value.x = (int)(value.x * xMul);
        value.y = (int)(value.y * yMul);

        return (value);
    }
}
