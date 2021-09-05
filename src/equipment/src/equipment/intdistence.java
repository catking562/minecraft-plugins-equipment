package equipment;

import java.util.Random;

public class intdistence {
	
	private int minint;
	private int maxint;
	
	public intdistence(int minint, int maxint) {
		this.minint = minint;
		this.maxint = maxint;
	}
	
	public int getmin() {
		return minint;
	}
	
	public int getmax() {
		return maxint;
	}
	
	public int random() {
		return new Random().nextInt(maxint - minint) + minint;
	}

}
