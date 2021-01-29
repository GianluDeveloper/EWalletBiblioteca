package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DBHandler;
import com.RicercaDb;

import model.TipoMovimento;

public class TipoMovimentoDao {
	

	public void insert(TipoMovimento d) throws Exception {
		Object[] campi = {d.getDescrizione()};
		String sql = "INSERT INTO `tipomovimento`( `descrizione`) VALUES (?)";
		DBHandler dbHandler = new DBHandler();
		dbHandler.sql(sql, campi);

	}
	
	public void update(TipoMovimento d) throws Exception {
		Object[] campi = {d.getDescrizione(),d.getIdTipoMovimento()};
		String sql = "UPDATE `tipomovimento` SET `descrizione`=? WHERE idTipoMovimento=?";
		DBHandler dbHandler = new DBHandler();
		dbHandler.sql(sql, campi);
	}
	
	public void remove(TipoMovimento d) throws ClassNotFoundException, SQLException,Exception {
		Object[] campi = {d.getIdTipoMovimento()};
		String sql = "DELETE FROM `tipomovimento` WHERE `idTipoMovimento`=? ";
		DBHandler dbHandler = new DBHandler();
		dbHandler.sql(sql, campi);
	}
	
	public TipoMovimento findById(int id) throws ClassNotFoundException, SQLException,Exception {
		Object[] campi = {id};
		String sql = "SELECT `idTipoMovimento`,`tipomovimento` FROM `tipomovimento` WHERE `idTipoMovimento`=? ";
		DBHandler dbHandler = new DBHandler();
		dbHandler.sql(sql, campi);
		List<Object> responses = dbHandler.getResponse();
		if(responses.size()<1) {
			throw new Exception("Non trovato");
		}
		Object [] r = (Object[])responses.get(0);
		
		TipoMovimento c = new TipoMovimento((int)r[0],(String)r[1]);
		return c;
		//return (ContoCorrente) dbHandler.getResponse();
	}
	
	public List<TipoMovimento> find(RicercaDb ricercaDb) throws Exception {
		
		String key = ricercaDb.getKey();
		String value = ricercaDb.getValue();
		
		List<TipoMovimento> res = new ArrayList<>();
		
		String[]allowed = {"idTipoMovimento","tipomovimento"};
		boolean notAllowed=true;
		for(String allow:allowed) {
			if(key.equals(allow)) {
				notAllowed=false;
				break;
			}
		}
		if(notAllowed) {
			throw new Exception("Chiave colonna '"+key+"' non valida");
		}
		
		Object[] campi = {value};
		String sql = "SELECT * FROM `tipomovimento` WHERE `"+key+"`=?  ";
		DBHandler dbHandler = new DBHandler();
		dbHandler.sql(sql, campi);
		List<Object>objs = dbHandler.getResponse();
		for(Object obj:objs) {
			Object[]tmp =(Object[]) obj;
			TipoMovimento c = new TipoMovimento((int)tmp[0],(String)tmp[1]);
			res.add(c);
		}
		return res;
	}
	
	public List<TipoMovimento> findAll(boolean reverse) throws Exception {
		List<TipoMovimento> res = new ArrayList<>();
		Object[] campi = {1};
		String sort = reverse?"DESC":"ASC";
		String sql = "SELECT * FROM `tipomovimento` WHERE ? ORDER BY idTipoMovimento "+sort;
		DBHandler dbHandler = new DBHandler();
		dbHandler.sql(sql, campi);
		List<Object>objs = dbHandler.getResponse();
		for(Object obj:objs) {
			Object[]tmp =(Object[]) obj;
			TipoMovimento c = new TipoMovimento((int)tmp[0],(String)tmp[1]);
			res.add(c);
		}
		return res;
	}
}
