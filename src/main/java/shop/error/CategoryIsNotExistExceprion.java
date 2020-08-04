package shop.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Category Is Not Exist!")
public class CategoryIsNotExistExceprion extends CustomBaseException {

	public CategoryIsNotExistExceprion(String message) {
		super(message);
	}

}
