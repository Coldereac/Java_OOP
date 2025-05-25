package Indiv_3;

import java.time.LocalDate;
import java.util.Objects;


public class Ticket implements Comparable<Ticket> {
    private final LocalDate eventDate;
    private final int row;
    private final int seat;

    public Ticket(LocalDate eventDate, int row, int seat) {
        this.eventDate = eventDate;
        this.row = row;
        this.seat = seat;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public int getRow() {
        return row;
    }

    public int getSeat() {
        return seat;
    }

    @Override
    public String toString() {
        return "Date: " + eventDate + ", Row: " + row + ", Seat: " + seat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return row == ticket.row &&
                seat == ticket.seat &&
                eventDate.equals(ticket.eventDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventDate, row, seat);
    }

    @Override
    public int compareTo(Ticket other) {
        int dateComparison = this.eventDate.compareTo(other.eventDate);
        if (dateComparison != 0) {
            return dateComparison;
        }
        int rowComparison = Integer.compare(this.row, other.row);
        if (rowComparison != 0) {
            return rowComparison;
        }
        return Integer.compare(this.seat, other.seat);
    }
}