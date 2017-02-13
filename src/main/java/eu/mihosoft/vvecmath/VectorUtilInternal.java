/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.mihosoft.vvecmath;

import static java.lang.Math.abs;

/**
 * Internal utility class.
 * 
 * @author Michael Hoffer <info@michaelhoffer.de>
 */
public class VectorUtilInternal {
    
    public static String toString(Vector3d v) {
        return "[" + v.x() + ", " + v.y() + ", " + v.z() + "]";
    }

    public static boolean equals(Vector3d thisV, Object obj) {
        if (obj == null) {
            return false;
        }
        if (thisV.getClass() != obj.getClass()) {
            return false;
        }
        final Vector3d other = (Vector3d) obj;
        if (abs(thisV.x() - other.x()) > Plane.TOL) {
            return false;
        }
        if (abs(thisV.y() - other.y()) > Plane.TOL) {
            return false;
        }
        if (abs(thisV.z() - other.z()) > Plane.TOL) {
            return false;
        }
        return true;
    }

    public static int getHashCode(Vector3d v) {
        int hash = 7;
        hash = 67 * hash + (int) (Double.doubleToLongBits(v.x()) ^ (Double.doubleToLongBits(v.x()) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(v.y()) ^ (Double.doubleToLongBits(v.y()) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(v.z()) ^ (Double.doubleToLongBits(v.z()) >>> 32));
        return hash;
    }    
}
