package ssh.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class RandomIdUtils {
	public static String getRandomId() {
		Random random = new Random();
		SimpleDateFormat allTime = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String subjectno = allTime.format(new Date()) + random.nextInt(10);
		return subjectno + random.nextInt(10);
	}
}
