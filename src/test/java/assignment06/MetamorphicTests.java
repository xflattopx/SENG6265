package assignment06;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class MetamorphicTests {

    @Test
    public void testPathSymmetry() {
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("A", Arrays.asList("B", "C"));
        graph.put("B", Arrays.asList("A", "D"));
        graph.put("C", Arrays.asList("A", "D"));
        graph.put("D", Arrays.asList("B", "C"));

        List<String> forwardPath = BFSShortestPath.bfsShortestPath(graph, "A", "D");
        List<String> reversePath = BFSShortestPath.bfsShortestPath(graph, "D", "A");

        assertNotNull(forwardPath);
        assertNotNull(reversePath);
        assertEquals(forwardPath.size(), reversePath.size());
    }

    @Test
    public void testSubpathConsistency() {
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("A", Arrays.asList("B", "C"));
        graph.put("B", Arrays.asList("A", "D"));
        graph.put("C", Arrays.asList("A", "D"));
        graph.put("D", Arrays.asList("B", "C"));

        List<String> path = BFSShortestPath.bfsShortestPath(graph, "A", "D");

        assertNotNull(path);

        List<String> subpath = path.subList(0, 2);  // Example: A -> B

        List<String> subpathResult = BFSShortestPath.bfsShortestPath(graph, subpath.get(0), subpath.get(subpath.size() - 1));

        assertNotNull(subpathResult);
        assertEquals(subpath, subpathResult);
    }

    @Test
    public void testPathExtension() {
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("A", Arrays.asList("B", "C"));
        graph.put("B", Arrays.asList("A", "D"));
        graph.put("C", Arrays.asList("A", "D"));
        graph.put("D", Arrays.asList("B", "C"));

        List<String> initialPath = BFSShortestPath.bfsShortestPath(graph, "A", "D");

        graph.put("E", Arrays.asList("A"));
        graph.put("A", Arrays.asList("B", "C", "E"));

        List<String> extendedPath = BFSShortestPath.bfsShortestPath(graph, "A", "D");

        assertNotNull(initialPath);
        assertNotNull(extendedPath);

        assertTrue(extendedPath.size() >= initialPath.size());
        assertTrue(extendedPath.contains("A"));
        assertTrue(extendedPath.contains("D"));

        if (extendedPath.size() > initialPath.size()) {
            assertNotEquals(initialPath, extendedPath);
        }
    }

    @Test
    public void testIdentityProperty() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] sortedArr = ArraySorter.sortArray(arr.clone());
        assertArrayEquals(arr, sortedArr);
    }

    @Test
    public void testAdditionOfElement() {
        int[] arr = {1, 3, 5, 7};
        int[] sortedArr = ArraySorter.sortArray(arr.clone());

        int[] newArr = {1, 3, 5, 7, 2};
        int[] sortedNewArr = ArraySorter.sortArray(newArr.clone());

        int[] expectedArr = {1, 2, 3, 5, 7};
        assertArrayEquals(expectedArr, sortedNewArr);
    }

    @Test
    public void testRemovalOfElement() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] sortedArr = ArraySorter.sortArray(arr.clone());

        int[] newArr = {2, 3, 4, 5};
        int[] sortedNewArr = ArraySorter.sortArray(newArr.clone());

        assertArrayEquals(newArr, sortedNewArr);
    }

}
