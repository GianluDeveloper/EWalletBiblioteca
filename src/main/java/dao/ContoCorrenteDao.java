package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DBHandler;
import com.DateHandler;
import com.RicercaDb;

import model.ContoCorrente;

public class ContoCorrenteDao {

	public void insert(ContoCorrente d) throws Exception {
		Object[] campi = { d.getIdCliente(), d.getSaldo(), DateHandler.toSql(d.getDataCreazione()) };
		String sql = "INSERT INTO `contocorrente`( `idCliente`, `saldo`, `dataCreazione`) VALUES (?, ?, ?)";
		DBHandler dbHandler = new DBHandler();
		dbHandler.sql(sql, campi);

	}

	public void update(ContoCorrente d) throws Exception {
		Object[] campi = { d.getIdCliente(), d.getSaldo(), DateHandler.toSql(d.getDataCreazione()), d.getIban() };
		String sql = "UPDATE `contocorrente` SET `idCliente`=?,`saldo`=?,`dataCreazione`=? WHERE iban=?";
		DBHandler dbHandler = new DBHandler();
		dbHandler.sql(sql, campi);
	}

	public void remove(ContoCorrente d) throws ClassNotFoundException, SQLException, Exception {
		Object[] campi = { d.getIban() };
		String sql = "DELETE FROM `contocorrente` WHERE `iban`=? ";
		DBHandler dbHandler = new DBHandler();
		dbHandler.sql(sql, campi);
	}

	public ContoCorrente findById(int id) throws ClassNotFoundException, SQLException, Exception {
		Object[] campi = { id };
		String sql = "SELECT `iban`,`idCliente`, `saldo`, `dataCreazione` FROM `contocorrente` WHERE `iban`=? ";
		DBHandler dbHandler = new DBHandler();
		dbHandler.sql(sql, campi);
		List<Object> responses = dbHandler.getResponse();
		if (responses.size() < 1) {
			throw new Exception("Non trovato");
		}
		Object[] r = (Object[]) responses.get(0);

		ContoCorrente c = new ContoCorrente((int) r[0], (int) r[1], (float) r[2],
				DateHandler.fromSql((java.sql.Date) r[3]));
		return c;
		// return (ContoCorrente) dbHandler.getResponse();
	}

	public List<ContoCorrente> find(RicercaDb ricercaDb) throws Exception {

		String key = ricercaDb.getKey();
		String value = ricercaDb.getValue();

		List<ContoCorrente> res = new ArrayList<>();

		String[] allowed = { "iban", "idCliente", "saldo", "dataCreazione" };
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
		String sql = "SELECT * FROM `contocorrente` WHERE `" + key + "`=?  ";
		DBHandler dbHandler = new DBHandler();
		dbHandler.sql(sql, campi);
		List<Object> objs = dbHandler.getResponse();
		for (Object obj : objs) {
			Object[] tmp = (Object[]) obj;
			ContoCorrente c = new ContoCorrente((int) tmp[0], (int) tmp[1], (float) tmp[2],
					DateHandler.fromSql((java.sql.Date) tmp[3]));
			res.add(c);
		}
		return res;
	}

	public List<ContoCorrente> findAll(boolean reverse) throws Exception {
		List<ContoCorrente> res = new ArrayList<>();
		Object[] campi = { 1 };
		String sort = reverse ? "DESC" : "ASC";
		String sql = "SELECT * FROM `contocorrente` WHERE ? ORDER BY iban " + sort;
		DBHandler dbHandler = new DBHandler();
		dbHandler.sql(sql, campi);
		List<Object> objs = dbHandler.getResponse();
		for (Object obj : objs) {
			Object[] tmp = (Object[]) obj;
			ContoCorrente c = new ContoCorrente((int) tmp[0], (int) tmp[1], (float) tmp[2],
					DateHandler.fromSql((java.sql.Date) tmp[3]));
			res.add(c);
		}
		return res;
	}

}
