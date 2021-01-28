package model;

public class ContoCorrente {
	

	private int iban,idCliente;
	private float saldo;
	private String dataCreazione;
	
	public ContoCorrente() {
		
	}

	public ContoCorrente(int iban, int idCliente, float saldo, String dataCreazione) {
		this.setIban(iban);
		this.setIdCliente(idCliente);
		this.setSaldo(saldo);
		this.setDataCreazione(dataCreazione);;
	}

	public int getIban() {
		return iban;
	}

	public void setIban(int iban) {
		this.iban = iban;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public String getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(String dataCreazione) {
		this.dataCreazione = dataCreazione;
	}
	
}
