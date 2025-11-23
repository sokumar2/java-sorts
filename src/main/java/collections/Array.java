package collections;

import java.util.Random;
import collections.interfaces.Shuffler;

public class Array implements Shuffler {

    protected Integer[] array;

    public Array(int length) {
        array = new Integer[length];

        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
    }

    public Integer[] build() {
        return this.array;
    }

    public Array shuffle() {
        Random random = new Random();

        int length = this.array.length - 1;
        while (length > 0) {
            int j = random.nextInt(length + 1);

            Integer swapped = this.array[length];
            this.array[length] = this.array[j];
            this.array[j] = swapped;

            length--;
        }

        return this;
    }

}