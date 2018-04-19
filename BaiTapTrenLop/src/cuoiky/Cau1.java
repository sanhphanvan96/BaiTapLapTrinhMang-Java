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

public class Cau1 extends JFrame implements ActionListener {

	JPanel pn1, pn2, pn21, pn22, pn3, pn31, pn32, pn33, pn34;
	JTextField txtMang, txtLoaiBo;
	JLabel lbNhap, lbKqDaoNguoc, lbKqLoaiBo, lbKq1, lbKq2;
	JButton btnDaoNguoc, btnLoaiBo;

	public Cau1(String title) {
		super(title);
		GUI();
	}

	public void GUI() {
		setLayout(new GridLayout(3, 1));

		// Nhap vao mang
		pn1 = new JPanel(new FlowLayout());
		lbNhap = new JLabel("Nhập vào mảng:     ");
		txtMang = new JTextField(15);
		pn1.add(lbNhap);
		pn1.add(txtMang);
		add(pn1);

		// Dao nguoc mang
		pn2 = new JPanel(new GridLayout(1, 2));
		pn21 = new JPanel(new FlowLayout());
		btnDaoNguoc = new JButton("Đảo ngược mảng");
		pn21.add(btnDaoNguoc);
		pn2.add(pn21);

		pn22 = new JPanel(new FlowLayout());
		lbKq1 = new JLabel("Kết quả: ");
		lbKqDaoNguoc = new JLabel();
		pn22.add(lbKq1);
		pn22.add(lbKqDaoNguoc);
		pn2.add(pn22);
		add(pn2);

		pn3 = new JPanel(new GridLayout(2, 1));

		pn31 = new JPanel(new FlowLayout());
		btnLoaiBo = new JButton("Loại bỏ phần tử thứ");
		txtLoaiBo = new JTextField(1);
		pn31.add(btnLoaiBo);
		pn31.add(new JLabel("                  "));
		pn31.add(txtLoaiBo);
		pn31.add(new JLabel("                                "));
		pn31.add(new JPanel());

		pn32 = new JPanel(new FlowLayout());

		lbKq2 = new JLabel("Kết quả:");
		lbKqLoaiBo = new JLabel("");
		pn32.add(new JPanel());
		pn32.add(lbKq2);
		pn32.add(lbKqLoaiBo);

		pn3.add(pn31);
		pn3.add(pn32);
		add(pn3);

		btnDaoNguoc.addActionListener(this);
		btnLoaiBo.addActionListener(this);

		setSize(400, 300);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnDaoNguoc) {
			try {
				String text = txtMang.getText();
				String kq = "";
				for (int i = text.length() - 1; i >= 0; i--) {
					kq += text.charAt(i);
				}

				lbKqDaoNguoc.setText(kq);
			} catch (Exception ex) {
			}
		}

		if (e.getSource() == btnLoaiBo) {
			try {
				String text = txtMang.getText();
				String kq = "";
				Integer index = Integer.parseInt(txtLoaiBo.getText());
				for (int i = text.length() - 1; i >= 0; i--) {
					if (i == index)
						continue;
					kq += text.charAt(i);
				}

				lbKqLoaiBo.setText(kq);
			} catch (Exception ex) {
			}

		}
	}

	

	public static void main(String[] args) {
		new Cau1("Thao tác với mảng");
	}

}
