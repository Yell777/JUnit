import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Created by User on 22.11.2017.
 */
public class RunCycleRule implements TestRule {

    @Override
    public Statement apply(Statement base, Description desc) {
        return new RunCycleRuleStatement(base, desc);
    }

    public class RunCycleRuleStatement extends Statement {

        private final Statement base;
        private Description desc;

        public RunCycleRuleStatement(Statement base, Description desc) {
            this.base = base;
            this.desc = desc;
        }

        @Override
        public void evaluate() throws Throwable {
            if (desc.getAnnotation(UnstableTest.class) != null) {
                try {
                    base.evaluate();
                } catch (Throwable t) {
                    System.out.println("Failed on first attempt: " + desc);
                    base.evaluate();
                }
            }

        }

    }
}
