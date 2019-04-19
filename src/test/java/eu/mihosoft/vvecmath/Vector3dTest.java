/*
 * Copyright 2017-2019 Michael Hoffer <info@michaelhoffer.de>. All rights reserved.
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

import org.junit.Test;

import junit.framework.Assert;

public class Vector3dTest {

    @Test
    public void collinearityTest() {
        {
            Vector3d p1 = Vector3d.xyz(1,1,1);
            Vector3d p2 = p1.times(5);
            Vector3d p3 = p1.times(10);

            Assert.assertTrue("p1, p2, p3 must be collinear", p1.collinear(p2, p3));
        }
        {
            Vector3d p1 = Vector3d.xyz(1,1,1);
            Vector3d p2 = p1.times(5,5,4);
            Vector3d p3 = p1.times(10);

            Assert.assertTrue("p1, p2, p3 must not be collinear", !p1.collinear(p2, p3));
        }
        {
            Vector3d p1 = Vector3d.xyz(10,10,10);
            Vector3d p2 = Vector3d.xyz(-1,-1,-1);
            Vector3d p3 = p1.times(5);

            Assert.assertTrue("p1, p2, p3 must be collinear", p1.collinear(p2, p3));
        }
        {
            Vector3d p1 = Vector3d.xyz(10,20,10);
            Vector3d p2 = p1.clone();
            Vector3d p3 = p2.clone();

            Assert.assertTrue("p1, p2, p3 must be collinear", p1.collinear(p2, p3));
        }
    }
}