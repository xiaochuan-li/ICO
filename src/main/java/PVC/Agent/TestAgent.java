package PVC.Agent;

import PVC.Algorithmes.Algorithme;
import PVC.Algorithmes.Tabou;
import PVC.Data.CityData;
import PVC.Definitions.City;
import PVC.Definitions.Route;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;

import java.util.ArrayList;

public class TestAgent extends Agent {
    private Route initialRoute;
    private Route bestRoute;
    private ArrayList<City> cities = new CityData(10).getCities();

    protected void setup() {

        System.out.println("Hello World! My name is " + getLocalName());
        this.addBehaviour(new behave(this.cities));

    }


    enum Status {
        INIT, CALC, END, SEND, WAIT, COMP
    }

    class behave extends Behaviour {
        private Algorithme algorithme;
        private Status status = Status.INIT;
        private int count = 0;
        private ArrayList<City> cities;

        public behave(ArrayList<City> cities) {
            this.cities = cities;
        }

        @Override
        public void action() {
            switch (this.status) {
                case END:
                    this.end();
                    break;
                case CALC:
                    this.calc();
                    break;
                case SEND:
                    this.send();
                    break;
                case INIT:
                    this.init();
                    break;
                case COMP:
                    this.comp();
                    break;
                case WAIT:
                    this.wait_();
                    break;
                default:
                    System.out.println("SomeError");
                    break;
            }

        }

        @Override
        public boolean done() {
            return this.status == Status.END;
        }

        @Override
        public int onEnd() {  //done()方法返回真时调用
            // TODO 自动生成的方法存根
            myAgent.doDelete();
            System.out.println("finished");
            return super.onEnd();
        }

        private void init() {
            // initialise
            this.algorithme = new Tabou(this.cities);
            System.out.println("Agent initializing, ready for calculating");
            this.status = Status.CALC;
        }

        private void calc() {
            // calculate
            this.algorithme.run();
            this.count++;
            System.out.println(this.algorithme.getBestRoute().getTotalDistance());
            System.out.println("Calculate finishing, ready for sending");
            this.status = Status.SEND;
        }

        private void send() {
            // send solution
            System.out.println("Sending finishing, see if the result meets demand");
            int iter = 5;
            this.status = this.count >= iter ? Status.END : Status.WAIT;
        }

        private void end() {
            // end the agent
            System.out.println("Agent stopped");
        }

        private void wait_() {
            // wait for the results of other agents
            System.out.println("Receiving other solutions, ready for comparing");
            this.status = Status.COMP;
        }

        private void comp() {
            // compare the result received
            System.out.println("Comparing other solutions, ready for recalculating");
            this.status = Status.CALC;
        }
    }
}
