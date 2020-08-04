package shop.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Manufacturer cannot be update!")
public class UpdateManufacturerException extends CustomBaseException {
    public UpdateManufacturerException(String msg) {
        super(msg);
    }
}
