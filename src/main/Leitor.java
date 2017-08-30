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

	public static void gerarArquivoHtmlFromCsv()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		BufferedReader br = null;
		try {
			br = carregaArquivoCsv("inscritos.csv");
			HTMLSource html = new HTMLSource();
			parseArquivoCsv(br, html);
			gerarArquivoHtml(html);
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

	private static void gerarArquivoHtml(HTMLSource html) throws IOException {
		OutputStream os;
		try {
			os = new FileOutputStream("inscritos.html", false);
			OutputStreamWriter osw = new OutputStreamWriter(os, Charset.forName("ISO-8859-15"));
			BufferedWriter bw = new BufferedWriter(osw);
			bw.newLine();
			bw.write(html.gerarListaInscritos());
			bw.write(html.totalBlusas());
			bw.close();
		} catch (FileNotFoundException e) {
			System.out.println("O arquivo HTML não pode ser criado");
			e.printStackTrace();
		}
	}

	private static void parseArquivoCsv(BufferedReader br, HTMLSource html)
			throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		String linhaArquivoCsv = br.readLine();

		int quantidade = 0;
		while (linhaArquivoCsv != null) {
			String[] textoDoArquivoSeparado = linhaArquivoCsv.split(Configuracoes.SPLIT);
			String tamanho = pegaTamanhoBlusaPelaPosicao(textoDoArquivoSeparado);

			gerarDados(quantidade++, html, textoDoArquivoSeparado, tamanho);
			linhaArquivoCsv = br.readLine();
		}
	}

	public static BufferedReader carregaArquivoCsv(String nomeArquivoCsv) throws IOException {
		InputStream is = new FileInputStream(nomeArquivoCsv);
		InputStreamReader isr = new InputStreamReader(is, Charset.forName("UTF-8"));
		return new BufferedReader(isr);
	}

	public static String pegaTamanhoBlusaPelaPosicao(String[] textoDoArquivoSeparado) {
		String tamanho = "";

		if (!textoDoArquivoSeparado[POSICAO_BLUSA].isEmpty()) {
			tamanho = textoDoArquivoSeparado[POSICAO_BLUSA];
		}

		return tamanho;
	}

	private static int gerarDados(int cont, HTMLSource html, String[] textoDoArquivoSeparado, String tamanho)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		if (tamanho != null && !tamanho.isEmpty()) {
			html.gerarDados(new Integer(cont), textoDoArquivoSeparado, POSICAO_BLUSA);
			cont++;
		}
		return cont;
	}

}
