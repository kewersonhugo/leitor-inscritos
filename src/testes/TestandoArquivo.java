package testes;

import java.io.BufferedReader;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import main.HTMLSource;
import main.Leitor;

public class TestandoArquivo {

	private static String LINHA_TEXTO_CSV = "";
	private static String[] TEXTO_DO_ARQUIVO_SEPARADO = null;
	private static final int POSICAO_BLUSA = 19;
	private static BufferedReader BR;
	private HTMLSource html = null;

	@Before
	public void init() throws IOException{
		BR = Leitor.carregaArquivo();
		LINHA_TEXTO_CSV = BR.readLine();
		TEXTO_DO_ARQUIVO_SEPARADO = LINHA_TEXTO_CSV.split(";");
		this.html = new HTMLSource();
	}

	@Test
	public void testaColunaTamanhoDaBlusa(){
		String string = TEXTO_DO_ARQUIVO_SEPARADO[POSICAO_BLUSA];
		Assert.assertEquals("A posicao da coluna do tamanho da blusa está errada", "M", string);
	}
	
	@Test
	public void testaPegaTamanhoDaBlusa(){
		String pegaTamanhoBlusaPelaPosicao = Leitor.pegaTamanhoBlusaPelaPosicao(TEXTO_DO_ARQUIVO_SEPARADO);
		Assert.assertEquals("", "M", pegaTamanhoBlusaPelaPosicao);
	}
	
	@Test
	public void validaSeTemCamisa(){
		html.setTextoDoArquivoSeparado(TEXTO_DO_ARQUIVO_SEPARADO);
		String validaSeTemCamisa = this.html.validaSeTemCamisa(POSICAO_BLUSA);
		Assert.assertEquals("", "M", validaSeTemCamisa);
		
	}
	
	@Test
	public void seTemCamisa(){
		html.setTextoDoArquivoSeparado(TEXTO_DO_ARQUIVO_SEPARADO);
		boolean semCamisa = this.html.isSEMCamisa();
		Assert.assertFalse(semCamisa);
	}
	
	@Test
	public void testaAlterarNomeTamanhoApenasM(){
		String alteraCampoParaNomeClasse = this.html.alteraCampoParaNomeClasse("M");
		Assert.assertEquals("", "MasculinaM", alteraCampoParaNomeClasse);
	}
	
	@Test
	public void testaAlterarNomeTamanhoApenasG(){
		String alteraCampoParaNomeClasse = this.html.alteraCampoParaNomeClasse("G");
		Assert.assertEquals("", "MasculinaG", alteraCampoParaNomeClasse);
	}
	
	@Test
	public void testaAlterarNomeTamanhoMasculinaM(){
		String alteraCampoParaNomeClasse = this.html.alteraCampoParaNomeClasse("Masculina M");
		Assert.assertEquals("", "MasculinaM", alteraCampoParaNomeClasse);
	}
	
	@Test
	public void testaAlterarNomeTamanhoMasculinaG(){
		String alteraCampoParaNomeClasse = this.html.alteraCampoParaNomeClasse("Masculina G");
		Assert.assertEquals("", "MasculinaG", alteraCampoParaNomeClasse);
	}
	
	@Test
	public void testaAlterarNomeTamanhoFemininaM(){
		String alteraCampoParaNomeClasse = this.html.alteraCampoParaNomeClasse("Feminina M");
		Assert.assertEquals("", "FemininaM", alteraCampoParaNomeClasse);
	}
	
	@Test
	public void testaAlterarNomeTamanhoFemininaBabyLookM(){
		String alteraCampoParaNomeClasse = this.html.alteraCampoParaNomeClasse("Babylook M");
		Assert.assertEquals("", "FemininaM", alteraCampoParaNomeClasse);
	}
	
		
}
