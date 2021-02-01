package restapi;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.RicercaDb;

import dao.TipoMovimentoDao;
import exceptions.NotHandledTypeException;
import model.TipoMovimento;
import response.ResponseTipoMovimento;

@Path("/TipoMovimento")
public class TipoMovimentoRest {
	TipoMovimentoDao tipoMovimentoDao = new TipoMovimentoDao();

	@GET
	@Path("/find")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseTipoMovimento find(@QueryParam("key") String key,@QueryParam("value") String value) {
		ResponseTipoMovimento r = new ResponseTipoMovimento();
		try {
			RicercaDb ricercaDb = new RicercaDb();
			ricercaDb.setKey(key);
			ricercaDb.setValue(value);
			r.setTipoMovimento(tipoMovimentoDao.find(ricercaDb));
			r.setSuccesso(true);
		} catch (ParseException e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1001);
			r.setDescription("Parse Exception: " + e.toString());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1002);
			r.setDescription("Class not found exception: " + e.toString());
		} catch (SQLException e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1003);
			r.setDescription("SQL exception: " + e.toString());
		} catch (NotHandledTypeException e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1004);
			r.setDescription("Not Handled Type Exception: " + e.toString());
		} catch (Exception e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1000);
			r.setDescription("Generic exception: " + e.toString());
		}
		return r;
	}

	@GET
	@Path("/findById")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseTipoMovimento findById(@QueryParam("id") String Id) {
		ResponseTipoMovimento r = new ResponseTipoMovimento();
		try {
			int id = Integer.parseInt(Id);
			List<TipoMovimento> c = new ArrayList<>();
			c.add(tipoMovimentoDao.findById(id));
			r.setTipoMovimento(c);
			r.setSuccesso(true);
		} catch (ParseException e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1001);
			r.setDescription("Parse Exception: " + e.toString());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1002);
			r.setDescription("Class not found exception: " + e.toString());
		} catch (SQLException e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1003);
			r.setDescription("SQL exception: " + e.toString());
		} catch (NotHandledTypeException e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1004);
			r.setDescription("Not Handled Type Exception: " + e.toString());
		} catch (Exception e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1000);
			r.setDescription("Generic exception: " + e.toString());
		}
		return r;
	}
	@GET
	@Path("/findAll")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseTipoMovimento findAll(@QueryParam("reverse") String Reverse) {
		ResponseTipoMovimento r = new ResponseTipoMovimento();
		boolean reverse = false;
		try {
			if(Reverse!=null) {
				reverse = Boolean.parseBoolean(Reverse);
			}
			r.setTipoMovimento(tipoMovimentoDao.findAll(reverse));
			r.setSuccesso(true);
		} catch (ParseException e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1001);
			r.setDescription("Parse Exception: " + e.toString());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1002);
			r.setDescription("Class not found exception: " + e.toString());
		} catch (SQLException e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1003);
			r.setDescription("SQL exception: " + e.toString());
		} catch (NotHandledTypeException e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1004);
			r.setDescription("Not Handled Type Exception: " + e.toString());
		} catch (Exception e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1000);
			r.setDescription("Generic exception: " + e.toString());
		}
		return r;
	}
}
