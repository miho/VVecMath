package eu.mihosoft.vvecmath;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StoredVector3dTest {

    @Test
    public void memoryLayoutTest() {
        {
            double[] memory = new double[] {1,2,3};
            Vector3d vec = StoredVector3d.from(memory, 0);
            assertEquals(memory[0], vec.getX(), Vector3dTest.EPSILON);
            assertEquals(memory[1], vec.getY(), Vector3dTest.EPSILON);
            assertEquals(memory[2], vec.getZ(), Vector3dTest.EPSILON);
        }

        {
            double[] memory = new double[] {1,2,3,4,5};
            Vector3d vec = StoredVector3d.from(memory, 2);
            assertEquals(memory[2], vec.getX(), Vector3dTest.EPSILON);
            assertEquals(memory[3], vec.getY(), Vector3dTest.EPSILON);
            assertEquals(memory[4], vec.getZ(), Vector3dTest.EPSILON);
        }
    }
    
}