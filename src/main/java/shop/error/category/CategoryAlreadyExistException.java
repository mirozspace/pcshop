package shop.error.category;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import shop.error.CustomBaseException;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Category Already exist")
public class CategoryAlreadyExistException extends CustomBaseException {

	private static final long serialVersionUID = 1L;

	public CategoryAlreadyExistException(String message) {
        super(message);
    }
}
