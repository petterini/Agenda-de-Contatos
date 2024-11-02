import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaPrincipal extends JPanel {
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JTable table = new JTable();
	private JButton btnNewButton;
	private Arquivo arq = new Arquivo("Contatos");

	/**
	 * Create the panel.
	 */
	public TelaPrincipal() {
		chamaLista();
		initComponents();
	}

	private void chamaLista() {
		arq.ler();
		DefaultTableModel m = (DefaultTableModel) table.getModel();
		m.setRowCount(0);
		for (Pessoa p : Principal.pessoas) {
			m.addRow(new String[] { p.getNome(), p.getCelular(), p.getEmail(), p.getTipo() });
		}
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

	private void initComponents() {
		setBounds(100, 100, 596, 339);
		setLayout(new MigLayout("", "[grow][][][][][grow][][][][][][][][][][][][][][][grow]",
				"[grow][][][grow][][][][][]"));

		this.lblNewLabel = new JLabel("Agenda de Contatos");
		this.lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		add(this.lblNewLabel, "cell 1 0 19 1,alignx center");

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

		this.btnNewButton = new JButton("Atualizar Lista");
		this.btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chamaLista();
			}
		});
		add(this.btnNewButton, "cell 16 7 4 1");
	}

}
