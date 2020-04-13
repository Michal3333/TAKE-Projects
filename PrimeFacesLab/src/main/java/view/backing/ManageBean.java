/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.backing;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.component.chart.Chart;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;

/**
 *
 * @author michal
 */
@Named(value = "manageBean")
@RequestScoped
public class ManageBean {
    
    public class Student {
        
        private String name;
        private String surname;
        private float averageGrade;
        
        public Student(String name, String surname, float grade){
            this.name = name;
            this.surname = surname;
            this.averageGrade = grade;
        }

        /**
         * @return the name
         */
        public String getName() {
            return name;
        }

        /**
         * @param name the name to set
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * @return the surname
         */
        public String getSurname() {
            return surname;
        }

        /**
         * @param surname the surname to set
         */
        public void setSurname(String surname) {
            this.surname = surname;
        }

        /**
         * @return the averageGrade
         */
        public float getAverageGrade() {
            return averageGrade;
        }

        /**
         * @param averageGrade the averageGrade to set
         */
        public void setAverageGrade(float averageGrade) {
            this.averageGrade = averageGrade;
        }
        
    }

    /**
     * Creates a new instance of ManageBean
     */
    private int firstNumber;
    private int secondNumber;
    private int sum;
    private Date currentDate = new Date();
    private LineChartModel chartData;
    private Chart chart;

    
    private Student students[] = new Student[10];
    
    
    
    public void add(){
        this.sum = this.firstNumber + this.secondNumber;
        this.setCurrentDate(new Date());
        String message = "" + this.firstNumber + " + " + this.secondNumber + " = " + this.sum;
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(message));
    }
    
    public ManageBean() {
        this.students[0] = new Student("Oliver", "Murphy", (float) 4.5);
        this.students[1] = new Student("Jack", "Walsh", (float) 4.6);
        this.students[2] = new Student("Harry", "Smith", (float) 4.7);
        this.students[3] = new Student("Jacob", "Jones", (float) 4.8);
        this.students[4] = new Student("Charlie", "Williams", (float) 4.9);
        this.students[5] = new Student("Thomas", "Brown", (float) 5.0);
        this.students[6] = new Student("George", "Taylor", (float) 3.6);
        this.students[7] = new Student("Oscar", "Davies", (float) 3.8);
        this.students[8] = new Student("James", "Wilson", (float) 4.5);
        this.students[9] = new Student("William", "Evans", (float) 4.4);
        
        this.chartData = new LineChartModel();
 
        ChartSeries sinusData = new ChartSeries();
        
        for(int i = 0; i < 360; i = i + 10){
            double radians = Math.toRadians(i);
            sinusData.set(i, Math.sin(radians));
        }
        
        this.chartData.setZoom(true);
        this.chartData.addSeries(sinusData);
        
    }

    /**
     * @return the firstNumber
     */
    public int getFirstNumber() {
        return firstNumber;
    }

    /**
     * @param firstNumber the firstNumber to set
     */
    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    /**
     * @return the secondNumber
     */
    public int getSecondNumber() {
        return secondNumber;
    }

    /**
     * @param secondNumber the secondNumber to set
     */
    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    /**
     * @return the sum
     */
    public int getSum() {
        return sum;
    }

    /**
     * @param sum the sum to set
     */
    public void setSum(int sum) {
        this.sum = sum;
    }

    /**
     * @return the currentDate
     */
    public Date getCurrentDate() {
        return currentDate;
    }

    /**
     * @param currentDate the currentDate to set
     */
    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    /**
     * @return the students
     */
    public Student[] getStudents() {
        return students;
    }

    /**
     * @param students the students to set
     */
    public void setStudents(Student[] students) {
        this.students = students;
    }

    /**
     * @return the chartData
     */
    public LineChartModel getChartData() {
        return chartData;
    }

    /**
     * @param chartData the chartData to set
     */
    public void setChartData(LineChartModel chartData) {
        this.chartData = chartData;
    }

    
}
