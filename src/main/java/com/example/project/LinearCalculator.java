package com.example.project;
public class LinearCalculator{
    //INSTANCE VARIABLES 
    //4 INTEGER variables (name them: x1,x2,y1,y2) 
    private int x1;
    private int x2;
    private int y1;
    private int y2;


    //CONSTRUCTOR
    //1 constructor with 2 String parameters. Each parameter represents a coordinate. 
    //For example, "(1,2)" and "(3,4)" would be two parameter values 
    //You will have to parse the string into 4 integers, representing the 2 points.
    public LinearCalculator(String coord1, String coord2){ // <--add 2 string parameters to this constructor
        // removes the parentheses from from the two string parameters
        coord1 = coord1.substring(1, coord1.length() - 1);
        coord2 = coord2.substring(1, coord2.length() - 1);
        // identifies the index at which , appears
        int coord1Index = coord1.indexOf(",");
        int coord2Index = coord2.indexOf(",");
        // parses the string parameter to int in each variable
        x1 = Integer.parseInt(coord1.substring(0, coord1Index));
        y1 = Integer.parseInt(coord1.substring(coord1Index + 1));
        x2 =  Integer.parseInt(coord2.substring(0, coord2Index));
        y2 = Integer.parseInt(coord2.substring(coord2Index + 1));

    }



    //METHODS
    //getters and setters for the 4 instance variables (8 methods total) 
    public int getX1(){return x1;}
    public int getY1(){return y1;}
    public int getX2(){return x2;}
    public int getY2(){return y2;}
    public void setX1(int setX1){
        x1 = setX1;
    }
    public void setY1(int setY1){
        y1 = setY1;
    }
    public void setX2(int setX2){
        x2 = setX2;
    }
    public void setY2(int setY2){
        y2 = setY2;
    }


    //distance() -> returns a double. 
    //calculates the distance between the two points to the nearest HUNDREDTH and returns the value.
    public double distance(){
        double distance = Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));

        return roundedToHundredth(distance);
    }
    //yInt() -> returns a double.
    //calculates the y intercept of the equation and returns the value to the nearest HUNDREDTH
    //if y-int is undefined, should return -999.99
    public double yInt(){
        // checks if the y-int is undefined and returns -999.99
        if (x1 == x2) { 
            return -999.99;
        }
        // y = mx + b -> subtract mx from both sides -> y - mx = b (b = y-intercept)
        double yIntercept = y1 - (slope() * x1);
        return roundedToHundredth(yIntercept);
    }

    //slope() -> returns a double. 
    //calculates the slope of the equations and returns the value to the nearest HUNDREDTH
    //if slope is undefined, should return -999.99
    public double slope(){
        // checks if the slope is undefined and returns -999.99. 
        if (x1 == x2) {
            return -999.99;
        }
        // (y2-y1) / (x2-x1), concatenates y2-y1 into a double or else when dividing, remainer is truncated
        double slope = (double) (y2-y1) / (x2-x1);
        return roundedToHundredth(slope);
    }

    //equations() -> returns a String.
    //calculates the final equation in y=mx+b form and returns the string
    //if the equation has no slope, the equation should return -> "undefined"
    //HINT: You may need other custom methods to decrease the amount of code in the equations() method
    public String equation(){
        // if slope is -999.99, returns undefined
        if (slope() == -999.99) {
            return "undefined";
        }
        // if slope is 0, return y=yInt
        else if (slope() == 0) {
            return "y=" + yInt();
        }
        // if the y intercept is negative, remove the plus sign (+)
        else if (yInt() < 0) {
            return "y=" + slope() + "x" + yInt();
        }
        // if y intercept is 0, return y=slope()x
        else if (yInt() == 0) {
            return "y=" + slope() + "x";
        }
        // if none of the conditions are met, return the slope-intercept form equation
        else {
            return "y="+slope()+"x"+ "+" + yInt();
        }
    }


    //roundedToHundredth(double x)-> returns double
    //calculates the input to the nearest hundredth and returns that value
    public double roundedToHundredth(double x){
        // 
        double roundedValue = Math.round(x * 100) / 100.00;
        return roundedValue; 
    }

    //You will need to concatenate to the string 
    //the results from findSymmetry() and Midpoint()
    public String printInfo(){
        String str = "The two points are: (" + getX1() + "," + getY1()  + ")";
        str += " and " + "(" + getX2() + "," + getY2() + ")";
        str += "\nThe equation of the line between these points is: " + equation();
        str += "\nThe slope of this line is: " + slope();
        str += "\nThe y-intercept of the line is: " + yInt();
        str += "\nThe distance between the two points is: " + distance();
        str += "\n" + findSymmetry();
        str += "\n" + Midpoint();

        return str;
    }

    //findSymmetry()-> returns a string 
    //the method should determine if there is symmetry between the two points
    // there should be  4 return statements 
    // return "Symmetric about the x-axis";
    // return "Symmetric about the y-axis";
    //return "Symmetric about the origin";
    //return "No symmetry";
    public String findSymmetry(){
        // checks if the two points are symmetric about the x-axis
        if (x1 == x2 && Math.abs(y1) == Math.abs(y2)) {
            return "Symmetric about the x-axis";
        }
        // checks if the two points are symmetric about the y-axis
        else if (y1 == y2 && Math.abs(x1) == Math.abs(x2)) {
            return "Symmetric about the y-axis";
        }
        // checks if the two points are symmetric about the origin
        else if (Math.abs(x1) == Math.abs(x2) && Math.abs(y1) == Math.abs(y2)){
                    return "Symmetric about the origin";
        }
        // returns "No symmetry" if none of the conditions are true
        return "No symmetry";
    }

    //Midpoint()->return a string 
    //the method should calculate the midpoint between the two points
    //it should return "The midpoint of this line is: (0,0)";
    public String Midpoint(){
        // finds the midpoint values for x and y
        double midpointX = (x1 + x2) / 2.0;
        double midpointY = (y1 + y2) / 2.0;
        // concatenates the midpoint value of x and y into a string
        String midpoint = "(" + midpointX + "," + midpointY + ")";
        return "The midpoint of this line is: " + midpoint;
    }

}



