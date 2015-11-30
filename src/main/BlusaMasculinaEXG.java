package main;

public class BlusaMasculinaEXG implements Blusa {
	private static Integer total = 0;
	public void contaBlusas() {
		total++;
	}
	@Override
	public String toString() {
		return "Extra G";
	}
	
	public static Integer getTotal() {
		return BlusaMasculinaEXG.total;
	}

}
