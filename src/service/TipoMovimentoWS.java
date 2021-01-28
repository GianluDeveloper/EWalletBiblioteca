package service;

import javax.jws.WebService;

import dao.TipoMovimentoDao;

@WebService
public class TipoMovimentoWS {
	TipoMovimentoDao tipoMovimentoDao = new TipoMovimentoDao();
}
