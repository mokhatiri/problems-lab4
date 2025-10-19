package problem6;

public class Square extends Forme{
    private double edge;
    public Square(double edge){
        this.edge = edge;
    }
    @Override
    public double getSurface(){
        return (edge*edge);
    }
    
    @Override
    public String toString() {
        return String.format("Square (side %.1f cm)", edge);
    }
}