package shop.error.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import shop.error.CustomBaseException;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "User With This Id is not found!")
public class UserWithThisIdNotFoundException extends CustomBaseException {

	public UserWithThisIdNotFoundException(String message) {
		super(message);
	}

}
