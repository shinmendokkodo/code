/*
Problem Description
You are the owner of a hotel at a hill station. There is a huge demand for guests but you have a limited car parking available. Given the arrival and departure time of all the cars, find the minimum number of car parking spaces needed.

Input format
First line contains integer N - Number of cars.

Next N lines contain 2 integers A, D - Arrival and departure time of ith car.

Output format
Print the minimum number of parking spaces required.

Sample Input 1
3

0 20

5 10

10 15

Sample Output 1
2

Explanation
One space will be occupied by 1st car (0-20) and the other will be occupied by 2nd car(5-10) and 3rd car(10-15). So only 2 spaces are required.

Constraints
N <= 10^5

0 <= A < D <= 10^9
*/

import java.util.*;

public class ParkingSpace {

    public int parkingSpace(int[][] times) {
        int n = times.length;
        Car[] cars = new Car[n];
        for (int i = 0; i < n; i++) {
            cars[i] = new Car(times[i][0], times[i][1]);
        }

        Arrays.sort(cars, Comparator.comparingInt(t -> t.arrival));

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(cars[0].departure);
        int totalParking = 1;
        for (int i = 1; i < n; i++) {
            Car car = cars[i];
            if (car.arrival < heap.peek()) {
                totalParking++;
            } else {
                heap.poll();
            }
            heap.add(car.departure);
        }

        return totalParking;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] times = new int[n][2];

        for (int i = 0; i < n; i++) {
            times[i][0] = scanner.nextInt();
            times[i][1] = scanner.nextInt();
        }

        int result = new ParkingSpace().parkingSpace(times);
        System.out.printf("%d", result);

        scanner.close();
    }

}

class Car {
    int arrival;
    int departure;

    public Car(int arrival, int departure) {
        this.arrival = arrival;
        this.departure = departure;
    }
}