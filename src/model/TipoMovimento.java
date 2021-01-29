package model;

public class TipoMovimento {
	private int idTipoMovimento;
	private String descrizione;
	
	public int getIdTipoMovimento() {
		return idTipoMovimento;
	}
	public void setIdTipoMovimento(int idTipoMovimento) {
		this.idTipoMovimento = idTipoMovimento;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public TipoMovimento(int idTipoMovimento, String descrizione) {
		this.idTipoMovimento = idTipoMovimento;
		this.descrizione = descrizione;
	}
	public TipoMovimento() {
		
	}
}
