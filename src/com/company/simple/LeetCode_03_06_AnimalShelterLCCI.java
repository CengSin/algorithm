package com.company.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @description: notcallme
 * @author: 15262
 * @date: 2020/3/3
 */

class Animal {
    private int type;

    private int index;

    public Animal(int index, int type) {
        this.type = type;
        this.index = index;
    }

    public int getType() {
        return type;
    }

    public int getIndex() {
        return index;
    }
}

class AnimalShelf {

    private List<Animal> animals;

    public AnimalShelf() {
        animals = new ArrayList<>();
    }

    public void enqueue(int[] animal) {
        animals.add(new Animal(animal[0], animal[1]));
    }

    public int[] dequeueAny() {
        if (animals == null || animals.size() == 0) return new int[]{-1, -1};
        Animal animal = animals.get(0);
        animals.remove(animal);
        return new int[]{animal.getIndex(), animal.getType()};
    }

    public int[] dequeueDog() {
        return getAnimal(1);
    }

    private int[] getAnimal(int type) {
        if (animals != null || animals.size() > 0) {
            Iterator<Animal> iterator = animals.iterator();
            while (iterator.hasNext()) {
                Animal animal = iterator.next();
                if (animal.getType() == type) {
                    iterator.remove();
                    return new int[]{animal.getIndex(), animal.getType()};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public int[] dequeueCat() {
        return getAnimal(0);
    }
}

public class LeetCode_03_06_AnimalShelterLCCI {

    public static void main(String[] args) {
        AnimalShelf obj = new AnimalShelf();
        obj.enqueue(new int[]{0, 0});
        obj.enqueue(new int[]{1, 0});
        int[] param_3 = obj.dequeueDog();
        System.out.println(Arrays.toString(param_3));
        int[] param_4 = obj.dequeueCat();
        System.out.println(Arrays.toString(param_4));
        int[] param_2 = obj.dequeueAny();
        System.out.println(Arrays.toString(param_2));
    }

}
