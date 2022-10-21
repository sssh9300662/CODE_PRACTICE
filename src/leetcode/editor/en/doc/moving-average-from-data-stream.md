[TOC]

## Solution

---
#### Approach 1: Array or List

**Intuition**

Following the description of the problem, we could simply keep track of all the incoming values with the data structure of *Array* or *List*. Then from the data structure, later we retrieve the necessary elements to calculate the average. 

![pic](https://leetcode.com/problems//Figures/346/346_array.png)

**Algorithm**

- First, we initialize a variable `queue` to store the values from the data stream, and the variable `n` for the size of the moving window.

- At each invocation of `next(val)`, we first append the value to the queue. We then retrieve the last `n` values from the queue, in order to calculate the average. 

```
class MovingAverage {
  int size;
  List queue = new ArrayList<Integer>();
  public MovingAverage(int size) {
    this.size = size;
  }

  public double next(int val) {
    queue.add(val);
    // calculate the sum of the moving window
    int windowSum = 0;
    for(int i = Math.max(0, queue.size() - size); i < queue.size(); ++i)
      windowSum += (int)queue.get(i);

    return windowSum * 1.0 / Math.min(queue.size(), size);
  }
}
```



**Complexity**

- Time Complexity: ![\mathcal{O}(N) ](./p__mathcal{O}_N__.png)  where *N* is the size of the moving window, since we need to retrieve *N* elements from the queue at each invocation of `next(val)` function.
<br/>
- Space Complexity: ![\mathcal{O}(M) ](./p__mathcal{O}_M__.png) , where *M* is the length of the queue which would grow at each invocation of the `next(val)` function.
<br/>
<br/>


---
#### Approach 2: Double-ended Queue

**Intuition**

We could do better than the first approach in both time and space complexity.

>First of all, one might notice that we do not need to keep all values from the data stream, but rather the last `n` values which falls into the moving window.

By definition of the moving window, at each step, we add a new element to the window, and at the same time we remove the oldest element from the window. Here, we could apply a data structure called *double-ended queue* (_a.k.a_ deque) to implement the moving window, which would have the constant time complexity (![\mathcal{O}(1) ](./p__mathcal{O}_1__.png) ) to add or remove an element from both its ends. With the deque, we could reduce the space complexity down to ![\mathcal{O}(N) ](./p__mathcal{O}_N__.png)  where *N* is the size of the moving window.

![pic](https://leetcode.com/problems//Figures/346/346_deque.png)

>Secondly, to calculate the sum, we do not need to reiterate the elements in the moving window.

We could keep the sum of the previous moving window, then in order to obtain the sum of the new moving window, we simply add the new element and deduce the oldest element. With this measure, we then can reduce the time complexity to constant.

**Algorithm**

Here is the definition of the _deque_ from Python. We have similar implementation of deque in other programming languages such as Java.

>Deques are a generalization of stacks and queues (the name is pronounced `deck` and is short for `double-ended queue`). Deques support thread-safe, memory efficient appends and pops from either side of the deque with approximately the same O(1) performance in either direction.

Follow the intuition, we replace the queue with the _deque_ and add a new variable `window_sum` in order to calculate the sum of moving window in constant time.

```
class MovingAverage {
  int size, windowSum = 0, count = 0;
  Deque queue = new ArrayDeque<Integer>();

  public MovingAverage(int size) {
    this.size = size;
  }

  public double next(int val) {
    ++count;
    // calculate the new sum by shifting the window
    queue.add(val);
    int tail = count > size ? (int)queue.poll() : 0;

    windowSum = windowSum - tail + val;

    return windowSum * 1.0 / Math.min(size, count);
  }
}
```



**Complexity**

- Time Complexity: ![\mathcal{O}(1) ](./p__mathcal{O}_1__.png) , as we explained in intuition.
<br/>
- Space Complexity: ![\mathcal{O}(N) ](./p__mathcal{O}_N__.png) , where *N* is the size of the moving window.
<br/>
<br/>


---
#### Approach 3: Circular Queue with Array

**Intuition**

Other than the _deque_ data structure, one could also apply another fun data structure called `circular queue`, which is basically a queue with the circular shape.

![pic](https://leetcode.com/problems//Figures/346/346_circular_queue.png)

- The major advantage of circular queue is that by adding a new element to a full circular queue, it automatically discards the oldest element. Unlike deque, we do not need to explicitly remove the oldest element.
<br/>
- Another advantage of circular queue is that a single index suffices to keep track of both ends of the queue, unlike deque where we have to keep a pointer for each end.

**Algorithm**

No need to resort to any library, one could easily implement a circular queue with a fixed-size array. The key to the implementation is the correlation between the index of `head` and `tail` elements, which we could summarize in the following formula:

![\text{tail}=(\text{head}+1)\mod\text{size} ](./p_______text{tail}_=__text{head}_+_1__mod_text{size}__.png) 

In other words, the `tail` element is right next to the `head` element. Once we move the head forward, we would overwrite the previous tail element.

![pic](https://leetcode.com/problems//Figures/346/346_snake.png)

```
class MovingAverage {
  int size, head = 0, windowSum = 0, count = 0;
  int[] queue;
  public MovingAverage(int size) {
    this.size = size;
    queue = new int[size];
  }

  public double next(int val) {
    ++count;
    // calculate the new sum by shifting the window
    int tail = (head + 1) % size;
    windowSum = windowSum - queue[tail] + val;
    // move on to the next head
    head = (head + 1) % size;
    queue[head] = val;
    return windowSum * 1.0 / Math.min(size, count);
  }
}
```



**Complexity**

- Time Complexity: ![\mathcal{O}(1) ](./p__mathcal{O}_1__.png) , as we can see that there is no loop in the `next(val)` function.

- Space Complexity: ![\mathcal{O}(N) ](./p__mathcal{O}_N__.png) , where *N* is the size of the circular queue.


---