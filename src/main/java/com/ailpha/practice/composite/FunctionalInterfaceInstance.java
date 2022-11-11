package com.ailpha.practice.composite;

import java.io.File;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceInstance {

	public static void main(String[] args) {
		// 1,function
		Function<String, byte[]> f = String:: getBytes;
		System.out.println(Arrays.toString(f.apply("fuyunsong")));
		
		// 3,supplier
		Supplier<Date> s = Calendar.getInstance() :: getTime;
		System.out.println(s.get());
		
		// 4,predict
		Predicate<File> p = File:: exists;
		System.out.println(p.test(new File("e:")));
		
		// 2,consumer
		Consumer<Integer> c = Runtime.getRuntime() :: exit;
		c.accept(1);
	}

}
