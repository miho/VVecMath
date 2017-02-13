/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.mihosoft.vvecmath;

/**
 * 
 * @author Michael Hoffer <info@michaelhoffer.de>
 */
public class StoredVector3dImpl implements ModifiableStoredVector3d {
    
    private double[] storage;
    private int offset;
    private int stride = 3;

    @Override
    public void setStorage(double[] storage) {
        this.storage = storage;
    }

    @Override
    public void setOffset(int offset) {
        this.offset = offset;
    }

    @Override
    public void setStride(int stride) {
        this.stride = stride;
    }

    @Override
    public Vector3d set(double... xyz) {
        for (int i = 0; i < xyz.length; i++) {
            set(i, xyz[i]);
        }
        
        return this;
    }

    @Override
    public Vector3d set(int i, double value) {
        this.storage[offset*stride+i]=value;
        return this;
    }

    @Override
    public double getX() {
        return this.storage[offset*stride+0];
    }

    @Override
    public double getY() {
        return this.storage[offset*stride+1];
    }

    @Override
    public double getZ() {
        return this.storage[offset*stride+1];
    }

    @Override
    public int getOffset() {
        return offset;
    }

    @Override
    public int getStride() {
        return stride;
    }
   
}
