//Topaz Avraham 206842627
import java.util.Map;

/**
 * @author Topaz Avraham
 * This class is used to represent the logical connective "Nor".
 */
public class Nor extends BinaryExpression {

    /**
     * Constructor.
     * @param e1 - the leftSide of the expression.
     * @param e2 - the rightSide of the expression.
     */
    public Nor(Expression e1, Expression e2) {
        super(e1, e2);
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return implementNor(getExpression1().evaluate(assignment), getExpression2().evaluate(assignment));
    }

    /**
     * this method is used to evaluate the result of the expression after calculating the "Nor" operator on it.
     * @param resE1 - the result of the leftSide of the expression
     * @param resE2 - the result of the rightSide of the expression
     * @return the result of the full expression
     */
    public boolean implementNor(boolean resE1, boolean resE2) {
        return !(resE1 || resE2);
    }
    @Override
    public String toString() {
        return ("(" + getExpression1().toString() + " ↓ " + getExpression2().toString() + ")");
    }
    @Override
    public Expression assign(String var, Expression expression) {
        try {
            Expression check1 = getExpression1().assign(var, expression);
            Expression check2 = getExpression2().assign(var, expression);
            return new Nor(check1, check2);

        } catch (Exception e) {
            return null;
        }
    }
    @Override
    public Expression nandify() {
        //= [ ( A NAND A ) NAND ( B NAND B ) ] NAND   [ ( A NAND A ) NAND ( B NAND B ) ]

        Nand nand1 = new Nand(new Nand(getExpression1().nandify(), getExpression1().nandify()),
                new Nand(getExpression2().nandify(), getExpression2().nandify()));

        Nand nand2 = new Nand(new Nand(getExpression1().nandify(), getExpression1().nandify()),
                new Nand(getExpression2().nandify(), getExpression2().nandify()));

        return new Nand(nand1, nand2);
    }
    @Override
    public Expression norify() {
        try {
            return new Nor(getExpression1().norify(), getExpression2().norify());
        } catch (Exception e) {
            return null;
        }
    }


    @Override
    public Expression simplify() {

        Boolean res = isExpressionVal(super.simplify());
        if (res) {
            return super.simplify();
        } else {
            Expression e1 = getExpression1().simplify();
            Expression e2 = getExpression2().simplify();

            if (e1.toString().compareTo("T") == 0 || e2.toString().compareTo("T") == 0) {
                return new Val(false);
            }

            if (e1.toString().compareTo("F") == 0) {
                return new Not(e2);
            }

            if (e2.toString().compareTo("F") == 0) {
                return new Not(e1);
            }

            if (e1.toString().compareTo(e2.toString()) == 0) {
                return new Not(e1);
            }
            return new Nor(e1, e2);
        }
    }
}

