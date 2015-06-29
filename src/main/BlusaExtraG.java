package main;

public class BlusaExtraG implements Blusa {
	private static Integer total = 0;
	public void contaBlusas() {
		total++;
	}
	@Override
	public String toString() {
		return "Extra G";
	}
	
	public static Integer getTotal() {
		return BlusaExtraG.total;
	}

}
