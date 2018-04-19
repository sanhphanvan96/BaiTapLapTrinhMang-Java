package io.nano.java;

import java.awt.*;

class Menudemo extends Frame {
	Menudemo(String title) {
		super(title);
		setBounds(300, 200, 200, 200);
		MenuBar mb = new MenuBar();
		setMenuBar(mb);
		Menu f = new Menu("File");
		f.add(new MenuItem("New"));
		f.add(new MenuItem("Open"));
		f.add(new MenuItem("Exit"));
		mb.add(f);
		Menu edit = new Menu("Edit");
		edit.add(new MenuItem("Copy"));
		edit.add(new MenuItem("Cut"));
		edit.add(new MenuItem("Paste"));
		Menu sub = new Menu("Option");
		sub.add(new MenuItem("First"));
		sub.add(new MenuItem("Second"));
		sub.add(new MenuItem("Third"));
		edit.add(sub);
		edit.add(new CheckboxMenuItem("Protected"));
		mb.add(edit);
		this.setVisible(true);
		// show();
	}

	public static void main(String args[]) {
		Menudemo f1 = new Menudemo("Menu Demo");
	}
}