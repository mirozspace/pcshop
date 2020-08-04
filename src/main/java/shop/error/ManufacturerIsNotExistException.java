package shop.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Manufacturer cannot be saved!")
public class ManufacturerIsNotExistException extends CustomBaseException {

    public ManufacturerIsNotExistException(String msg) {
        super(msg);
    }
}
