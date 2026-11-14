package livingstack;

public interface LivingStackKernel<T> {

    void push(T x);

    T pop();

    T top();

    int length();

    //belonging to creature
    boolean isFat(T x);

    void feed(T x);

    int creatureAge(T x);

    int creatureHealth(T x);

    void feedAll();

}