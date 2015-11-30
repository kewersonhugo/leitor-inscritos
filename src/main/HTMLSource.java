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
		
		if(!isSEMCamisa()){
			blusasTotal++;			
		}
	}
	
	private String validaSeTemCamisa(int posicaoArray){
		String tamanhoCamisa="SEMBlusa";
		if(!isSEMCamisa()){
			return tamanhoCamisa = textoDoArquivoSeparado[posicaoArray];
		}
		return tamanhoCamisa;
	}
	
	boolean isSEMCamisa(){
		return this.textoDoArquivoSeparado[3].contains("SEM");
	}
	
	public void gerarDados(Integer numero, String[] textoDoArquivoSeparado, int posicaoArray) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		this.textoDoArquivoSeparado = textoDoArquivoSeparado;
		Class classe = Class.forName("main.Blusa"+validaSeTemCamisa(posicaoArray)
				.replace("\"", "")
				.replace("-", "")
				.replace(" ", "")
				.replace("no", "na"));
		Object o = classe.newInstance();
		Blusa blusa = (Blusa) o;
		this.setarValores(numero, validaSePossuiNome(), blusa);
	}
	
	private String validaSePossuiNome(){
		if(getNome().isEmpty()){
			return getNomeDonoPayPal() + " - " + getEmail();
		}
		
		return getNome() + " - " + getEmail();
			
	}
	
	public String geraHTML(){
		stringsHTML.append("</table>");
		return stringsHTML.toString();
	}
	
	public String geraHTMLSemNomes(){
		return this.semNomes.toString();
	}
	
	public String getNome(){
		return this.textoDoArquivoSeparado[0].replace("\"", "");
	}
	
	public String getNomeDonoPayPal(){
		return this.textoDoArquivoSeparado[3].replace("\"", "");
	}
	
	public String getEmail(){
		return this.textoDoArquivoSeparado[12].replace("\"", "").toString();
	}
	
	public String totalBlusas(){
		totalBlusas.append("Total de Camisas: ").append(this.blusasTotal);
		totalBlusas.append("<br>");
		totalBlusas.append("Total Masculinas:").append("<br>");
		totalBlusas.append("Total P: ").append(BlusaMasculinaP.getTotal()).append("<br>");
		totalBlusas.append("Total M: ").append(BlusaMasculinaM.getTotal()).append("<br>");
		totalBlusas.append("Total G: ").append(BlusaMasculinaG.getTotal()).append("<br>");
		totalBlusas.append("Total GG: ").append(BlusaMasculinaGG.getTotal()).append("<br>");
		totalBlusas.append("Total Extra G: ").append(BlusaMasculinaEXG.getTotal()).append("<br>");
		totalBlusas.append("<br>");
		totalBlusas.append("Total Femininas:").append("<br>");
		totalBlusas.append("Total P: ").append(BlusaFemininaP.getTotal()).append("<br>");
		totalBlusas.append("Total M: ").append(BlusaFemininaM.getTotal()).append("<br>");
		totalBlusas.append("Total G: ").append(BlusaFemininaG.getTotal()).append("<br>");
		totalBlusas.append("Total GG: ").append(BlusaFemininaGG.getTotal()).append("<br>");
		totalBlusas.append("Total Inscritos SEM CAMISA: ").append(BlusaSEMBlusa.getTotal()).append("<br>");
		return totalBlusas.toString();
	}
	
	public List<String> getSemNomes(){
		return this.semNomes;
	}
}
