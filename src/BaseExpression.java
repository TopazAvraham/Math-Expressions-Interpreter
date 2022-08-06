//Topaz Avraham 206842627
import java.util.TreeMap;

/**
 * @author Topaz Avraham
 * This class is used to represent a basic logical expression.
 */
public abstract class BaseExpression implements Expression {
    @Override
    public Boolean evaluate() throws Exception {
        TreeMap map = new TreeMap<>();
        Boolean res = evaluate(map);
        return res;
    }

    /**
     * this method receives an expression and determines whether it contains only value or not.
     * @param e - the expression
     * @return -true if the expression contains only values, false otherwise
     */
    public Boolean isExpressionVal(Expression e) {
        if (e.toString().compareTo("T") == 0 || e.toString().compareTo("F") == 0) {
            return true;
        }
        return false;
    }



}
