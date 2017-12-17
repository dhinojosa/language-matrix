import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueRunner {

    public static class Person {
        private String firstName;
        private String lastName;

        Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        String getLastName() {
            return lastName;
        }
    }

    public static class PersonComparator implements Comparator<Person> {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getLastName().compareTo(o2.getLastName());
        }
    }

    public static void main(String[] args) {
        Queue<Person> queue = new PriorityQueue<>(new PersonComparator());
        queue.offer(new Person("Franz", "Kafka"));
        queue.offer(new Person("Jane", "Austen"));
        queue.offer(new Person("Leo", "Tolstoy"));
        queue.offer(new Person("Lewis", "Carroll"));
        assert(queue.peek().getLastName().equals("Austen3"));
    }
}
