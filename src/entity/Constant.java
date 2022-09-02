package entity;


public enum Constant {

    // Bonuses definitions
    MULTI_BALL(1, "multi-ball"),
    WIDE_PADDLE(2, "wide-paddle"),
    STICKY_PADDLE(3, "sticky-paddle"),
    LASER(4, "laser");

    public int code;
    public String msg;

    Constant(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
