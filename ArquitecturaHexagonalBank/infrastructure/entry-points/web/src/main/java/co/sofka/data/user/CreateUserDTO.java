package co.sofka.data.user;

public class CreateUserDTO {

    private String name;

    public CreateUserDTO(String name) {
        this.name = name;
    }

    public CreateUserDTO(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
