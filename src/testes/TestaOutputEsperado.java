package testes;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import main.Leitor;

import org.junit.Before;
import org.junit.Test;

public class TestaOutputEsperado {

	private static final String ARQUIVO_TESTE_INSCRITOS = "test-input-inscritos.csv";
	private static final Path ARQUIVO_MASTER = Paths.get("expected-output.html");
	private static final Path ARQUIVO_ATUAL = Paths.get("inscritos.html");

	@Before
	public void init() throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		Leitor leitor = new Leitor();
		leitor.gerarArquivoHtmlFromCsv(ARQUIVO_TESTE_INSCRITOS);
	}

	@Test
	public void sampleOutputFileShouldBeEqualActualOutputFile()
			throws UnsupportedEncodingException, IOException {
		String outputEsperado = new String(Files.readAllBytes(ARQUIVO_MASTER),
				"UTF-8");
		String outputAtual = new String(Files.readAllBytes(ARQUIVO_ATUAL),
				"UTF-8");
		assertEquals(outputEsperado, outputAtual);
	}
}
