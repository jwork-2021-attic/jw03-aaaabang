package S191220057;

import example.Sorter;


public class InsertSorter implements Sorter{

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


    @Override
    public void sort() {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            // 寻找元素 a[i] 合适的插入位置
           for( int j = i ; j > 0 ; j -- )
                if( a[j] < a[j-1] )
                    swap(j , j-1 );
                else
                    break;
        }
        
    }

    @Override
    public String getPlan() {
        return this.plan;
    }


    }