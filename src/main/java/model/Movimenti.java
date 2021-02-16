package model;

public class Movimenti {
	private int id, iban, idTipoMovimento;
	private float importo;
	private String dataMovimento;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIban() {
		return iban;
	}

	public void setIban(int iban) {
		this.iban = iban;
	}

	public int getIdTipoMovimento() {
		return idTipoMovimento;
	}

	public void setIdTipoMovimento(int idTipoMovimento) {
		this.idTipoMovimento = idTipoMovimento;
	}

	public float getImporto() {
		return importo;
	}

	public void setImporto(float importo) {
		this.importo = importo;
	}

	public String getDataMovimento() {
		return dataMovimento;
	}

	public void setDataMovimento(String dataMovimento) {
		this.dataMovimento = dataMovimento;
	}

	public Movimenti(int id, int iban, int idTipoMovimento, float importo, String dataMovimento) {
		this.id = id;
		this.iban = iban;
		this.idTipoMovimento = idTipoMovimento;
		this.importo = importo;
		this.dataMovimento = dataMovimento;
	}

	public Movimenti() {

	}

}
