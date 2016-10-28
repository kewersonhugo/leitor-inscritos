package testes;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.matchers.JUnitMatchers;

import main.HTMLSource;

public class TestesHTMLSource {

	private static String LINHA_TEXTO_CSV = "Abelardo Vieira Mota;abevieiramota@gmail.com;;JAVOU!#08 - Java Technology Day;200.300.201.6635;82507;30.00;30;;0;05/10/2016 19:20;;27.27;(85) 98796-2501;abevieiramota@gmail.com;UFC;Analista de TI;Masculino;Google groups JavaCE;M;Gradua��o";
	private static String[] TEXTO_DO_ARQUIVO_SEPARADO = LINHA_TEXTO_CSV.split(";");
	private static String LINHA_TEXTO_CSV_SEM_BLUSA = "Abelardo Vieira Mota;abevieiramota@gmail.com;;JAVOU!#08 - SEM Blusa;200.300.201.6635;82507;30.00;30;;0;05/10/2016 19:20;;27.27;(85) 98796-2501;abevieiramota@gmail.com;UFC;Analista de TI;Masculino;Google groups JavaCE;M;Gradua��o";
	private static String[] TEXTO_DO_ARQUIVO_SEPARADO_SEM_BLUSA = LINHA_TEXTO_CSV_SEM_BLUSA.split(";");
	private static String LINHA_TEXTO_CSV_SEM_NOME = ";abevieiramota@gmail.com;;JAVOU!#08 - Java Technology Day;200.300.201.6635;82507;30.00;30;;0;05/10/2016 19:20;;27.27;(85) 98796-2501;abevieiramota@gmail.com;UFC;Analista de TI;Masculino;Google groups JavaCE;M;Gradua��o";
	private static String[] TEXTO_DO_ARQUIVO_SEPARADO_SEM_NOME = LINHA_TEXTO_CSV_SEM_NOME.split(";");
	private static final int POSICAO_BLUSA = 19;
	private HTMLSource html = null;
	private JUnitMatchers match = new JUnitMatchers();
	@Before
	public void init(){
		this.html = new HTMLSource();
	}
	
	@Test
	public void testaValidaSeTemCamisa(){
		this.html.setTextoDoArquivoSeparado(TEXTO_DO_ARQUIVO_SEPARADO);
		String validaSeTemCamisa = this.html.validaSeTemCamisa(POSICAO_BLUSA);
		Assert.assertEquals("", "M", validaSeTemCamisa);
		
	}
	
	@Test
	public void testaValidaSeTemCamisaSEMCamisa(){
		this.html.setTextoDoArquivoSeparado(TEXTO_DO_ARQUIVO_SEPARADO_SEM_BLUSA);
		String validaSeTemCamisa = this.html.validaSeTemCamisa(POSICAO_BLUSA);
		Assert.assertEquals("", "SEMBlusa", validaSeTemCamisa);
	}
	
	@Test
	public void testaSeNaoTemCamisa(){
		this.html.setTextoDoArquivoSeparado(TEXTO_DO_ARQUIVO_SEPARADO_SEM_BLUSA);
		boolean semCamisa = this.html.isSEMCamisa();
		Assert.assertTrue(semCamisa);
		
	}
	
	@Test
	public void testaSeTemCamisa(){
		this.html.setTextoDoArquivoSeparado(TEXTO_DO_ARQUIVO_SEPARADO);
		boolean semCamisa = this.html.isSEMCamisa();
		Assert.assertFalse(semCamisa);
	}
	
	@Test
	public void testaSemCamisaComColunaTamanhoVazia(){
		this.html.setTextoDoArquivoSeparado(TEXTO_DO_ARQUIVO_SEPARADO_SEM_BLUSA);
		String alteraCampoParaNomeClasse = this.html.alteraCampoParaNomeClasse("");
		Assert.assertEquals("", "SEMBlusa", alteraCampoParaNomeClasse);
	}
	
	@Test
	public void testaSemCamisaComColunaTamanhoNull(){
		this.html.setTextoDoArquivoSeparado(TEXTO_DO_ARQUIVO_SEPARADO_SEM_BLUSA);
		String alteraCampoParaNomeClasse = this.html.alteraCampoParaNomeClasse(null);
		Assert.assertEquals("", "SEMBlusa", alteraCampoParaNomeClasse);
	}
	
	@Test
	public void testaComCamisaComColunaTamanhoNull(){
		this.html.setTextoDoArquivoSeparado(TEXTO_DO_ARQUIVO_SEPARADO);
		String alteraCampoParaNomeClasse = this.html.alteraCampoParaNomeClasse(null);
		Assert.assertEquals("", "SEMBlusa", alteraCampoParaNomeClasse);
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
	
	@Test
	public void testaSePossuiNome(){
		this.html.setTextoDoArquivoSeparado(TEXTO_DO_ARQUIVO_SEPARADO);
		String nome = this.html.getNome();
		Assert.assertEquals("Abelardo Vieira Mota", nome);
	}
	
	@Test
	public void testaSePossuEmail(){
		this.html.setTextoDoArquivoSeparado(TEXTO_DO_ARQUIVO_SEPARADO);
		String email = this.html.getEmail();
		Assert.assertThat(email,CoreMatchers.containsString("@"));
	}
	
	@Test
	public void testaValidaSePossuiNomes(){
		this.html.setTextoDoArquivoSeparado(TEXTO_DO_ARQUIVO_SEPARADO);
		String validaSePossuiNome = this.html.validaSePossuiNome();
		Assert.assertEquals("Abelardo Vieira Mota - abevieiramota@gmail.com", validaSePossuiNome);
	}
	
	@Test
	public void testaRegexComM(){
		String regexNome = this.html.regexNome("M");
		Assert.assertEquals("M", regexNome);
	}
	
	@Test
	public void testaRegexComMasculino(){
		String regexNome = this.html.regexNome("Masculino M");
		Assert.assertEquals("MasculinaM", regexNome);
	}
	
	@Test
	public void testaRegexComMasculina(){
		String regexNome = this.html.regexNome("Masculina M");
		Assert.assertEquals("MasculinaM", regexNome);
	}
	
	@Test
	public void testaRegexComMasculinoComTraco(){
		String regexNome = this.html.regexNome("Masculino-M");
		Assert.assertEquals("MasculinaM", regexNome);
	}
	
	@Test
	public void testaRegexComMasculinaComTraco(){
		String regexNome = this.html.regexNome("Masculina-M");
		Assert.assertEquals("MasculinaM", regexNome);
	}
	
}
