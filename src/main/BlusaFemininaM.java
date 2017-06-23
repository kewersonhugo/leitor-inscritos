package main;

public class BlusaFemininaM implements Blusa {
	private static Integer total = 0;
	public void contaBlusas() {
		total++;
	}
	@Override
	public String toString() {
		return "<font color='#FF00FF'><strong>M-Feminina</strong></font>";
	}

	public static Integer getTotal() {
		return BlusaFemininaM.total;
	}
	

}
