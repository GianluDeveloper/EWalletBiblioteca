package response;

import java.util.List;

import model.TipoMovimento;

public class ResponseTipoMovimento extends Response {
	private List<TipoMovimento> tipoMovimento;

	public List<TipoMovimento> getTipoMovimento() {
		return tipoMovimento;
	}

	public void setTipoMovimento(List<TipoMovimento> tipoMovimento) {
		this.tipoMovimento = tipoMovimento;
	}

}
