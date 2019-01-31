package quicksort;

public class SimpleQuickSort {

    private int[] arr;

    public SimpleQuickSort(int[] a) {
        arr = a;
        quicksort(0, arr.length - 1);
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
            int pivot = arr[right]; // опорный элемент - правый в подмассиве
            int part = partition(left, right, pivot); // разбиение диапазона на два
            quicksort(left, part - 1); // рекурсионный вызов для левого диапазона
            quicksort(part + 1, right); // -''- правого
        }
    }

    public int partition(int left, int right, int pivot) {

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
        swap(leftPart, right); // перемещаем опорный элемент справа
        return leftPart; // позиция опорного элемента 
    }

    public void displayQS() {
        System.out.println("QuickSortArray:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " - ");
        }
        System.out.println();
    }

}
