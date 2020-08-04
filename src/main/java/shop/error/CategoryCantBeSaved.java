package shop.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Category cannot be saved!")
public class CategoryCantBeSaved extends CustomBaseException{
    public CategoryCantBeSaved(String message) {
        super(message);
    }
}
