package unit.user.parts;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import user.bean.RegistrantInfo;
import user.parts.RegInfDAO;

public class NRegInfDAO {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			System.setProperty(Context.INITIAL_CONTEXT_FACTORY,
					"org.apache.naming.java.javaURLContextFactory");
			System.setProperty(Context.URL_PKG_PREFIXES,
					"org.apache.naming");
			InitialContext ic = new InitialContext();

			ic.createSubcontext("java:");
			ic.createSubcontext("java:comp");
			ic.createSubcontext("java:comp/env");
			ic.createSubcontext("java:comp/env/jdbc");

			MysqlDataSource ds = new MysqlDataSource();
			ds.setUser("root");
			ds.setPassword("root");
			ds.setURL("jdbc:mysql://localhost/Task");

			ic.bind("java:comp/env/jdbc/Task", ds);

		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void ninsert() {
		RegInfDAO ch = new RegInfDAO();
		ch.insert("004", "佐藤路未央", "28");
		ArrayList<RegistrantInfo> ar = ch.getReglist();
		assertEquals("001",ar.get(0).getrId());
		assertEquals("鈴木太郎",ar.get(0).getrName());
		assertEquals("35",ar.get(0).getrAge());
		assertEquals("002",ar.get(1).getrId());
		assertEquals("Tommy",ar.get(1).getrName());
		assertEquals("25",ar.get(1).getrAge());
		assertEquals("003",ar.get(2).getrId());
		assertEquals("山田花子",ar.get(2).getrName());
		assertEquals("30",ar.get(2).getrAge());
		assertEquals("004",ar.get(3).getrId());
		assertEquals("佐藤路未央",ar.get(3).getrName());
		assertEquals("28",ar.get(3).getrAge());
	}

	@Test
	public void nupdate() {
		RegInfDAO ch = new RegInfDAO();
		ch.update("002", "Michael", "29");
		ArrayList<RegistrantInfo> ar = ch.getReglist();
		assertEquals("001",ar.get(0).getrId());
		assertEquals("鈴木太郎",ar.get(0).getrName());
		assertEquals("35",ar.get(0).getrAge());
		assertEquals("002",ar.get(1).getrId());
		assertEquals("Michael",ar.get(1).getrName());
		assertEquals("29",ar.get(1).getrAge());
		assertEquals("003",ar.get(2).getrId());
		assertEquals("山田花子",ar.get(2).getrName());
		assertEquals("30",ar.get(2).getrAge());
	}

	@Test
	public void ndelete() {
		RegInfDAO ch = new RegInfDAO();
		ch.delete("001");
		ArrayList<RegistrantInfo> ar = ch.getReglist();
		assertEquals("002",ar.get(0).getrId());
		assertEquals("Tommy",ar.get(0).getrName());
		assertEquals("25",ar.get(0).getrAge());
		assertEquals("003",ar.get(1).getrId());
		assertEquals("山田花子",ar.get(1).getrName());
		assertEquals("30",ar.get(1).getrAge());
	}

	@Test
	public void ngetReglist() {
		RegInfDAO ch = new RegInfDAO();
		ArrayList<RegistrantInfo> ar = ch.getReglist();
		assertEquals("001",ar.get(0).getrId());
		assertEquals("鈴木太郎",ar.get(0).getrName());
		assertEquals("35",ar.get(0).getrAge());
		assertEquals("002",ar.get(1).getrId());
		assertEquals("Tommy",ar.get(1).getrName());
		assertEquals("25",ar.get(1).getrAge());
		assertEquals("003",ar.get(2).getrId());
		assertEquals("山田花子",ar.get(2).getrName());
		assertEquals("30",ar.get(2).getrAge());
	}

	@Test
	public void ngetNextId() {
		RegInfDAO ch = new RegInfDAO();
		String nextId = ch.getNextId();
		assertEquals("001",nextId);
	}
}
