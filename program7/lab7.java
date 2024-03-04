import java.io.*;
import java.util.*;

class Queue {
	int q[], f = 0, r = 0, size;
	void insert(int n) {
		Scanner in = new Scanner(System.in);
		q = new int[10];
		for(int i = 0; i < n; ++i) {
			System.out.print("Enter " + i + " element: ");
			int ele = in.nextInt();
			if(r + 1 > 10) {
				System.out.println("\nQueue is full\n\nLost Packet: " + ele);
				break;
			} else {
				++r;
				q[i] = ele;
			}
		}
		in.close();
	}
	void delete() {
		Scanner in = new Scanner(System.in);
		Thread t = new Thread();
		if(r == 0) {
			System.out.println("\nQueue is empty");
		} else {
			for(int i = f; i < r; ++i) {
				try {
					t.sleep(1000);
				} catch(Exception e) {
				}
				System.out.println("Leaked Packet: " + q[i]);
				++f;
			}
		}
		System.out.println();
		in.close();
	}
}

class Leaky extends Thread {
	public static void main(String args[]) throws Exception {
		Queue q = new Queue();
		Scanner src = new Scanner(System.in);
		System.out.print("Enter the packets to be sent: ");
		int size = src.nextInt();
		System.out.println();
		q.insert(size);
		q.delete();
	}
}
