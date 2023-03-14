package persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import model.ClienteM;

public class ClienteDao {
	private Connection c;
	private String msg;
	public Connection getC() {
		return c;
	}
	public void setC(Connection c) {
		this.c = c;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public ClienteDao() {
		DaoC dc = new DaoC();
		try {
			c = dc.getC();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void OPT(ClienteM cm, String opt) throws SQLException {
		String sql = "{CALL OPT (?,?,?,?,?,?,?)}";
		CallableStatement cs = c.prepareCall(sql);
		cs.setString(1, opt);
		cs.setString(2, cm.getCpf());
		cs.setString(3, cm.getNome());
		cs.setString(4, cm.getEmail());
		cs.setDouble(5, cm.getLimitC());
		if(cm.getData() != null) {
			cs.setDate(6, Date.valueOf(cm.getData()));
		}
		else {
			cs.setDate(6, null);
		}
		cs.registerOutParameter(7, Types.VARCHAR);
		cs.execute();
		setMsg(cs.getString(7));
		cm.setMsg(cs.getString(7));
		System.out.println(getMsg());
	}
	public ClienteM Buscar(ClienteM cm) throws SQLException {
		String sql = "SELECT C.CPF,C.NOME,C.EMAIL,C.LIMITE_DE_CREDITO,C.DT_NASCIMENTO FROM CLIENTE C WHERE C.CPF = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, cm.getCpf());
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			cm.setNome(rs.getString("NOME"));
			cm.setEmail(rs.getString("EMAIL"));
			cm.setLimitC(rs.getDouble("LIMITE_DE_CREDITO"));
			cm.setData(rs.getDate("DT_NASCIMENTO").toLocalDate());
		}
		return cm;
	}
	public List<ClienteM> Listar() throws SQLException {
		String sql = "SELECT C.CPF,C.NOME,C.EMAIL,C.LIMITE_DE_CREDITO,C.DT_NASCIMENTO FROM CLIENTE C";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<ClienteM> lc = new ArrayList<ClienteM>();
		while(rs.next()) {
			ClienteM cm = new ClienteM();
			cm.setCpf(rs.getString("CPF"));
			cm.setNome(rs.getString("NOME"));
			cm.setEmail(rs.getString("EMAIL"));
			cm.setLimitC(rs.getDouble("LIMITE_DE_CREDITO"));
			cm.setData(rs.getDate("DT_NASCIMENTO").toLocalDate());
			lc.add(cm);
		}
		return lc;
	}
}
