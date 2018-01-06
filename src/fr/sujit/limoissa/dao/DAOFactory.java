package fr.sujit.limoissa.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import fr.sujit.limoissa.beans.Author;
import fr.sujit.limoissa.beans.Book;

/*
 * DAOFactory groupes connection method to data bases
 */

public class DAOFactory {
	
	private static DAOFactory instance;

	private DAOFactory() {
	}

	public static DAOFactory getInstance() { // pattern singleton

		if (null == instance) {
			instance = new DAOFactory();

		}


		return instance;
	}

	public Connection getConnection() {
		Connection cnx = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/library");
			cnx = ds.getConnection();
		} catch (SQLException | NamingException e) {
			e.printStackTrace();
		}
		return cnx;
	}

	public void closeConnection(Connection cnx) { // method to close connection
		try {
			if (null != cnx && !cnx.isClosed()) {
				cnx.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Here we call InterfaceDAO method and send Book and Author as parameter
	
	
	public InterfaceDAO<Book> getBookDAO() {
		return new BookDAOImp();
	}

	public InterfaceDAO<Author> getAuthorDAO() {
		return new AuthorDAOImp();
	}
//
//	public InterfaceDAO<User> getUserDAO() {
//		return new UserDAOImp();
//	}

}
