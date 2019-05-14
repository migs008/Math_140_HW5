# Math_140_HW5
Math 140 HW5
The last assignment for the course is a linked list application that approximates a solution to the
traveling salesperson problem.
Suppose we have a set of points on a two-dimensional plane. The traveling salesperson visits
every point while keeping the distance traveled as short as possible. If there are n points the
number of possible trips equals n! For large values of n it is unrealistic to compute the distance
of all n! trips. Instead, we’ll find an approximate solution to this problem.
We’ll use the following algorithms to find an approximate solution:
● Nearest neighbor approximation: Read in an ordered pair and add it to the linked list
after the point to which it is closest. If there is more than one point to which it is closest,
insert it after the first such point you discover.
● Smallest increase approximation: Read in a point and add it to the linked list after the
point where it results in the least possible increase in the length of the trip. If there is
more than one point, insert it after the first such point you discover.
The traveling salesperson’s route is round-trip. The route returns to the first point visited.
Example: Suppose the traveling salesperson visits points A, B, and C in that order. The
salesperson’s route is A - B - C - A.
Implement the problems by writing the following two classes:
1. Location Class
 Instance variables:
 private double x;
 private double y;
Constructors and Methods:
 public Location(double x, double y) - initialize the instance variables
 public String toString() - return the String representation. Example if x = 2 and y = 4
 then return “(2,4)“.
 public void drawTo(Location b) - draw line segment between the current Location
 and the input parameter. (Use a method in StdDraw.java)
 public double distanceTo(Location b) - return the Euclidean distance between the current
 Location and the input parameter.
Math 140 HW5
2. MinimizeDistance Class
This class stores Location objects in a singly-linked circular linked list.
The Node class only defines a next property and the last Node in the linked list refers to the
head Node.
Example: If A, B, and C are the Node objects in the linked list, where A is the head node, then
A.next = B, B.next = C, and C.next = A.
Instance variables:
 private Node head = null;
 private int size = 0;
Private inner class:

private class Node {
 private Location location;
 private Node next;
 public Node(Location location) { /
 this.location = location;
 this.next = null;
 }
}
Constructors and Methods:
 public MinimizeDistance () - create an empty MinimizeDistance object. In other words,
 create a MinimizeDistance object with size = 0. The constructor is optional since the
 instance variable head is assigned the default value of null and the instance variable
 size is assigned the default value of zero.
 public void draw() - draws the route for the trip. Hint: Iterate through the linked list. Use
 the drawTo method to draw a line segment connecting the Location object in Node ptr
 and the Location object stored in ptr.next

 public double distance() - returns the total distance of the trip
 public void insertNearest(Location location) - inserts a point using the nearest
 neighbor approximation.
Math 140 HW5
 public void insertSmallest(Location location) - inserts a point using the smallest
 increase in total distance traveled approximation
 public int size() - returns the number of Nodes in the linked list.
 public String toString() – concatenates the Strings returned by every Location object
 stored in the LinkedList.
 Example: Suppose the coordinates of the Location objects stored in the linked list are
 shown below
110.0 225.0
161.0 280.0
325.0 554.0
490.0 285.0
The toString method returns the following String:
(110.000000, 225.000000)
(161.000000, 280.000000)
(325.000000, 554.000000)
(490.000000, 285.000000)
When you complete the project upload MinimizeDistance.java and Location.java.
What files should be uploaded to Canvas?
• MinimizeDistance.java
• Location.java
• A screenshot of the image drawn by the insertNearest method
• A text file called outputOne.txt that contains your output generated by the insertNearest
method. An example is shown below
(110.000000, 225.000000)
(161.000000, 280.000000)
(325.000000, 554.000000)
(490.000000, 285.000000)
Tour length = 1094.6174
Number of points = 4
• A text file called outputTwo.txt that contains your output generated by the insertSmallest
method.
Math 140 HW5
Coding Instructions
1. You are only allowed to add Node objects to the linked list. You cannot remove Node
objects from the linked list.
2. Do not use Java classes that trivialize the problem.
3. Do not declare static instance variables for this assignment.
4. You can write additional helper methods but they should be declared as private.
5. Use consistent notation to format your code. Indent 4-spaces.
6. Variables and methods should start with a lower-case character. Each abbreviation or
word that appears in the middle of the identifier starts with an uppercase character.
7. Use meaningful variables names.
8. Do not use variable names that consist of one character unless they are declared in a for
loop. Example: for (int i = 0; i < arr.length; i++)
9. Do not use a single character for an abbreviation. Example: Suppose a variable
represents the number of books. Do not call this variable nBooks. Instead, use
numBooks or numberBooks.
10. Do not use break or continue statements in while or for loops.
11. Do not change the value of a counter variable to terminate a loop:
Example:
for (int i = 0; i < arr.length; i++){
 if (arr[i] < 0)
 i = arr.length;
}
12. Loops should not perform any irrelevant iterations.
13. Each method should have at most one return statement.
14. Do not use a return statement in a void method.
15. Do not use a while loop when an if statement is appropriate for the code segment. (In
other words, do not write a while loop that is guaranteed to iterate at most one time.)
16. Use “else if” when appropriate:
Example:
Instead of
if (a < 1){
 a++;
}
if (a > 10){
 a--;
}
use
if (a < 1){
 a++;
}
else if (a > 10){
 a--;
}
Math 140 HW5
17. boolean variables should not be compared to true or false.
Example: Suppose flag is a boolean variable.
Do not write statements similar to
if (flag == true) or if (flag == false)
 Instead use
 if (flag) or if (!flag)
18. Remove irrelevant statements. Example: remove variable declarations if the variable
are not used in the code.
19. Separate code segments with a most one blank line. Note that a code segment is a
method, a loop or an if block. A single statement is usually not considered to be a code
segment.
20. A block comment near the top of the Java file with the following information
/*
Author: Your name
Sources: Acknowledge sources (including online sources) used for this project.
Date: The date you completed the assignment.
Purpose: A description of the class.
*/
21. Write a block comment above each method and constructor with the following
information: Note that the terms Purpose, Parameters, and Return should appear in
every block comment.
/*
 Purpose: A meaningful description of the method/constructor.
 Parameters: Describe the purpose of each parameter
 Return: A description of the return value.
*/
