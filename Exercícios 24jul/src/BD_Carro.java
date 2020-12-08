import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DropMode;

public class BD_Carro extends JFrame {

	private JPanel contentPane;
	private JTextField txtModelo;
	private JTextField txtFabricante;
	private JTextField txtAno;
	private JTextField txtPlaca;
	private JTextField txtCor;
	private JTextField txtComentarios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BD_Carro frame = new BD_Carro();
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
	public BD_Carro() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\ETEC\\3\u00B0ano\\PC\\Workspace\\Exerc\u00EDcios 24jul\\car-flat.png"));
		setTitle("Consulta de Carros");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 463, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblConsultaDeCarros = new JLabel("Informe o modelo do carro a ser pesquisado");
		lblConsultaDeCarros.setForeground(Color.WHITE);
		lblConsultaDeCarros.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConsultaDeCarros.setBounds(60, 11, 328, 25);
		contentPane.add(lblConsultaDeCarros);
		
		JLabel lblIdCarro = new JLabel("ID Carro:");
		lblIdCarro.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIdCarro.setForeground(Color.WHITE);
		lblIdCarro.setBounds(10, 52, 56, 14);
		contentPane.add(lblIdCarro);
		
		JLabel lblFabricante = new JLabel("Fabricante:");
		lblFabricante.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFabricante.setForeground(Color.WHITE);
		lblFabricante.setBounds(10, 105, 77, 14);
		contentPane.add(lblFabricante);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblModelo.setForeground(Color.WHITE);
		lblModelo.setBounds(10, 77, 56, 14);
		contentPane.add(lblModelo);
		
		JLabel lblAno = new JLabel("Ano:");
		lblAno.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAno.setForeground(Color.WHITE);
		lblAno.setBounds(10, 130, 46, 14);
		contentPane.add(lblAno);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPlaca.setForeground(Color.WHITE);
		lblPlaca.setBounds(10, 159, 46, 14);
		contentPane.add(lblPlaca);
		
		JLabel lblCor = new JLabel("Cor:");
		lblCor.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCor.setForeground(Color.WHITE);
		lblCor.setBounds(10, 186, 46, 14);
		contentPane.add(lblCor);
		
		JLabel lblNewLabel = new JLabel("Coment\u00E1rios:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 211, 96, 14);
		contentPane.add(lblNewLabel);
		
		JLabel txtIdCarro = new JLabel("");
		txtIdCarro.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtIdCarro.setForeground(Color.WHITE);
		txtIdCarro.setBounds(72, 52, 46, 14);
		contentPane.add(txtIdCarro);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(70, 75, 110, 20);
		contentPane.add(txtModelo);
		txtModelo.setColumns(10);
		
		txtFabricante = new JTextField();
		txtFabricante.setColumns(10);
		txtFabricante.setBounds(86, 103, 100, 20);
		contentPane.add(txtFabricante);
		
		txtAno = new JTextField();
		txtAno.setColumns(10);
		txtAno.setBounds(52, 128, 66, 20);
		contentPane.add(txtAno);
		
		txtPlaca = new JTextField();
		txtPlaca.setColumns(10);
		txtPlaca.setBounds(52, 157, 86, 20);
		contentPane.add(txtPlaca);
		
		txtCor = new JTextField();
		txtCor.setColumns(10);
		txtCor.setBounds(52, 184, 86, 20);
		contentPane.add(txtCor);
		
		txtComentarios = new JTextField();
		txtComentarios.setColumns(10);
		txtComentarios.setBounds(110, 209, 168, 46);
		contentPane.add(txtComentarios);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBackground(Color.WHITE);
		btnPesquisar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPesquisar.setBounds(199, 72, 100, 25);
		contentPane.add(btnPesquisar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBackground(Color.WHITE);
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLimpar.setBounds(10, 275, 89, 31);
		contentPane.add(btnLimpar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBackground(Color.WHITE);
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAlterar.setBounds(239, 279, 89, 23);
		contentPane.add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBackground(Color.WHITE);
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnExcluir.setBounds(338, 279, 89, 23);
		contentPane.add(btnExcluir);
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.setBackground(Color.WHITE);
		btnIncluir.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnIncluir.setBounds(140, 279, 89, 23);
		contentPane.add(btnIncluir);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("G:\\ETEC\\3\u00B0ano\\PC\\Workspace\\Exerc\u00EDcios 24jul\\audi-q5-taillights-black-wallpapers.jpg"));
		label_1.setBounds(-76, -45, 545, 419);
		contentPane.add(label_1);
		
		btnPesquisar.addActionListener(
				new ActionListener(){
					public void actionPerformed (ActionEvent e){
						if (txtModelo.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Digite o modelo na caixa de texto!", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
						}
						else {
							try {
								Connection con;
								String userName = "root";
								String password = "";
								String url = "jdbc:mysql://127.0.0.1/bd_carro";
								
								Class.forName("com.mysql.jdbc.Driver").newInstance();
								con = DriverManager.getConnection(url, userName, password);
								Statement st = con.createStatement();
								ResultSet rs = st.executeQuery("SELECT * FROM carro WHERE Modelo like '%"+txtModelo.getText()+"%'");
								rs.next();
								
								txtIdCarro.setText(rs.getString("idCarro"));
								txtFabricante.setText(rs.getString("Fabricante"));
								txtModelo.setText(rs.getString("Modelo"));
								txtAno.setText(rs.getString("Ano"));
								txtPlaca.setText(rs.getString("Placa"));
								txtCor.setText(rs.getString("Cor"));
								txtComentarios.setText(rs.getString("Comentarios"));
								
								st.close();
								con.close();
							}
							catch(Exception event){
								JOptionPane.showMessageDialog(null, "Conexão não estabelecida \nCarro não encontrado", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
								txtModelo.setText("");
							}
						}
					}
				}
			);
			
			btnIncluir.addActionListener(
					new ActionListener(){
						public void actionPerformed (ActionEvent e){
							int opcao;
					         Object[] BtSair={"Sim","Não"};
					         opcao = JOptionPane.showOptionDialog(null,"Deseja incluir esse registro?","Confirmação de Inclusão", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, BtSair, BtSair[0]);
					        if(opcao == JOptionPane.YES_OPTION) {
								try {
									Connection con;
									String userName = "root";
									String password = "";
									String url = "jdbc:mysql://127.0.0.1/bd_carro";
									
									Class.forName("com.mysql.jdbc.Driver").newInstance();
									con = DriverManager.getConnection(url, userName, password);
									Statement st = con.createStatement();
									st.executeUpdate("INSERT INTO carro (Fabricante, Modelo, Ano, Placa, Cor, Comentarios ) VALUES ('"+txtFabricante.getText()+"','"+txtModelo.getText()+"','"+txtAno.getText()+"','"+txtPlaca.getText()+"','"+txtCor.getText()+"','"+txtComentarios.getText()+"')");
									
									st.close();
									con.close();
									JOptionPane.showMessageDialog(null, "Registro inserido com sucesso!");
									
									txtFabricante.setText("");
									txtModelo.setText("");
									txtAno.setText("");
									txtPlaca.setText("");
									txtCor.setText("");
									txtComentarios.setText("");
									txtIdCarro.setText("");
																	
								}
								catch(Exception event){
									JOptionPane.showMessageDialog(null, "Conexão não estabelecida", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
								}
					        }
						}
					}
				);

			btnAlterar.addActionListener(
				new ActionListener(){
					public void actionPerformed (ActionEvent e){
						int opcao;
				         Object[] BtSair={"Sim","Não"};
				         opcao = JOptionPane.showOptionDialog(null,"Deseja alterar esse registro?","Confirmação de Alteração", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, BtSair, BtSair[0]);
				        if(opcao == JOptionPane.YES_OPTION) {
							try {
								Connection con;
								String userName = "root";
								String password = "";
								String url = "jdbc:mysql://127.0.0.1/bd_carro";
								
								Class.forName("com.mysql.jdbc.Driver").newInstance();
								con = DriverManager.getConnection(url, userName, password);
								Statement st = con.createStatement();
								st.executeUpdate("UPDATE carro SET Fabricante ='"+txtFabricante.getText()+"', Modelo='"+txtModelo.getText()+"',Ano ='"+txtAno.getText()+"',Placa ='"+txtPlaca.getText()+"',Cor ='"+txtCor.getText()+"',Comentarios ='"+txtComentarios.getText()+"' WHERE idCarro like '"+txtIdCarro.getText()+"'");
								
								st.close();
								con.close();
								JOptionPane.showMessageDialog(null, "Registro alterado com sucesso!");
							}
							catch(Exception event){
								JOptionPane.showMessageDialog(null, "Conexão não estabelecida \nCarro não encontrado", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
							}
				        }
					}
				}
			);
		
			
			btnLimpar.addActionListener(
				new ActionListener(){
					public void actionPerformed (ActionEvent e){
						txtFabricante.setText("");
						txtModelo.setText("");
						txtAno.setText("");
						txtPlaca.setText("");
						txtCor.setText("");
						txtComentarios.setText("");
						txtIdCarro.setText("");
					}
				}
			);
			contentPane.setLayout(null);
			
			btnExcluir.addActionListener(
					new ActionListener(){
						public void actionPerformed (ActionEvent e){
							int opcao;
					         Object[] BtSair={"Sim","Não"};
					         opcao = JOptionPane.showOptionDialog(null,"Deseja excluir esse registro?","Confirmação de Exclusão", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, BtSair, BtSair[0]);
					        if(opcao == JOptionPane.YES_OPTION) {
								try {
									Connection con;
									String userName = "root";
									String password = "";
									String url = "jdbc:mysql://127.0.0.1/bd_carro";
									
									Class.forName("com.mysql.jdbc.Driver").newInstance();
									con = DriverManager.getConnection(url, userName, password);
									Statement st = con.createStatement();
									st.executeUpdate("DELETE FROM carro WHERE idCarro like "+txtIdCarro.getText()+"");

									JOptionPane.showMessageDialog(null, "Registro excluído com sucesso!");
									
									txtFabricante.setText("");
									txtModelo.setText("");
									txtAno.setText("");
									txtPlaca.setText("");
									txtCor.setText("");
									txtComentarios.setText("");
									txtIdCarro.setText("");
									
									st.close();
									con.close();
								}
								catch(Exception event){
									JOptionPane.showMessageDialog(null, "Conexão não estabelecida \nCarro não encontrado", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
								}
							}
						}
					}
				);
	}
}
