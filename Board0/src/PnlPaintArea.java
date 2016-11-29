import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.*;
import javax.swing.*;

public class PnlPaintArea extends JComponent implements MouseMotionListener, MouseListener {
	
	private int reDraw = 0;
	Point mousePosition = null;	//	In coordinate BOARD
	Point mouseClickPos = null;	//	In coordinate BOARD
	
	Dama game;
	
	public PnlPaintArea() {
		addMouseMotionListener(this);
		addMouseListener(this);
	}
	
	public PnlPaintArea(Dama game) {
		this(); 
		this.game = game;
	}
	
	
	private int size;
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);		
		
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		size = getBoardCellSize();
		
		paintBoard(g);
		paintActiveCell(g);
		paintPezzi(g);
		//paintSelectedCell(g);
	
		g.setColor(Color.red);
		g.drawString(String.format("Redraw: %d", reDraw++), 0,  g.getClipBounds().height);
		
		/*if(mousePosition != null) {
			g.setColor(Color.YELLOW);
			g.fillOval(mousePosition.x, mousePosition.y, 10, 10);
		}*/
	}
	
	void fillOval(Graphics g, Point boardPos, Color color, double sizeFactor) {
		int delta = (int)(size * 0.1);
		int delta2 = delta / 2;
		Point pos = boardToScreen(boardPos);
		
		g.setColor(color);
		g.fillOval(pos.x+delta2, pos.y+delta2, size-delta, size-delta);
	}
	
	void paintPezzi(Graphics g) {
		
		if(game.getSelectedPezzo() != null) 
			fillOval(g, game.getSelectedPezzo().posizione, Color.RED, 0.05);
		
		for(Dama.Pezzo p: game.listaPezzi()) 
			paintPezzo(g, p);
	
	}
	
	void paintPezzo(Graphics g, Dama.Pezzo p) {
		Point pos = boardToScreen(p.posizione);
		Color color = p.colore == Dama.Colore.BIANCO ? Color.GREEN : Color.BLUE;
		g.setColor(color);
		g.fillOval(pos.x, pos.y, (int)(size*0.9), (int)(size*0.9));
	}
	
	Point boardToScreen(Point bc) {
		return new Point(bc.x * size, bc.y * size);
	}
	
	Point screenToBoard(Point sc) {
		return new Point(sc.x / size, sc.y / size);
	}
	
	void paintBoard(Graphics g) {
		int size = getBoardCellSize();
		g.setColor(Color.lightGray);
		g.fillRect(0, 0, size*8, size*8);
		g.setColor(Color.darkGray);
		
		for(int i=0; i<8; i++) 
			for(int j=0; j<8; j++) {
				if((i+j)%2 != 0) {
					int x = i * size;
					int y = j * size;
					g.fillRect(x, y, size, size);
				}
			}
	}
	
	int getBoardCellSize() {
		return Math.min(getHeight(), getWidth()) / game.getBoardSize();
	}
	
	void paintActiveCell(Graphics g) {
		if(mousePosition == null)
			return;
		
		int x = mousePosition.x * size;
		int y = mousePosition.y * size;
		
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, size, size);
	}
	
	/*void paintSelectedCell(Graphics g) {
		if(mouseClickPos == null) 
			return;
		int size = getBoardCellSize();
		int i = mouseClickPos.x / size;
		int j = mouseClickPos.y / size;
		int x = i*size;
		int y = j*size;
		
		g.setColor(Color.RED);
		g.drawRect(x, y, size, size);
	}*/
		
	public void mouseDragged(MouseEvent e) {
		mouseClickPos = e.getPoint();
		repaint();
	}

	public void mouseMoved(MouseEvent e) {
		Point currentMousePosition = screenToBoard(e.getPoint());
		if(mousePosition == null || !currentMousePosition.equals(mousePosition)) {
			mousePosition = screenToBoard(e.getPoint());	
			repaint();
		}
	}	
	
	public void mouseClicked(MouseEvent e) {
		Point boardPos = screenToBoard(e.getPoint());
		
		if(game.getSelectedPezzo() == null) {
			game.setSelectedPezzo(game.getPezzoAtPos(boardPos));
		} else {
			game.move(game.getSelectedPezzo().id, boardPos.x, boardPos.y);
			game.setSelectedPezzo(null);
		}
		
		repaint();
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		mouseClickPos = e.getPoint();
		repaint();
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
