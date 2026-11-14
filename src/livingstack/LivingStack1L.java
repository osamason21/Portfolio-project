package livingstack;

//each node in the stack contains a creature
//a creature correlates to whatever you add to the stack
//if you dont take care of the creatures in your stack "feed them"
//they die
//and if you feed them and spoil them too much
//they also die from obesity
//the creatures are immortal and live forever as long as you take care of them
//or as long as you dont reach integer overflow with the age then some crazy
//thing might happen
public class LivingStack1L<T> extends LivingStackSecondary<T> {

    public class Creature {

        //for now i am making the health correlate to hunger
        private int health;
        private int age;
        private T name;

        public Creature(T name) {
            this.name = name;
            this.health = 10;
            this.age = 1;

        }
    }

    public class Node {

        private Creature creature;
        private Node next;
        private Node previous;

        public Node(Creature creature) {
            this.creature = creature;
            this.next = null;
            this.previous = null;
        }
    }

    private Node preFront;
    private Node top;
    private int length;

    private void createNewRep() {
        this.preFront = new Node(null);
        this.top = new Node(null);
        this.preFront.next = this.top;
        this.top.previous = this.preFront;
        this.length = 0;
    }

    public LivingStack1L() {
        this.createNewRep();
    }

    @Override
    public int length() {

        return this.length;
    }

    @Override
    public void push(T x) {

        Node current = this.preFront.next;

        while (current != this.top) {

            Node next = current.next;

            current.creature.health--;
            current.creature.age++;

            if (current.creature.health <= 0|| current.creature.health > 30 ) {

                //killing the nodes
                current.previous.next = current.next;
                current.next.previous = current.previous;
                this.length--;
            }

            current = next;

        }

        Creature newCreature = new Creature(x);
        Node newNode = new Node(newCreature);

        newNode.next = this.preFront.next;
        newNode.previous = this.preFront;

        this.preFront.next.previous = newNode;
        this.preFront.next = newNode;

        this.length++;
    }

    @Override
    public T pop() {

        assert this.length() > 0 : "Stack is empty";

        Node current = this.preFront.next;

        T data = current.creature.name;

        this.preFront.next = current.next;
        current.next.previous = this.preFront;

        //updating length
        this.length--;

        return data;

    }

    @Override
    public void feed(T x) {

        Node current = this.preFront.next;

        while (current != this.top) {
            if (current.creature.name.equals(x)) {

                if (current.creature.health > 30) {

                    current.previous.next = current.next;
                    current.next.previous = current.previous;
                    this.length--;

                } else {
                    current.creature.health++;

                }

            }

            current = current.next;
        }
    }

    @Override
    public boolean isFat(T x) {

        boolean fatass = false;
        Node current = this.preFront.next;
        boolean found = false;

        //preventing loop from looping to last element
        while (current != this.top && !found) {
            if (current.creature.name.equals(x)) {
                if (current.creature.health > 20) {
                    fatass = true;

                }

                found = true;

            }

            current = current.next;
        }

        return fatass;

    }

    @Override
    public int creatureAge(T x) {

        //preventing loop from looping to last element
        boolean found = false;

        int age = 0;
        Node current = this.preFront.next;
        while (current != this.top && !found) {
            if (current.creature.name.equals(x)) {

                age = current.creature.age;
                found = true;
            }

            current = current.next;
        }

        return age;
    }

    @Override
    public int creatureHealth(T x) {

        //preventing loop from looping to last element
        boolean found = false;

        int health = 0;
        Node current = this.preFront.next;
        while (current != this.top && !found) {
            if (current.creature.name.equals(x)) {

                health = current.creature.health;
                found = true;
            }

            current = current.next;
        }

        return health;

    }

    public void feedAll(){

        Node current = this.preFront.next;

        while (current != this.top) {
            Node next = current.next;
            current.creature.health++;
            current.creature.age++;

        if (current.creature.health > 30) {

            //killing the fat nodes
            current.previous.next = current.next;
            current.next.previous = current.previous;
            this.length--;
            }

            current = next;

        }

        

    }

}
