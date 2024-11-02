import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel jl1;
	private JScrollPane scrollPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenu mnNewMenu_2;
	private JMenuItem mnCadastrar;
	private JMenuItem mnEditar;
	private JMenuItem mnExcluir;
	private JMenuItem mnProcurar;
	private JMenuItem mnInfo;
	private JTable table;
	static Principal frame;
	static List<Pessoa> pessoas = new LinkedList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		initComponents();
		this.setContentPane(new TelaPrincipal());
	}
			
	public void cadastrarContato() {
		this.setContentPane(new Cadastrar());
		this.setVisible(true);
	}
	
	public void editarContato() {
		this.setContentPane(new Editar());
		this.setVisible(true);
	}
	
	public void excluirContato() {
		this.setContentPane(new Excluir());
		this.setVisible(true);
	}
	
	public void procurarContato() {
		this.setContentPane(new Procurar());
		this.setVisible(true);
	}
	
	public void ajuda() {
		this.setContentPane(new Ajuda());
		this.setVisible(true);
	}
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 616, 359);
		
		this.menuBar = new JMenuBar();
		setJMenuBar(this.menuBar);
		
		this.mnNewMenu = new JMenu("Contatos");
		this.menuBar.add(this.mnNewMenu);
		
		this.mnCadastrar = new JMenuItem("Cadastrar");
		this.mnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarContato();
			}
		});
		this.mnNewMenu.add(this.mnCadastrar);
		
		this.mnEditar = new JMenuItem("Editar");
		this.mnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarContato();
			}
		});
		this.mnNewMenu.add(this.mnEditar);
		
		this.mnExcluir = new JMenuItem("Excluir");
		this.mnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirContato();
			}
		});
		this.mnNewMenu.add(this.mnExcluir);
		
		this.mnNewMenu_1 = new JMenu("Procurar");
		this.menuBar.add(this.mnNewMenu_1);
		
		this.mnProcurar = new JMenuItem("Procurar Contatos");
		this.mnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				procurarContato();
			}
		});
		this.mnNewMenu_1.add(this.mnProcurar);
		
		this.mnNewMenu_2 = new JMenu("Ajuda");
		this.menuBar.add(this.mnNewMenu_2);
		
		this.mnInfo = new JMenuItem("Informações");
		this.mnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajuda();
			}
		});
		this.mnNewMenu_2.add(this.mnInfo);
		
	}

}
