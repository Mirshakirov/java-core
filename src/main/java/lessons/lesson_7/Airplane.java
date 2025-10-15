package lessons.lesson_7;

import java.io.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Airplane {
    private List<Seat> seats;
    private static final String FILE_PATH = "seats.txt";
    private LocalDate flightDate;

    public Airplane() {
        this.flightDate = flightDate;
        seats = loadSeats();
        if (seats == null) {
            seats = generateSeats();
        }
    }

    private List<Seat> generateSeats() {
        List<Seat> list = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            SeatClass seatClass = (i <= 5) ? SeatClass.BUSINESS : SeatClass.ECONOMY;
            list.add(new Seat(i, seatClass));
        }
        return list;
    }

    public void showAllSeats() {
        clearExpiredBookings();
        for (Seat seat : seats) {
            System.out.println(seat);
        }
    }

    public void bookSeat(int seatNumber, String fullName) {
        try {
            Seat seat = getSeat(seatNumber);
            if (seat.isBooked()) {
                System.out.println("This seat is already booked!");
                return;
            }
            seat.book(new Passenger(fullName));
            saveSeats();
            System.out.println("Seat booked successfully!");
        } catch (Exception e) {
            System.out.println("Booking error: " + e.getMessage());
        }
    }

    public void cancelBooking(int seatNumber) {
        try {
            Seat seat = getSeat(seatNumber);
            if (!seat.isBooked()) {
                System.out.println("This seat is not currently booked.");
                return;
            }
            seat.cancel();
            saveSeats();
            System.out.println("Booking canceled.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void showSeatInfo(int seatNumber) {
        try {
            Seat seat = getSeat(seatNumber);
            System.out.println(seat);
            if (seat.isBooked()) {
                System.out.println("Passenger: " + seat.getPassenger());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private Seat getSeat(int seatNumber) {
        return seats.stream()
                .filter(s -> s.getSeatNumber() == seatNumber)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Seat not found!"));
    }

    private void saveSeats() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(seats);
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    private List<Seat> loadSeats() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<Seat>) ois.readObject();
        } catch (Exception e) {
            return null;
        }
    }

    private void clearExpiredBookings() {
        LocalDateTime now = LocalDateTime.now();
        for (Seat seat : seats) {
            if (seat.getStatus() == SeatStatus.BOOKED && seat.getBookingTime() != null) {
                Duration diff = Duration.between(seat.getBookingTime(), now);
                if (diff.toMinutes() > 24) {
                    seat.cancel();
                    System.out.println("Booking expired for seat " + seat.getSeatNumber());
                }
            }
        }
        saveSeats();
    }
}
