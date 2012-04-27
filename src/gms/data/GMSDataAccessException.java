package gms.data;

import properties.ApplicationStrings;
import util.ApplicationException;

public class GMSDataAccessException extends ApplicationException {

	private static final long serialVersionUID = 1L;

	public GMSDataAccessException(ApplicationStrings string) {
		super(string);
	}

}
