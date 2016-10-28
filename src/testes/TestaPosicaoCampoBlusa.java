package testes;

import java.io.BufferedReader;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import main.HTMLSource;
import main.Leitor;

public class TestaPosicaoCampoBlusa {

	private static String LINHA_TEXTO_CSV = "Abelardo Vieira Mota;abevieiramota@gmail.com;;JAVOU!#08 - Java Technology Day;200.300.201.6635;82507;30.00;30;;0;05/10/2016 19:20;;27.27;(85) 98796-2501;abevieiramota@gmail.com;UFC;Analista de TI;Masculino;Google groups JavaCE;M;Gradua��o";
	private static String[] TEXTO_DO_ARQUIVO_SEPARADO = LINHA_TEXTO_CSV.split(";");
	private static String LINHA_TEXTO_CSV_SEM_BLUSA = "Abelardo Vieira Mota;abevieiramota@gmail.com;;JAVOU!#08 - SEM Blusa;200.300.201.6635;82507;30.00;30;;0;05/10/2016 19:20;;27.27;(85) 98796-2501;abevieiramota@gmail.com;UFC;Analista de TI;Masculino;Google groups JavaCE;M;Gradua��o";
	private static String[] TEXTO_DO_ARQUIVO_SEPARADO_SEM_BLUSA = LINHA_TEXTO_CSV_SEM_BLUSA.split(";");
	private static String LINHA_TEXTO_CSV_FEMININA = "Marilia Tamiles Soares Guerra;maritami2000@gmail.com;;JAVOU!#08 - Java Technology Day;200.201.029.9189;82693;30.00;30;;0;07/10/2016 16:01;;27.27;(85) 99668-8328;maritami2000@gmail.com;Secretaria da Educação;Suporte Operacional;Feminino;Através de amigos;Babylook M;Ensino médio";
	private static String[] TEXTO_DO_ARQUIVO_SEPARADO_FEMININA = LINHA_TEXTO_CSV_FEMININA.split(";");
	private static final int POSICAO_BLUSA = 19;



	@Test
	public void testaColunaTamanhoDaBlusa(){
		String string = TEXTO_DO_ARQUIVO_SEPARADO[POSICAO_BLUSA];
		Assert.assertEquals("A posicao da coluna do tamanho da blusa está errada", "M", string);
	}
	
	@Test
	public void testaColunaTamanhoDaBlusaFeminina(){
		String string = TEXTO_DO_ARQUIVO_SEPARADO_FEMININA[POSICAO_BLUSA];
		Assert.assertEquals("A posicao da coluna do tamanho da blusa está errada", "Babylook M", string);
	}
	
	@Test
	public void testaPegaTamanhoDaBlusa(){
		String pegaTamanhoBlusaPelaPosicao = Leitor.pegaTamanhoBlusaPelaPosicao(TEXTO_DO_ARQUIVO_SEPARADO);
		Assert.assertEquals("", "M", pegaTamanhoBlusaPelaPosicao);
	}
	
	
	
}
