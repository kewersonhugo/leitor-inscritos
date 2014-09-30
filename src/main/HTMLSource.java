package main;

public class HTMLSource {
	private StringBuilder stringsHTML = new StringBuilder();
	private StringBuilder totalBlusas = new StringBuilder();
	private Integer blusasTotal = 0;
	
	public HTMLSource(){
		stringsHTML.append("<table>").append("<tr><td>Nœmero</td><td>Nome</td><td>Blusa</td></tr>");
	}
	
	public void setarValores(Integer numero, String nome, Blusa blusa){
		stringsHTML.append("<tr>")
		.append("<td>").append(numero).append("</td>");
		stringsHTML.append("<td>").append(nome).append("</td>");
		stringsHTML.append("<td>").append(blusa.toString()).append("</td>").append("</tr>");
		blusa.contaBlusas();
		blusasTotal++;
	}
	
	public String geraHTML(){
		stringsHTML.append("</table>");
		return stringsHTML.toString();
	}
	
	public String totalBlusas(){
		totalBlusas.append("Total: ").append(this.blusasTotal);
		totalBlusas.append("Total P: ").append(BlusaP.getTotal());
		totalBlusas.append("Total M: ").append(BlusaM.getTotal());
		totalBlusas.append("Total G: ").append(BlusaG.getTotal());
		totalBlusas.append("Total GG: ").append(BlusaGG.getTotal());
		return totalBlusas.toString();
	}
}
