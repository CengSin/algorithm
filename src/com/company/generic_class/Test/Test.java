package com.company.generic_class.Test;

import java.text.SimpleDateFormat;
import java.util.*;

class ScheduleItem {

    private String startTime;

    private String endTime;

    public ScheduleItem(String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "ScheduleItem{" +
                "startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @Date: Create in 14:40 2019/3/1
 */
public class Test {

    private int a;

    private int b;

    public Test(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public Test() {
    }

    @Override
    public String toString() {
        return "Test{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

    public static void main(String[] args) {
//        test();
        String time = "10:00~20:00";
        String[] split = time.split("~");
        System.out.println(split[0]);
        System.out.println(split[1]);
    }

    private static void test() {
        List<ScheduleItem> list = new ArrayList<>();
        list.add(new ScheduleItem("10:00", "12:00"));
        list.add(new ScheduleItem("12:00", "16:00"));
        list.add(new ScheduleItem("16:00", "19:00"));
        list.add(new ScheduleItem("19:00", "22:00"));
        list.forEach(s -> {
            String endHour = s.getEndTime();
            if (endHour != null && endHour.length() > 0) {
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                // 拿到当前的小时
                String nowHour = sdf.format(date);
                // 如果结束时间在当前时间之后，就校验排班
                if (nowHour.compareTo(endHour) < 0) {
                    System.out.println(s);
                }
            }
        });
    }

}
