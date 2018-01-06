package fr.sujit.limoissa.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.sujit.limoissa.beans.Author;
import fr.sujit.limoissa.beans.Book;



public class BookDAOImp implements InterfaceDAO<Book>{
	
//	private DAOFactory daoFactory;
	private final String COLUMN_ID = "id";
	private final String COLUMN_TITLE = "title";
	private final String COLUMN_AVAILABILITY = "availability";
	private final String COLUMN_PRICE = "price";
	private final String COLUMN_OVERVIEW = "overview";

	private Connection cnx;
	private Statement statement;

	public BookDAOImp() {
//		this.daoFactory = DAOFactory.getInstance();
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
	public Book find(int id) {
		Book book = new Book();

		executeQuery("SELECT * FROM Book b JOIN Authors_Books ab ON ab.book_id=Book.id WHERE id=" + id);

		try {

			ResultSet result = statement.getResultSet();

			while (result.next()) {
				Author author = DAOFactory.getInstance().getAuthorDAO().find(result.getInt("author_id"));

				if (result.next()) {
					book.setId(result.getInt(COLUMN_ID));
					book.setTitle(result.getString(COLUMN_TITLE));
					book.setAvailability(result.getBoolean(COLUMN_AVAILABILITY));
					book.setPrice(result.getFloat(COLUMN_PRICE));
					book.setOverview(result.getString(COLUMN_OVERVIEW));
				}
				book.addAuthor(author);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DAOFactory.getInstance().closeConnection(cnx);
		}
		return book;
	}

	@Override
	public void delete(int id) {
		executeQuery("DELETE FROM Book WHERE id=" + id);

		DAOFactory.getInstance().closeConnection(cnx);

	}

	@Override
	public void update(Book obj) {
		executeQuery("UPDATE Book SET " + " title = " + obj.getTitle() + " price = " + obj.getPrice() + " overview = "
				+ obj.getOverview() + " availability = " + obj.isAvailability() + " WHERE id = " + obj.getId());
		DAOFactory.getInstance().closeConnection(cnx);
		// TODO Auto-generated method stub

	}
	
	public int findBookIdByTitle(String title) {
		int id = -1;
		executeQuery("SELECT id FROM Book WHERE title = '" + title +"'");

		ResultSet result;
		try {
			result = statement.getResultSet();
			if (result.next()) {
				id = result.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return id;
	}

	@Override
	public void create(Book obj) {
		// Book existe ?
		int id = findBookIdByTitle(obj.getTitle());
		if (-1 != id) {
			System.out.println("Le livre existe déjà !");
		} else {
			// Insertion du livre
			executeQuery("INSERT INTO Book(title, overview, price, availability) VALUES"
					+ "('"
					+ obj.getTitle() + "','"
					+ obj.getOverview() + "','"
					+ obj.getPrice() + "','"
					+ (obj.isAvailability() ? 1 : 0)
					+ "')");
			
			// Ajout auteur s'il n'existe pas
			List<Author> authors = DAOFactory.getInstance().getAuthorDAO().findAll();
			boolean found;
			
			for (Author author : obj.getAuthors()) {
				found = false;
				
				for (Author a : authors) {
					if (a.getFirstname().equals(author.getFirstname())
							&& a.getLastname().equals(author.getLastname())
							&& a.getCountry().equals(author.getCountry())) {
						found = true;
					}
				}
				
				if (!found) DAOFactory.getInstance().getAuthorDAO().create(author);
			}
			
			// Jonction entre book et ses auteurs
			authors = DAOFactory.getInstance().getAuthorDAO().findAll();
			for (Author author : authors) {
				found = false;
				
				for (Author a : obj.getAuthors()) {
					if (a.getFirstname().equals(author.getFirstname())
							&& a.getLastname().equals(author.getLastname())
							&& a.getCountry().equals(author.getCountry())) {
						found = true;
					}
				}
				
				if (found) {
					executeQuery("INSERT INTO Authors_Books VALUES "
						+ "('" + author.getId() + "','"
						+  findBookIdByTitle(obj.getTitle()) + "')");
				}
			}
			
			DAOFactory.getInstance().closeConnection(cnx);}
	}
//	@Override
//	public void create(Book obj) {
//		executeQuery("INSERT INTO Book(title, overview, price, availability) VALUES" + "(" + obj.getTitle() + ","
//				+ obj.getOverview() + "," + obj.getPrice() + "," + obj.isAvailability() + ")");
//		daoFactory.closeConnection(cnx);
//
//	}

	@Override
	public List<Book> findAll() {
		Map<Integer, Book> books = new HashMap<Integer, Book>();
		// List<Book> books = new ArrayList<Book>();

		executeQuery("SELECT * FROM Book b JOIN Authors_Books ab ON b.id=ab.book_id");

		try {
			ResultSet result = statement.getResultSet();

			while (result.next()) {
				Author author = DAOFactory.getInstance().getAuthorDAO().find(result.getInt("author_id"));
				Book book = new Book(result.getInt(COLUMN_ID), result.getString(COLUMN_TITLE),
						result.getString(COLUMN_OVERVIEW), result.getFloat(COLUMN_PRICE),
						result.getBoolean(COLUMN_AVAILABILITY), new ArrayList<Author>()

				);
				
				if (books.containsKey(book.getId())) {
					books.get(book.getId()).addAuthor(author);
				} else {
					book.addAuthor(author);
					books.put(book.getId(), book);
				}
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		return new ArrayList<Book>(books.values());
	}

	public InterfaceDAO<Book> getBookDAO() {
		return new BookDAOImp();
	}

}
