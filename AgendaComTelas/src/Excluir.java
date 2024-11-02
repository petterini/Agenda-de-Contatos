import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Excluir extends JPanel {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField pcrNome;
	private JButton btSalvar;
	private JButton btVoltar;
	private JButton btnProcurar;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField txtNome;
	private JTextField txtTel;
	private JTextField txtEmail;
	private Arquivo arq = new Arquivo("Contatos");

	/**
	 * Create the panel.
	 */
	public Excluir() {
		initComponents();
	}

	public void voltar() {
		Principal.frame.setContentPane(new TelaPrincipal());
		Principal.frame.setVisible(true);
	}

	public void procurarContato() {
		boolean aux = false;
		for (Pessoa p : Principal.pessoas) {
			if (p.getNome().toUpperCase().equals(this.pcrNome.getText().toUpperCase())) {
				this.txtNome.setText(p.getNome());
				this.txtTel.setText(p.getCelular());
				this.txtEmail.setText(p.getEmail());
				aux = true;
				break;
			}
		}
		if (!aux) {
			JOptionPane.showMessageDialog(null, "Contato não encontrado!");
		}
	}

	public void excluirContato() {
		for (Pessoa p : Principal.pessoas) {
			if (p.getNome().toUpperCase().equals(this.pcrNome.getText().toUpperCase())) {
				Principal.pessoas.remove(p);
				arq.atualizaLista();
				JOptionPane.showMessageDialog(null, "Contato excluído com sucesso!");
				this.txtNome.setText("");
				this.txtTel.setText("");
				this.txtEmail.setText("");
				break;
			}
		}
	}

	private void initComponents() {
		setBounds(100, 100, 596, 339);
		setLayout(new MigLayout("", "[grow][][][][grow][grow][grow][grow][][][][][][][][][][][][][][][grow]",
				"[grow][][][][35.00][][][][][][grow]"));

		this.lblNewLabel = new JLabel("Excluir Contato");
		this.lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		add(this.lblNewLabel, "cell 2 1 20 1,alignx center");

		this.lblNewLabel_1 = new JLabel("Nome");
		this.lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(this.lblNewLabel_1, "cell 3 2 2 1");

		this.pcrNome = new JTextField();
		add(this.pcrNome, "cell 5 2 16 1,growx");
		this.pcrNome.setColumns(10);

		this.btnProcurar = new JButton("Procurar");
		this.btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				procurarContato();
			}
		});
		this.btnProcurar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(this.btnProcurar, "cell 3 3 19 1,alignx center");

		this.lblNewLabel_2 = new JLabel("Nome");
		this.lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(this.lblNewLabel_2, "cell 3 4 2 1");

		this.txtNome = new JTextField();
		this.txtNome.setEditable(false);
		this.txtNome.setColumns(10);
		add(this.txtNome, "cell 5 4 16 1,growx");

		this.lblNewLabel_3 = new JLabel("Telefone");
		this.lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(this.lblNewLabel_3, "cell 3 5 2 1");

		this.txtTel = new JTextField();
		this.txtTel.setEditable(false);
		this.txtTel.setColumns(10);
		add(this.txtTel, "cell 5 5 16 1,growx");

		this.lblNewLabel_4 = new JLabel("Email");
		this.lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(this.lblNewLabel_4, "cell 3 6 2 1");

		this.txtEmail = new JTextField();
		this.txtEmail.setEditable(false);
		this.txtEmail.setColumns(10);
		add(this.txtEmail, "cell 5 6 16 1,growx");

		this.btSalvar = new JButton("     Excluir     ");
		this.btSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirContato();
			}
		});
		this.btSalvar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(this.btSalvar, "cell 3 7 19 1,alignx center");

		this.btVoltar = new JButton("     Voltar     ");
		this.btVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				voltar();
			}
		});
		this.btVoltar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(this.btVoltar, "cell 3 8 19 1,alignx center");
	}

}
