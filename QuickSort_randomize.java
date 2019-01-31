package quicksort;

public class QuickSort_randomize {

    private int[] arr;

    public QuickSort_randomize(int[] a) {
        arr = a;
        quicksort(0, arr.length - 1);
    }

    public QuickSort_randomize(int[] a, int sizeIns) { // быстрая сортировка со вставкой
        arr = a;
        quicksortIns(0, arr.length - 1, sizeIns);
    }

    public void swap(int var1, int var2) { // перестановка элементов массива
        int temp = arr[var1];
        arr[var1] = arr[var2];
        arr[var2] = temp;
    }

    public void quicksort(int left, int right) {
        if (right - left <= 0) // подмассив стал <= 1, значит уже отсортирован
        {
            return;
        } else {
            int part = partition(left, right); // разбиение диапазона на два
            quicksort(left, part - 1); // рекурсионный вызов для левого диапазона
            quicksort(part + 1, right); // -''- правого
        }
    }

    public void quicksortIns(int left, int right, int sizeIns) {
        if (right - left <= 0) // подмассив стал <= 1, значит уже отсортирован
        {
            return;
        } else if (right - left < sizeIns) {
            insertionSort(left, right); //подмассив стал <= sizeIns, значит делаем insertionSort вместо разбиения и рекурсии
        } else {
            int part = partition(left, right); // разбиение диапазона на два
            quicksort(left, part - 1); // рекурсионный вызов для левого диапазона
            quicksort(part + 1, right); // -''- правого
        }
    }

    public int partition(int left, int right) {
        int pivotIndex = left + (int) (Math.random() * (right - left + 1));
        swap(pivotIndex, right); // опорный элемент располагаем справа        
        int pivot = arr[right];
        int leftPart = left - 1;
        int rightPart = right;
        while (true) {
            while (arr[++leftPart] < pivot); //поиск бОльшего элемента в левом диапазоне
            while (arr[--rightPart] > pivot && rightPart > 0); //поиск мЕньшего элемента в правом диапазоне
            if (leftPart >= rightPart) {
                break; // разбиение закончено;
            } else {
                swap(leftPart, rightPart);
            }
        }
        swap(leftPart, right);   // возврат опорного элемента
        return leftPart; // позиция опорного элемента 
    }

    public void displayQSr() {
        System.out.println("QuickSortArray:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " - ");
        }
        System.out.println();
    }

    public void insertionSort(int left, int right) {

        int in, out;
        for (out = left + 1; out <= right; out++) {
            int tmp = arr[out];
            in = out;
            while (in > left && arr[in - 1] >= tmp) {
                arr[in] = arr[in - 1];
                --in;
            }
            arr[in] = tmp;
        }

    }

}
