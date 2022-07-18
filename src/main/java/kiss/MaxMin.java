package kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return comparingMethod(value, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {

        return comparingMethod(value, comparator.reversed());
}
        private static <T> T comparingMethod(List<T> value, Comparator<T> comparator) {
            T rsl = value.get(0);
            for (T elem : value) {
                if (comparator.compare(rsl, elem) < 0) {
                    rsl = elem;
                }
            }
            return rsl;
        }
    }
