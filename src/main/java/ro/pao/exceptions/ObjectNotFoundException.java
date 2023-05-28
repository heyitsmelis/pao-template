package ro.pao.exceptions;

public sealed class ObjectNotFoundException extends Exception permits RestaurantNotFoundException {

    public ObjectNotFoundException(String message) {
        super(message);
    }
}