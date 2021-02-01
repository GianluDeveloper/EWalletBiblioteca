package service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import com.RicercaDb;

import dao.ContoCorrenteDao;
import exceptions.NotHandledTypeException;
import model.ContoCorrente;
import response.Response;
import response.ResponseContoCorrente;

@WebService
public class ContoCorrenteWS {

	ContoCorrenteDao contoCorrenteDao = new ContoCorrenteDao();

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

	public ResponseContoCorrente find(RicercaDb ricercaDb) {
		ResponseContoCorrente r = new ResponseContoCorrente();
		try {
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

	public ResponseContoCorrente findById(Integer id) {
		ResponseContoCorrente r = new ResponseContoCorrente();
		try {
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

	public ResponseContoCorrente findAll(Boolean reverse) {
		ResponseContoCorrente r = new ResponseContoCorrente();
		try {
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

}
