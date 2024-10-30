package co.sofka.gateway;

import java.util.List;

public interface CrudRepository <T>{
    void create(T t);
    void update(T t);
    void delete(T t);
    T getById(String id);
}
