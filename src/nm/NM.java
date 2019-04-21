/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nm;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Dr.Abuzant
 */
class GoldenSearch{
    private double xl;
    private double xu;
    private double x1;
    private double x2;
    private double d;
    private double xopt;
    private double fx1;
    private double fx2;
    public GoldenSearch(){
        String x=JOptionPane.showInputDialog("Please enter Xl");
        xl=Double.parseDouble(x);
        String y=JOptionPane.showInputDialog("Please enter Xu");
        xu=Double.parseDouble(y);
        getD(xl, xu);
       
        while(true){
            
                fx1=function(x1);          
                fx2=function(x2);
               
                if(fx1>fx2){
                   xl=x2;
                   xopt=x1; 
                    getD(xl, xu);
                }
                if(fx2>fx1){
                    xu=x1;
                    xopt=x2;
                  getD(xl, xu);

                }
               
                if((Math.round(x1*1000)/1000)==(Math.round(x2*1000)/1000)){
                    
                    break;
                }
 
            
        }
        System.out.println("Xopt = "+xopt);
        
    }
    public double function(double x){
            return (5*cos(Math.toRadians(x))-(sin(Math.toRadians(x))/x));
    }
    public void getD(double xxl,double xxu){
         d=0.61803*(xu-xl);
        x1=xl+d;
        x2=xu-d;
        
    }
    
}
class LinearRegression{
    private double[]x={1,1.5,2.3,3.8,4};
    private double[]y={0.5,2,2.8,3,3.2};
    private double newX[]={0,0,0,0,0};
    private double newY[]={0,0,0,0,0};
    private int n=5;
    private double sumXY=0;
    private double sumX=0;
    private double sumY=0;
    private double sumXSquare=0;
    private double a1;
    private double a0;
    private double a;
    private double b;
    private double rsquare;
    private double sr;
    private double st;
    private double SyAboveSx;
    
    public LinearRegression(){
        getNewX();
        getNewY();
        for(int i=0;i<n;i++){
            sumXY+=newX[i]*newY[i];
            sumX+=newX[i];
            sumY+=newY[i];
            sumXSquare+=Math.pow(newX[i],2);
        }
        a1=((n*sumXY)-(sumX*sumY))/((5*sumXSquare)-(Math.pow(sumX, 2)));
        a0=(sumY/n)-(a1*(sumX/n));
        System.out.println("a0 = "+a0+"\na1 = "+a1);
        a=a0;
        b=a0*a1;
        System.out.println("a = "+a+"\nb = "+b);
        getSr();
        getST();
        rsquare=(st-sr)/st;
        System.out.println("r² ="+rsquare);
        SyAboveSx=Math.sqrt(sr/(n-2));
        System.out.println("Sy/x = "+SyAboveSx);
        
        
    }
    public void getNewX(){
        for(int i=0;i<n;i++){
            newX[i]=(Math.exp(x[i])/x[i]);
        }
    }
    public void getNewY(){
        for(int i=0;i<n;i++){
            newY[i]=(Math.exp(y[i])+8.8)/x[i];
        }
    }
    public void getSr(){
        double sum=0;
        for(int i=0;i<n;i++){
            sum+=Math.pow((newY[i]-a0-(a1*newX[i])),2);
        }
        sr=sum;
    }
    public void getST(){
        double sum=0;
        double yAvg=0;
        for(int i=0;i<n;i++){
          sum+=newY[i];
        }
        yAvg=sum/n;
        sum=0;
        for(int i=0;i<n;i++){
            sum+=Math.pow((newY[i]-yAvg), 2);
        }
        st=sum;
    }
    
}
public class NM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GoldenSearch m = new GoldenSearch();
        LinearRegression n = new LinearRegression();
        // TODO code application logic here
    }
    
}
