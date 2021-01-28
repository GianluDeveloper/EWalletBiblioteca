package service;

import javax.jws.WebService;

import dao.MovimentiDao;

@WebService
public class MovimentiWS {
	MovimentiDao movimentiDao = new MovimentiDao();
}
