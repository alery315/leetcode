package alibaba;

import sun.misc.Contended;

import java.util.Random;

public class User implements Comparable{

    private int height;
    @Contended
    private int weight;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public User(int height, int weight) {
        this.height = height;

        this.weight = weight;
    }

    @Override
    public String toString() {
        return "height: " + height + ", weight: " + weight;
    }

    public static void main(String[] args) {

        User[] users = new User[5];

        Random random = new Random();
        for (int i = 0; i < users.length - 1; i++) {
            int height = random.nextInt(190);
            int weight = random.nextInt(200);
            users[i] = new User(height, weight);
            System.out.println(users[i]);
        }
        users[4] = new User(users[3].height,230);

        quickSort(users, 0, users.length - 1);

        for (int i = 0; i < users.length; i++) {
            System.out.println(users[i]);
        }


    }

    public static void quickSort(User[] users, int low, int high) {
        if (low >= high) return;
        int i = low, j = high;
        System.out.println(low + "" + high);
        User temp = users[low];
        while (i < j) {
            while (i < j && users[j].height > temp.height) {
                j--;
            }
            while (i < j && users[j].height == temp.height && users[j].weight > temp.weight) {
                j--;
            }
            if (i < j) {
                users[i] = users[j];
            }
            while (i < j && users[i].height < temp.height) {
                i++;
            }
            while (i < j && users[i].height == temp.height && users[i].weight < temp.weight) {
                i++;
            }
            if (i < j) {
                users[j] = users[i];
            }
        }
        users[i] = temp;
        quickSort(users, low, i - 1);
        quickSort(users, i + 1, high);
    }

    @Override
    public int compareTo(Object o) {
        User user = (User) o;
        if (this.height > user.height) {
            return 1;
        } else if (this.height == user.height) {
            return this.weight - user.weight;
        }
        return -1;

    }
}