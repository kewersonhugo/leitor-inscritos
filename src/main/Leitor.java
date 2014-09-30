package main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class Leitor {

	public static void main(String[] args) {

		BufferedReader br = null;

		try {
			InputStream is = new FileInputStream("inscritos.csv");
			InputStreamReader isr = new InputStreamReader(is, "UTF-8");
			br = new BufferedReader(isr);
			String textoDoArquivo = br.readLine();

			while (textoDoArquivo != null) {
				textoDoArquivo = br.readLine();
				String[] textoDoArquivoSeparado = textoDoArquivo.split(",");
				System.out.println(textoDoArquivoSeparado[24] + " "
						+ textoDoArquivoSeparado[25] + " / "
						+ textoDoArquivoSeparado[22] + ": "
						+ textoDoArquivoSeparado[23]);

				textoDoArquivo = br.readLine();
			}

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
