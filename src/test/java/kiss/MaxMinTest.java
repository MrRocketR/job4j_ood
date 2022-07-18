package kiss;


import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class MaxMinTest {
    List<Integer> values = List.of(1, 22, 55, 100, 45, 52);
    MaxMin maxMin = new MaxMin();

    @Test
    public void whenMaxInt() {
        int test = maxMin.max(values, Integer::compareTo);
        assertEquals(100, test);
    }

    @Test
    public void whenMinInt() {
        int test =  maxMin.min(values, Integer::compareTo);
        assertEquals(1, test);
    }

}