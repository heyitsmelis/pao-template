package ro.pao.exceptions;

public final class RestaurantNotFoundException extends ObjectNotFoundException{

    public RestaurantNotFoundException(String message) {
        super("Restaurant not found!" + " : " + message);
    }
}
