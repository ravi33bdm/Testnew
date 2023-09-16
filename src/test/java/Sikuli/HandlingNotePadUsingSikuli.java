package Sikuli;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class HandlingNotePadUsingSikuli {

	public static void main(String[] args) throws Throwable {

		Screen screen = new Screen();
		/*Pattern data = new Pattern("C:\\Users\\Admin\\Desktop\\Search.png");
		screen.click(data);
		screen.type("notepad");*/
        
		Pattern min = new Pattern("C:\\Users\\Admin\\Desktop\\Minimise.png");
		screen.click(min);
		
		Pattern data1 = new Pattern("C:\\Users\\Admin\\Desktop\\Search.png");
		screen.click(data1);
		screen.type("Excel");
		Robot rob = new Robot();
		rob.keyPress(KeyEvent.VK_ENTER);
		rob.keyRelease(KeyEvent.VK_ENTER);
		
		Pattern excel = new Pattern("C:\\Users\\Admin\\Desktop\\Excel.png");
		screen.click(excel);
		
		
	}

}
