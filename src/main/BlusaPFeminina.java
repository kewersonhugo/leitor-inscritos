package main;

public class BlusaPFeminina implements Blusa {
	private static Integer total = 0;
	public void contaBlusas() {
		total++;
	}
	
	@Override
	public String toString() {
		return "P-Feminina";
	}

	public static Integer getTotal() {
		return BlusaPFeminina.total;
	}
	
}
