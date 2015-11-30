package main;

public class BlusaMasculinaP implements Blusa {
	private static Integer total = 0;
	public void contaBlusas() {
		total++;
	}
	@Override
	public String toString() {
		return "P-Masculina";
	}

	public static Integer getTotal() {
		return BlusaMasculinaP.total;
	}
	
}
