package shop.error.manufacturer;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import shop.error.CustomBaseException;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Manufacturer cannot be update!")
public class ManufacturerUpdateException extends CustomBaseException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ManufacturerUpdateException(String msg) {
        super(msg);
    }
}
