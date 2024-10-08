package assignment03;

import org.junit.Test;
import org.junit.Assert;

public class GradingSystemTest {

    @Test
    public void testGetGradeA() {
        Assert.assertEquals("A", GradingSystem.getGrade(92));
        Assert.assertEquals("A", GradingSystem.getGrade(90));
        Assert.assertEquals("A", GradingSystem.getGrade(100));
    }

    @Test
    public void testGetGradeB() {
        Assert.assertEquals("B", GradingSystem.getGrade(82));
        Assert.assertEquals("B", GradingSystem.getGrade(85));
        Assert.assertEquals("B", GradingSystem.getGrade(88));
    }

    @Test
    public void testGetGradeC() {
        Assert.assertEquals("C", GradingSystem.getGrade(72));
        Assert.assertEquals("C", GradingSystem.getGrade(75));
        Assert.assertEquals("C", GradingSystem.getGrade(78));
    }

    @Test
    public void testGetGradeD() {
        Assert.assertEquals("D", GradingSystem.getGrade(62));
        Assert.assertEquals("D", GradingSystem.getGrade(65));
        Assert.assertEquals("D", GradingSystem.getGrade(68));
    }

    @Test
    public void testGetGradeF() {
        Assert.assertEquals("F", GradingSystem.getGrade(50));
        Assert.assertEquals("F", GradingSystem.getGrade(59));
    }

    @Test
    public void testGetGradeInvalidScore() {
        Assert.assertEquals("Invalid score", GradingSystem.getGrade(-3));
        Assert.assertEquals("Invalid score", GradingSystem.getGrade(101));
    }
}
