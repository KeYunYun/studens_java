package over;

public class Over {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Coo c=new Coo();
		Aoo o=new Boo();
		c.t(o);
	}

}

class Aoo{
	public void show(){
		System.out.println("111");
	}
}
class Boo extends Aoo{
	public void show(){
		System.out.println("222");
	}
}
class Coo{
	public void t(Aoo o){
		System.out.println("333");
		o.show();
	}
	public void t(Boo o){
		System.out.println("444");
		o.show();
	}
}
