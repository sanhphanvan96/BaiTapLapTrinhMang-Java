package cuoiky;

import java.awt.*;
import java.awt.event.*;

public class Bai11 extends Frame implements ActionListener {
	Label lb1, lb2, lb3;
	Button btnShow, btnReset;
	TextField txt;
	TextArea tarea;
	CheckboxGroup cbg;
	Panel pn, pn1, pn2, pn3, pn4, pn5;

	public void GUI() {
		setLayout(new GridLayout(3, 1));
		setBounds(700, 100, 600, 400);
		setTitle("Bài tập 1.1");

		lb1 = new Label("Nhập số n: ");
		lb2 = new Label("Sắp xếp theo chiều: ");
		lb3 = new Label("Kết quả:                           ");

		btnShow = new Button("Hiển thị");
		btnReset = new Button("Xóa");

		btnShow.addActionListener(this);
		btnReset.addActionListener(this);

		txt = new TextField();
		tarea = new TextArea(4, 45);
		tarea.setEditable(false);

		cbg = new CheckboxGroup();
		Checkbox cb1 = new Checkbox("Tăng dần", true, cbg);
		Checkbox cb2 = new Checkbox("Giảm dần", false, cbg);

		pn1 = new Panel(new GridLayout(3, 3));
		pn1.setSize(10, 10);
		// pn1.setBackground(Color.red);
		pn1.add(lb1);
		pn1.add(txt);
		pn1.add(new Label(""));
		pn1.add(lb2);
		pn1.add(cb1);
		pn1.add(cb2);
		pn1.add(new Label(""));
		pn1.add(btnShow);
		pn1.add(new Label(""));

		pn2 = new Panel(new FlowLayout());
		pn2.setSize(10, 10);
		pn2.add(lb3);
		pn2.add(tarea);

		pn3 = new Panel(new GridLayout(3, 3));
		pn3.setSize(10, 10);
		pn3.add(new Label(""));
		pn3.add(btnReset);
		for (int i = 0; i < 6; i++) {
			pn3.add(new Label(""));
		}
		add(pn1);
		add(pn2);
		add(pn3);

		setVisible(true);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		new Bai11().GUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnShow) {
			int number = Integer.parseInt(txt.getText());
			String msg = "", select;
			select = cbg.getSelectedCheckbox().getLabel();
			if (number < 0) {
				msg = "Không hợp lệ !";
			} else {
				if (select.equalsIgnoreCase("Tăng dần")) {
					for (int i = 0; i <= number; i += 2) {
						msg += i + " ";
					}
				} else {
					for (int i = (number - (number % 2)); i >= 0; i -= 2) {
						msg += i + " ";
					}
				}
			}
			tarea.setText(msg);
		}
		if (e.getSource() == btnReset) {
			txt.setText("");
			tarea.setText("");
		}
	}
}
