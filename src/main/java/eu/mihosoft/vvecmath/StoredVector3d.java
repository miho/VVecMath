/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.mihosoft.vvecmath;

/**
 * A 3d vector that is stored in an external double array. As of today Java does
 * not support value objects. This class is designed to be used to store vast
 * amouts of vectors in large double arrays without the overhead that typically
 * comes with large object arrays. Another use case is shared memory with native
 * code.
 *
 * @author Michael Hoffer <info@michaelhoffer.de>
 */
public interface StoredVector3d extends Vector3d {

    /**
     * Sets the array that is used to store this vector.
     *
     * @param storage storage array to set
     */
    void setStorage(double[] storage);

    /**
     * Sets the storage offset used by this vector.
     *
     * @param offset offset to set
     */
    void setOffset(int offset);

    /**
     * Returns the storage offset used by this vector.
     *
     * @return the storage offset used by this vector
     */
    int getOffset();

    /**
     * Sets the stride used to store the vector elements (x,y,z).
     *
     * @param stride the stride to set
     */
    void setStride(int stride);

    /**
     * Returns the stride used to store the vector elements (x,y,z).
     *
     * @return the stride used to store the vector elements (x,y,z)
     */
    int getStride();

    /**
     * Returns the struct size of this vector (3).
     *
     * @return the struct size of this vector (3)
     */
    static int getStructSize() {
        return 3;
    }

    /**
     * Creates a new stored vector from the specified double array.
     *
     * @param storage double array used to store the vector
     * @param offset the storage offset used by the vector
     * @param stride the stride used to store the vector elements (x,y,z)
     * @return a new stored vector from the specified double array
     */
    static StoredVector3d from(double[] storage, int offset, int stride) {
        StoredVector3dImpl result = new StoredVector3dImpl();
        result.setStorage(storage);
        result.setOffset(offset);
        result.setStride(stride);
        return result;
    }

    /**
     * Creates a new stored vector from the specified double array.
     *
     * @param storage double array used to store the vector
     * @param offset the storage offset used by the vector
     * @return a new stored vector from the specified double array
     */
    static StoredVector3d from(double[] storage, int offset) {
        return from(storage, offset, getStructSize());
    }

}
