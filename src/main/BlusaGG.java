package main;

public class BlusaGG implements Blusa {
	private static Integer total = 0;
	public void contaBlusas() {
		total++;
	}
	@Override
	public String toString() {
		return "GG";
	}
	
	public static Integer getTotal() {
		return BlusaGG.total;
	}

}
