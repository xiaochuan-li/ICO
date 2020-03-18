package PVC.Agent;

import jade.core.Agent;

public class TestAgent extends Agent {
    protected void setup() {
        System.out.println("Hello World! My name is " + getLocalName());
    }
}
