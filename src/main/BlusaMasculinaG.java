package main;

public class BlusaMasculinaG implements Blusa {
	private static Integer total = 0;
	public void contaBlusas() {
		total++;
	}
	@Override
	public String toString() {
		return "G-Masculina";
	}
	
	public static Integer getTotal() {
		return BlusaMasculinaG.total;
	}

}
