package cuoiky;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChuViTamGiac extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Container con;
	JPanel pn1, pn2, pn3, pn4, pn5, pn6;
	JTextField txtCanhA, txtCanhB, txtCanhC, txtKetQua;
	JButton btnTinhCV, btnTinhDT;

	public ChuViTamGiac(String title) {
		super(title);
		addControls();
		addEvents();
	}

	public void addControls() {
		con = getContentPane();
		con.setLayout(new GridLayout(6, 1));
		
		pn1 = new JPanel();
		pn1.setLayout(new FlowLayout());
		JLabel lblCanhA = new JLabel("Độ dài cạnh a: ");
		txtCanhA = new JTextField(15);
		pn1.add(lblCanhA);
		pn1.add(txtCanhA);
		con.add(pn1);

		pn2 = new JPanel();
		pn2.setLayout(new FlowLayout());
		JLabel lblCanhB = new JLabel("Độ dài cạnh b: ");
		txtCanhB = new JTextField(15);
		pn2.add(lblCanhB);
		pn2.add(txtCanhB);
		con.add(pn2);

		pn3 = new JPanel();
		pn3.setLayout(new FlowLayout());
		JLabel lblCanhC = new JLabel("Độ dài cạnh c: ");
		txtCanhC = new JTextField(15);
		pn3.add(lblCanhC);
		pn3.add(txtCanhC);
		con.add(pn3);

		pn4 = new JPanel();
		pn4.setLayout(new FlowLayout());
		btnTinhDT = new JButton("Tính diện tích");
		btnTinhDT.setPreferredSize(txtCanhA.getPreferredSize());
		JLabel lbl1 = new JLabel("");
		lbl1.setPreferredSize(lblCanhA.getPreferredSize());
		pn4.add(lbl1);
		pn4.add(btnTinhDT);
		con.add(pn4);

		pn5 = new JPanel();
		pn5.setLayout(new FlowLayout());
		btnTinhCV = new JButton("Tính Chu Vi");
		btnTinhCV.setPreferredSize(txtCanhA.getPreferredSize());
		JLabel lbl2 = new JLabel("");
		lbl2.setPreferredSize(lblCanhA.getPreferredSize());
		pn5.add(lbl2);
		pn5.add(btnTinhCV);
		con.add(pn5);

		pn6 = new JPanel();
		pn6.setLayout(new FlowLayout());
		JLabel lblKetQua = new JLabel("Kết quả: ");
		lblKetQua.setPreferredSize(lblCanhA.getPreferredSize());
		txtKetQua = new JTextField(15);
		txtKetQua.setEditable(false);
		pn6.add(lblKetQua);
		pn6.add(txtKetQua);
		con.add(pn6);

	}

	public void addEvents() {
		btnTinhCV.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					float a = Float.parseFloat(txtCanhA.getText());
					float b = Float.parseFloat(txtCanhB.getText());
					float c = Float.parseFloat(txtCanhC.getText());
					if (ktTamGiac(a, b, c)) {
						txtKetQua.setText(Float.toString(a + b + c));
					} else {
						txtKetQua.setText("Đây không phải tam giác");
						txtCanhA.setText("");
						txtCanhB.setText("");
						txtCanhC.setText("");
						txtCanhA.requestFocus();
					}
				} catch (Exception e) {
					txtKetQua.setText("Nhập sai định dạng số");
					txtCanhA.setText("");
					txtCanhB.setText("");
					txtCanhC.setText("");
					txtCanhA.requestFocus();
				}
			}
		});
		btnTinhDT.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					float a = Float.parseFloat(txtCanhA.getText());
					float b = Float.parseFloat(txtCanhB.getText());
					float c = Float.parseFloat(txtCanhC.getText());
					if (ktTamGiac(a, b, c)) {
						float p = (a + b + c) / 2;
						txtKetQua.setText(Double.toString(Math.sqrt(p * (p - a) * (p - b) * (p - c))));
					} else {
						txtKetQua.setText("Đây không phải tam giác");
						txtCanhA.setText("");
						txtCanhB.setText("");
						txtCanhC.setText("");
						txtCanhA.requestFocus();
					}
				} catch (Exception e1) {
					txtKetQua.setText("Nhập sai định dạng số");
					txtCanhA.setText("");
					txtCanhB.setText("");
					txtCanhC.setText("");
					txtCanhA.requestFocus();
				}
			}
		});
	}

	public boolean ktTamGiac(float a, float b, float c) {
		if ((a + b <= c) || (a + c <= b) || (b + c <= a)) {
			return false;
		} else {
			return true;
		}
	}

	public void showWindow() {
		this.setSize(400, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public static void main(String args[]) {
		ChuViTamGiac obj = new ChuViTamGiac("Chu Vi Tam Giac");
		obj.showWindow();
	}
}