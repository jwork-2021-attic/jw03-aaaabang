package S191220057;

import example.Sorter;

public class QuickSorter implements Sorter{
    private int[] a;
    private String plan = "";//改进

    @Override
    public void load(int[] a) {
        this.a = a;
    }

    private void swap(int i, int j) {
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        plan += "" + a[i] + "<->" + a[j] + "\n";
    }

    private int[] quickSort(int[] arr, int left,int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex-1);
            quickSort(arr, partitionIndex+1, right);
        }
        return arr;
    }
    
    private int  partition(int[] arr,int left ,int right) {     // 分区操作
        int pivot = left;                     // 设定基准值（pivot）
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(i, index);
                index++;
            }        
        }
        swap(pivot, index - 1);
        return index-1;
    }
    
    @Override
    public void sort() {
        quickSort(a, 0, a.length - 1);
    }

    @Override
    public String getPlan() {
        return this.plan;
    }
}
