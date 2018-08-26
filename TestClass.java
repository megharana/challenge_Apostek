import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        TestClass tc = new TestClass();
        //Scanner
        int[] queryAndCount = new int[2];
        Scanner s1 = new Scanner(System.in);
        int iterator1=0;

        while(iterator1<2)
        {
            queryAndCount[iterator1]=s1.nextInt(); // accepts N and Q in an array
            ++iterator1;
        }
        int N = queryAndCount[0]; //denoting the number of elements in array
        int Q = queryAndCount[1]; //number of queries
        if(N>=1 && N<=100000){
	       	int[] elements = new int[N]; //array containing elements in which query works on 
	        Scanner s2 = new Scanner(System.in);
			int iterator2 = 0;

			while(iterator2 < N)
			{
				if(s2.hasNextInt()){
					elements[iterator2] = s2.nextInt(); //accepting the elements
				}
				iterator2++;
			}

	        for (int i=0; i<N; i++){
	            System.out.print(elements[i]+"\t"); //printing all elements
	        }
			int query=0,index=0;
			int[] resultArray = new int[2];
			Scanner s3 = new Scanner(System.in);
			for(int iterator3=0;iterator3<Q;iterator3++){
				query = s3.nextInt();
				index = s3.nextInt();
				if(index>=1 && index<=N){
					if(query == 0){
						System.out.println("Executing query 0...");
						resultArray=tc.query0(index,N,elements);
						System.out.println("the nearest Left 1"+resultArray[0]);

						System.out.println("the nearest Right 1"+resultArray[1]);
					}
					else if(query == 1){
						System.out.println("Executing query 1...");
						tc.query1(index,N,elements);
					}
					else{
						System.out.println("Invalid query number");
					}
				}
				else{
					System.out.println("index can be between 1 to "+N);
				}			
			}
			s1.close();
			s2.close();
			s3.close();
        }
        else{
        	System.out.println("Size of elements array can be between 1 to 100000 ");
        }
	}
	//query0 returns the nearest left and nearest right element from position index in the array whose value is 1.
	public int[] query0(int index,int N,int elements[]){
		int[] left = new int[index]; // takes the elements which are left from elements[index]
		int[] right = new int[N-index-1]; // takes the elements which are right from elements[index]
		int[] resultArray = new int[2]; // takes the index of '1' which are nearest left and nearest right to element[index] 
		int nearestRight=-1,nearestLeft=-1;

		for(int j = 0 ; j<index ; j++){ //array for all left side elements from elements[index]
			left[j] = elements[j];
		}
		int j=0;
		for(int i = index + 1 ; i<N  ; i++){ //array for all right side elements from elements[index]

			right[j] = elements[i];
			j++;
		}
		for(int i = index-1 ; i>0 ; i--){ //traversing the left side of elements[index] to find nearest 1
			if(left[i]==1)
			{
				nearestLeft=i;
				break;
			}
		}
		for(int i = 0 ; i<N-index-1 ; i++){  //traversing the right side of elements[index] to find nearest 1
			if(right[i]==1)
			{
				nearestRight=i+index+1;
				break;
			}
		}		
		resultArray[0] = nearestLeft;
		resultArray[1] = nearestRight;
		return resultArray;
	} 
	//query1 resetting elements[index] if  previous value is 0
	public void query1(int index,int N,int elements[]){
		for (int i=0; i<N;i++){
			if(elements[index-1]==0)
				elements[index]=1;
		}
		System.out.println("\n The changed Array");
		for (int i=0; i<N;i++){
			System.out.println(elements[i]+"\t");
		}
	}
}
