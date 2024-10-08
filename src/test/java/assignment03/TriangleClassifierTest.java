package assignment03;

import org.junit.Assert;
import org.junit.Test;

public class TriangleClassifierTest {

    @Test
    public void testClassifyEquilateralTriangle() {
        Assert.assertEquals("Equilateral", TriangleClassifier.classifyTriangle(3, 3, 3));
    }

    @Test
    public void testClassifyScaleneTriangle() {
        Assert.assertEquals("Scalene", TriangleClassifier.classifyTriangle(3, 4, 5));
    }

    @Test
    public void testClassifyIsoscelesTriangle() {
        Assert.assertEquals("Isosceles", TriangleClassifier.classifyTriangle(3, 3, 5));
    }

    @Test
    public void testClassifyNotATriangle() {
        Assert.assertEquals("Not a triangle", TriangleClassifier.classifyTriangle(1, 2, 3));
    }

    @Test
    public void testClassifyNotATriangleWithZero() {
        Assert.assertEquals("Not a triangle", TriangleClassifier.classifyTriangle(0, 1, 1));
    }

    @Test
    public void testClassifyNotATriangleWithNegative() {
        Assert.assertEquals("Not a triangle", TriangleClassifier.classifyTriangle(-1, 2, 2));
    }

    @Test
    public void testClassifyMinimalEquilateral() {
        Assert.assertEquals("Equilateral", TriangleClassifier.classifyTriangle(1, 1, 1));
    }

    @Test
    public void testClassifyMinimalIsoscelesEdge() {
        Assert.assertEquals("Not a triangle", TriangleClassifier.classifyTriangle(1, 1, 2));
    }

    @Test
    public void testClassifyMinimalScalene() {
        Assert.assertEquals("Scalene", TriangleClassifier.classifyTriangle(2, 3, 4));
    }
}
