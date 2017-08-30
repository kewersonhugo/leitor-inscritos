package testes;

import main.BlusaMasculinaG;
import main.BlusaMasculinaM;
import main.Configuracoes;
import main.HTMLSource;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.matchers.JUnitMatchers;

public class TestesHTMLSource {

	private static final String MASCULINA_M2 = "Masculina M";
	private static final String NOME_PARTICIPANTE_COM_EMAIL = "Rafael Mota Correia - rafaelmcdono@gmail.com";
	private static final String NOME_DO_PARTICIPANTE = "Rafael Mota Correia";
	private static final String HTML_GERADO = "<meta http-equiv='Content-Type' content='text/html;charset=ISO-8859-1'><table><tr><td>Número</td><td>Nome</td><td>Blusa</td></tr><tr><td>1</td><td>Fulano</td><td>M-Masculina</td></tr></table>";
	private static final String FEMININAM = "FemininaM";
	private static final String MASCULINAG = "MasculinaG";
	private static final String MASCULINAM = "MasculinaM";
	private static final String SEM_BLUSA = Configuracoes.TEXTO_CAMPO_SEM_BLUSA;
	private static final String G = "G";
	private static final String MASCULINA_G = "Masculina G";
	private static final String FEMININA_M = "Feminina M";
	private static final String BABYLOOK_M = "Babylook M";
	private static final String M = "M";
	private static final String MASCULINO_M = "Masculino-M";
	private static final String MASCULINA_M = "Masculina-M";
	private static String LINHA_TEXTO_CSV = "629449905,2017-05-15 12:44:03-03:00,Rafael,Mota Correia,rafaelmcdono@gmail.com,1,JAVOU10 - COM CAMISA,788772647,,Eventbrite Completed,BRL,30.24,2.24,2.24,0.00,Attending,,,,,,,Masculina M,,,,,61620040,BR,Desenvolvendor,Resource IT Solutions";
	private static String[] TEXTO_DO_ARQUIVO_SEPARADO = LINHA_TEXTO_CSV.split(Configuracoes.SPLIT);
	private static String LINHA_TEXTO_CSV_SEM_BLUSA = "639027067,2017-06-12 19:42:54-03:00,João,Batista Araujo Neto,joao.1309@gmail.com,1,JAVOU10 - SEM CAMISA,800366792,,Eventbrite Completed,BRL,30.24,2.24,2.24,0.00,Attending,,,,,,,Masculina EXG,Rua Dom Xisto Albano, 410,casa,Fortaleza,CE,60730165,BR,Aluno,Estácio";
	private static String[] TEXTO_DO_ARQUIVO_SEPARADO_SEM_BLUSA = LINHA_TEXTO_CSV_SEM_BLUSA.split(Configuracoes.SPLIT);
	private static String LINHA_TEXTO_CSV_SEM_NOME = ";abevieiramota@gmail.com;;JAVOU!#08 - Java Technology Day;200.300.201.6635;82507;30.00;30;;0;05/10/2016 19:20;;27.27;(85) 98796-2501;abevieiramota@gmail.com;UFC;Analista de TI;Masculino;Google groups JavaCE;M;Gradua��o";
	private static String[] TEXTO_DO_ARQUIVO_SEPARADO_SEM_NOME = LINHA_TEXTO_CSV_SEM_NOME.split(Configuracoes.SPLIT);
	private static String LINHA_TEXTO_CSV_FEMININO = "639866746,2017-06-15 00:24:22-03:00,Vivian,Menezes,vivianmenezes130@gmail.com,1,JAVOU10 - SEM CAMISA,801375339,,Eventbrite Completed,BRL,30.24,2.24,2.24,0.00,Attending,,,,,,,Feminina M,Oito de Setembro,1135, apto 302,Fortaleza,CE,60175-210,BR,,";
	private static String[] TEXTO_DO_ARQUIVO_SEPARADO_FEMININO = LINHA_TEXTO_CSV_FEMININO.split(Configuracoes.SPLIT);
	private static final int POSICAO_BLUSA = Configuracoes.POSICAO_BLUSA;
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
		Assert.assertEquals("", MASCULINA_M2, validaSeTemCamisa);
		
	}
	
	@Test
	public void testaValidaSeTemCamisaSEMCamisa(){
		this.html.setTextoDoArquivoSeparado(TEXTO_DO_ARQUIVO_SEPARADO_SEM_BLUSA);
		String validaSeTemCamisa = this.html.validaSeTemCamisa(POSICAO_BLUSA);
		Assert.assertEquals("", Configuracoes.NOME_CLASSE_SEM_BLUSA, validaSeTemCamisa);
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
	public void testaSeEhFeminino(){
		this.html.setTextoDoArquivoSeparado(TEXTO_DO_ARQUIVO_SEPARADO_FEMININO);
		boolean ehFeminino = this.html.isFeminino();
		Assert.assertTrue(ehFeminino);
	}
	
	@Test
	public void testaSeNaoEhFeminino(){
		this.html.setTextoDoArquivoSeparado(TEXTO_DO_ARQUIVO_SEPARADO);
		boolean ehFeminino = this.html.isFeminino();
		Assert.assertFalse(ehFeminino);
	}
	
	@Test
	public void testaSemCamisaComColunaTamanhoVazia(){
		this.html.setTextoDoArquivoSeparado(TEXTO_DO_ARQUIVO_SEPARADO_SEM_BLUSA);
		String alteraCampoParaNomeClasse = this.html.alteraCampoParaNomeClasse("");
		Assert.assertEquals("", Configuracoes.NOME_CLASSE_SEM_BLUSA, alteraCampoParaNomeClasse);
	}
	
	@Test
	public void testaSemCamisaComColunaTamanhoNull(){
		this.html.setTextoDoArquivoSeparado(TEXTO_DO_ARQUIVO_SEPARADO_SEM_BLUSA);
		String alteraCampoParaNomeClasse = this.html.alteraCampoParaNomeClasse(null);
		Assert.assertEquals("", Configuracoes.NOME_CLASSE_SEM_BLUSA, alteraCampoParaNomeClasse);
	}
	
	@Test
	public void testaComCamisaComColunaTamanhoNull(){
		this.html.setTextoDoArquivoSeparado(TEXTO_DO_ARQUIVO_SEPARADO);
		String alteraCampoParaNomeClasse = this.html.alteraCampoParaNomeClasse(null);
		Assert.assertEquals("", Configuracoes.NOME_CLASSE_SEM_BLUSA, alteraCampoParaNomeClasse);
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
		Assert.assertEquals(NOME_DO_PARTICIPANTE, nome);
	}
	
	@Test
	public void testaSePossuEmail(){
		this.html.setTextoDoArquivoSeparado(TEXTO_DO_ARQUIVO_SEPARADO);
		String email = this.html.getEmail();
		Assert.assertThat(email,CoreMatchers.containsString("@"));
	}
	
	@Test
	public void testaValidaSePossuiColunaNome(){
		this.html.setTextoDoArquivoSeparado(TEXTO_DO_ARQUIVO_SEPARADO);
		String validaSePossuiNome = this.html.validaSePossuiNome();
		Assert.assertEquals(NOME_PARTICIPANTE_COM_EMAIL, validaSePossuiNome);
	}
	
	@Test
	public void testaValidaSePossuiNomes(){
		this.html.setTextoDoArquivoSeparado(TEXTO_DO_ARQUIVO_SEPARADO);
		String validaSePossuiNome = this.html.validaSePossuiNome();
		Assert.assertEquals(NOME_PARTICIPANTE_COM_EMAIL, validaSePossuiNome);
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
		String htmlGerado = this.html.gerarListaInscritos();
		Assert.assertEquals(HTML_GERADO, htmlGerado);
	}
	
	@Test
	public void testaSetarValoresETestaSeGerouComONomeEnviado(){
		this.html.setTextoDoArquivoSeparado(TEXTO_DO_ARQUIVO_SEPARADO);
		this.html.setarValores(1, NOME_DO_PARTICIPANTE, new BlusaMasculinaG());
		String htmlGerado = this.html.gerarListaInscritos();
		Assert.assertThat(htmlGerado,CoreMatchers.containsString(NOME_DO_PARTICIPANTE));
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
