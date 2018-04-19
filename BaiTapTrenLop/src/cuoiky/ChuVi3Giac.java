package cuoiky;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChuVi3Giac extends JFrame implements ActionListener {

	JPanel pn1, pn2, pn3, pn4, pn5, pn6;
	JTextField txtCanhA, txtCanhB, txtCanhC, txtKq;
	JLabel lbCanhA, lbCanhB, lbCanhC, lbKq;
	JButton btnTinhCV, btnTinhDT;

	public ChuVi3Giac(String title) {
		super(title);
		GUI();
	}

	public void GUI() {
		setLayout(new GridLayout(6, 1));

		pn1 = new JPanel(new FlowLayout());
		lbCanhA = new JLabel("Độ dài cạnh a: ");
		txtCanhA = new JTextField(15);
		pn1.add(lbCanhA);
		pn1.add(txtCanhA);
		add(pn1);

		pn2 = new JPanel(new FlowLayout());
		lbCanhB = new JLabel("Độ dài cạnh b: ");
		txtCanhB = new JTextField(15);
		pn2.add(lbCanhB);
		pn2.add(txtCanhB);
		add(pn2);

		pn3 = new JPanel(new FlowLayout());
		lbCanhC = new JLabel("Độ dài cạnh c: ");
		txtCanhC = new JTextField(15);
		pn3.add(lbCanhC);
		pn3.add(txtCanhC);
		add(pn3);

		pn4 = new JPanel(new FlowLayout());
		btnTinhCV = new JButton("Tính Chu Vi");
		btnTinhCV.addActionListener(this);
		pn4.add(btnTinhCV);
		add(pn4);

		pn5 = new JPanel(new FlowLayout());
		btnTinhDT = new JButton("Tính Diện Tích");
		btnTinhDT.addActionListener(this);
		pn5.add(btnTinhDT);
		add(pn5);

		pn6 = new JPanel(new FlowLayout());
		lbKq = new JLabel("Kết quả:");
		txtKq = new JTextField(15);
		txtKq.setEditable(false);
		pn6.add(lbKq);
		pn6.add(txtKq);
		add(pn6);

		setSize(400, 300);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnTinhCV) {
			try {
				float canhA = Float.parseFloat(txtCanhA.getText());
				float canhB = Float.parseFloat(txtCanhB.getText());
				float canhC = Float.parseFloat(txtCanhC.getText());
				if (isTamGiac(canhA, canhB, canhC)) {
					txtKq.setText(((Float) (canhA + canhB + canhC)).toString());
				} else {
					txtKq.setText("3 cạnh không hợp lệ");
				}
			} catch (Exception ex) {
				txtKq.setText("Vui lòng nhập dữ liệu hợp lệ");
			}
		}

		if (e.getSource() == btnTinhDT) {
			try {
				float canhA = Float.parseFloat(txtCanhA.getText());
				float canhB = Float.parseFloat(txtCanhB.getText());
				float canhC = Float.parseFloat(txtCanhC.getText());
				if (isTamGiac(canhA, canhB, canhC)) {
					float p = (canhA + canhB + canhC) / 2;
					txtKq.setText(Double.toString(Math.sqrt(p * (p - canhA) * (p - canhB) * (p - canhC))));
				} else {
					txtKq.setText("3 cạnh không hợp lệ");
				}
			} catch (Exception ex) {
				txtKq.setText("Vui lòng nhập dữ liệu hợp lệ");
			}
		}
	}

	public boolean isTamGiac(float a, float b, float c) {
		return ((a + b > c) && (b + c > a) && (a + c > b));
	}

	public static void main(String[] args) {
		new ChuVi3Giac("Tính chu vi tam giác");
	}

}
