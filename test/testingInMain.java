import livingstack.LivingStack;
import livingstack.LivingStack1L;

public class testingInMain {
    public static void main(String arg[]) {

        LivingStack<String> s = new LivingStack1L<String>();

        s.push("lol");

        int age = s.creatureAge("lol");

        System.out.println(age);

        s.push("asdgfadsfda");

        int age2 = s.creatureAge("lol");

        int health = s.creatureHealth("lol");

        System.out.println(health);
        System.out.println(age2);

    }
}
