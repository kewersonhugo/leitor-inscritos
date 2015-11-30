package main;

public class BlusaFemininaM implements Blusa {
	private static Integer total = 0;
	public void contaBlusas() {
		total++;
	}
	@Override
	public String toString() {
		return "M-Feminina";
	}

	public static Integer getTotal() {
		return BlusaFemininaM.total;
	}
	

}
