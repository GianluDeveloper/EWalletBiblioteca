package response;

import java.util.List;

import model.ContoCorrente;

public class ResponseContoCorrente extends Response {
	private List<ContoCorrente> contoCorrente;

	public List<ContoCorrente> getContoCorrente() {
		return contoCorrente;
	}

	public void setContoCorrente(List<ContoCorrente> contiCorrente) {
		this.contoCorrente = contiCorrente;
	}

}
