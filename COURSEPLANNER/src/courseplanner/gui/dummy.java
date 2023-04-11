package courseplanner.gui;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class dummy {
public static void main(String[] args) {
	String x = "^[A-Za-z0-9+_.-]+@(.+)$";
	Pattern pattern = Pattern.compile(x);
	String y = "^[0-9]{10}";
	Pattern p = Pattern.compile(y);
	Matcher m = pattern.matcher("@bc@gami.com");
	Matcher m2 = p.matcher("1212121212");
	System.out.println(m.find());
	System.out.println(m2.find());
}
}
