package shop.error.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import shop.error.CustomBaseException;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Passwords not matches!")
public class UserPasswordsNotMatchException extends CustomBaseException {

	private static final long serialVersionUID = 1L;

	public UserPasswordsNotMatchException(String message) {
		super(message);
	}

}
