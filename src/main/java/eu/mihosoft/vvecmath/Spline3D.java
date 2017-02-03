
package eu.mihosoft.vvecmath;

import java.util.ArrayList;
import java.util.List;


/**
 * 3d Spline.
 * 
 * @author Michael Hoffer (info@michaelhoffer.de)
 */
public final class Spline3D extends Spline {

    private final List<Vector3d> points;

    private final List<Cubic> xCubics;
    private final List<Cubic> yCubics;
    private final List<Cubic> zCubics;

    /**
     * Creates a new spline.
     */
    public Spline3D() {
        this.points = new ArrayList<>();

        this.xCubics = new ArrayList<>();
        this.yCubics = new ArrayList<>();
        this.zCubics = new ArrayList<>();

    }

    /**
     * Adds a control point to this spline.
     * @param point point to add
     */
    public void addPoint(Vector3d point) {
        this.points.add(point);
    }

    /**
     * Returns all control points.
     * @return control points
     */
    public List<Vector3d> getPoints() {
        return points;
    }

    /**
     * Calculates this spline.
     */
    public void calcSpline() {
        calcNaturalCubic(points, 0, xCubics);
        calcNaturalCubic(points, 1, yCubics);
        calcNaturalCubic(points, 2, zCubics);
    }

    /**
     * Returns a point on the spline curve.
     * @param position position on the curve, range {@code [0, 1)}
     * @return a point on the spline curve
     */
    public Vector3d getPoint(double position) {
        position = position * xCubics.size();
        int cubicNum = (int) position;
        double cubicPos = (position - cubicNum);

        return Vector3d.xyz(xCubics.get(cubicNum).eval(cubicPos),
                yCubics.get(cubicNum).eval(cubicPos),
                zCubics.get(cubicNum).eval(cubicPos));
    }
}
