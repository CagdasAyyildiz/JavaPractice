import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class FileRead implements Runnable {
    @Override
    public void run() {
        Random rand = new Random();
        int wait_sec = 2500+rand.nextInt(5000);
        try {
            Thread.sleep(wait_sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Waited %.2f seconds \n",(float)wait_sec/1000);
        File file = new File("c:\\Users\\"+ System.getProperty("user.name") + "\\Desktop\\ss.png");
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
        String date = formatter.format(file.lastModified());
        String[] dates = date.split("\\s+");
        if (FileRead.validateTime(dates[1]) && FileRead.validateDate(dates[0]))
            System.out.println("System is online");
        else
            System.out.println("System is offline");
    }
    //TODO
    private static boolean validateTime(String time) {
        String[] time_seperated = time.split(":");
        Integer seconds = Integer.parseInt(time_seperated[2]) + (((Integer.parseInt(time_seperated[0]))*60) + (Integer.parseInt(time_seperated[1])))* 60 ;
        System.out.println("File time : "+ time);

        String now = java.time.LocalTime.now().toString();
        System.out.println("Now : " + now);

        String[] now_s = now.split(":");
        now_s[2] = (now_s[2].split("\\."))[0];
        Integer seconds_now = Integer.parseInt(now_s[2]) + (((Integer.parseInt(now_s[0]))*60) + (Integer.parseInt(now_s[1])))*60;

        return seconds_now - seconds < 5;
    }

    private static boolean validateDate(String date) {
        String[] date_seperated = date.split("-");
        DateTimeFormatter date_today_formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String date_today = date_today_formatter.format(now);
        System.out.println(date_today);
        date_today = date_today.split("\\s+")[0];
        String[] date_separate_today = date_today.split("-");
        if (!date_seperated[0].equals(date_separate_today[0]))
            return false;
        if (!date_seperated[1].equals(date_separate_today[1]))
            return false;
        return date_seperated[2].equals(date_separate_today[2]);
    }
}
