import java.util.Collection;
import java.util.List;

public class TestMyArrayList {
    public static void main(String[] args) {
        MyList<Integer> testList = new MyArrayList<>();
        testList.add(2);
        testList.add(2);
        testList.add(3);
        testList.add(4);

        MyList<Integer> testList2 = new MyArrayList<>();
        testList2.addAll(List.of(6, 7, 8, 3, 4, 5, 6, 7, 8));
        MyMergeSort.sort(testList2);
        System.out.println(testList2);
    }
}
