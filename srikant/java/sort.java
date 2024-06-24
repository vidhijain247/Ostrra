class sort {
	public static void main(String[] args){
		int[] arr = new int[]{72,51,30,17,13,47,31,7,15,3};

		System.out.println("Unsorted list - ");
		for(int i : arr)
			System.out.print(i + " ");
		System.out.println();

		for(int i = 0; i < arr.length; i++){
			for(int j = i + 1; j < arr.length; j++){
				if(arr[j] < arr[i]){
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}

		System.out.println("Sorted list - ");
		for(int i : arr)
			System.out.print(i + " ");

		
	}
}