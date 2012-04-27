package util.connection;

import java.util.List;
import util.ApplicationException;

public interface DAO <Type> {

		public void insert(Type t) throws ApplicationException;
		public void update(Type t) throws ApplicationException;
		public void delete(Type t) throws ApplicationException;

		public List<Type> listAll() throws ApplicationException;
		public Type listById(int id) throws ApplicationException;
	
}
