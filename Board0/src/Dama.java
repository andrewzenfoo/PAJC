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
		
		for(int j=0, i=1; j<3; j++, i-=size+1) {
			for(; i<size; i+=2) {
				addPezzo(""+k++, i, j, Tipo.PEDINA, Colore.BIANCO);
			}
		}
		
		for(int j=0, i=1; j<3; j++, i-=size+1) {
			for(; i<size; i+=2) {
				addPezzo(""+k++, i, size-j-1, Tipo.PEDINA, Colore.NERO);
			}
		}		
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
		
		if(pezzo != null) {
			pezzo.posizione = new Point(x, y);
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
}
