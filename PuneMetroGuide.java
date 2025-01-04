import java.util.*;

public class PuneMetroGuide {
    static class MetroNetwork {
        Map<String, List<String>> connections = new HashMap<>();
        Map<String, String> lineMap = new HashMap<>();
        Set<String> interchangeStations = new HashSet<>();

        void addStation(String station, String line) {
            connections.putIfAbsent(station, new ArrayList<>());
            lineMap.put(station, line);
        }

        void addConnection(String station1, String station2) {
            connections.get(station1).add(station2);
            connections.get(station2).add(station1);
        }

        void addInterchangeStation(String station) {
            interchangeStations.add(station);
        }

        List<String> findShortestPath(String src, String dest) {
            Queue<List<String>> queue = new LinkedList<>();
            Set<String> visited = new HashSet<>();
            queue.add(Collections.singletonList(src));

            while (!queue.isEmpty()) {
                List<String> path = queue.poll();
                String lastStation = path.get(path.size() - 1);

                if (lastStation.equals(dest)) {
                    return path;
                }

                visited.add(lastStation);

                for (String neighbor : connections.get(lastStation)) {
                    if (!visited.contains(neighbor)) {
                        List<String> newPath = new ArrayList<>(path);
                        newPath.add(neighbor);
                        queue.add(newPath);
                    }
                }
            }
            return Collections.emptyList();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Initialize Metro Network
        MetroNetwork metro = new MetroNetwork();

        // Line 1 (Purple Line)
        String[] purpleLineStations = {
            "PCMC", "Sant Tukaram Nagar", "Bhosari (Nashik Phata)", "Kasarwadi",
            "Phugewadi", "Dapodi", "Bopodi", "Khadki", "Range Hill", "Shivaji Nagar",
            "Civil Court", "Kasba Peth","Mandai","Swargate"
        };
        for (String station : purpleLineStations) {
            metro.addStation(station, "Purple");
        }
        for (int i = 0; i < purpleLineStations.length - 1; i++) {
            metro.addConnection(purpleLineStations[i], purpleLineStations[i + 1]);
        }

        // Line 2 (Aqua Line)
        String[] aquaLineStations = {
            "Vanaz", "Anand Nagar", "Ideal Colony", "Nal Stop", "Garware College",
            "Deccan Gymkhana", "Chhatrapati Sambhaji Udyan", "PMC", "Civil Court",
            "Mangalwar Peth", "Pune Railway Station", "Ruby Hall Clinic", "Bund Garden",
            "Yerawada", "Kalyani Nagar", "Ramwadi"
        };
        for (String station : aquaLineStations) {
            metro.addStation(station, "Aqua");
        }
        for (int i = 0; i < aquaLineStations.length - 1; i++) {
            metro.addConnection(aquaLineStations[i], aquaLineStations[i + 1]);
        }

        // Interchange Stations
        metro.addInterchangeStation("Civil Court");

        // User Input
        System.out.println("Welcome to Pune Metro Guide!");
        System.out.println("Enter your source station:");
        String source = sc.nextLine();

        System.out.println("Enter your destination station:");
        String destination = sc.nextLine();

        if (!metro.connections.containsKey(source) || !metro.connections.containsKey(destination)) {
            System.out.println("Invalid stations. Please check your input.");
            return;
        }

        // Find Shortest Path
        List<String> path = metro.findShortestPath(source, destination);

        if (path.isEmpty()) {
            System.out.println("No path found between " + source + " and " + destination);
        } else {
            System.out.println("Shortest path from " + source + " to " + destination + ":");
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i));
                if (i < path.size() - 1) System.out.print(" -> ");
            }
            System.out.println();

            // Display line changes
            System.out.println("\nLine changes:");
            for (int i = 0; i < path.size() - 1; i++) {
                String currentLine = metro.lineMap.get(path.get(i));
                String nextLine = metro.lineMap.get(path.get(i + 1));
                if (!currentLine.equals(nextLine)) {
                    System.out.println("Change from " + currentLine + " Line to " + nextLine + " Line at " + path.get(i + 1));
                }
            }
        }
    }
}
