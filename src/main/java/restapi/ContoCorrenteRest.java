package restapi;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.RicercaDb;

import dao.ContoCorrenteDao;
import exceptions.NotHandledTypeException;
import model.ContoCorrente;
import response.Response;
import response.ResponseContoCorrente;

@Path("ContoCorrente")
public class ContoCorrenteRest {

	ContoCorrenteDao contoCorrenteDao = new ContoCorrenteDao();

	
	@POST
	@Path("/insert")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insert(ContoCorrente d) {
		Response r = new Response();
		try {
			contoCorrenteDao.insert(d);
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

	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(ContoCorrente d) {
		Response r = new Response();
		try {
			contoCorrenteDao.update(d);
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

	@DELETE
	@Path("/remove")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response remove(ContoCorrente d) {
		Response r = new Response();
		try {
			contoCorrenteDao.remove(d);
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
	public ResponseContoCorrente findById(@QueryParam("id") String Id) {
		
		ResponseContoCorrente r = new ResponseContoCorrente();
		try {
			int id = Integer.parseInt(Id);
			List<ContoCorrente> c = new ArrayList<>();
			c.add(contoCorrenteDao.findById(id));
			r.setContoCorrente(c);
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
	public ResponseContoCorrente findAll(@QueryParam("reverse") String Reverse) {
		Boolean reverse=false;
		ResponseContoCorrente r = new ResponseContoCorrente();
		try {
			if(Reverse!=null) {
				reverse = Boolean.parseBoolean(Reverse);
			}
				
			r.setContoCorrente(contoCorrenteDao.findAll(reverse));
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
	@Path("/find")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseContoCorrente find(@QueryParam("key") String key,@QueryParam("value") String value) {
		ResponseContoCorrente r = new ResponseContoCorrente();
		try {
			RicercaDb ricercaDb = new RicercaDb();
			ricercaDb.setKey(key);
			ricercaDb.setValue(value);
			r.setContoCorrente(contoCorrenteDao.find(ricercaDb));
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