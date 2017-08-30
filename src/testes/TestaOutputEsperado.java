package testes;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

import main.Leitor;

public class TestaOutputEsperado {
	
	private static final Path ARQUIVO_MASTER = Paths.get("expected-output.html");
	private static final Path ARQUIVO_ATUAL = Paths.get("inscritos.html"); 
	
	@Test
	public void sampleOutputFileShouldBeEqualActualOutputFile() throws UnsupportedEncodingException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		Leitor.gerarArquivoHtmlFromCsv();;
		String outputEsperado = new String(Files.readAllBytes(ARQUIVO_MASTER), "UTF-8");
		String outputAtual= new String(Files.readAllBytes(ARQUIVO_ATUAL), "UTF-8");
		assertEquals(outputEsperado, outputAtual);
	}
}
