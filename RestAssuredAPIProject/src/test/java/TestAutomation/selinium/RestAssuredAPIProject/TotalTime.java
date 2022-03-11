package TestAutomation.selinium.RestAssuredAPIProject;

public class TotalTime {
	public static int converttominutes(String in) {
		String a1[]=in.split(" ");
		String b1[]=a1[1].split(":");
		int h1=Integer.parseInt(b1[0]);
		int m1=Integer.parseInt(b1[1]);
		return (m1+(h1*60));
	}
	
	public static int converttominutes2(String in) {
		String a1[]=in.split(" ");
		String hours=a1[0].substring(0,a1[0].length()-1);
		String min=a1[1].substring(0,a1[1].length()-1);
		int h=Integer.parseInt(hours);
		int m=Integer.parseInt(min);
		return (m+(h*60));
	}
}
