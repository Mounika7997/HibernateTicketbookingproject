package com.abctravels.applaunch;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Logo {
	public static void logoLaunch() throws IOException {
		File file = new File("C:\\Users\\mouni\\OneDrive\\Desktop\\abctravels.txt.txt");

		@SuppressWarnings("resource")
		FileInputStream fis = new FileInputStream(file);

		while (!(fis.read() == -1)) {
			int i = fis.read();
			System.out.print((char) i);

		}
	}
}
