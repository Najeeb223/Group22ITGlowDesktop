package za.ac.cput.domain;

/*
Okuhle Vellem
 */

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalTime;
import java.util.Objects;
import java.time.LocalDate;


@Entity
public class Schedule {

    @Id
    private String scheduleId;
    private String employeeId;
    private LocalDate scheduleDate;
    private LocalTime startTime;
    private LocalTime endTime;

    protected Schedule() {}

    private Schedule(Builder builder) {
        this.scheduleId = builder.scheduleId;
        this.employeeId = builder.employeeId;
        this.scheduleDate = builder.scheduleDate;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public LocalDate getScheduleDate() {
        return scheduleDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return Objects.equals(scheduleId, schedule.scheduleId) &&
                Objects.equals(employeeId, schedule.employeeId) &&
                Objects.equals(scheduleDate, schedule.scheduleDate) &&
                Objects.equals(startTime, schedule.startTime) &&
                Objects.equals(endTime, schedule.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scheduleId, employeeId, scheduleDate, startTime, endTime);
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "scheduleId='" + scheduleId + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", scheduleDate=" + scheduleDate +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    public static class Builder {
        private String scheduleId;
        private String employeeId;
        private LocalDate scheduleDate;
        private LocalTime startTime;
        private LocalTime endTime;

        public Builder setScheduleId(String scheduleId) {
            this.scheduleId = scheduleId;
            return this;
        }

        public Builder setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public Builder setScheduleDate(LocalDate scheduleDate) {
            this.scheduleDate = scheduleDate;
            return this;
        }

        public Builder setStartTime(LocalTime startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder setEndTime(LocalTime endTime) {
            this.endTime = endTime;
            return this;
        }

        public Builder copy(Schedule schedule) {
            this.scheduleId = schedule.scheduleId;
            this.employeeId = schedule.employeeId;
            this.scheduleDate = schedule.scheduleDate;
            this.startTime = schedule.startTime;
            this.endTime = schedule.endTime;
            return this;
        }

        public Schedule build() {
            return new Schedule(this);
        }
    }
}
