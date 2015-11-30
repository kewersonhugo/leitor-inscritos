package main;

public class BlusaFemininaGG implements Blusa {
	private static Integer total = 0;
	public void contaBlusas() {
		total++;
	}
	@Override
	public String toString() {
		return "GG-Feminina";
	}
	
	public static Integer getTotal() {
		return BlusaFemininaGG.total;
	}

}
