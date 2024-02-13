package Question_5;

import java.util.*;

// Class to represent a city
class City {
    private final int x;
    private final int y;

    public City(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Calculate distance to another city
    public double distanceTo(City other) {
        int xDistance = Math.abs(x - other.x);
        int yDistance = Math.abs(y - other.y);
        return Math.sqrt((xDistance * xDistance) + (yDistance * yDistance));
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

// Class to represent an ant
class Ant {
    private final int numCities;
    private List<Integer> tour;
    private boolean[] visited;
    private final double[][] pheromones;
    private final double[][] distances;
    private final double alpha;
    private final double beta;
    private final Random random;

    public Ant(int numCities, double[][] distances, double[][] pheromones, double alpha, double beta, double evaporationRate, long seed) {
        this.numCities = numCities;
        this.distances = distances;
        this.pheromones = pheromones;
        this.alpha = alpha;
        this.beta = beta;
        this.random = new Random(seed);
        this.tour = new ArrayList<>();
        this.visited = new boolean[numCities];
    }

    // Construct a tour by following the ACO algorithm
    public void constructTour() {
        // Initialize visited array
        for (int i = 0; i < numCities; i++) {
            visited[i] = false;
        }

        // Choose random starting city
        int startCity = random.nextInt(numCities);
        tour.add(startCity);
        visited[startCity] = true;

        // Build the rest of the tour
        while (tour.size() < numCities) {
            int currentCity = tour.get(tour.size() - 1);
            int nextCity = selectNextCity(currentCity);
            tour.add(nextCity);
            visited[nextCity] = true;
        }
    }

    // Select the next city based on the ACO probabilities
    private int selectNextCity(int currentCity) {
        double[] probabilities = new double[numCities];
        double totalProbability = 0;

        // Calculate the probability for each unvisited city
        for (int i = 0; i < numCities; i++) {
            if (!visited[i]) {
                double pheromone = Math.pow(pheromones[currentCity][i], alpha);
                double distance = Math.pow(1.0 / distances[currentCity][i], beta);
                probabilities[i] = pheromone * distance;
                totalProbability += probabilities[i];
            }
        }

        // Choose the next city based on probabilities
        double randomValue = random.nextDouble() * totalProbability;
        double sum = 0;
        for (int i = 0; i < numCities; i++) {
            if (!visited[i]) {
                sum += probabilities[i];
                if (sum >= randomValue) {
                    return i;
                }
            }
        }

        // Should not reach here
        return -1;
    }

    // Deposit pheromones on the edges of the tour
    public void depositPheromones(double[][] deltaPheromones, double tourLength) {
        for (int i = 0; i < numCities - 1; i++) {
            int fromCity = tour.get(i);
            int toCity = tour.get(i + 1);
            deltaPheromones[fromCity][toCity] += 1.0 / tourLength;
            deltaPheromones[toCity][fromCity] += 1.0 / tourLength;
        }
    }

    public List<Integer> getTour() {
        return tour;
    }
}

// Class to represent the Ant Colony Optimization algorithm
public class Q_A {
    private final int numAnts;
    private final int numIterations;
    private final double evaporationRate;
    private final double alpha;
    private final double beta;
    private final double[][] distances;
    private final double[][] pheromones;
    private final int numCities;
    private final long seed;

    public Q_A(int numAnts, int numIterations, double evaporationRate, double alpha, double beta, double Q, double[][] distances, int numCities, long seed) {
        this.numAnts = numAnts;
        this.numIterations = numIterations;
        this.evaporationRate = evaporationRate;
        this.alpha = alpha;
        this.beta = beta;
        this.distances = distances;
        this.numCities = numCities;
        this.seed = seed;

        // Initialize pheromones
        this.pheromones = new double[numCities][numCities];
        double initialPheromone = 1.0 / numCities;
        for (int i = 0; i < numCities; i++) {
            for (int j = 0; j < numCities; j++) {
                pheromones[i][j] = initialPheromone;
            }
        }
    }

    // Execute the Ant Colony Optimization algorithm
    public List<Integer> solveTSP() {
        List<Integer> bestTour = null;
        double bestTourLength = Double.POSITIVE_INFINITY;

        for (int iteration = 0; iteration < numIterations; iteration++) {
            // Initialize ants
            List<Ant> ants = new ArrayList<>();
            for (int i = 0; i < numAnts; i++) {
                ants.add(new Ant(numCities, distances, pheromones, alpha, beta, evaporationRate, seed));
            }

            // Construct tours for each ant
            for (Ant ant : ants) {
                ant.constructTour();
            }

            // Update pheromones based on ant tours
            double[][] deltaPheromones = new double[numCities][numCities];
            for (Ant ant : ants) {
                ant.depositPheromones(deltaPheromones, calculateTourLength(ant.getTour()));
            }

            // Update global pheromone levels
            for (int i = 0; i < numCities; i++) {
                for (int j = 0; j < numCities; j++) {
                    pheromones[i][j] = (1 - evaporationRate) * pheromones[i][j] + deltaPheromones[i][j];
                }
            }

            // Update best tour if needed
            for (Ant ant : ants) {
                double tourLength = calculateTourLength(ant.getTour());
                if (tourLength < bestTourLength) {
                    bestTourLength = tourLength;
                    bestTour = ant.getTour();
                }
            }
        }

        return bestTour;
    }

    // Calculate the total length of a tour
    private double calculateTourLength(List<Integer> tour) {
        double length = 0;
        for (int i = 0; i < tour.size() - 1; i++) {
            int fromCity = tour.get(i);
            int toCity = tour.get(i + 1);
            length += distances[fromCity][toCity];
        }
        length += distances[tour.get(tour.size() - 1)][tour.get(0)]; // Return to starting city
        return length;
    }

    public static void main(String[] args) {
        // Example usage
        int numCities = 5;
        double[][] distances = {
                {0, 10, 15, 20, 25},
                {10, 0, 35, 25, 30},
                {15, 35, 0, 30, 10},
                {20, 25, 30, 0, 40},
                {25, 30, 10, 40, 0}
        };
        int numAnts = 10;
        int numIterations = 100;
        double evaporationRate = 0.5;
        double alpha = 1.0;
        double beta = 2.0;
        double Q = 1.0;
        long seed = System.currentTimeMillis();

        Q_A tspSolver = new Q_A(numAnts, numIterations, evaporationRate, alpha, beta, Q, distances, numCities, seed);
        List<Integer> bestTour = tspSolver.solveTSP();

        System.out.println("Best tour found: " + bestTour);
        System.out.println("Length of best tour: " + tspSolver.calculateTourLength(bestTour));
    }
}

