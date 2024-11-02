import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Procurar extends JPanel {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField pcrNome;
	private JButton btSalvar;
	private JScrollPane scrollPane;
	private JTable table = new JTable();
	private JButton btVoltar;
	private Arquivo arq = new Arquivo("Contatos");

	/**
	 * Create the panel.
	 */
	public Procurar() {
		initComponents();
	}

	public void voltar() {
		Principal.frame.setContentPane(new TelaPrincipal());
		Principal.frame.setVisible(true);
	}
	
	private void clicarTabela(MouseEvent e) {
		int linha = table.rowAtPoint(e.getPoint());
		int coluna = table.columnAtPoint(e.getPoint());

		if (linha >= 0 && coluna >= 0) {
			String aviso = ("Nome: " + table.getValueAt(linha, 0) + "\nTelefone: " + table.getValueAt(linha, 1) + "\nEmail: "
					+ table.getValueAt(linha, 2) + "\nTipo: " + table.getValueAt(linha, 3));
			JOptionPane.showMessageDialog(null, aviso);
		}
	}

	public void procurarContato() {
		boolean aux = false;
		DefaultTableModel m = (DefaultTableModel) table.getModel();
		m.setRowCount(0);
		for (Pessoa p : Principal.pessoas) {
			m = (DefaultTableModel) table.getModel();
			if (p.getNome().toUpperCase().contains(this.pcrNome.getText().toUpperCase())) {

				m.addRow(new String[] { p.getNome(), p.getCelular(), p.getEmail(), p.getTipo() });

				aux = true;
			}
		}
		if (!aux) {
			JOptionPane.showMessageDialog(null, "Contato não encontrado!");
		}
	}

	private void initComponents() {
		setBounds(100, 100, 596, 339);
		setLayout(new MigLayout("", "[grow][][][][][grow][][][][][][][][][][][][][][][grow]", "[][][][grow][][][][]"));

		this.lblNewLabel = new JLabel("Procurar Contato");
		this.lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		add(this.lblNewLabel, "cell 1 0 19 1,alignx center");

		this.lblNewLabel_1 = new JLabel("Nome");
		this.lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(this.lblNewLabel_1, "cell 2 1 2 1");

		this.pcrNome = new JTextField();
		add(this.pcrNome, "cell 4 1 15 1,growx");
		this.pcrNome.setColumns(10);

		this.btSalvar = new JButton("Procurar");
		this.btSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				procurarContato();
			}
		});
		this.btSalvar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(this.btSalvar, "cell 4 2 11 1,alignx center");

		this.btVoltar = new JButton("Voltar");
		this.btVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				voltar();
			}
		});
		this.btVoltar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(this.btVoltar, "cell 16 2 3 1,alignx left");

		this.scrollPane = new JScrollPane();
		add(this.scrollPane, "cell 2 3 18 4,grow");

		this.table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clicarTabela(e);
			}
		});
		this.table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, },
				new String[] { "Nome", "Telefone", "Email", "Tipo" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		this.table.getColumnModel().getColumn(0).setResizable(false);
		this.table.getColumnModel().getColumn(0).setPreferredWidth(161);
		this.table.getColumnModel().getColumn(1).setResizable(false);
		this.table.getColumnModel().getColumn(1).setPreferredWidth(123);
		this.table.getColumnModel().getColumn(2).setResizable(false);
		this.table.getColumnModel().getColumn(2).setPreferredWidth(138);
		this.table.getColumnModel().getColumn(3).setResizable(false);
		this.table.getColumnModel().getColumn(3).setPreferredWidth(96);
		this.scrollPane.setViewportView(this.table);
		this.table.getTableHeader().setReorderingAllowed(false);
	}

}
