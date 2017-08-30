package main;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Leitor leitor = new Leitor();
		leitor.gerarArquivoHtmlFromCsv("inscritos.csv");
	}

}
