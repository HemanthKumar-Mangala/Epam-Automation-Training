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
	public static  String addTwoTimes(String time1,String time2)
	{
		String time1Hours=time1.split(":")[0];
		String time2Hours=time2.split(":")[0];
		
		String time1Minutes=time1.split(":")[1];
		String time2Minutes=time2.split(":")[1];
		
		int hh1=Integer.parseInt(time1Hours);
		int hh2=Integer.parseInt(time2Hours);
		
		int mm1=Integer.parseInt(time1Minutes);
		int mm2=Integer.parseInt(time2Minutes);
		
		int mm=mm1+mm2;
		int hh=hh1+hh2;
		
		
		if(mm>=60)
		{
			mm=mm-60;
			hh++;
		}
		
		return hh+":"+mm;
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
		System.out.println(Test.addTwoTimes("4:10","02:00"));
	}
    
}
