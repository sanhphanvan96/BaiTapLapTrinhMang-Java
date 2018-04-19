package Caro;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class CoCaroOffline extends JFrame implements MouseListener{
	public static void main(String[] args) {
		new CoCaroOffline();
	}
	int so = 100;
	int s = 20;
	int m = 50;
	List<Point> dadanh = new ArrayList<>();
	public CoCaroOffline() {
		this.setTitle("Caro Offline");
		this.setSize(so*s + 2*m, so*s + 2*m);
		this.setDefaultCloseOperation(3);
		this.addMouseListener(this);
		this.setVisible(true);
	}
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getWidth());
		
		g.setColor(Color.BLACK);
		for (int i = 0; i<=so; i++) {
			g.drawLine(m, m + i*s, m + so*s, m + i*s);
			g.drawLine(m + i*s, m, m + i*s, m + so*s);
		}
		g.setFont(new Font("arial", Font.BOLD, s));
		for (int i = 0; i<dadanh.size(); i++) {
			String st = "o";
			g.setColor(Color.BLUE);
			if (i%2 == 1) {
				st = "x";
				g.setColor(Color.RED);
			}
			int x = dadanh.get(i).x*s+m + s/2 - s/4;
			int y = dadanh.get(i).y*s+m + s/2 + s/4;
			g.drawString(st, x, y);
 		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		if (x<m || x>= m+so*s || y<m || y>= m+so*s) return;
		
		int xi = (x-m)/s;
		int yi = (y-m)/s;
		for (int i = 0; i < dadanh.size(); i++) {
			int oldxi = dadanh.get(i).x;
			int oldyi = dadanh.get(i).y;
			if (xi == oldxi && yi == oldyi) return;
		}
		dadanh.add(new Point(xi, yi));
		this.repaint();
		System.out.println("click");
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
