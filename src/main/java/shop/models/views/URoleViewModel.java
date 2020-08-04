package shop.models.views;

public class URoleViewModel {

    private String authority;

    public URoleViewModel() {
    }

    public URoleViewModel(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
