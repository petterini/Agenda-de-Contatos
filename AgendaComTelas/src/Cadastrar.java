import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class Cadastrar extends JPanel {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField txtNome;
	private JTextField txtTel;
	private JTextField txtEmail;
	private JButton btSalvar;
	private JButton btVoltar;
	private Arquivo arq = new Arquivo("Contatos");
	private JRadioButton rdPessoal;
	private JRadioButton rdProfissional;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Pessoa pessoa;

	/**
	 * Create the panel.
	 */
	public Cadastrar() {
		initComponents();
	}

	public void cadastrarContato() {
		String tipo = "Pessoal";
		if (rdProfissional.isSelected())
			tipo = "Profissional";
		if (txtNome.getText().replace(" ", "").equals("") || txtTel.getText().replace(" ", "").equals("")
				|| txtEmail.getText().replace(" ", "").equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos!");

		} else {
			if (testaContato(txtNome.getText())) {
				pessoa = new Pessoa(txtNome.getText(), txtTel.getText(), txtEmail.getText(), tipo);
				arq.gravar(pessoa);
				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
			} else {
				JOptionPane.showMessageDialog(null, "Nome já existente!");
			}
		}
	}

	public boolean testaContato(String nome) {
		for (Pessoa p : Principal.pessoas) {
			if (p.getNome().toUpperCase().equals(nome.toUpperCase())) {
				return false;
			}
		}
		return true;
	}

	public void voltar() {
		Principal.frame.setContentPane(new TelaPrincipal());
		Principal.frame.setVisible(true);
	}

	private void initComponents() {
		setBounds(100, 100, 596, 339);
		setLayout(new MigLayout("", "[grow][][][][][grow][][][][][][][][][][][][][][][grow]", "[][][][][][][][]"));

		this.lblNewLabel = new JLabel("Adicionar Contato");
		this.lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		add(this.lblNewLabel, "cell 1 0 19 1,alignx center");

		this.lblNewLabel_1 = new JLabel("Nome");
		this.lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(this.lblNewLabel_1, "cell 2 2 3 1");

		this.txtNome = new JTextField();
		add(this.txtNome, "cell 5 2 14 1,growx");
		this.txtNome.setColumns(10);

		this.lblNewLabel_2 = new JLabel("Telefone");
		this.lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(this.lblNewLabel_2, "cell 2 3 3 1");

		this.txtTel = new JTextField();
		this.txtTel.setColumns(10);
		add(this.txtTel, "cell 5 3 14 1,growx");

		this.lblNewLabel_3 = new JLabel("Email");
		this.lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(this.lblNewLabel_3, "cell 2 4 3 1");

		this.txtEmail = new JTextField();
		this.txtEmail.setColumns(10);
		add(this.txtEmail, "cell 5 4 14 1,growx");

		this.btSalvar = new JButton("     Salvar     ");
		this.btSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarContato();
			}
		});

		this.rdPessoal = new JRadioButton("Pessoal");
		this.rdPessoal.setSelected(true);
		buttonGroup.add(this.rdPessoal);
		add(this.rdPessoal, "cell 8 5 3 1");

		this.rdProfissional = new JRadioButton("Profissional");
		this.rdProfissional.setSelected(true);
		buttonGroup.add(this.rdProfissional);
		add(this.rdProfissional, "cell 12 5 3 1");
		this.btSalvar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(this.btSalvar, "cell 2 6 18 1,alignx center");

		this.btVoltar = new JButton("     Voltar     ");
		this.btVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				voltar();
			}
		});
		this.btVoltar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(this.btVoltar, "cell 2 7 18 1,alignx center");
	}

}
