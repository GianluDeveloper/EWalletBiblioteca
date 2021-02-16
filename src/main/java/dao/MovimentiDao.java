package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DBHandler;
import com.DateHandler;
import com.RicercaDb;

import model.Movimenti;

public class MovimentiDao {

	public void insert(Movimenti d) throws Exception {
		Object[] campi = { d.getIban(), d.getIdTipoMovimento(), d.getImporto(),
				DateHandler.toSql(d.getDataMovimento()) };
		String sql = "INSERT INTO `movimenti`( `iban`, `idTipoMovimento`, `importo`, `dataMovimento`) VALUES (?,?, ?, ?)";
		DBHandler dbHandler = new DBHandler();
		dbHandler.sql(sql, campi);

	}

	public void update(Movimenti d) throws Exception {
		Object[] campi = { d.getIban(), d.getIdTipoMovimento(), d.getImporto(), DateHandler.toSql(d.getDataMovimento()),
				d.getId() };
		String sql = "UPDATE `movimenti` SET `iban`=?,`idTipoMovimento`=?,`importo`=?,`dataMovimento`=? WHERE id=?";
		DBHandler dbHandler = new DBHandler();
		dbHandler.sql(sql, campi);
	}

	public void remove(Movimenti d) throws ClassNotFoundException, SQLException, Exception {
		Object[] campi = { d.getId() };
		String sql = "DELETE FROM `movimenti` WHERE `id`=? ";
		DBHandler dbHandler = new DBHandler();
		dbHandler.sql(sql, campi);
	}

	public Movimenti findById(int id) throws ClassNotFoundException, SQLException, Exception {
		Object[] campi = { id };
		String sql = "SELECT `id`, `iban`, `idTipoMovimento`, `importo`, `dataMovimento` FROM `movimenti` WHERE `id`=? ";
		DBHandler dbHandler = new DBHandler();
		dbHandler.sql(sql, campi);
		List<Object> responses = dbHandler.getResponse();
		if (responses.size() < 1) {
			throw new Exception("Non trovato");
		}
		Object[] r = (Object[]) responses.get(0);

		Movimenti c = new Movimenti((int) r[0], (int) r[1], (int) r[2], (float) r[3],
				DateHandler.fromSql((java.sql.Date) r[4]));
		return c;
		// return (ContoCorrente) dbHandler.getResponse();
	}

	public List<Movimenti> find(RicercaDb ricercaDb) throws Exception {

		String key = ricercaDb.getKey();
		String value = ricercaDb.getValue();

		List<Movimenti> res = new ArrayList<>();

		String[] allowed = { "id", "iban", "idTipoMovimento", "importo", "dataMovimento" };
		boolean notAllowed = true;
		for (String allow : allowed) {
			if (key.equals(allow)) {
				notAllowed = false;
				break;
			}
		}
		if (notAllowed) {
			throw new Exception("Chiave colonna '" + key + "' non valida");
		}

		Object[] campi = { value };
		String sql = "SELECT `id`, `iban`, `idTipoMovimento`, `importo`, `dataMovimento` FROM `movimenti` WHERE `" + key
				+ "`=?  ";
		DBHandler dbHandler = new DBHandler();
		dbHandler.sql(sql, campi);
		List<Object> objs = dbHandler.getResponse();
		for (Object obj : objs) {
			Object[] tmp = (Object[]) obj;
			Movimenti c = new Movimenti((int) tmp[0], (int) tmp[1], (int) tmp[2], (float) tmp[3],
					DateHandler.fromSql((java.sql.Date) tmp[4]));
			res.add(c);
		}
		return res;
	}

	public List<Movimenti> findAll(boolean reverse) throws Exception {
		List<Movimenti> res = new ArrayList<>();
		Object[] campi = { 1 };
		String sort = reverse ? "DESC" : "ASC";
		String sql = "SELECT `id`, `iban`, `idTipoMovimento`, `importo`, `dataMovimento` FROM `movimenti` WHERE ? ORDER BY id "
				+ sort;
		DBHandler dbHandler = new DBHandler();
		dbHandler.sql(sql, campi);
		List<Object> objs = dbHandler.getResponse();
		for (Object obj : objs) {
			Object[] tmp = (Object[]) obj;
			Movimenti c = new Movimenti((int) tmp[0], (int) tmp[1], (int) tmp[2], (float) tmp[3],
					DateHandler.fromSql((java.sql.Date) tmp[4]));
			res.add(c);
		}
		return res;
	}

}
