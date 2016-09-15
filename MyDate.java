/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mydate;

/**
 *
 * @author Carmen_Lucia3
 */
public class MyDate {
    private int day;
    private int month;
    private int year;
    private int numberOfDays=0;
    private int i =0;
    private int days=0;

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String toString() {
        return this.day + "." + this.month + "." + this.year;
    }

    public boolean earlier(MyDate compared) {
        
        if ( this.year < compared.year ) {
            return true;
        }

        if ( this.year == compared.year && this.month < compared.month ) {
            return true;
        }

        if ( this.year == compared.year && this.month == compared.month &&
                this.day < compared.day ) {
            return true;
        }

        return false;
    }
    
    public void advance() {
        
        if (this.day == 30 && this.month==12){
            this.day=1;
            this.month=1;
            this.year++;
        }
        else if (this.day == 30) {
            this.day = 1;
            this.month++;
        }
        else{
            this.day++;   
        }       
    }
    
    public void advance (int numberOfDays){
        while (i < numberOfDays){
            advance();
        i++;
        }
       
    }
    
    public MyDate afterNumberOfDays(int numberOfDays){
        advance(numberOfDays);
        
        MyDate newMyDate = new MyDate (this.day, this.month, this.year);
    return newMyDate;
    }
    
    public static void main(String[] args) {
    MyDate day = new MyDate(25, 2, 2011);
    MyDate newDate = day.afterNumberOfDays(7);
    for (int i = 1; i <= 7; ++i) {
        System.out.println("Friday after  " + i + " weeks is " + newDate);
        newDate = newDate.afterNumberOfDays(7);
    }
    System.out.println("This week's Friday is " + day);
    System.out.println("The date 790 days from this week's Friday is  " + day.afterNumberOfDays(790));
    }
}
