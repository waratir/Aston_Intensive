import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class MyMergeSort<E> {
    private static Object[] sortedList;

    public static <E> void sort(MyList<E> list) {
        sortedList = new Object[list.size()];
        Object[] workArray = new Object[list.size()];

        Object[] array = new Object[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        recMergeSort(array, workArray, 0, list.size() - 1);

        list.clear();
        for (int i = 0; i < sortedList.length; i++) {
            list.add((E) sortedList[i]);
        }
    }

    private static void recMergeSort(Object[] list, Object[] workArray, int lower, int upper) {
        if (lower == upper) {
            return;
        } else {
            int middle = (lower + upper) / 2;
            recMergeSort(list, workArray, lower, middle);
            recMergeSort(list, workArray, middle + 1, upper);
            merge(list, workArray, lower, middle + 1, upper);
        }

    }

    private static <T extends Comparable<T>> void merge(Object[] list, Object[] workArray, int lower, int middle, int upper) {
        Comparator<T> comparator = Comparable::compareTo;
        int i = 0;
        int lowerBound = lower;
        int mid = middle - 1;
        int n = upper - lower + 1;
        while ((lower <= mid) && (middle <= upper)) {
            if (comparator.compare((T) list[middle], (T) list[lower]) > 0) {
                workArray[i++] = list[lower++];
            } else {
                workArray[i++] = list[middle++];
            }
        }
        while (lower <= mid) {
            workArray[i++] = list[lower++];
        }
        while (middle <= upper) {
            workArray[i++] = list[middle++];
        }
        for (i = 0; i < n; i++) {
            sortedList[lowerBound + i] = workArray[i];
        }
    }

}
