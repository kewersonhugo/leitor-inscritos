package main;

public class BlusaP implements Blusa {
	private static Integer total = 0;
	public void contaBlusas() {
		total++;
	}
	@Override
	public String toString() {
		return "P";
	}

	public static Integer getTotal() {
		return BlusaP.total;
	}
	
}
