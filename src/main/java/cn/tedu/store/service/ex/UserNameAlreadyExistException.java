package cn.tedu.store.service.ex;

public class UserNameAlreadyExistException extends RuntimeException {
	
	private static final long serialVersionUID = -9162448296610474601L;

	public UserNameAlreadyExistException() {
		super();
	}

	public UserNameAlreadyExistException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserNameAlreadyExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserNameAlreadyExistException(String message) {
		super(message);
	}

	public UserNameAlreadyExistException(Throwable cause) {
		super(cause);
	}
	

}
