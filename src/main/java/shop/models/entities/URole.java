package shop.models.entities;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "roles")
public class URole extends BaseEntity implements GrantedAuthority {
	
	private String authority;

    public URole() {
    }

    public URole(String authority) {
        this.authority = authority;
    }
    public URole(String id, String authority) {
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