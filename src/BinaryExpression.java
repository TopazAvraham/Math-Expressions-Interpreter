//Topaz Avraham 206842627
import java.util.LinkedList;
import java.util.List;

/**
 * @author Topaz Avraham
 * This class is used to represent a binary logical expression.
 */
public abstract class BinaryExpression extends BaseExpression {
    private Expression e1;
    private Expression e2;

    /**
     * Constructor.
     * @param e1 - the leftSide of the expression.
     * @param e2 - the rightSide of the expression.
     */
    public BinaryExpression(Expression e1, Expression e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    @Override
    public List<String> getVariables() {
        List<String> list = new LinkedList<String>();

        list.addAll(e1.getVariables());
        list.addAll(e2.getVariables());

        List<String> listWithoutDuplicates = new LinkedList<String>();

        for (int i = 0; i < list.size(); i++) {
            if (!listWithoutDuplicates.contains(list.get(i))) {
                listWithoutDuplicates.add(list.get(i));
            }
        }
        return listWithoutDuplicates;
    }

    /**
     * @return the leftSide of the expression
     */
    protected Expression getExpression1() {
        return this.e1;
    }

    /**
     * @return the rightSide of the expression
     */
    protected Expression getExpression2() {
        return this.e2;
    }

    @Override
    public abstract Expression assign(String var, Expression expression);
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
        } catch (Exception e) {
            return this;
        }
    }
}
