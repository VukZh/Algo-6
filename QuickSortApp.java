package quicksort;

import java.util.Arrays;

public class QuickSortApp {

    public static void main(String[] args) {

        RandomArray ra = new RandomArray(100000, 100000);
//        ra.display();
        int RandomArray[] = ra.getArray();
        int RandomArray2[] = Arrays.copyOf(RandomArray, RandomArray.length);
        int RandomArray3[] = Arrays.copyOf(RandomArray, RandomArray.length);

        long timeStartA1 = System.currentTimeMillis();
        SimpleQuickSort qs1 = new SimpleQuickSort(RandomArray); // при массиве > 10000 переполнение стэка на упорядоченном массиве
        long timeStopA1 = System.currentTimeMillis() - timeStartA1;
//        qs1.displayQS();
        System.out.println("время выполнения быстрой простой сортировки " + timeStopA1 + " миллисекунд");

        long timeStartA2 = System.currentTimeMillis();
        QuickSort_randomize qs2 = new QuickSort_randomize(RandomArray2);
        long timeStopA2 = System.currentTimeMillis() - timeStartA2;
//        qs2.displayQSr();
        System.out.println("время выполнения быстрой сортировки с рандомом " + timeStopA2 + " миллисекунд");

        long timeStartA3 = System.currentTimeMillis();
        QuickSort_randomize qs3 = new QuickSort_randomize(RandomArray3, 9);
        long timeStopA3 = System.currentTimeMillis() - timeStartA3;
//        qs3.displayQSr();
        System.out.println("время выполнения быстрой сортировки с рандомом с InsertionSort " + timeStopA3 + " миллисекунд");

    }

}
