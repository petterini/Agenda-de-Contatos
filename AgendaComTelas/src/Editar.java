import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Editar extends JPanel {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField txtNome;
	private JTextField txtTel;
	private JTextField txtEmail;
	private JButton btSalvar;
	private JButton btVoltar;
	private JLabel lblNewLabel_4;
	private JTextField pcrNome;
	private JButton btnProcurar;
	private Arquivo arq = new Arquivo("Contatos");
	private JComboBox cbTipo;


	public Editar() {
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
				if(p.getTipo().equals("Pessoal")) {					
					this.cbTipo.setSelectedIndex(0);
				}else {
					this.cbTipo.setSelectedIndex(1);
				}
				aux = true;
				break;
			}
		}
		if (!aux) {
			JOptionPane.showMessageDialog(null, "Contato não encontrado!");
			this.txtNome.setText("");
			this.txtTel.setText("");
			this.txtEmail.setText("");
		}
	}

	public void editarContato() {
		boolean aux = false;
		for (Pessoa p : Principal.pessoas) {
			if (p.getNome().toUpperCase().equals(this.pcrNome.getText().toUpperCase())) {
				if (txtNome.getText().replace(" ", "").equals("") || txtTel.getText().replace(" ", "").equals("")
						|| txtEmail.getText().replace(" ", "").equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
					aux = true;
					break;
				} else {
					p.setNome(this.txtNome.getText());
					p.setCelular(this.txtTel.getText());
					p.setEmail(this.txtEmail.getText());
					if (this.cbTipo.getSelectedIndex() == 0) {
						p.setTipo("Pessoal");
					} else {
						p.setTipo("Profissional");
					}
					aux = true;
					arq.atualizaLista();
					JOptionPane.showMessageDialog(null, "Contato alterado com sucesso!");
					break;
				}
			}
			if (!aux) {
				JOptionPane.showMessageDialog(null, "Contato não encontrado!");
			}
		}
	}

	private void initComponents() {
		setBounds(100, 100, 596, 339);
		setLayout(new MigLayout("", "[grow][][][][][][grow][][][][][][][][][][][][][grow][][][grow]", "[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]"));

		this.lblNewLabel = new JLabel("Editar Contato");
		this.lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		add(this.lblNewLabel, "cell 1 0 21 1,alignx center");
		
				this.lblNewLabel_4 = new JLabel("Nome");
				this.lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 22));
				add(this.lblNewLabel_4, "cell 2 1 3 1");
		
				this.pcrNome = new JTextField();
				this.pcrNome.setColumns(10);
				add(this.pcrNome, "cell 5 1 16 1,growx");
		
				this.btnProcurar = new JButton("Procurar");
				this.btnProcurar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						procurarContato();
					}
				});
				this.btnProcurar.setFont(new Font("Tahoma", Font.PLAIN, 18));
				add(this.btnProcurar, "cell 2 2 19 1,alignx center");
		
				this.lblNewLabel_1 = new JLabel("Nome");
				this.lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
				add(this.lblNewLabel_1, "cell 2 5 3 1");
				
						this.txtNome = new JTextField();
						add(this.txtNome, "cell 5 5 16 1,growx");
						this.txtNome.setColumns(10);
		
				this.lblNewLabel_2 = new JLabel("Telefone");
				this.lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
				add(this.lblNewLabel_2, "cell 2 6 3 1");
				
						this.txtTel = new JTextField();
						this.txtTel.setColumns(10);
						add(this.txtTel, "cell 5 6 16 1,growx");
		
				this.lblNewLabel_3 = new JLabel("Email");
				this.lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
				add(this.lblNewLabel_3, "cell 2 7 3 1");
		
				this.txtEmail = new JTextField();
				this.txtEmail.setColumns(10);
				add(this.txtEmail, "cell 5 7 16 1,growx");
						
								this.btSalvar = new JButton("     Salvar     ");
								this.btSalvar.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										editarContato();
									}
								});
								this.btSalvar.setFont(new Font("Tahoma", Font.PLAIN, 18));
								add(this.btSalvar, "flowx,cell 10 9,alignx center");
						
						this.cbTipo = new JComboBox();
						this.cbTipo.setModel(new DefaultComboBoxModel(new String[] {"Pessoal", "Profissional"}));
						add(this.cbTipo, "cell 16 8 5 1,growx");
		
				this.btVoltar = new JButton("     Voltar     ");
				this.btVoltar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						voltar();
					}
				});
				this.btVoltar.setFont(new Font("Tahoma", Font.PLAIN, 18));
				add(this.btVoltar, "cell 10 10,alignx center");
	}

}
