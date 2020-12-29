package shop.models.entities;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Authority extends BaseEntity implements GrantedAuthority {
	
	private String authority;

    public Authority() {
    }

    public Authority(String authority) {
        this.authority = authority;
    }
    public Authority(String id, String authority) {
        super(id);
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
