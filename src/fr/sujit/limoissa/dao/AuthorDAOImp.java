package fr.sujit.limoissa.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.sujit.limoissa.beans.Author;



public class AuthorDAOImp implements InterfaceDAO<Author> {
	
	//private DAOFactory daoFactory;
	private final String COLUMN_ID = "id";
	private final String COLUMN_FIRSTNAME = "firstname";
	private final String COLUMN_LASTNAME = "lastname";
	private final String COLUMN_COUNTRY = "country";
	
	private Connection cnx;
	private Statement statement;
	
	public AuthorDAOImp() {
		//this.daoFactory = DAOFactory.getInstance();
	}
	
	private void executeQuery(String query) {
		cnx = DAOFactory.getInstance().getConnection();
		
		try {
			statement = cnx.createStatement();
			statement.execute(query);

			} catch (SQLException e) { 
				e.printStackTrace();
			} catch (NullPointerException e) {
				e.printStackTrace();
			}
		
	}
	@Override
	public Author find(int id) {
		Author author = new Author();
		

		executeQuery("SELECT * FROM Author WHERE id=" + id);

		try {

			ResultSet result = statement.getResultSet();

			if (result.next()) {
				author.setId(result.getInt(COLUMN_ID));
				author.setFirstname(result.getString(COLUMN_FIRSTNAME));
				author.setLastname(result.getString(COLUMN_LASTNAME));
				author.setCountry(result.getString(COLUMN_COUNTRY));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DAOFactory.getInstance().closeConnection(cnx);
		}
		return author;
	}

	@Override
	public void delete(int id) {
		executeQuery("DELETE FROM Author WHERE id=" + id);

			DAOFactory.getInstance().closeConnection(cnx);
		
	}	
	@Override
	public void update(Author obj) {
        executeQuery("UPDATE Author SET "
                + " id = " + obj.getId()
                + " firstname = " + obj.getFirstname()
                + " lastname = " + obj.getLastname()
                + " country = " + obj.getCountry()
        		+ " WHERE id = " + obj.getId());
        DAOFactory.getInstance().closeConnection(cnx);
        // TODO Auto-generated method stub

    }
	@Override
	public void create(Author obj) {
		executeQuery("INSERT INTO Author(firstname, lastname, native_country) VALUES"
				+ "("
				+ obj.getFirstname() + ","
				+ obj.getLastname() + ","
				+ obj.getCountry() + ","
				+")");
		DAOFactory.getInstance().closeConnection(cnx);

	}
	@Override
	public List<Author> findAll() {
		List<Author> authors = new ArrayList<Author>();
		
		executeQuery("SELECT * FROM Author");
		
		try {
			ResultSet result = statement.getResultSet();
			
			while (result.next()) {
				authors.add(
						new Author(
							result.getInt(COLUMN_ID),
							result.getString(COLUMN_FIRSTNAME),
							result.getString(COLUMN_LASTNAME),
							result.getString(COLUMN_COUNTRY)
								)
						);
			}
		
		}
	
		catch (SQLException e) {
			e.printStackTrace();
		}
		return authors;
}
	public InterfaceDAO<Author> getAuthorDAO() {
		return new AuthorDAOImp();
	}

}
