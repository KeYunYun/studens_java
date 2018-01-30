package interfacetext;

public class InterFaceT {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Abs a= new Aoo();
		Abs b =new Boo();
		b.b();
		a.b();
		Inter a1=new Aoo();
		a1.a();
		Abs a2=new Aoo();
		Aoo a3=(Aoo)a2;
		
		System.out.println(a3 instanceof Aoo);
	}

}
interface Inter{
	abstract void a();
}
abstract class Abs{
	abstract void b();
}
class Aoo extends Abs implements Inter{
	
	@Override
	void b() {
		// TODO Auto-generated method stub
		System.out.println( "aoo.b");
	}

	@Override
	public void a() {
		// TODO Auto-generated method stub
		System.out.println( "aoo.a");
	}
	
}
class Boo extends Abs{

	@Override
	void b() {
		// TODO Auto-generated method stub
		System.out.println( "boo.b");
	}
	
}
