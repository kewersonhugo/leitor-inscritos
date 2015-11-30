package main;

public class BlusaMasculinaGG implements Blusa {
	private static Integer total = 0;
	public void contaBlusas() {
		total++;
	}
	@Override
	public String toString() {
		return "GG-Masculina";
	}
	
	public static Integer getTotal() {
		return BlusaMasculinaGG.total;
	}

}
