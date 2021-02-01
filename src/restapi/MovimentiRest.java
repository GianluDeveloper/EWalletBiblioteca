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

import dao.MovimentiDao;
import exceptions.NotHandledTypeException;
import model.Movimenti;
import response.ResponseMovimenti;

@Path("Movimenti")
public class MovimentiRest {
	MovimentiDao movimentiDao = new MovimentiDao();

	@GET
	@Path("/find")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMovimenti find(@QueryParam("key") String key,@QueryParam("value") String value) {
		ResponseMovimenti r = new ResponseMovimenti();
		try {
			RicercaDb ricercaDb = new RicercaDb();
			ricercaDb.setKey(key);
			ricercaDb.setValue(value);
			r.setMovimenti(movimentiDao.find(ricercaDb));
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
	public ResponseMovimenti findById(@QueryParam("id") String Id) {
		
		ResponseMovimenti r = new ResponseMovimenti();
		try {
			int id = Integer.parseInt(Id);
			List<Movimenti> c = new ArrayList<>();
			c.add(movimentiDao.findById(id));
			r.setMovimenti(c);
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
	public ResponseMovimenti findAll(@QueryParam("reverse") String Reverse) {
		ResponseMovimenti r = new ResponseMovimenti();
		boolean reverse = false;
		try {
			if(Reverse!=null) {
				reverse = Boolean.parseBoolean(Reverse);
			}
			r.setMovimenti(movimentiDao.findAll(reverse));
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
