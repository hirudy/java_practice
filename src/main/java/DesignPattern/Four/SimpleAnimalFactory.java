package DesignPattern.Four;

/**
 * @author: rudy
 * @date: 2016/10/20
 *
 * 简单工厂模式
 */
public class SimpleAnimalFactory {

    public static Animal createAnimal(String animalName){
        switch (animalName){
            case "dog":{
                return new Dog();
            }
            case "cat":{
                return new Cat();
            }
        }

        return null;
    }
}
