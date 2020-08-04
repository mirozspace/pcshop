package shop.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Passwords not matches!")
public class PasswordsNotMatchExeption extends CustomBaseException {

	public PasswordsNotMatchExeption(String message) {
		super(message);
	}

}
