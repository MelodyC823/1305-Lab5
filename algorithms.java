public class algorithms {

    static void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    //linear search
    static int linear_search(int arr[], int target){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == target)
                return i;

    }
    return -1;
}
    //binary_search
    static int binary_search(int arr[], int target){
        int l = 0;
        int r = arr.length-1;

        while(l <= r) {
            int m = (l+r) /2;
            if (arr[m] == target)
                return m;
            else{
                if(target < arr[m]){
                    r = m - 1;
                }else{
                    l = m +1;
                }
            }
        } return -1;
    }

    //bubble_sort
    static void bubble_sort(int []arr){
        for(int i = arr.length - 1; i > 0; i-- ){
            for(int j = 0; j < i; j++){
                if(arr[j] > arr[j+1])
                    swap(arr, j , j+1);
            }
        }
    }

    //selection_sort
    static void selection_sort(int [] arr){
        for(int i = 0; i < arr.length ; i++){

            int min = 999999;
            int smallest_index = -1;
            for(int j = i ; j < arr.length; j++){
                if(arr[j] < min){
                    min = arr[j];
                    smallest_index = j;
                }
            }

            swap(arr, i, smallest_index);
        }
    }

    //insertion_sort
    static void insertion_sort(int [] arr) {
        for (int i = 1; i < arr.length; i++) {

            int j = i;
            int tmp = arr[j];
            while (j > 0 && arr[j - 1] > tmp) {
                // shift
                arr[j] = arr[j - 1];
                j--;
            }
            // place
            arr[j] = tmp;

        }
    }


    static void merge(int []arr, int l , int m, int  r){
        int size_left = m - l + 1;
        int size_right = r -m;

        int []left_tmp_array = new int [size_left];
        int []right_tmp_array = new int [size_right];


        for(int i = 0; i < size_left; i++){
            left_tmp_array[i] = arr[l + i];
        }

        for(int i = 0; i < size_right; i++){
            right_tmp_array[i] = arr[m + 1 + i];
        }


        int iterator_left = 0;
        int iterator_right = 0;

        int iterator = l;
        while(iterator_left < size_left && iterator_right < size_right){
            if(left_tmp_array[iterator_left] < right_tmp_array[iterator_right]){
                arr[iterator] = left_tmp_array[iterator_left];
                iterator_left++;
            }else{
                arr[iterator] = right_tmp_array[iterator_right];
                iterator_right++;
            }
            iterator++;
        }


        while(iterator_left< size_left){
            arr[iterator] = left_tmp_array[iterator_left];
            iterator_left++;
            iterator++;
        }

        while(iterator_right< size_right){
            arr[iterator] = right_tmp_array[iterator_right];
            iterator_right++;
            iterator++;
        }
    }


    static void merge_sort(int []arr,int l, int r ){

        if(r > l){
            int m = (r + l)/2; // bad middle point
            merge_sort(arr, l, m);  // passing indices
            merge_sort(arr,m + 1, r);  // passing indices
            merge(arr, l, m, r); // passing indices
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[10];
        //arr = new int[]{10, 20, 30, 15, 25, 3};

        arr = new int[]{12,59,6,30,15,41};
        //bubble_sort(arr);
        //selection_sort(arr);
        //insertion_sort(arr);
        merge_sort(arr,0,arr.length-1);

        for(int x : arr){
            System.out.println(x);
        }
        //arr = new int[]{10,12,30,41,59,60};
        //int target = 12;
        //System.out.println(binary_search(arr, target));

        //System.out.println(linear_search(arr, target));      //index 5
        //System.out.println(linear_search(arr, 44));   //target doesn't exist, return -1
    }

}

