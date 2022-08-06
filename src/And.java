//Topaz Avraham 206842627
import java.util.Map;

/**
 * @author Topaz Avraham
 * This class is used to represent the logical connective "And".
 */
public class And extends BinaryExpression {

    /**
     * Constructor.
     * @param e1 - the leftSide of the expression.
     * @param e2 - the rightSide of the expression.
     */
    public And(Expression e1, Expression e2) {
        super(e1, e2);
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return implementAnd(getExpression1().evaluate(assignment), getExpression2().evaluate(assignment));
    }

    /**
     * this method is used to evaluate the result of the expression after calculating the "And" operator on it.
     * @param resE1 - the result of the leftSide of the expression
     * @param resE2 - the result of the rightSide of the expression
     * @return the result of the full expression
     */
    public boolean implementAnd(boolean resE1, boolean resE2) {
       return resE1 && resE2;
    }

    @Override
    public String toString() {
        return ("(" + getExpression1().toString() + " ∧ " + getExpression2().toString() + ")");
    }

    @Override
    public Expression assign(String var, Expression expression) {
        try {
            Expression check1 = getExpression1().assign(var, expression);
            Expression check2 = getExpression2().assign(var, expression);
            return new And(check1, check2);

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Expression nandify() {
       // = ( A NAND B ) NAND ( A NAND B )

        return new Nand(new Nand(getExpression1().nandify(), getExpression2().nandify()),
                        new Nand(getExpression1().nandify(), getExpression2().nandify()));
    }
    @Override
    public Expression norify() {
        //= ( A NOR A ) NOR ( B NOR B )
        return new Nor(new Nor(getExpression1().norify(), getExpression1().norify()),
                new Nor(getExpression2().norify(), getExpression2().norify()));
    }

    @Override
    public Expression simplify() {

        Boolean res = isExpressionVal(super.simplify());
        if (res) {
            return super.simplify();
        } else {
            Expression e1 = getExpression1().simplify();
            Expression e2 = getExpression2().simplify();

            if (e1.toString().compareTo("T") == 0) {
                return e2;
            }
            if (e2.toString().compareTo("T") == 0) {
                return e1;
            }

            if (e1.toString().compareTo("F") == 0) {
                return e1;
            }

            if (e2.toString().compareTo("F") == 0) {
                return e2;
            }

            if (e1.toString().compareTo(e2.toString()) == 0) {
                return e1;
            }
            return new And(e1, e2);
        }
    }
}

