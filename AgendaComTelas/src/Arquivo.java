
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Arquivo {
	private BufferedReader br;
	private BufferedWriter bw;
	private String file;

	public Arquivo(String arquivo) {
		this.file = arquivo;
	}


	public boolean gravar(Pessoa p) {
		try {
			bw = new BufferedWriter(new FileWriter(this.file + ".txt"));
			Principal.pessoas.add(p);
			for (Pessoa c : Principal.pessoas) {
				bw.write(c.toString());
				bw.write("\n");
			}

			bw.close();
			return true;
		} catch (Exception e) {
			System.out.println("Erro na abertura de arquivo para gravação.");
			return false;
		}
	}

	public void ler() {
		String conteudo = "";
		try {
			br = new BufferedReader(new FileReader(this.file + ".txt"));
			conteudo = br.readLine();
			if (conteudo != null) {
				Principal.pessoas.clear();
				br = new BufferedReader(new FileReader(this.file + ".txt"));
				while ((conteudo = br.readLine()) != null) {
					String[] auxiliar = conteudo.split(",");
					if (auxiliar.length == 4) {
						Principal.pessoas.add(new Pessoa(auxiliar[0], auxiliar[1], auxiliar[2], auxiliar[3]));
					}
				}
				br.close();

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

	public void atualizaLista() {
		try {
			bw = new BufferedWriter(new FileWriter(this.file + ".txt"));
			for (Pessoa p : Principal.pessoas) {
				bw.write(p.toString());
				bw.write("\n");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
