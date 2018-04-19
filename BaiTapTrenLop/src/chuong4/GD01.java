package chuong4;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GD01 extends Frame implements ActionListener {

	private static final long serialVersionUID = 1L;
	Button tinhBtn = new Button("Tinh");
	Button rsBtn = new Button("Reset");
	Button thoatBtn = new Button("Thoat");

	TextField aTf = new TextField(5);
	TextField bTf = new TextField(5);
	TextField kqTf = new TextField(5);

	public float a, b, x;

	public void makeUI() {
		GD01 fr = new GD01();
		fr.setTitle("Chuong trinh giai PTB1");
		fr.setBounds(300, 200, 400, 400);
		fr.setLayout(new GridLayout(3, 1));

		Panel topFrame = new Panel();
		topFrame.setLayout(new GridLayout());
		Label topLabel = new Label("CTGPTB1");
		topFrame.add(topLabel);
		fr.add(topFrame);

		Panel midFrame = new Panel();
		midFrame.setLayout(new GridLayout(3, 2));
		Label aLb = new Label("nhap a");
		Label bLb = new Label("nhap b");
		Label kqLb = new Label("Ket qua");
		kqTf.setEditable(false);
		midFrame.add(aLb);
		midFrame.add(aTf);
		midFrame.add(bLb);
		midFrame.add(bTf);
		midFrame.add(kqLb);
		midFrame.add(kqTf);
		fr.add(midFrame);

		Panel botFrame = new Panel();
		botFrame.setLayout(new GridLayout(1, 3));
		botFrame.add(tinhBtn);
		botFrame.add(rsBtn);
		botFrame.add(thoatBtn);
		fr.add(botFrame);
		fr.setVisible(true);

		addListener();
	}

	void addListener() {
		tinhBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					a = Float.parseFloat(aTf.getText());
					b = Float.parseFloat(bTf.getText());
					if (a == 0 && b == 0)
						kqTf.setText("vo so nghiem");
					else if (a == 0 && b != 0)
						kqTf.setText("vo nghiem");
					else {
						float x = -b / a;
						String out = String.valueOf(x);
						kqTf.setText(out);
					}
				} catch (NumberFormatException nfe) {
					kqTf.setText("Nhap sai so!");
				}
				// return;
			}
		});
		rsBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				aTf.setText("");
				bTf.setText("");
				kqTf.setText("");
				return;
			}
		});
		thoatBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		GD01 obj = new GD01();
		obj.makeUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
