package chuong4;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GD03 extends Frame {
	private static final long serialVersionUID = 1L;
	TextField nTf, kqTf;
	Button timBtn, rsBtn, exitBtn;

	void initialize() {
		GD03 fr = new GD03();
		fr.setTitle("Tim so nguyen to");
		fr.setBounds(300, 200, 400, 200);
		fr.setLayout(new GridLayout(3, 1));

		Panel topPanel = new Panel();
		topPanel.setLayout(new GridLayout());
		Label topLabel = new Label("Cac so nguyen to <= n");
		topPanel.add(topLabel);
		fr.add(topPanel);

		Panel midPanel = new Panel();
		midPanel.setLayout(new GridLayout(2, 2));
		Label nLb = new Label("nhap n");
		nLb.setAlignment(Label.CENTER);
		Label kqLb = new Label("KQ");
		kqLb.setAlignment(Label.CENTER);
		nTf = new TextField(5);
		kqTf = new TextField(5);
		kqTf.setEditable(false);
		midPanel.add(nLb);
		midPanel.add(nTf);
		midPanel.add(kqLb);
		midPanel.add(kqTf);
		fr.add(midPanel);

		Panel botFrame = new Panel();
		botFrame.setLayout(new FlowLayout());
		timBtn = new Button("Tim");
		rsBtn = new Button("Reset");
		exitBtn = new Button("Exit");
		botFrame.add(timBtn);
		botFrame.add(rsBtn);
		botFrame.add(exitBtn);
		fr.add(botFrame);

		fr.setVisible(true);
		addListener();
	}

	public boolean ktNguyenTo(int n) {
		if (n == 2)
			return true;
		if (n < 2)
			return false;
		int soUoc = 0;
		for (int i = 2; i < n; i++)
			if (n % i == 0)
				soUoc++;
		if (soUoc == 0)
			return true;
		else
			return false;
	}

	void addListener() {
		timBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int n;
					String nt = "";
					n = Integer.parseInt(nTf.getText());
					GD03 call = new GD03();
					for (int i = 2; i <= n; i++)
						if (call.ktNguyenTo(i)) {
							// String str = String.valueOf(i);
							nt += String.valueOf(i) + " ";
						}
					kqTf.setText(nt);
				} catch (NumberFormatException nfe) {
					kqTf.setText("Nhap sai so!");
				}
				return;
			}
		});
		rsBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				nTf.setText("");
				kqTf.setText("");
				return;
			}
		});
		exitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		GD03 obj = new GD03();
		obj.initialize();
	}
}