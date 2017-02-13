/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.mihosoft.vvecmath;

import static eu.mihosoft.vvecmath.StoredVector3d.getStructSize;

/**
 * A modifiable 3d vector that is stored in an external double array.
 *
 * @author Michael Hoffer <info@michaelhoffer.de>
 */
public interface ModifiableStoredVector3d
        extends StoredVector3d, ModifiableVector3d {

    /**
     * Creates a new stored vector from the specified double array.
     *
     * @param storage double array used to store the vector
     * @param offset the storage offset used by the vector
     * @param stride the stride used to store the vector elements (x,y,z)
     * @return a new stored vector from the specified double array
     */
    static ModifiableStoredVector3d from(double[] storage, int offset, int stride) {
        StoredVector3dImpl result = new StoredVector3dImpl();
        result.setStorage(storage);
        result.setOffset(offset);
        result.setStride(stride);
        return result;
    }

    /**
     * Creates a new modifiable stored vector from the specified double array.
     *
     * @param storage double array used to store the vector
     * @param offset the storage offset used by the vector
     * @return a new stored vector from the specified double array
     */
    static ModifiableStoredVector3d from(double[] storage, int offset) {
        return from(storage, offset, getStructSize());
    }

    /**
     * Creates a new modifiable stored vector from the specified double array.
     *
     * @param storage double array used to store the vector
     * @param v the vector who's storage offset and stride shall be used
     * @return a new stored vector from the specified double array
     */
    static ModifiableStoredVector3d from(double[] storage, StoredVector3d v) {
        return from(storage, v.getOffset(), v.getStride());
    }
}
