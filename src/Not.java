//Topaz Avraham 206842627
import java.util.Map;

/**
 * @author Topaz Avraham
 * This class is used to represent the logical connective "Not".
 */
public class Not extends UnaryExpression {

    /**
     * Constructor.
     * @param e - the expression
     */
    public Not(Expression e) {
        super(e);
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return implementNot(getExpression().evaluate(assignment));
    }

    /**
     * this method is used to evaluate the result of the expression after calculating the "Not" operator on it.
     * @param resE - the expression
     * @return the result of the full expression
     */
    public boolean implementNot(boolean resE) {
        return !resE;
    }
    @Override
    public String toString() {
        return ("~(" + getExpression().toString() + ")");
    }
    @Override
    public Expression nandify() {
        return new Nand(getExpression().nandify(), getExpression().nandify());
    }
    @Override
    public Expression norify() {
        return new Nor(this.getExpression().norify(), this.getExpression().norify());
    }
    @Override
    public Expression simplify() {

        Expression e = getExpression().simplify();
        if (e.toString().compareTo("T") == 0) {
            return new Val(false);
        }
        if (e.toString().compareTo("F") == 0) {
            return new Val(true);
        }

        return new Not(e);

    }
}





