
public class ThisTest {
	public static void main(String[] args) {
		Time1 time1 = new Time1();
		Time1 time2 = new Time1(14,04,04);
		Time1 time3 = new Time1(14,04);
		Time1 time4 = new Time1(14);
		System.out.println(time1.buildString());
		System.out.println(time2.buildString());
		System.out.println(time3.buildString());
		System.out.println(time4.buildString());
	}
}

class Time1 {
	private int h;
	private int m;
	private int s;
	
	public Time1(int hour, int minute, int second) {
		this.h = hour;
		this.m = minute;
		this.s = second;
		if(hour < 0 || hour >= 24 || minute < 0 || minute > 60 ||
				second < 0 || second >= 60) {
			throw new IllegalArgumentException(""
					+ "hour, minute and/or second was out of range");
		}
		
	}
	
	public Time1(int hour, int minute) {
		this(hour, minute, 13);
	}
	
	public Time1(int hour) {
		this(hour, 13, 13);
	}
	
	public Time1() {
		this(13, 13, 13);
	}
	
	public Time1(Time1 time) {
		this(time.h,time.m,time.s);
	}

	public String toUniversalString() {
		return String.format("%02d:%02d:%02d:", this.h,this.m,this.s);
	}

	public String buildString() {
		return String.format("%d:%02d:%02d %s", ((h == 0 || h == 12 ) ? 12 : 
			h % 12), m, s, (h < 12 ? "AM" : "PM"));
	}


}
