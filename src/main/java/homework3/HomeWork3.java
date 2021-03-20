package homework3;

import java.util.Arrays;
import java.util.Scanner;

public class HomeWork3 {
    public static void main(String[] args) {
        /* 1 */
        guessTheNumber();
        /* 2 */
        guessTheWord();
    }

    /*
    1. Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки угадать это число.
    При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число, чем загаданное, или меньше.
    После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
    */
    public static void guessTheNumber() {
        System.out.println("Добро пожаловать в игру 'Угадай число'. Введите число от 0 до 9. У вас 3 попытки.");
        Scanner scan = new Scanner(System.in);
        int x, count = 1, isExit = 0;
        int r = (int) (Math.random() * 10); // сохраним случайное число от 0 до 9
        do {
            System.out.print("Попытка № " + count + ". Введите число: ");
            x = scan.nextInt();
            if (x != r) System.out.println("Ваше число " + (x < r ? "меньше" : "больше"));
            else System.out.println("Вы угадали!");
            if (x == r || count == 3) {
                if (x != r) System.out.println("\nВы проиграли! Загаданное число = " + r);
                System.out.println("\nПовторить игру еще раз? 1 – да / 0 – нет");
                isExit = scan.nextInt();
                if (isExit == 0) break;
                else {
                    count = 0;
                    r = (int) (Math.random() * 10); // переопределим случайное число от 0 до 9 для новой игры
                }
            }
            count++;
        } while (x != r || isExit == 1);
    }

    /*
    2. * Создать массив из слов
    String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape",
    "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"}.
    При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя, сравнивает его с загаданным словом и сообщает,
    правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы, которые стоят на своих местах.
    apple – загаданное
    apricot - ответ игрока
    ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
    Для сравнения двух слов посимвольно можно пользоваться:
    String str = "apple";
    char a = str.charAt(0); - метод вернет char, который стоит в слове str на первой позиции
    Играем до тех пор, пока игрок не отгадает слово.
    Используем только маленькие буквы.
    */
    public static void guessTheWord() {
        Scanner scan = new Scanner(System.in);
        String systemWord;
        String enteredWord;
        StringBuilder mask = new StringBuilder();
        int posSysWord;
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic",
                "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        posSysWord = (int) (Math.random() * 25); // определим случайную позицию загаданного слова
        systemWord = words[posSysWord]; // сохраним загаданное слово
        //System.out.println("Загаданное слово: " + words[posSysWord]); // для тестов
        do {
            System.out.println("Угадайте слово из списка: " + Arrays.toString(words));
            System.out.print("Введите слово: ");
            enteredWord = scan.nextLine(); // сохраним введенное слово
            if (enteredWord.equals(systemWord)) { // если слова равны - конец игры
                System.out.println("Верно! Игра окончена.");
                break;
            } else {
                System.out.println("Неверно");
                int i = 0;
                do {
                    if (systemWord.charAt(i) == enteredWord.charAt(i)) { // сравним слова итерационно посимвольно
                        mask.append(systemWord.charAt(i)); // нарастим маску совпавшими буквами
                    } else
                        break; // если первые буквы не равны, то нет смысла сравнивать остальные, прерываем вложенный цикл
                    i++;
                } while (i < enteredWord.length() && i < systemWord.length()); // выполнять сравнение пока не пройдемся по всем буквам одного из слов
                if (mask.length() > 0)
                    System.out.println(mask + "#############"); // если маска не пуста - распечатаем ее
                mask = new StringBuilder();
            }
        } while (true);
    }
}
