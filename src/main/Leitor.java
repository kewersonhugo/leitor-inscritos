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

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		BufferedReader br = null;

		try {
			InputStream is = new FileInputStream("inscritos.csv");
			InputStreamReader isr = new InputStreamReader(is, Charset.forName("ISO-8859-15"));
			br = new BufferedReader(isr);
			String textoDoArquivo = br.readLine();
			int cont = 0;
			HTMLSource html = new HTMLSource();
			textoDoArquivo = br.readLine();
			
			while (textoDoArquivo != null) {
				String[] textoDoArquivoSeparado = textoDoArquivo.split(",");
				String tamanho = textoDoArquivoSeparado[26].replace("\"", "");
				
				Class classe = Class.forName("main.Blusa"+tamanho);
				Object o = classe.newInstance();
				Blusa blusa = (Blusa) o;
				
				html.setarValores(new Integer(cont),
						textoDoArquivoSeparado[28].replace("\"", ""), blusa);
				cont++;
				textoDoArquivo = br.readLine();
			}

			OutputStream os = new FileOutputStream("inscritos.html", false);
			OutputStreamWriter osw = new OutputStreamWriter(os,Charset.forName("ISO-8859-15"));
			BufferedWriter bw = new BufferedWriter(osw);
			bw.newLine();
			bw.write(html.geraHTML());
			bw.write(html.totalBlusas());
			bw.close();
		} catch (FileNotFoundException e) {
			System.out.println("Não foi possível encontrar o arquivo.");
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			System.out.println("Encode não suportado.");
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
}
