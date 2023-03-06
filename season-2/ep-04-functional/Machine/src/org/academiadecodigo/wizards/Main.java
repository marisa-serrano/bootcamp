package org.academiadecodigo.wizards;

public class Main {
    public static void main(String[] args) {

        MonoOperation<Integer, Integer> multiplyByItself = num -> num *= num;
        MonoOperation<Integer, Integer> doube = num -> num += num;
        MonoOperation<Integer, Integer> increment = num -> ++num;

        BiOperation<Integer, Integer> add = (n1, n2) -> n1 + n2;
        BiOperation<Integer, Integer> multiply = (n1, n2) -> n1 * n2;

        BiOperation<Boolean, Integer> isGreaterThan = (n1, n2) -> n1 > n2;
        MonoOperation<String, String> upperCase = string -> string = string.toUpperCase();

        Machine<Integer, Integer> intMachine = new Machine<>();
        Machine<String, String> stringMachine = new Machine<>();
        Machine<Boolean, Integer> booleanIntegerMachine = new Machine<>();

        System.out.println(intMachine.executeMono(multiplyByItself, 6));
        System.out.println(intMachine.executeMono());

        System.out.println(intMachine.executeBi(add, 3, 4));
        System.out.println(intMachine.executeMono(increment, 2));
        System.out.println(stringMachine.executeMono(upperCase, "olá, malta"));
        System.out.println(booleanIntegerMachine.executeBi(isGreaterThan, 3, 4));






        Fighter fighter1 = new Fighter(80, 100, true);
        Fighter fighter2 = new Fighter(75, 0, false);
        Fighter fighter3 = new Fighter(90, 50, true);

        MonoOperation<Boolean, Fighter> isStrong = f1 -> f1.getStrength() > 80;
        MonoOperation<Boolean, Fighter> isHealthy = f1 -> f1.getHealth() > 60;
        BiOperation<Fighter, Fighter> getStrongerFighter = (f1, f2) -> (f1.getStrength() > f2.getStrength()) ? f1 : f2;

        Machine<Boolean, Fighter> booleanFighterMachine = new Machine<>();
        System.out.println(booleanFighterMachine.executeMono(isHealthy, fighter2));
    }
}