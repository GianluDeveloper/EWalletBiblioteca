package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import com.RicercaDb;

import dao.TipoMovimentoDao;
import model.TipoMovimento;
import response.Response;
import response.ResponseTipoMovimento;

@WebService
public class TipoMovimentoWS {
	TipoMovimentoDao tipoMovimentoDao = new TipoMovimentoDao();

	public Response insert(TipoMovimento d) {
		Response r = new Response();
		try {
			tipoMovimentoDao.insert(d);
			r.setSuccesso(true);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1001);
			r.setDescription(e.toString());
		}catch(Exception e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1000);
			r.setDescription(e.toString());
		}
		
		return r;
	}
	public Response update(TipoMovimento d) {
		Response r = new Response();
		try {
			tipoMovimentoDao.update(d);
			r.setSuccesso(true);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1001);
			r.setDescription(e.toString());
		}catch(Exception e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1000);
			r.setDescription(e.toString());
		}
		
		return r;
	}
	public Response remove(TipoMovimento d) {
		Response r = new Response();
		try {
			tipoMovimentoDao.remove(d);
			r.setSuccesso(true);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1001);
			r.setDescription(e.toString());
		}catch(Exception e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1000);
			r.setDescription(e.toString());
		}
		
		return r;
	}
	public ResponseTipoMovimento find(RicercaDb ricercaDb) {
		ResponseTipoMovimento r = new ResponseTipoMovimento();
		try {
			r.setTipoMovimento(tipoMovimentoDao.find(ricercaDb));
			r.setSuccesso(true);
		} catch (Exception e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1000);
			r.setDescription(e.toString());
		}
		return r;
	}
	public ResponseTipoMovimento findById(Integer id) {
		ResponseTipoMovimento r = new ResponseTipoMovimento();
		try {
			List<TipoMovimento> c = new ArrayList<>();
			c.add(tipoMovimentoDao.findById(id));
			r.setTipoMovimento(c);
			r.setSuccesso(true);
		} catch (Exception e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1000);
			r.setDescription(e.toString());
		}
		return r;
	}
	public ResponseTipoMovimento findAll(Boolean reverse) {
		ResponseTipoMovimento r = new ResponseTipoMovimento();
		try {
			r.setTipoMovimento(tipoMovimentoDao.findAll(reverse));
			r.setSuccesso(true);
		} catch (Exception e) {
			e.printStackTrace();
			r.setSuccesso(false);
			r.setErrorCode(1000);
			r.setDescription(e.toString());
		}
		return r;
	}
	
}
