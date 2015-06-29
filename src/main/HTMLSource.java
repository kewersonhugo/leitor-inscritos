package main;

import java.util.ArrayList;
import java.util.List;

public class HTMLSource {
	private StringBuilder stringsHTML = new StringBuilder();
	private StringBuilder totalBlusas = new StringBuilder();
	private Integer blusasTotal = 0;
	private List<String> semNomes = new ArrayList<>();
	private String[] textoDoArquivoSeparado;
	private String nome;
	private String email;
	private String nomeDonoPayPal;
	
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
	
	public void gerarDados(Integer numero, String[] textoDoArquivoSeparado) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		this.textoDoArquivoSeparado = textoDoArquivoSeparado;
		Class classe = Class.forName("main.Blusa"+textoDoArquivoSeparado[26].replace("\"", "").replace("-", "").replace(" ", ""));
		Object o = classe.newInstance();
		Blusa blusa = (Blusa) o;
		this.setarValores(numero, validaSePossuiNome(), blusa);
	}
	
	private String validaSePossuiNome(){
		if(getNome().isEmpty()){
			return getNomeDonoPayPal();
		}
		
		return getNome();
			
	}
	
	public String geraHTML(){
		stringsHTML.append("</table>");
		return stringsHTML.toString();
	}
	
	public String geraHTMLSemNomes(){
		return this.semNomes.toString();
	}
	
	public String getNome(){
		return this.textoDoArquivoSeparado[28].replace("\"", "");
	}
	
	public String getNomeDonoPayPal(){
		return this.textoDoArquivoSeparado[3].replace("\"", "");
	}
	
	public String getEmail(){
		return this.textoDoArquivoSeparado[13].replace("\"", "").toString();
	}
	
	public String totalBlusas(){
		totalBlusas.append("Total de Camisas: ").append(this.blusasTotal);
		totalBlusas.append("<br>");
		totalBlusas.append("Total Masculinas:").append("<br>");
		totalBlusas.append("Total P: ").append(BlusaPMasculina.getTotal()).append("<br>");
		totalBlusas.append("Total M: ").append(BlusaMMasculina.getTotal()).append("<br>");
		totalBlusas.append("Total G: ").append(BlusaGMasculina.getTotal()).append("<br>");
		totalBlusas.append("Total GG: ").append(BlusaGGMasculina.getTotal()).append("<br>");
		totalBlusas.append("Total Extra G: ").append(BlusaExtraG.getTotal()).append("<br>");
		totalBlusas.append("<br>");
		totalBlusas.append("Total Femininas:").append("<br>");
		totalBlusas.append("Total P: ").append(BlusaPFeminina.getTotal()).append("<br>");
		totalBlusas.append("Total M: ").append(BlusaMFeminina.getTotal()).append("<br>");
		totalBlusas.append("Total G: ").append(BlusaGFeminina.getTotal()).append("<br>");
		totalBlusas.append("Total GG: ").append(BlusaGGFeminina.getTotal()).append("<br>");
		return totalBlusas.toString();
	}
	
	public List<String> getSemNomes(){
		return this.semNomes;
	}
}
