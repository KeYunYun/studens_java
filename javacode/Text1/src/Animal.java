
public class Animal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			cat cat1=new cat();
			cat1.setfood();
			cat1.setleg();
			cat1.sound();
			cat1.setname();
			cat1.setage();
			cat1.setgender();
			
			cat cat2=cat1;
			cat2.setname();
			cat2.sound();
			
			
			
			
	}
	
	
}
class Bioy{
	String leg;
	String food;
	String sound;
	Bioy()
	{
		leg="��һ��������";
		 food="��һ��������";
		 sound="��һ�������";	
		 System.out.println("����");
	}
	public void setleg()
	{
		System.out.println("leg"+leg);
	}
	public void setfood()
	{
		System.out.println("food"+food);
		
	}
	public void sound()
	{
		System.out.println("sound"+sound);
	}
}

class Pet extends Bioy{
	private String name;
	private String age;
	private String gender;
	Pet()
	{		
		name="����";
		age="25";
		gender="����";
	}

	void getname(String n)
	{
		this.name=n;
	}
	 void setname()
	{
		System.out.println("�������˵�����"+name);
	}
	
	 void setage()
		{
			System.out.println("�������˵�����"+age);
		}
	 void setgender()
		{
			System.out.println("�������˵��Ա�"+gender);
		}
}
class cat extends Pet
{
	cat()
	{
		 leg="è����ֻ��";
		food="è������";
		sound="����";	
		System.out.println("è");
	}
}
class dog extends Pet
{
	dog()
	{
		 leg="������ֻ��";
		 food="�����Թ�ͷ";
		 sound="����";	
		 System.out.println("��");
	}
}
