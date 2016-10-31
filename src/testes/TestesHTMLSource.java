package testes;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.matchers.JUnitMatchers;

import main.BlusaMasculinaG;
import main.BlusaMasculinaM;
import main.HTMLSource;

public class TestesHTMLSource {

	private static final String ABELARDO_VIEIRA_MOTA = "Abelardo Vieira Mota";
	private static final String HTML_GERADO = "<meta http-equiv='Content-Type' content='text/html;charset=ISO-8859-1'><table><tr><td>Número</td><td>Nome</td><td>Blusa</td></tr><tr><td>1</td><td>Fulano</td><td>M-Masculina</td></tr></table>";
	private static final String FEMININAM = "FemininaM";
	private static final String MASCULINAG = "MasculinaG";
	private static final String MASCULINAM = "MasculinaM";
	private static final String SEM_BLUSA = "SEMBlusa";
	private static final String G = "G";
	private static final String MASCULINA_G = "Masculina G";
	private static final String FEMININA_M = "Feminina M";
	private static final String BABYLOOK_M = "Babylook M";
	private static final String M = "M";
	private static final String MASCULINO_M = "Masculino-M";
	private static final String MASCULINA_M = "Masculina-M";
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
		Assert.assertEquals("", M, validaSeTemCamisa);
		
	}
	
	@Test
	public void testaValidaSeTemCamisaSEMCamisa(){
		this.html.setTextoDoArquivoSeparado(TEXTO_DO_ARQUIVO_SEPARADO_SEM_BLUSA);
		String validaSeTemCamisa = this.html.validaSeTemCamisa(POSICAO_BLUSA);
		Assert.assertEquals("", SEM_BLUSA, validaSeTemCamisa);
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
		Assert.assertEquals("", SEM_BLUSA, alteraCampoParaNomeClasse);
	}
	
	@Test
	public void testaSemCamisaComColunaTamanhoNull(){
		this.html.setTextoDoArquivoSeparado(TEXTO_DO_ARQUIVO_SEPARADO_SEM_BLUSA);
		String alteraCampoParaNomeClasse = this.html.alteraCampoParaNomeClasse(null);
		Assert.assertEquals("", SEM_BLUSA, alteraCampoParaNomeClasse);
	}
	
	@Test
	public void testaComCamisaComColunaTamanhoNull(){
		this.html.setTextoDoArquivoSeparado(TEXTO_DO_ARQUIVO_SEPARADO);
		String alteraCampoParaNomeClasse = this.html.alteraCampoParaNomeClasse(null);
		Assert.assertEquals("", SEM_BLUSA, alteraCampoParaNomeClasse);
	}
	
	@Test
	public void testaAlterarNomeTamanhoApenasM(){
		String alteraCampoParaNomeClasse = this.html.alteraCampoParaNomeClasse(M);
		Assert.assertEquals("", MASCULINAM, alteraCampoParaNomeClasse);
	}
	
	@Test
	public void testaAlterarNomeTamanhoApenasG(){
		String alteraCampoParaNomeClasse = this.html.alteraCampoParaNomeClasse(G);
		Assert.assertEquals("", MASCULINAG, alteraCampoParaNomeClasse);
	}
	
	@Test
	public void testaAlterarNomeTamanhoMasculinaM(){
		String alteraCampoParaNomeClasse = this.html.alteraCampoParaNomeClasse(MASCULINA_M);
		Assert.assertEquals("", MASCULINAM, alteraCampoParaNomeClasse);
	}
	
	@Test
	public void testaAlterarNomeTamanhoMasculinaG(){
		String alteraCampoParaNomeClasse = this.html.alteraCampoParaNomeClasse(MASCULINA_G);
		Assert.assertEquals("", MASCULINAG, alteraCampoParaNomeClasse);
	}
	
	@Test
	public void testaAlterarNomeTamanhoFemininaM(){
		String alteraCampoParaNomeClasse = this.html.alteraCampoParaNomeClasse(FEMININA_M);
		Assert.assertEquals("", FEMININAM, alteraCampoParaNomeClasse);
	}
	
	@Test
	public void testaAlterarNomeTamanhoFemininaBabyLookM(){
		String alteraCampoParaNomeClasse = this.html.alteraCampoParaNomeClasse(BABYLOOK_M);
		Assert.assertEquals("", FEMININAM, alteraCampoParaNomeClasse);
	}
	
	@Test
	public void testaSePossuiNome(){
		this.html.setTextoDoArquivoSeparado(TEXTO_DO_ARQUIVO_SEPARADO);
		String nome = this.html.getNome();
		Assert.assertEquals(ABELARDO_VIEIRA_MOTA, nome);
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
		String regexNome = this.html.regexNome(M);
		Assert.assertEquals(M, regexNome);
	}
	
	@Test
	public void testaRegexComMasculino(){
		String regexNome = this.html.regexNome(MASCULINO_M);
		Assert.assertEquals(MASCULINAM, regexNome);
	}
	
	@Test
	public void testaRegexComMasculina(){
		String regexNome = this.html.regexNome(MASCULINA_M);
		Assert.assertEquals(MASCULINAM, regexNome);
	}
	
	@Test
	public void testaRegexComMasculinoComTraco(){
		String regexNome = this.html.regexNome(MASCULINO_M);
		Assert.assertEquals(MASCULINAM, regexNome);
	}
	
	@Test
	public void testaRegexComMasculinaComTraco(){
		String regexNome = this.html.regexNome(MASCULINA_M);
		Assert.assertEquals(MASCULINAM, regexNome);
	}
	
	@Test(expected=ClassNotFoundException.class)
	public void testaCarregaBlusaComNomeErrado() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		this.html.carregarClasseBlusa(0,"NomeErradoDaClasse");
	}
	
	@Test(expected=NullPointerException.class)
	public void testaCarregaBlusaComNullPointer() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		this.html.carregarClasseBlusa(0, MASCULINA_M);
	}
	
	@Test
	public void testaSetarValores(){
		this.html.setTextoDoArquivoSeparado(TEXTO_DO_ARQUIVO_SEPARADO);
		this.html.setarValores(1, "Fulano", new BlusaMasculinaM());
		String htmlGerado = this.html.geraHTML();
		Assert.assertEquals(HTML_GERADO, htmlGerado);
	}
	
	@Test
	public void testaSetarValoresETestaSeGerouComONomeEnviado(){
		this.html.setTextoDoArquivoSeparado(TEXTO_DO_ARQUIVO_SEPARADO);
		this.html.setarValores(1, ABELARDO_VIEIRA_MOTA, new BlusaMasculinaG());
		String htmlGerado = this.html.geraHTML();
		Assert.assertThat(htmlGerado,CoreMatchers.containsString(ABELARDO_VIEIRA_MOTA));
	}
	
	@Test
	public void testaSeGeraTotalNoHTML() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		this.html = null;
		this.html = new HTMLSource();
		this.html.setTextoDoArquivoSeparado(TEXTO_DO_ARQUIVO_SEPARADO);
		this.html.gerarDados(0, TEXTO_DO_ARQUIVO_SEPARADO, POSICAO_BLUSA);
		String totalGerado= this.html.totalBlusas();
		Assert.assertThat(totalGerado,CoreMatchers.containsString("Total de Camisas: 1"));
		Assert.assertThat(totalGerado,CoreMatchers.containsString("<br>Total M: 1"));
	}
	
}
