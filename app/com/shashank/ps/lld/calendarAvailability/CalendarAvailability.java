package com.shashank.ps.lld.calendarAvailability;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CalendarAvailability {
    public static void main(String[] args) {
        List<Schedule> appointments = new ArrayList<>();
        appointments.add(new Schedule(LocalTime.of(10, 0), LocalTime.of(11,0)));
        appointments.add(new Schedule(LocalTime.of(12, 0), LocalTime.of(12,30)));
        appointments.add(new Schedule(LocalTime.of(16, 0), LocalTime.of(16,45)));
        appointments.add(new Schedule(LocalTime.of(13, 0), LocalTime.of(13,30)));

        LocalTime workStartTime = LocalTime.of(8, 0);
        LocalTime workEndTime = LocalTime.of(19, 0);

        List<Schedule> availabilites = getAvailabilities(appointments, workStartTime, workEndTime);
        List<Schedule> availabilitesForDuration1 = getAvailabilitiesForDuration(appointments, workStartTime, workEndTime, Duration.of(1, ChronoUnit.HOURS));
        List<Schedule> availabilitesForDuration2 = getAvailabilitiesForDuration(appointments, workStartTime, workEndTime, Duration.of(1, ChronoUnit.MINUTES));

        availabilites.forEach(System.out::println);
        System.out.println("-----------------------");
        availabilitesForDuration1.forEach(System.out::println);
        System.out.println("-----------------------");
        availabilitesForDuration2.forEach(System.out::println);
    }

    private static List<Schedule> getAvailabilities(List<Schedule> appointments, LocalTime workStartTime, LocalTime workEndTime) {
        List<Schedule> availabilities = new ArrayList<>();

        LocalTime tempStart = workStartTime;
        Collections.sort(appointments);

        for (Schedule appointment : appointments) {
            if (tempStart.compareTo(appointment.getStartTime()) < 0) {
                availabilities.add(new Schedule(tempStart, appointment.getStartTime()));
                tempStart = appointment.getEndTime();
            } else {
                tempStart = appointment.getEndTime();
            }
            if (tempStart.compareTo(workEndTime) >= 0) {
                break;
            }
        }
        if (tempStart.compareTo(workEndTime) < 0) {
            availabilities.add(new Schedule(tempStart, workEndTime));
        }

        return availabilities;
    }

    private static List<Schedule> getAvailabilitiesForDuration(List<Schedule> appointments,
                                                               LocalTime workStartTime,
                                                               LocalTime workEndTime,
                                                               Duration meetingDuration) {
        List<Schedule> availabilities = new ArrayList<>();
        LocalTime tempStart = workStartTime;
        Collections.sort(appointments);

        for (Schedule appointment : appointments) {
            if (tempStart.compareTo(appointment.getStartTime()) < 0) {
                if (Duration.between(tempStart, appointment.getStartTime()).compareTo(meetingDuration) >= 0) {
                    availabilities.add(new Schedule(tempStart, appointment.getStartTime()));
                }
                tempStart = appointment.getEndTime();
            } else {
                tempStart = appointment.getEndTime();
            }
            if (tempStart.compareTo(workEndTime) >= 0) {
                break;
            }
        }

        if (tempStart.compareTo(workEndTime) < 0
                && Duration.between(tempStart, workEndTime).compareTo(meetingDuration) >= 0) {
            availabilities.add(new Schedule(tempStart, workEndTime));
        }

        return availabilities;
    }

}

@Getter
@Setter
@AllArgsConstructor
@ToString
class Schedule implements Comparable<Schedule> {
    private LocalTime startTime;
    private LocalTime endTime;

    @Override
    public int compareTo(Schedule sch) {
        return this.getStartTime().compareTo(sch.getEndTime());
    }
}