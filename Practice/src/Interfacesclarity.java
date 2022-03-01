import java.util.*;
import java.util.function.Predicate;





class Test 
{

	int a;
	Test(int a)
	{
		this.a=a;
	}
	
	public int getint()
	{
		return  this.a;
	}
	
}


public class Interfacesclarity {
	
	public void filter(ArrayList<Test>al, Predicate<Test>p)
	{
		 Iterator<Test> i = al.iterator();
		 while(i.hasNext())
		 {
			 if(p.test(i.next()))
			 {
				 i.remove();
			 }
		 }
	}
	
	public static void main(String[] args) {
		Interfacesclarity obj=new Interfacesclarity();
		ArrayList<Test>l=new ArrayList<Test>();
		Test t1=new Test(5);
		l.add(t1);
		Test t2=new Test(6);
		l.add(t2);
		Test t3=new Test(7);
		l.add(t3);
		obj.filter(l,t->t.a%2==0);
		//obj.filter(l,(Test y)->y.a%2==0);
		for(Test t:l)
		{
			System.out.println(t.getint());
		}
	}
    
}
