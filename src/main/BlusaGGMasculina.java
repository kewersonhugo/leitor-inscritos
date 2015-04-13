package main;

public class BlusaGGMasculina implements Blusa {
	private static Integer total = 0;
	public void contaBlusas() {
		total++;
	}
	@Override
	public String toString() {
		return "GG";
	}
	
	public static Integer getTotal() {
		return BlusaGGMasculina.total;
	}

}
