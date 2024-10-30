package co.sofka.data.user;

public class UserResponseDTO {

    private String id;

    private String name;

    public UserResponseDTO(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public UserResponseDTO(){}

    public String getName(){return name;}

    public void setName(String name){this.name = name;}

}
