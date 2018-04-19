package tanggiamdan;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TiengVietCaiTien extends Frame implements ActionListener {
	Label lb, lb1, lb2;
	Checkbox tang, giam;
	CheckboxGroup cbg;
	TextArea txt;
	TextArea txt1;
	Button xoa, caitien;
	Panel pn, pn1, pn2, pn3, pn4, pn5;

	public void GUI() {
		lb = new Label("Nhập chuỗi cần chuyển đổi");
		lb1 = new Label("Sắp xếp theo chiều");
		lb2 = new Label("Đã cải tiến");

		txt = new TextArea();
		txt1 = new TextArea();

		xoa = new Button("Xóa");
		caitien = new Button("Cải tiến");

		xoa.addActionListener(this);
		caitien.addActionListener(this);

		pn1 = new Panel(new GridLayout(1, 2));
		pn2 = new Panel(new FlowLayout());
		pn3 = new Panel(new FlowLayout());
		pn4 = new Panel(new GridLayout(1, 2));
		pn5 = new Panel(new FlowLayout());
		pn = new Panel(new GridLayout(4, 1));

		pn1.add(lb);
		pn1.add(txt);

		// pn2.add(lb1);
		// pn2.add(tang);
		// pn2.add(giam);

		pn3.add(caitien);

		pn4.add(lb2);
		pn4.add(txt1);

		pn5.add(xoa);

		pn.add(pn1);
		// pn.add(pn2);
		pn.add(pn3);
		pn.add(pn4);
		pn.add(pn5);

		add(pn);

		setSize(500, 500);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == caitien) {
			String text = txt.getText();
			String rs = "";
			int len = text.length();
			for (int i = 0; i < len; i++) {
				rs += text.charAt(i) + " ";
			}
			txt1.setText(rs);
		}
		if (e.getSource() == xoa) {
			txt.setText("");
			txt1.setText("");
		}
	}

	public TiengVietCaiTien(String msg) {
		super(msg);
		GUI();
	}

	public static void main(String[] args) {
		new TiengVietCaiTien("Tiếng Việt cải tiến");
	}

}
