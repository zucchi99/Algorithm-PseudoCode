class SortAlgorithms {

	/*
	Insertion Sort
	T(n): O(n^2), To(n): θ(n), Tp(n): θ(n^2)

	Caso Migliore: θ(n) (array già ordinato -> tj = 1);
	Caso Peggiore: θ(n^2) (array ordinato contrario -> tj = j);
	T(n) = 2*c*n + 3*c*(n-1) + 2*c*Sum(j=2->n, tj) + 2*c*Sum(j=2->n, tj-1);
	*/		
	public void InsertionSort(int[] A) {
		for(int j = 2; j < A.length; j++) {
			int key = A[j];
			int i = j - 1;
			while(i >= 1 && A[i] > key) {
				A[i+1] = A[i];
				i = i - 1;
			}
			A[i+1] = key;
		}
	}

	/*
	Merge Sort
	T(n): θ(n log n)

	Caso Migliore = Caso Peggiore = Caso Medio: tempo costante;
	*/
    public void mergeSort(int[] array, int p, int q) {
        if(p < q) {
            int r = Math.floorDiv((p + q), 2);
            mergeSort(array, p, r);
            mergeSort(array, r+1, q);
            merge(array, p, q, r);
        }
	}
	
	public void merge(int[] A, int p, int q, int r) {
		int i = p;
		int j = r + 1;
		int k = 1;
		int[] temp = new int[A.length];
		while(i <= r && j <= q) {
			if(A[i] < A[j]) {
				temp[k] = A[i];
				i = i + 1;
			} else {
				temp[k] = A[j];
				j = j + 1;
			}
			k = k + 1;
		}
		while(i <= r) {
			temp[k] = A[i];
			i = i + 1;
			k = k + 1;
		}
	}
	
	/*
	Quick Sort
	T(n): O(n^2), To(n) = Tm(n): θ(n log n), Tp(n): θ(n^2)

	Caso Migliore: θ(n log n) (partition sempre sul mediano)
	Caso Peggiore: θ(n^2) (partition sempre sul min/max);
	T(n) = { θ(1) se n = 1			T(m) + T(n-m+1) se n > 1 }
	*/	
    public void quickSort(int[] array, int p, int q) {
        if(p < q) {
			int r = partition(array, p, q);
            quickSort(array, p, r-1);
            quickSort(array, r+1, q);
		}
	}
	
	/*
	Partition
	T(n) = θ(q-p) = θ(n) se p=0, q=n-1
	
    takes array[q] as pivot and places:
    	- elements <= pivot to his left [p, i-1]
    	- the pivot element at its correct position i in sorted array [i]
    	- elements > pivots to his right [i+1, q]
	*/
    public int partition(int[] array, int p, int q) {
        int x = array[q];
        int i = p - 1;
        for(int j = p; j <= q; j++) {
            if(array[j] <= x) {
                i++;
                swap(array, i, j);
            }
        }
        return i;
	}
	
    public  void swap(int[] array, int i ,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}