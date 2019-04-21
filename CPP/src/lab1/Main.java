package lab1;

import org.eclipse.swt.widgets.Display;
import lab1.GUI.ComplexNumbersGUI;

public class Main {
	
	public static void main(String[] args) {
		
		Display display = new Display();
		ComplexNumbersGUI shell = new ComplexNumbersGUI(display);
		shell.open();
		while(!shell.isDisposed()) {
			
			if(!display.readAndDispatch()) {
				display.sleep();
				
			}	
		}
		display.dispose();
	}

}
