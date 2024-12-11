/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package queue1;

/**
 *
 * @author dilakshi
 */
public class Queue1 {

   
    private int[] queueArray; 
    private int front;        
    private int rear;        
    private int size;         
    private int capacity;     

    // Constructor to initialize the queue
    public Queue1(int capacity) {
        this.capacity = capacity;
        this.queueArray = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

   
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + value);
            return;
        }
        rear = (rear + 1) % capacity; 
        queueArray[rear] = value;    // Add the value at the rear
        size++;                      
        System.out.println("Enqueued: " + value);
    }

    // Dequeue: Remove and return the front element
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }
        int value = queueArray[front]; // Get the front value
        front = (front + 1) % capacity; // Circular increment for front
        size--;                        
        System.out.println("Dequeued: " + value);
        return value;
    }

    // Peek: View the front element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Nothing to peek.");
            return -1;
        }
        return queueArray[front]; // Return the front element
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if the queue is full
    public boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {
        // Create a queue with a capacity of 3
        Queue1 queue = new Queue1(3);

        // Enqueue some elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        // Peek at the front element
        System.out.println("Front element: " + queue.peek());

        // Dequeue some elements
        queue.dequeue();
        queue.dequeue();

        // Add more elements
        queue.enqueue(40);

        // Peek again
        System.out.println("Front element after operations: " + queue.peek());
    }
}

