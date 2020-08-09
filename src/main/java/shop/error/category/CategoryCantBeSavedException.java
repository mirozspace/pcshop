package shop.error.category;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import shop.error.CustomBaseException;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Category cannot be saved!")
public class CategoryCantBeSavedException extends CustomBaseException {

	private static final long serialVersionUID = 1L;

	public CategoryCantBeSavedException(String message) {
        super(message);
    }
}
