package sort;

/**
 * @author allen
 * @date 2021年11月30日 16:18
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = {1, 6, 2, 9, 2,3,3,3,9,1,0};
        sort(array,0,array.length-1);
        for(int n : array){
            System.out.println(n);
        }
    }

    public static void sort(int[] array, int l, int r){
        if(l < r){
            int i =l;
            int j =r;
            int tmp = array[i];
            while (i<j){
                //从右往左找比tmp小的数
                for(;j>i;j--){
                    if(array[j] < tmp){
                        array[i] = array[j];
                        break;
                    }
                }

                //从左往右找比tmp大的数
                for(;i<j;i++){
                    if(array[i] > tmp){
                        array[j] = array[i];
                        break;
                    }
                }
            }

            array[i] = tmp;

            sort(array,l,i-1);
            sort(array,i+1, r);
        }
    }
}
