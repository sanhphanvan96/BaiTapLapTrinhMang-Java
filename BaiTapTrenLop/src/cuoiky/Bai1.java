package cuoiky;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Bai1 {

	/**
	 * @param args
	 */
	Frame fr;
	Panel p1, p3, p11, p12, p13, p2, p21, p22, pc, ps;
	Label l1, l2, l3;
	Button b1, b2;
	TextField tf;
	TextArea ta;
	CheckboxGroup cbg;
	Checkbox c1, c2;
	GridBagLayout gb;
	GridBagConstraints gbc;

	public void loadUI() {
		fr = new Frame();
		fr.setLayout(new GridLayout(3, 1));
		fr.setBounds(300, 300, 400, 300);
		fr.setTitle("Bai so 1");

		// pc = new Panel();

		p1 = new Panel();
		p1.setLayout(new GridLayout(3, 3));
		l1 = new Label("Nhập số n: ");
		tf = new TextField(10);
		l2 = new Label("Sắp xếp theo chiều:");
		cbg = new CheckboxGroup();
		c1 = new Checkbox("Tăng dần", cbg, true);
		c2 = new Checkbox("Giảm dần", cbg, false);
		b1 = new Button("Hiển thị");
		p1.add(l1);
		p1.add(tf);
		p1.add(new Label(""));
		p1.add(l2);
		p1.add(c1);
		p1.add(c2);
		p1.add(new Label(""));
		p1.add(b1);
		p1.add(new Label(""));

		p2 = new Panel();
		p2.setLayout(new BorderLayout());

		p21 = new Panel();
		gb = new GridBagLayout();
		gbc = new GridBagConstraints();
		p21.setLayout(gb);
		l3 = new Label("Kết quả:              ");
		ta = new TextArea(4, 30);
		// .setSize(200, 100);
		// p21.add(l3); p21.add(ta);
		addComp(l3, 0, 0, 1, 1);
		addComp(ta, 1, 0, 1, 1);

		p22 = new Panel();
		p22.setLayout(new GridLayout(1, 3));
		b2 = new Button("Xóa");
		p22.add(new Label(""));
		p22.add(b2);
		p22.add(new Label(""));

		p2.add(p21, BorderLayout.CENTER);
		p2.add(p22, BorderLayout.SOUTH);

		fr.add(p1);
		fr.add(p2);
		// fr.add(p3);
		fr.setVisible(true);
		addLsn();
		fr.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	void addComp(Component c, int col, int row, int ncol, int nrow) {
		gbc.gridx = col;
		gbc.gridy = row;
		gbc.gridwidth = ncol;
		gbc.gridheight = nrow;
		gb.setConstraints(c, gbc);
		p21.add(c);
	}

	void addLsn() {
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				int n, i;
				String lb, kq = "";
				n = Integer.parseInt(tf.getText());
				if (n < 0)
					ta.setText("Không thực hiện được");
				else {
					lb = cbg.getSelectedCheckbox().getLabel();
					if (lb.equals("Tăng dần")) {
						for (i = 1; i <= n; i += 2)
							kq += String.valueOf(i) + " ";
					} else {
						if (n % 2 != 0)
							n--;
						for (i = n; i >= 0; i -= 2)
							kq += String.valueOf(i) + " ";
					}
					ta.setText(kq);
				}
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				tf.setText("");
				ta.setText("");
			}
		});
	}

	public static void main(String[] args) {
		Bai1 dt = new Bai1();
		dt.loadUI();
	}
}
