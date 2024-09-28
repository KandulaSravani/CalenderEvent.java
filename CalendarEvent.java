import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Event {
    private String name;
    private LocalDateTime dateTime;
    private String description;

    public Event(String name, LocalDateTime dateTime, String description) {
        this.name = name;
        this.dateTime = dateTime;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "Event: " + name + " on " + dateTime + " - " + description;
    }
}

public class CalendarApp {
    private List<Event> events;

    public CalendarApp() {
        events = new ArrayList<>();
    }

    public void addEvent(String name, LocalDateTime dateTime, String description) {
        Event event = new Event(name, dateTime, description);
        events.add(event);
        System.out.println("Event added successfully.");
    }

    public void viewEvents() {
        if (events.isEmpty()) {
            System.out.println("No events found.");
        } else {
            for (Event event : events) {
                System.out.println(event);
            }
        }
    }

    public void deleteEvent(String name) {
        events.removeIf(event -> event.getName().equals(name));
        System.out.println("Event deleted successfully.");
    }

    public static void main(String[] args) {
        CalendarApp app = new CalendarApp();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Calendar Application ---");
            System.out.println("1. Add Event");
            System.out.println("2. View Events");
            System.out.println("3. Delete Event");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter event name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter event date and time (yyyy-MM-ddTHH:mm): ");
                    LocalDateTime dateTime = LocalDateTime.parse(scanner.nextLine());
                    System.out.print("Enter event description: ");
                    String description = scanner.nextLine();
                    app.addEvent(name, dateTime, description);
                    break;

                case 2:
                    app.viewEvents();
                    break;

                case 3:
                    System.out.print("Enter the name of the event to delete: ");
                    String eventName = scanner.nextLine();
                    app.deleteEvent(eventName);
                    break;

                case 4:
                    System.out.println("Exiting application.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}