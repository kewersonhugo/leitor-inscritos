package main;

public class BlusaSEMBlusa implements Blusa {
	private static Integer total = 0;
	public void contaBlusas() {
		total++;
	}
	@Override
	public String toString() {
		return "<font color='#FF0000'><strong>SEM CAMISA</strong></font>";
	}
	
	public static Integer getTotal() {
		return BlusaSEMBlusa.total;
	}

}
