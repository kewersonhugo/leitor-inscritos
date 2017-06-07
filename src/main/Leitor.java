package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class Leitor {

	private static final int POSICAO_BLUSA = Configuracoes.POSICAO_BLUSA;
	private static HTMLSource html = new HTMLSource();

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		BufferedReader br = null;

		try {
			br = carregaArquivo();
			String textoDoArquivo = br.readLine();
			
			int cont = 0;
			while (textoDoArquivo != null) {
				String[] textoDoArquivoSeparado = textoDoArquivo.split(Configuracoes.SPLIT);
				String tamanho = pegaTamanhoBlusaPelaPosicao(textoDoArquivoSeparado);
				
				cont = gerarDados(cont, html, textoDoArquivoSeparado, tamanho);
				textoDoArquivo = br.readLine();
			}

			OutputStream os = new FileOutputStream("inscritos.html", false);
			OutputStreamWriter osw = new OutputStreamWriter(os,Charset.forName("ISO-8859-15"));
			BufferedWriter bw = new BufferedWriter(osw);
			bw.newLine();
			bw.write(html.geraHTML());
			bw.write(html.totalBlusas());
			
			System.out.println(html.totalBlusas());
			
			bw.close();
		} catch (FileNotFoundException e) {
			System.out.println("N�o foi poss�vel encontrar o arquivo.");
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			System.out.println("Encode n�o suportado.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao tentar ler o arquivo.");
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static BufferedReader carregaArquivo() throws IOException{
		BufferedReader br = null;
		InputStream is = new FileInputStream("inscritos.csv");
		InputStreamReader isr = new InputStreamReader(is, Charset.forName("UTF-8"));
		br = new BufferedReader(isr);
		return br;
	}
	
	public static String pegaTamanhoBlusaPelaPosicao(String[] textoDoArquivoSeparado){
		String tamanho = "";
		
		if(!textoDoArquivoSeparado[POSICAO_BLUSA].isEmpty()){
			tamanho = textoDoArquivoSeparado[POSICAO_BLUSA];
		}
		
		return tamanho;
	}

	private static int gerarDados(int cont, HTMLSource html, String[] textoDoArquivoSeparado, String tamanho)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		if(tamanho != null && !tamanho.isEmpty()){
			html.gerarDados(new Integer(cont), textoDoArquivoSeparado, POSICAO_BLUSA);
			cont++;
		}
		return cont;
	}
	
	
	
}
