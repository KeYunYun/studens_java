
public class CellText {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tetromin t =new T(0,0) ;
		print(t);
		Tetromin t1;
		t1=new T(0,4);
		print(t1);
		
	}
	public static void print(Tetromin t ){
		for(int i=0;i<20;i++){
			for(int j=0;j<10;j++){
				boolean flag=true;
				for(int k=0;k<4;k++){
				if(i==t.cells[k].col&&j==t.cells[k].row){
					flag=false;
					System.out.print("* ");
					}
				}
				if(flag)
				{
					System.out.print("- ");
				}
			}
			System.out.println();
		}
	}
}
