package shop.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Category Already exist")
public class CategoryAlreadyExistException extends CustomBaseException{

    public CategoryAlreadyExistException(String message) {
        super(message);
    }
}
