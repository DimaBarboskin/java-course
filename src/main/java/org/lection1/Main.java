package org.lection1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    System.out.println(modifyInputNumbers());
    System.out.println("=============================================================================");
    System.out.println(modifyInputNumbersWithMath());
    System.out.println("=============================================================================");

    strangeMath();
    System.out.println("=============================================================================");

    findLimitation();
    System.out.println("=============================================================================");

    int[] firstArray = {(int) (Math.random() * 9), (int) (Math.random() * 9), (int) (Math.random() * 9)};
    int[] secondArray = {(int) (Math.random() * 9), (int) (Math.random() * 9), (int) (Math.random() * 9)};
    int[] result = findOnlyFirstArrayElements(firstArray, secondArray);
    for (int j : result) {
      System.out.println(j);
    }

  }

  //task 1.1
  public static int modifyInputNumbers() {
    System.out.print("Enter a three-digit positive integer: ");
    Scanner scanner = new Scanner(System.in);
    int inputNumber = scanner.nextInt();
    if (inputNumber < 100 || inputNumber > 999)
      throw new IllegalArgumentException("You can't provide number < 100 or number > 999");

    char[] inputArrayChar = Integer.toString(inputNumber).toCharArray();
    if (inputNumber > 500) {
      return Integer.parseInt("" + inputArrayChar[2] + inputArrayChar[1] + inputArrayChar[0]);
    } else {
      return Integer.parseInt("" + inputArrayChar[0] + inputArrayChar[2] + inputArrayChar[1]);
    }
  }

  //task 1.2
  public static int modifyInputNumbersWithMath() {
    System.out.print("Enter a three-digit positive integer: ");
    Scanner scanner = new Scanner(System.in);
    int inputNumber = scanner.nextInt();
    if (inputNumber < 100 || inputNumber > 999)
      throw new IllegalArgumentException("You can't provide number < 100 or number > 999");

    int firstDigit = inputNumber / 100;
    int secondDigit = (inputNumber / 10) % 10;
    int thirdDigit = inputNumber % 10;
    if (inputNumber > 500) {
      return thirdDigit * 100 + secondDigit * 10 + firstDigit;
    } else return firstDigit * 100 + thirdDigit * 10 + secondDigit;
  }

  //task 2
  public static void strangeMath() {
    for (int result = 100; result < 1000; result++) {
      if (result % 10 == 0) {
        int sumOfDivider = 0;
        for (int i = 1; i <= result; i += 2) {
          if (result % i == 0) {
            sumOfDivider += i;
          }
        }
        if (sumOfDivider % 10 == 0)
          System.out.print(result + " ");
      }
    }
    System.out.println();
  }

  //task 3
  public static void findLimitation() {
    final int MAX_AMOUNT_OF_PEOPLE = 6;
    final int MAX_WEIGHT = 450;
    int sumWeight = 0;
    int countPeople = 0;
    while (countPeople < MAX_AMOUNT_OF_PEOPLE) {
      System.out.print("Enter weight of next person: ");
      Scanner scanner = new Scanner(System.in);
      int inputWeight = scanner.nextInt();
      countPeople++;
      sumWeight += inputWeight;
      if (countPeople == MAX_AMOUNT_OF_PEOPLE) {
        System.out.println("It's not allowed more than 6 people");
        break;
      }
      if (sumWeight > MAX_WEIGHT) {
        System.out.println("It's not allowed more than 450kg");
        break;
      }
    }
    System.out.println(countPeople);
    System.out.println(sumWeight);
  }

  //task 4
  public static int[] findOnlyFirstArrayElements(int[] firstArray, int[] secondArray) {
    List<Integer> uniqueFromFirstArray = new ArrayList<>();
    for (int j : firstArray) {
      boolean equal = false;
      for (int k : secondArray) {
        if (j == k) {
          equal = true;
          break;
        }
      }
      if (!equal) {
        uniqueFromFirstArray.add(j);
      }
    }
    return uniqueFromFirstArray.stream()
        .mapToInt(Integer::intValue)
        .toArray();
  }
}