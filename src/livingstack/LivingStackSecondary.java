package livingstack;

public abstract class LivingStackSecondary<T> implements LivingStack<T> {

    @Override
    public boolean isEmpty() {
        return this.length() == 0;
    }

}
