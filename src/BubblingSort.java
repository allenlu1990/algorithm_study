/**
 * @author allen
 * @date 2021年11月30日 16:56
 */
public class BubblingSort {
    public static void main(String[] args) {
        int[] array = {1, 6, 2, 9, 2,3,3,3,9,1,0};
        sort(array);
        for(int n : array){
            System.out.println(n);
        }
    }

    public static void sort(int[] array){
        for(int i =0; i < array.length; i++){
            for(int j=0; j < array.length -i-1; j++){
                if(array[j] > array[j+1]){
                    int tmp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }
}
