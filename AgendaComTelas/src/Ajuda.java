import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ajuda extends JPanel {
	private JLabel lblNewLabel;
	private JButton btVoltar;
	private JLabel lblNomeAgendaDe;
	private JLabel lblVerso;
	private JLabel lblDesenvolvidoPorPedro;
	private JLabel lblTurmaAds;
	private JLabel lblEmailPpetterinigmailcom;

	/**
	 * Create the panel.
	 */
	public Ajuda() {
		initComponents();
	}
	
	public void voltar() {
		Principal.frame.setContentPane(new TelaPrincipal());
		Principal.frame.setVisible(true);
	}
	
	private void initComponents() {
		setBounds(100, 100, 596, 339);
		setLayout(new MigLayout("", "[grow][][][][][grow][][][][][][][][][][][][][][][grow]", "[][][][][][][][][]"));	
		
		this.lblNewLabel = new JLabel("Sobre o aplicativo:");
		this.lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		add(this.lblNewLabel, "cell 0 0 20 1,alignx left");
		
		this.btVoltar = new JButton("     Voltar     ");
		this.btVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				voltar();
			}
		});
		
		this.lblNomeAgendaDe = new JLabel("Nome: Agenda de contatos");
		this.lblNomeAgendaDe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(this.lblNomeAgendaDe, "cell 0 1 20 1,aligny top");
		
		this.lblVerso = new JLabel("Versão: 1.0");
		this.lblVerso.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(this.lblVerso, "cell 0 2 19 1");
		
		this.lblDesenvolvidoPorPedro = new JLabel("Desenvolvido por: Pedro Petterini");
		this.lblDesenvolvidoPorPedro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(this.lblDesenvolvidoPorPedro, "cell 0 3 19 1");
		
		this.lblTurmaAds = new JLabel("Turma: ADS 19");
		this.lblTurmaAds.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(this.lblTurmaAds, "cell 0 4 19 1");
		
		this.lblEmailPpetterinigmailcom = new JLabel("Email: ppetterini@gmail.com");
		this.lblEmailPpetterinigmailcom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(this.lblEmailPpetterinigmailcom, "cell 0 5 18 1");
		this.btVoltar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(this.btVoltar, "cell 2 7 18 1,alignx center");
	}

}
