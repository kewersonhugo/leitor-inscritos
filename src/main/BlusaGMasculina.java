package main;

public class BlusaGMasculina implements Blusa {
	private static Integer total = 0;
	public void contaBlusas() {
		total++;
	}
	@Override
	public String toString() {
		return "G";
	}
	
	public static Integer getTotal() {
		return BlusaGMasculina.total;
	}

}
