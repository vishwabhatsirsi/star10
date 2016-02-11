package utils.res.vb;

import android.graphics.PointF;

/**
 * The line math.
 *
 * Created by VB on 21-Jan-2016.
 */
public class LineMath {

    private float CalculateSlope(PointF start, PointF end)
    {
        /// \remarks Given two points of line calculate the slope.
        /// Slope is y/x.
        ///
        float slope = (end.y - start.y) / (end.x - start.x);

        return (slope);
    }

    private float CalculateIntercept(PointF start, PointF end)
    {
        /// \remarks Given two points of line calculate the intercept.
        /// c = y - mx.
        ///
        float c = end.y - CalculateSlope(start, end) * end.x;

        return (c);
    }

    public PointF CalculateIntersection(PointF line1Start, PointF line1End, PointF line2Start, PointF line2End)
    {
        /// \remarks Calculate the intersection points.
        /// The line is
        /// y = m * x + c
        ///
        /// Given two lines, solve for x and y.
        ///
        /// At the point of intersection,
        /// y1 = y2 =>
        /// m1 * x1 + c1 = m2 * x2 + c2
        /// But x1 = x2 = x say, so =>
        /// m1 * x + c1 = m2 * x + c2.
        /// Now solve.

        PointF point = new PointF();

        float m1 = CalculateSlope(line1Start, line1End);
        float c1 = CalculateIntercept(line1Start, line1End);
        float m2 = CalculateSlope(line2Start, line2End);
        float c2 = CalculateIntercept(line2Start, line2End);

        point.x = (c2-c1)/(m1-m2);
        point.y = m1 * point.x + c1;

        return (point);
    }
}
