package sf.mephi.study;

import java.util.Comparator;
import java.util.List;

public class MyCollection {
    public static <T extends Comparable<? super T>> int binarySearch(List<T> list, T key) {
        return binarySearch(list, key, Comparator.naturalOrder());
    }

    // Binary search for Lists with a Comparator
    public static <T> int binarySearch(List<T> list, T key, Comparator<? super T> c) {
        int fromIndex = 0, toIndex = list.size();
        while (fromIndex < toIndex) {
            int mid = (fromIndex + toIndex) >>> 1;
            int cmp = c.compare(list.get(mid), key);
            if (cmp < 0) {
                fromIndex = mid + 1;
            } else if (cmp > 0) {
                toIndex = mid;
            } else {
                return mid;
            }
        }
        return -(fromIndex + 1);
    }
}
