class TicketBooking {
    int availableTickets = 5;

    synchronized void bookTicket(String user, int tickets) {
        System.out.println(user + " is trying to book " + tickets + " ticket(s).");

        if (availableTickets >= tickets) {
            System.out.println("Tickets are available.");

            availableTickets = availableTickets - tickets;

            System.out.println(user + " successfully booked "
                    + tickets + " ticket(s).");
            System.out.println("Tickets remaining: " + availableTickets);
        } else {
            System.out.println("Sorry " + user
                    + ", tickets are not available.");
        }
    }
}

// Creating thread by extending Thread class
class UserThread extends Thread {
    TicketBooking booking;
    String user;
    int tickets;

    UserThread(TicketBooking booking, String user, int tickets) {
        this.booking = booking;
        this.user = user;
        this.tickets = tickets;
    }

    public void run() {
        booking.bookTicket(user, tickets);
    }
}

// Creating thread by implementing Runnable interface
class UserRunnable implements Runnable {
    TicketBooking booking;
    String user;
    int tickets;

    UserRunnable(TicketBooking booking, String user, int tickets) {
        this.booking = booking;
        this.user = user;
        this.tickets = tickets;
    }

    public void run() {
        booking.bookTicket(user, tickets);
    }
}

public class TicketBookingDemo {
    public static void main(String[] args) {

        TicketBooking booking = new TicketBooking();

        // Using Thread class
        UserThread user1 =
                new UserThread(booking, "User 1", 2);

        UserThread user2 =
                new UserThread(booking, "User 2", 2);

        // Using Runnable interface
        UserRunnable user3 =
                new UserRunnable(booking, "User 3", 2);

        Thread thread3 = new Thread(user3);

        // Start all threads
        user1.start();
        user2.start();
        thread3.start();
    }
}
