package d_max.static_map;

/**
 * @user: Maxim Dybarsky | maxim.dybarskyy@gmail.com
 * @date: 8/13/14
 * @time: 2:22 PM
 */
public class StaticMapException extends Exception {

    public StaticMapException(String detailMessage) {
        super(detailMessage);
    }

    public StaticMapException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }
}
