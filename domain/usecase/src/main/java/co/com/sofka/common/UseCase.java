package co.com.sofka.common;

public interface UseCase<RequestType, ResponseType> {
    ResponseType execute(RequestType request);
}
