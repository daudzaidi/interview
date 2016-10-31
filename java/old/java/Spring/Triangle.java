package old.java.Spring;

import java.util.List;

/**
 * Created by pandita on 9/3/2015.
 */
public class Triangle {

    private String type;
    private Point pointA;
    private Point pointB;
    private Point pointC;

    private List<Point> points;

    public void draw(){
        System.out.println("Triangle Drawn");
        System.out.println("PointA : x = "+pointA.getX()+"  y = "+pointA.getY());
        System.out.println("PointB : x = "+pointB.getX()+"  y = "+pointB.getY());
        System.out.println("PointC : x = "+pointC.getX()+"  y = "+pointC.getY());

        for(Point point :points){
            System.out.println("Point : x = "+point.getX()+"  y = "+point.getY());
        }
    }

    public Triangle(String type){
        this.type=type;
    }

    public String getType() {
        return type;
    }

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }
}
