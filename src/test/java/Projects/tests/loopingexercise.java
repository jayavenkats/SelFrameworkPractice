package Projects.tests;

public class loopingexercise {

	public static void main(String[] args) {
		loopingexercise le = new loopingexercise();
		le.multidimarray();
		
}

	public void nestedloops() {
		//1 2 3 4
		//5 6 7
		//8 9
		//10
		int j=0;
		for(int i=1;i<5;i++) {
 			
			for( j=4;i<=j;j--){
				System.out.print(j + "\t ");
			}
			System.out.println();
		}
		
	
	}
	
	public void multidimarray() {
		
		int a[][] = new int[2][2];
		
		a[0][0]= 4;
		a[0][1]= 2;
		a[1][0]= 3;
		a[1][1]= 5;
		
		for(int i=0; i<2; i++) {
			for(int j=0;j<2;j++) {
				System.out.print(a[i][j] +" ");
			}
			System.out.println();
		}
	}
}
