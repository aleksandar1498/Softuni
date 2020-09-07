package exams;

public class Testing {

	public static void main(String[] args) {
		Integer data = 0;
		process(data);
		System.out.println(data);

	}
	private static void process(Integer data) {
		
		data = Integer.valueOf(2);
		System.out.println(data);
	}

}
