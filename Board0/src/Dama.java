import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Dama {
	
	int size;
	enum Tipo {PEDINA, PEDONE}
	enum Colore {BIANCO, NERO}
	
	public class Pezzo {
		String id;
		Tipo tipo; 
		Colore colore;
		Point posizione;
		
		Pezzo(String id, Point posizione, Tipo tipo, Colore colore) {
			this.id = id;
			this.posizione = posizione;
			this.tipo = tipo;
			this.colore = colore;
		}	
	}
	
	private HashMap<String, Dama.Pezzo> listaPezzi = new HashMap<>();
	
	private void addPezzo(String id, int x, int y, Tipo tipo, Colore colore) {
		
		listaPezzi.put(id, this.new Pezzo(id, new Point(x, y), tipo, colore));
		
	}
	
	public Dama(int size) {
		this.size = size;
		int k = 0;
		
		for(int j=0, i=1; j<3; j++, i-=size+1) 
			for(; i<size; i+=2) 
				addPezzo(""+k++, i, j, Tipo.PEDINA, Colore.BIANCO);
					
		for(int j=0, i=0; j<3; j++, i-=size+1) 
			for(; i<size; i+=2) 
				addPezzo(""+k++, i, size-j-1, Tipo.PEDINA, Colore.NERO);
	}
	
	public Collection<Dama.Pezzo> listaPezzi() {
		return listaPezzi.values();
	}
	
	public int getBoardSize() {
		return size;
	}
	
	//	Gestione movimento pezzi
	private Pezzo selectedPezzo;
	
	public Pezzo getSelectedPezzo() {
		return selectedPezzo;
	}
	
	public void setSelectedPezzo(Pezzo pezzo) {
		this.selectedPezzo = pezzo;
	}
	
	public Pezzo getPezzoAtPos(Point pos) {
		for(Pezzo p : listaPezzi())
			if(p.posizione.equals(pos))
				return p;
		return null;
	}
	
	public Pezzo getPezzo(String id) {
		return listaPezzi.get(id);
	}

	public Boolean move(String idPezzo, int x, int y) {
		Pezzo pezzo = listaPezzi.get(idPezzo);
		Point posFinale = new Point(x, y);
		ArrayList<Point> mosse = new ArrayList();
		
		for(Pezzo p : listaPezzi()) {
			if(pezzo.colore.equals(Colore.BIANCO)) {
				if(pezzo.tipo.equals(Tipo.PEDINA)) {
					mosse.add(new Point(pezzo.posizione.x+1, pezzo.posizione.y+1));
					mosse.add(new Point(pezzo.posizione.x-1, pezzo.posizione.y+1));
				}
				else {
					mosse.add(new Point(pezzo.posizione.x+1, pezzo.posizione.y+1));
					mosse.add(new Point(pezzo.posizione.x-1, pezzo.posizione.y+1));
					mosse.add(new Point(pezzo.posizione.x+1, pezzo.posizione.y-1));
					mosse.add(new Point(pezzo.posizione.x-1, pezzo.posizione.y-1));
				}
			}
			else {
				if(pezzo.tipo.equals(Tipo.PEDINA)) {
					mosse.add(new Point(pezzo.posizione.x+1, pezzo.posizione.y-1));
					mosse.add(new Point(pezzo.posizione.x-1, pezzo.posizione.y-1));
				}
				else {
					mosse.add(new Point(pezzo.posizione.x+1, pezzo.posizione.y+1));
					mosse.add(new Point(pezzo.posizione.x-1, pezzo.posizione.y+1));
					mosse.add(new Point(pezzo.posizione.x+1, pezzo.posizione.y-1));
					mosse.add(new Point(pezzo.posizione.x-1, pezzo.posizione.y-1));					
				}
			}
			
		}
		//Se selezione una casella dove non dovrebbe andare il pezzo si muove in una casella valida
		if(((pezzo != null && pezzo.colore.equals(Colore.BIANCO) && posFinale.y > pezzo.posizione.y) ||		//Controllo che il pezzo non si muova all'indietro
				(pezzo != null && pezzo.colore.equals(Colore.NERO) && posFinale.y < pezzo.posizione.y)) &&	//Controllo che il pezzo non si muova all'indietro
				(posFinale.x > 0 && posFinale.x < size && posFinale.y > 0 && posFinale.y < size) &&			//Controllo che posFinale sia dentro la board
				(posFinale.x < pezzo.posizione.x + 2 && posFinale.x > pezzo.posizione.x - 2)) {				
			for(int i=0; i<mosse.size(); i++) {
				if(!posFinale.equals(mosse.get(i))) {
					mosse.remove(i);
					//pezzo.posizione = new Point(x,y);
					//return true;
				}
				//else 
					//pezzo.posizione = new Point(x, y);
				
			}

			pezzo.posizione = mosse.get(0).getLocation();
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
}
