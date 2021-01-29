package response;

import java.util.List;

import model.Movimenti;

public class ResponseMovimenti extends Response{
	private List<Movimenti> movimenti;

	public List<Movimenti> getMovimenti() {
		return movimenti;
	}

	public void setMovimenti(List<Movimenti> movimenti) {
		this.movimenti = movimenti;
	}

	
}
