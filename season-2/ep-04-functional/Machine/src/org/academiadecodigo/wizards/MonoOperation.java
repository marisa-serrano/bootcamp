package org.academiadecodigo.wizards;

public interface MonoOperation<T, E> {
    T operation(E arg);
}