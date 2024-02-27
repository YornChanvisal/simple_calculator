package Exception;

public class DivideBy0Exception extends Exception {

    public DivideBy0Exception(){
        super("You can't divide a number by 0. The result will be INFINITY");
    }
}
