package main;

public class BlusaFemininaGG implements Blusa {
	private static Integer total = 0;
	public void contaBlusas() {
		total++;
	}
	@Override
	public String toString() {
		return "<font color='#FF00FF'><strong>GG-Feminina</strong></font>";
	}
	
	public static Integer getTotal() {
		return BlusaFemininaGG.total;
	}

}
