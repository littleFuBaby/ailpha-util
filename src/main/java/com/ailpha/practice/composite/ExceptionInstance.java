package com.ailpha.practice.composite;

class Math {

	public static int div(int x, int y) throws Exception {
		int result = 0;
		System.out.println("1,begin to div");
		try {
			result = x / y;
		} catch (Exception e) {
			throw e;
		}finally {
			System.out.println("2,end to div");
		}
		return result;
	}
}

@SuppressWarnings("serial")
class MyException extends RuntimeException {
	private String name;
	public MyException(String name){
		this.name = name;
	}
	@Override
	public void printStackTrace() {
		System.out.println(name);
	}
}

public class ExceptionInstance {
	public static void main(String[] args) {
		int result = 0;
		try {
			result = Math.div(10, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				assert result == 10:"Result is not 10";
			} catch (Throwable e2) {
				e2.printStackTrace();
			}
		}
		try {
			throw new MyException("new exception");
		} catch (MyException e) {
			e.printStackTrace();
		}
	}
}
