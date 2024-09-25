package Run;

import PilasColas.ArrayQueue;
import PilasColas.ArrayStack;

public class Run {

    public void run(){

        System.out.println("===== Haciendo uso de Stack =====");
        ArrayStack stack = new ArrayStack(5);
        stack.push(2);
        stack.push(4);
        stack.push(6);
        stack.push(8);
        stack.push(10);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println("\n===== Haciendo uso de Queue =====");
        ArrayQueue queue = new ArrayQueue(5);

        queue.enqueue(2);
        queue.enqueue(4);
        queue.enqueue(6);
        queue.enqueue(8);
        queue.enqueue(10);
        //queue.enqueue(10);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
