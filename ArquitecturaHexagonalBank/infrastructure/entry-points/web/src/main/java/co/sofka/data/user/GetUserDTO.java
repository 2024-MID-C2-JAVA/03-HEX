package co.sofka.data.user;

public class GetUserDTO {
    private String id;

    public GetUserDTO() {}

    public GetUserDTO(String id) {
        this.id = id;
    }

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}
}
