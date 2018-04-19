package tanggiamdan;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SapXep extends Frame implements ActionListener {
	Label lb, lb1, lb2;
	Checkbox tang, giam;
	CheckboxGroup cbg;
	TextField txt, txt1;
	Button xoa, tinh;
	Panel pn, pn1, pn2, pn3, pn4, pn5;

	public void GUI() {
		lb = new Label("                    Nhập số n");
		lb1 = new Label("Sắp xếp theo chiều");
		lb2 = new Label("                   Kết quả");

		cbg = new CheckboxGroup();
		tang = new Checkbox("Tăng dần", cbg, true);
		giam = new Checkbox("Giảm dần", cbg, false);

		txt = new TextField();
		txt1 = new TextField();

		xoa = new Button("Xóa");
		tinh = new Button("Hiển thị");

		xoa.addActionListener(this);
		tinh.addActionListener(this);

		pn1 = new Panel(new GridLayout(1, 2));
		pn2 = new Panel(new FlowLayout());
		pn3 = new Panel(new FlowLayout());
		pn4 = new Panel(new GridLayout(1, 2));
		pn5 = new Panel(new FlowLayout());
		pn = new Panel(new GridLayout(5, 1));

		pn1.add(lb);
		pn1.add(txt);

		pn2.add(lb1);
		pn2.add(tang);
		pn2.add(giam);

		pn3.add(tinh);

		pn4.add(lb2);
		pn4.add(txt1);

		pn5.add(xoa);

		pn.add(pn1);
		pn.add(pn2);
		pn.add(pn3);
		pn.add(pn4);
		pn.add(pn5);

		add(pn);

		setSize(400, 300);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == tinh) {
			if (tang.getSelectedObjects() != null) {
				String s = "";
				int a = Integer.parseInt(txt.getText());
				if (a % 2 == 0) {
					for (int i = 1; i <= a - 1; i += 2) {
						s = s + Integer.toString((int) i) + " ";
					}
					txt1.setText(s);
				}

				if (a % 2 != 0) {
					for (int i = 1; i <= a; i += 2) {
						s = s + Integer.toString((int) i) + " ";
					}
					txt1.setText(s);
				}

			}

			if (giam.getSelectedObjects() != null) {
				String s = "";
				int a = Integer.parseInt(txt.getText());
				if (a % 2 == 0) {
					for (int i = a; i >= 0; i -= 2) {
						s = s + Integer.toString((int) i) + " ";
					}
					txt1.setText(s);
				}

				if (a % 2 != 0) {
					for (int i = a - 1; i >= 0; i -= 2) {
						s = s + Integer.toString((int) i) + " ";
					}
					txt1.setText(s);
				}

			}
		}
		if (e.getSource() == xoa) {
			txt.setText("");
			txt1.setText("");
		}
	}

	public SapXep(String msg) {
		super(msg);
		GUI();
	}

	public static void main(String[] args) {
		new SapXep("Sắp xếp");
	}

}
