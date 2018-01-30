
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
		leg="不一定都有腿";
		 food="不一定都有嘴";
		 sound="不一定都会叫";	
		 System.out.println("生物");
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
		name="老王";
		age="25";
		gender="汉子";
	}

	void getname(String n)
	{
		this.name=n;
	}
	 void setname()
	{
		System.out.println("宠物主人的名字"+name);
	}
	
	 void setage()
		{
			System.out.println("宠物主人的年龄"+age);
		}
	 void setgender()
		{
			System.out.println("宠物主人的性别"+gender);
		}
}
class cat extends Pet
{
	cat()
	{
		 leg="猫有四只脚";
		food="猫爱吃鱼";
		sound="喵喵";	
		System.out.println("猫");
	}
}
class dog extends Pet
{
	dog()
	{
		 leg="狗有四只脚";
		 food="狗爱吃骨头";
		 sound="汪汪";	
		 System.out.println("狗");
	}
}
