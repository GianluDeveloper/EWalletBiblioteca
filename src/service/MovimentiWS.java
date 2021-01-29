package service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import com.RicercaDb;

import dao.MovimentiDao;
import exceptions.NotHandledTypeException;
import model.Movimenti;
import response.Response;
import response.ResponseMovimenti;

@WebService
public class MovimentiWS {
	MovimentiDao movimentiDao = new MovimentiDao();
	

	public Response insert(Movimenti d) {
		Response r = new Response();
		try {
			movimentiDao.insert(d);
			r.setSuccesso(true);
		} catch (ParseException e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1001);
			r.setDescription("Parse Exception: "+e.toString());
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1002);
			r.setDescription("Class not found exception: "+e.toString());
		} catch(SQLException e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1003);
			r.setDescription("SQL exception: "+e.toString());
		} catch(NotHandledTypeException e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1004);
			r.setDescription("Not Handled Type Exception: "+e.toString());
		} catch (Exception e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1000);
			r.setDescription("Generic exception: "+e.toString());
		}
		
		return r;
	}
	public Response update(Movimenti d) {
		Response r = new Response();
		try {
			movimentiDao.update(d);
			r.setSuccesso(true);
		} catch (ParseException e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1001);
			r.setDescription("Parse Exception: "+e.toString());
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1002);
			r.setDescription("Class not found exception: "+e.toString());
		} catch(SQLException e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1003);
			r.setDescription("SQL exception: "+e.toString());
		} catch(NotHandledTypeException e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1004);
			r.setDescription("Not Handled Type Exception: "+e.toString());
		} catch (Exception e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1000);
			r.setDescription("Generic exception: "+e.toString());
		}
		
		return r;
	}
	public Response remove(Movimenti d) {
		Response r = new Response();
		try {
			movimentiDao.remove(d);
			r.setSuccesso(true);
		} catch (ParseException e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1001);
			r.setDescription("Parse Exception: "+e.toString());
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1002);
			r.setDescription("Class not found exception: "+e.toString());
		} catch(SQLException e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1003);
			r.setDescription("SQL exception: "+e.toString());
		} catch(NotHandledTypeException e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1004);
			r.setDescription("Not Handled Type Exception: "+e.toString());
		} catch (Exception e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1000);
			r.setDescription("Generic exception: "+e.toString());
		}
		
		return r;
	}
	public ResponseMovimenti find(RicercaDb ricercaDb) {
		ResponseMovimenti r = new ResponseMovimenti();
		try {
			r.setMovimenti(movimentiDao.find(ricercaDb));
			r.setSuccesso(true);
		} catch (ParseException e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1001);
			r.setDescription("Parse Exception: "+e.toString());
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1002);
			r.setDescription("Class not found exception: "+e.toString());
		} catch(SQLException e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1003);
			r.setDescription("SQL exception: "+e.toString());
		} catch(NotHandledTypeException e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1004);
			r.setDescription("Not Handled Type Exception: "+e.toString());
		} catch (Exception e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1000);
			r.setDescription("Generic exception: "+e.toString());
		}
		return r;
	}
	public ResponseMovimenti findById(Integer id) {
		ResponseMovimenti r = new ResponseMovimenti();
		try {
			List<Movimenti> c = new ArrayList<>();
			c.add(movimentiDao.findById(id));
			r.setMovimenti(c);
			r.setSuccesso(true);
		} catch (ParseException e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1001);
			r.setDescription("Parse Exception: "+e.toString());
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1002);
			r.setDescription("Class not found exception: "+e.toString());
		} catch(SQLException e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1003);
			r.setDescription("SQL exception: "+e.toString());
		} catch(NotHandledTypeException e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1004);
			r.setDescription("Not Handled Type Exception: "+e.toString());
		} catch (Exception e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1000);
			r.setDescription("Generic exception: "+e.toString());
		}
		return r;
	}
	public ResponseMovimenti findAll(Boolean reverse) {
		ResponseMovimenti r = new ResponseMovimenti();
		try {
			r.setMovimenti(movimentiDao.findAll(reverse));
			r.setSuccesso(true);
		} catch (ParseException e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1001);
			r.setDescription("Parse Exception: "+e.toString());
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1002);
			r.setDescription("Class not found exception: "+e.toString());
		} catch(SQLException e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1003);
			r.setDescription("SQL exception: "+e.toString());
		} catch(NotHandledTypeException e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1004);
			r.setDescription("Not Handled Type Exception: "+e.toString());
		} catch (Exception e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1000);
			r.setDescription("Generic exception: "+e.toString());
		}
		return r;
	}
	
}
