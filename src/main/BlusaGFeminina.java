package main;

public class BlusaGFeminina implements Blusa {
	private static Integer total = 0;
	public void contaBlusas() {
		total++;
	}
	@Override
	public String toString() {
		return "G-Feminina";
	}
	
	public static Integer getTotal() {
		return BlusaGFeminina.total;
	}

}
