package task;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner intScan = new Scanner(System.in), strScan = new Scanner(System.in);
        Map<Integer, List<User>> mapUser = new HashMap<>();
        String name;
        int age;

        for (int i = 0; i < 5; i++) {
            System.out.println("Введите имя пользователя " + (i+1));
            name = strScan.nextLine();
            System.out.println("Введите возраст пользователя " + (i+1));
            age = intScan.nextInt();

            if(mapUser.containsKey(age)){
                mapUser.get(age).add(new User(name,age));
            }
            else{
                mapUser.put(age, new ArrayList<>());
                mapUser.get(age).add(new User(name,age));
            }
        }

        System.out.println("\nВведите требуемый возраст");
        age = intScan.nextInt();
        if(mapUser.containsKey(age)){
            mapUser.get(age).sort(Comparator.comparing(User::getName));
            for (int i = 0; i < mapUser.get(age).size(); i++) {
                System.out.println(mapUser.get(age).get(i).toString());
            }
        }
        else{
            System.out.printf("Пользователь с возрастом '%d' не найден", age);
        }
    }
}