package practica_2;

public class Edge {
    private Node origin;
    private Node destination;
    private int distance;
 
    public Edge(Node origin, Node destination, int distance) {
        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
    }
 
    public Node getOrigin() {
        return origin;
    }
 
    public void setOrigin(Node origin) {
        this.origin = origin;
    }
 
    public Node getDestination() {
        return destination;
    }
 
    public void setDestination(Node destination) {
        this.destination = destination;
    }
 
    public double getDistance() {
        return distance;
    }
 
    public void setDistance(int distance) {
        this.distance = distance;
    }
 
    @Override
    public String toString() {
        return "\n Edge [origin=" + origin.getCity() + ", destination=" + destination.getCity() + ", distance="
                + distance + "]";
    }
 
}
