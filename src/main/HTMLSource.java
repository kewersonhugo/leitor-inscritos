package main;

public class HTMLSource {

	private StringBuilder stringsHTML = new StringBuilder();
	
	public HTMLSource(){
<<<<<<< HEAD
		stringsHTML.append("<table>").append("<tr><td>NÃºmero</td><td>Nome</td><td>Blusa</td></tr>");
=======
		stringsHTML.append("<table>").append("<tr><td>Nœmero</td><td>Nome</td><td>Blusa</td></tr>");
>>>>>>> 64a427ef07450f1432e7752a0d88cf129e6ec1e8
	}
	
	public void setarValores(Integer numero, String nome, String tamanhoBlusa){
		stringsHTML.append("<tr><td>").append(numero).append("</td>");
		stringsHTML.append("<tr><td>").append(nome).append("</td>");
		stringsHTML.append("<td>").append(tamanhoBlusa).append("</td>").append("</tr>");
	}
	public String geraHTML(){
		stringsHTML.append("</table>");
		return stringsHTML.toString();
	}
}
