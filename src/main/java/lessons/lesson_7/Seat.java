package lessons.lesson_7;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Seat implements Serializable {
    private int seatNumber;
    private SeatClass seatClass;
    private boolean isBooked;
    private Passenger passenger;
    private SeatStatus status;
    private LocalDateTime bookingTime;

    public Seat(int seatNumber, SeatClass seatClass) {
        this.seatNumber = seatNumber;
        this.seatClass = seatClass;
        this.isBooked = false;
    }

    public int getSeatNumber() {
        return seatNumber;
    }
    public SeatClass getSeatClass() {
        return seatClass;
    }
    public boolean isBooked() {
        return isBooked;
    }
    public Passenger getPassenger() {
        return passenger;
    }
    public LocalDateTime getBookingTime() {
        return bookingTime;
    }
    public SeatStatus getStatus() {
        return status;
    }

    public void book(Passenger passenger) {
        this.passenger = passenger;
        this.isBooked = true;
        this.bookingTime = LocalDateTime.now();
    }

    public void cancel() {
        this.passenger = null;
        this.isBooked = false;
        this.bookingTime = null;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatNumber=" + seatNumber +
                ", seatClass=" + seatClass +
                ", isBooked=" + isBooked +
                ", passenger=" + passenger +
                ", bookingTime=" + bookingTime +
                '}';
    }
}
