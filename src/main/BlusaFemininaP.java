package main;

public class BlusaFemininaP implements Blusa {
	private static Integer total = 0;
	public void contaBlusas() {
		total++;
	}
	
	@Override
	public String toString() {
		return "P-Feminina";
	}

	public static Integer getTotal() {
		return BlusaFemininaP.total;
	}
	
}
