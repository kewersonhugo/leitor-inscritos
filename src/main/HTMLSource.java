package main;

public class HTMLSource {
	private String tamanhoBlusa;
	private StringBuilder stringsHTML = new StringBuilder();
	private StringBuilder totalBlusas = new StringBuilder();
	private Integer blusasTotal = 0;
	private Integer totalBlusaP = 0;
	private Integer totalBlusaM = 0;
	private Integer totalBlusaG = 0;
	private Integer totalBlusaGG = 0;
	
	public HTMLSource(){
		stringsHTML.append("<table>").append("<tr><td>Nœmero</td><td>Nome</td><td>Blusa</td></tr>");
	}
	
	public void setarValores(Integer numero, String nome, String tamanhoBlusa){
		this.tamanhoBlusa = tamanhoBlusa;
		stringsHTML.append("<tr>")
		.append("<td>").append(numero).append("</td>");
		stringsHTML.append("<td>").append(nome).append("</td>");
		stringsHTML.append("<td>").append(tamanhoBlusa).append("</td>").append("</tr>");
	}
	
	public void somaBlusas(){
		blusasTotal++;
		if(this.tamanhoBlusa.equalsIgnoreCase("P")){
			totalBlusaP++;
		}
		
		if(this.tamanhoBlusa.equalsIgnoreCase("M")){
			totalBlusaM++;
		}
		
		if(this.tamanhoBlusa.equalsIgnoreCase("G")){
			totalBlusaG++;
		}
		
		if(this.tamanhoBlusa.equalsIgnoreCase("GG")){
			totalBlusaGG++;
		}
		
	}
	public String geraHTML(){
		stringsHTML.append("</table>");
		return stringsHTML.toString();
	}
	
	public String totalBlusas(){
		totalBlusas.append("Total:").append(this.blusasTotal);
		totalBlusas.append("Total P:").append(this.totalBlusaP);
		totalBlusas.append("Total M:").append(this.totalBlusaM);
		totalBlusas.append("Total G:").append(this.totalBlusaG);
		totalBlusas.append("Total GG:").append(this.totalBlusaGG);
		return totalBlusas.toString();
	}
}
