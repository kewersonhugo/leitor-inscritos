package main;

public class BlusaMMasculina implements Blusa {
	private static Integer total = 0;
	public void contaBlusas() {
		total++;
	}
	@Override
	public String toString() {
		return "M";
	}

	public static Integer getTotal() {
		return BlusaMMasculina.total;
	}
	

}