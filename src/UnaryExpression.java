//Topaz Avraham 206842627
import java.util.LinkedList;
import java.util.List;

/**
 * @author Topaz Avraham
 * This class is used to represent a unary logical expression.
 */
public abstract class UnaryExpression extends BaseExpression {
    private Expression e;

    /**
     * Constructor.
     * @param e - the expression
     */
    public UnaryExpression(Expression e) {
        this.e = e;
    }
    @Override
    public List<String> getVariables() {
        List<String> list = new LinkedList<String>();

        list.addAll(e.getVariables());

        return list;
    }
    @Override
    public Expression assign(String var, Expression exp) {

        try {
            Expression check = e.assign(var, exp);
            return new Not(check);
        } catch (Exception e) {
            return null;
        }
    }

    protected Expression getExpression() {
        return this.e;
    }
    @Override
    public abstract Expression nandify();
    @Override
    public abstract Expression norify();

    @Override
    public Expression simplify() {
        try {
            Boolean res = this.evaluate();
            Val v = new Val(res);
            return v;
        } catch (Exception e1) {

            return this;
        }
    }
}