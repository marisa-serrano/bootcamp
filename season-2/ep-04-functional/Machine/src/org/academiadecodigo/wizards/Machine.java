package org.academiadecodigo.wizards;

public class Machine<T, E> {

    public T executeMono(MonoOperation<T, E> monoOperation, E arg) {
        return monoOperation.operation(arg);
    }

    public T executeBi(BiOperation<T, E> biOperation, E arg1, E arg2) {
        return biOperation.operation(arg1, arg2);
    }
}