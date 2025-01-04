# PuneMetroMadeEasy
Pune Metro Guide: 
A Java-based command-line application to navigate the Pune Metro system efficiently. It calculates the shortest path between stations, highlights line changes, and supports dynamic metro network management. Ideal for exploring metro systems with ease!

Pune Metro Guide
Pune Metro Guide is a command-line Java application designed to assist commuters in navigating the Pune Metro system. It calculates the shortest path between two stations and provides information about line changes required during the journey.

Features
-Shortest Path Finder: Computes the shortest route between two stations.
-Interchange Station Handling: Identifies and accommodates interchange stations.
-Dynamic Metro Network: Easily adds stations, connections, and interchanges.
-Line Change Notification: Alerts users about required line changes during the journey.

Technologies Used
-Language: Java
-Data Structures: HashMap, ArrayList, Queue, and Set for efficient network representation and pathfinding.

How It Works
1.Metro Network Initialization:
-Stations are grouped by lines (Purple Line and Aqua Line).
-Connections between adjacent stations are established.
-Interchange stations (e.g., Civil Court) are explicitly marked.

2.User Interaction:
-The user provides the source and destination stations.
-The program checks the validity of input stations.
-If valid, it calculates the shortest path using a Breadth-First Search (BFS) algorithm.

Output:
-Displays the shortest path as a sequence of station names.
-Highlights line changes along the route.

Example :
Welcome to Pune Metro Guide!
Enter your source station:
Shivaji Nagar
Enter your destination station:
Ramwadi

Shortest path from Shivaji Nagar to Ramwadi:
Shivaji Nagar -> Civil Court -> PMC -> Deccan Gymkhana -> Ramwadi

Line changes:
Change from Purple Line to Aqua Line at Civil Court

How to Run
1.Ensure you have Java installed on your machine.

2.Compile the program:
  javac PuneMetroGuide.java

3.Run the program:
  java PuneMetroGuide

Future Enhancements
-Add support for more lines and stations dynamically from external files or databases.
-Implement a graphical user interface (GUI).
-Provide additional details like estimated travel time and fare calculation.

License
This project is open-source and available under the MIT License.
