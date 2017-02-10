/*
 * Copyright 2017 Michael Hoffer <info@michaelhoffer.de>. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are
 * permitted provided that the following conditions are met:
 *
 *    1. Redistributions of source code must retain the above copyright notice, this list of
 *       conditions and the following disclaimer.
 *
 *    2. Redistributions in binary form must reproduce the above copyright notice, this list
 *       of conditions and the following disclaimer in the documentation and/or other materials
 *       provided with the distribution.
 *
 * If you use this software for scientific research then please cite the following publication(s):
 *
 * M. Hoffer, C. Poliwoda, & G. Wittum. (2013). Visual reflection library:
 * a framework for declarative GUI programming on the Java platform.
 * Computing and Visualization in Science, 2013, 16(4),
 * 181–192. http://doi.org/10.1007/s00791-014-0230-y
 *
 * THIS SOFTWARE IS PROVIDED BY Michael Hoffer <info@michaelhoffer.de> "AS IS" AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL Michael Hoffer <info@michaelhoffer.de> OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * The views and conclusions contained in the software and documentation are those of the
 * authors and should not be interpreted as representing official policies, either expressed
 * or implied, of Michael Hoffer <info@michaelhoffer.de>.
 */
package eu.mihosoft.vvecmath;

import static java.lang.Math.abs;
import static java.lang.Math.acos;
import static java.lang.Math.max;
import static java.lang.Math.min;
import java.util.Random;

/**
 *
 * @author Michael Hoffer &lt;info@michaelhoffer.de&gt;
 */
class Vector3dImpl implements Vector3d {

    protected double x;
    protected double y;
    protected double z;


    /**
     * Creates a new vector.
     *
     * @param x x value
     * @param y y value
     * @param z z value
     */
    public Vector3dImpl(double x, double y, double z) {

        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Creates a new vector with specified {@code x}, {@code y} and
     * {@code z = 0}.
     *
     * @param x x value
     * @param y y value
     */
    public Vector3dImpl(double x, double y) {

        this.x = x;
        this.y = y;
        this.z = 0;
    }

    

    @Override
    public Vector3d clone() {
        return new Vector3dImpl(x, y, z);
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getZ() {
        return z;
    }

    @Override
    public double[] get() {
        return new double[]{x, y, z};
    }

    @Override
    public double get(int i) {
        return get()[i];
    }

    Vector3d set(double... xyz) {
        for (int i = 0; i < xyz.length; i++) {
            set(i, xyz[i]);
        }

        return this;
    }

    void setX(double x) {
        this.x = x;
    }

    void setY(double y) {
        this.y = y;
    }

    void setZ(double z) {
        this.z = z;
    }

    Vector3d set(int i, double value) {
        switch (i) {
            case 0:
                setX(value);
                break;
            case 1:
                setY(value);
                break;
            case 2:
                setZ(value);
            default:
                throw new RuntimeException("Illegal index: " + i);
        }

        return this;
    }

    @Override
    public double x() {
        return x;
    }

    @Override
    public double y() {
        return y;
    }

    @Override
    public double z() {
        return z;
    }

    /**
     * Returns a negated copy of this vector.
     *
     * <b>Note:</b> this vector is not modified.
     *
     * @return a negated copy of this vector
     */
    @Override
    public Vector3d negated() {
        return new Vector3dImpl(-x, -y, -z);
    }

    /**
     * Returns the sum of this vector and the specified vector.
     *
     * @param v the vector to add
     *
     * <b>Note:</b> this vector is not modified.
     *
     * @return the sum of this vector and the specified vector
     */
    @Override
    public Vector3d plus(Vector3d v) {
        return new Vector3dImpl(x + v.x(), y + v.y(), z + v.z());
    }

    /**
     * Returns the difference of this vector and the specified vector.
     *
     * @param v the vector to subtract
     *
     * <b>Note:</b> this vector is not modified.
     *
     * @return the difference of this vector and the specified vector
     */
    @Override
    public Vector3d minus(Vector3d v) {
        return new Vector3dImpl(x - v.x(), y - v.y(), z - v.z());
    }

    /**
     * Returns the product of this vector and the specified value.
     *
     * @param a the value
     *
     * <b>Note:</b> this vector is not modified.
     *
     * @return the product of this vector and the specified value
     */
    @Override
    public Vector3d times(double a) {
        return new Vector3dImpl(x * a, y * a, z * a);
    }

    /**
     * Returns the product of this vector and the specified vector.
     *
     * @param a the vector
     *
     * <b>Note:</b> this vector is not modified.
     *
     * @return the product of this vector and the specified vector
     */
    @Override
    public Vector3d times(Vector3d a) {
        return new Vector3dImpl(x * a.x(), y * a.y(), z * a.z());
    }

    /**
     * Returns this vector devided by the specified value.
     *
     * @param a the value
     *
     * <b>Note:</b> this vector is not modified.
     *
     * @return this vector devided by the specified value
     */
    @Override
    public Vector3d dividedBy(double a) {
        return new Vector3dImpl(x / a, y / a, z / a);
    }

    /**
     * Returns the dot product of this vector and the specified vector.
     *
     * <b>Note:</b> this vector is not modified.
     *
     * @param a the second vector
     *
     * @return the dot product of this vector and the specified vector
     */
    @Override
    public double dot(Vector3d a) {
        return this.x * a.x() + this.y * a.y() + this.z * a.z();
    }

    /**
     * Linearly interpolates between this and the specified vector.
     *
     * <b>Note:</b> this vector is not modified.
     *
     * @param a vector
     * @param t interpolation value
     *
     * @return copy of this vector if {@code t = 0}; copy of a if {@code t = 1};
     * the point midway between this and the specified vector if {@code t = 0.5}
     */
    @Override
    public Vector3d lerp(Vector3d a, double t) {
        return this.plus(a.minus(this).times(t));
    }

    /**
     * Returns the magnitude of this vector.
     *
     * <b>Note:</b> this vector is not modified.
     *
     * @return the magnitude of this vector
     */
    @Override
    public double magnitude() {
        return Math.sqrt(this.dot(this));
    }

    /**
     * Returns a normalized copy of this vector with length {@code 1}.
     *
     * <b>Note:</b> this vector is not modified.
     *
     * @return a normalized copy of this vector with length {@code 1}
     */
    @Override
    public Vector3d normalized() {
        return this.dividedBy(this.magnitude());
    }

    /**
     * Returns the cross product of this vector and the specified vector.
     *
     * <b>Note:</b> this vector is not modified.
     *
     * @param a the vector
     *
     * @return the cross product of this vector and the specified vector.
     */
    @Override
    public Vector3d cross(Vector3d a) {
        return new Vector3dImpl(
                this.y * a.z() - this.z * a.y(),
                this.z * a.x() - this.x * a.z(),
                this.x * a.y() - this.y * a.x()
        );
    }

    /**
     * Returns this vector in STL string format.
     *
     * @return this vector in STL string format
     */
    @Override
    public String toStlString() {
        return toStlString(new StringBuilder()).toString();
    }

    /**
     * Returns this vector in STL string format.
     *
     * @param sb string builder
     * @return the specified string builder
     */
    @Override
    public StringBuilder toStlString(StringBuilder sb) {
        return sb.append(this.x).append(" ").
                append(this.y).append(" ").
                append(this.z);
    }

    /**
     * Returns this vector in OBJ string format.
     *
     * @return this vector in OBJ string format
     */
    @Override
    public String toObjString() {
        return toObjString(new StringBuilder()).toString();
    }

    /**
     * Returns this vector in OBJ string format.
     *
     * @param sb string builder
     * @return the specified string builder
     */
    @Override
    public StringBuilder toObjString(StringBuilder sb) {
        return sb.append(this.x).append(" ").
                append(this.y).append(" ").
                append(this.z);
    }

    /**
     * Returns a transformed copy of this vector.
     *
     * @param transform the transform to apply
     *
     * <b>Note:</b> this vector is not modified.
     *
     * @return a transformed copy of this vector
     */
    @Override
    public Vector3d transformed(Transform transform, double amount) {
        return transform.transform(this.asModifiable(), amount);
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + ", " + z + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vector3d other = (Vector3d) obj;
        if (abs(this.x - other.x()) > Plane.EPS) {
            return false;
        }
        if (abs(this.y - other.y()) > Plane.EPS) {
            return false;
        }
        if (abs(this.z - other.z()) > Plane.EPS) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.z) ^ (Double.doubleToLongBits(this.z) >>> 32));
        return hash;
    }

    /**
     * Returns the angle between this and the specified vector.
     *
     * @param v vector
     * @return angle in degrees
     */
    @Override
    public double angle(Vector3d v) {
        double val = this.dot(v) / (this.magnitude() * v.magnitude());
        return acos(max(min(val, 1), -1)) * 180.0 / Math.PI; // compensate rounding errors
    }



    

    /**
     * Creates a new vector which is orthogonal to this.
     *
     * this_i , this_j , this_k => i,j,k € {1,2,3} permutation
     *
     * looking for orthogonal vector o to vector this: this_i * o_i + this_j *
     * o_j + this_k * o_k = 0
     *
     * @return a new vector which is orthogonal to this
     */
    @Override
    public Vector3d orthogonal() {

//        if ((this.x == Double.NaN) || (this.y == Double.NaN) || (this.z == Double.NaN)) {
//            throw new IllegalStateException("NaN is not a valid entry for a vector.");
//        }
        double o1 = 0.0;
        double o2 = 0.0;
        double o3 = 0.0;

        Random r = new Random();

        int numberOfZeroEntries = 0;

        if (this.x == 0) {
            numberOfZeroEntries++;
            o1 = r.nextDouble();
        }

        if (this.y == 0) {
            numberOfZeroEntries++;
            o2 = r.nextDouble();
        }

        if (this.z == 0) {
            numberOfZeroEntries++;
            o3 = r.nextDouble();
        }

        switch (numberOfZeroEntries) {

            case 0:
                // all this_i != 0
                //
                //we do not want o3 to be zero
                while (o3 == 0) {
                    o3 = r.nextDouble();
                }

                //we do not want o2 to be zero
                while (o2 == 0) {
                    o2 = r.nextDouble();
                }
                // calculate or choose randomly ??
//                o2 = -this.z * o3 / this.y;

                o1 = (-this.y * o2 - this.z * o3) / this.x;

                break;

            case 1:
                // this_i = 0 , i € {1,2,3}
                // this_j != 0 != this_k , j,k € {1,2,3}\{i}
                // 
                // choose one none zero randomly and calculate the other one

                if (this.x == 0) {
                    //we do not want o3 to be zero
                    while (o3 == 0) {
                        o3 = r.nextDouble();
                    }

                    o2 = -this.z * o3 / this.y;

                } else if (this.y == 0) {

                    //we do not want o3 to be zero
                    while (o3 == 0) {
                        o3 = r.nextDouble();
                    }

                    o1 = -this.z * o3 / this.x;

                } else if (this.z == 0) {

                    //we do not want o1 to be zero
                    while (o1 == 0) {
                        o1 = r.nextDouble();
                    }

                    o2 = -this.z * o1 / this.y;
                }

                break;

            case 2:
                // if two parts of this are 0 we can achieve orthogonality
                // via setting the corressponding part of the orthogonal vector
                // to zero this is ALREADY DONE in the init (o_i = 0.0)
                // NO CODE NEEDED
//                if (this.x == 0) {
//                    o1 = 0;
//                } else if (this.y == 0) {
//                    o2 = 0;
//                } else if (this.z == 0) {
//                    o3 = 0;
//                }
                break;

            case 3:
                System.err.println("This vector is equal to (0,0,0). ");

            default:
                System.err.println("The orthogonal one is set randomly.");

                o1 = r.nextDouble();
                o2 = r.nextDouble();
                o3 = r.nextDouble();
        }

        Vector3d result = new Vector3dImpl(o1, o2, o3);

//        if ((this.x ==Double.NaN) || (this.y == Double.NaN) || (this.z == Double.NaN)) {
//            throw new IllegalStateException("NaN is not a valid entry for a vector.");
//        }
//        System.out.println(" this : "+ this);
//        System.out.println(" result : "+ result);
        // check if the created vector is really orthogonal to this
        // if not try one more time
        while (this.dot(result) != 0.0) {
            result = this.orthogonal();
        }

        return result;
    }

    /**
     * Returns a modifiable copy of this vector.
     *
     * @return a modifiable copy of this vector
     */
    @Override
    public ModifiableVector3d asModifiable() {
        return new ModifiableVector3d(this.x, this.y, this.z);
    }

    @Override
    public Vector3d transformed(Transform transform) {
        return transform.transform(this.asModifiable());
    }

    @Override
    public Vector3d plus(double x, double y, double z) {
        return Vector3d.xyz(this.x+x, this.y+y, this.z+z);
    }

    @Override
    public Vector3d minus(double x, double y, double z) {
        return Vector3d.xyz(this.x-x, this.y-y, this.z-z);
    }

    @Override
    public Vector3d times(double x, double y, double z) {
        return Vector3d.xyz(this.x*x, this.y*y, this.z*z);
    }

}
