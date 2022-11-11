package com.ailpha.practice.juc;

import com.ailpha.common.util.DateUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TimeUnitInstance {

	public static void main(String[] args) throws InterruptedException {
		// ʹ��Thread��ʵ������2��
		Thread.sleep(2 * 1000);
		// ʹ��TimeUnit��ʵ������2��
		TimeUnit.SECONDS.sleep(2);

		// ʱ�䵥λת��
		System.out.println(TimeUnit.SECONDS.convert(120000000, TimeUnit.MICROSECONDS));

		// ����������
		long time = TimeUnit.MILLISECONDS.convert(3, TimeUnit.DAYS);
		time += System.currentTimeMillis();
		Date threeDays = new Date(time);
		System.out.println("Three days later by using TimeUnit -->" + threeDays);
		
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 3);
		System.out.println("Three days later by using Calendar -->" + calendar.getTime());
		
		System.out.println(DateUtils.addTime(new Date(), -3, TimeUnit.DAYS));
	}

}
