package lab1.GUI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;
import lab1.logic.ComplexNumbers;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormAttachment;


public class ComplexNumbersGUI {
	
	private Shell shell;
	private Text realPartTextField;
	private Text imaginaryPartTextField;
	private Button countButton;
	private Label realPartLabel;
	private Label imaginaryPartLable;
	private Label moduleLabel;
	private Label phaseLable;
		
	public ComplexNumbersGUI(Display display) {
		
		shell = new Shell(display);
		shell.setLayout(new FormLayout());
		buildRealPart();
		buildModuleLabel("Модуль ");
		buildImaginaryPart();
		buildPhaseLabel("Фаза ");
		buildButton();
		shell.setSize(300, 120);
		
	}
	
	public void open() {
		
		shell.open();
		
	}
	
	public boolean isDisposed() {
		
		return shell.isDisposed();
	}
	
	private void buildRealPart() {
		
		realPartLabel = new Label(shell,SWT.NONE);
		realPartLabel.setText("Действительная часть");	
		
        FormData formData = new FormData (120, 20);
        formData.top      = new FormAttachment (5, 10);
        formData.left     = new FormAttachment (0, 10);
        
        realPartLabel.setLayoutData(formData);
        
		realPartTextField = new Text(shell,SWT.BORDER);
		
        formData = new FormData (SWT.DEFAULT, SWT.DEFAULT);
        formData.top      = new FormAttachment (0, 10);
        formData.left     = new FormAttachment (realPartLabel, 10);
        formData.right    = new FormAttachment (78 ,-10);
        formData.height   = 15;
        
        realPartTextField.setLayoutData (formData);		
	}
	
	private void buildImaginaryPart() {
		
		imaginaryPartLable = new Label(shell,SWT.NONE);
		imaginaryPartLable.setText ("Мнимая часть");
		
        FormData formData = new FormData (80, 20);
        formData.top      = new FormAttachment (realPartLabel, 5);
        formData.left     = new FormAttachment (0, 10);
        
        imaginaryPartLable.setLayoutData (formData);
        
		imaginaryPartTextField = new Text(shell,SWT.BORDER);
		
        formData = new FormData (SWT.DEFAULT, SWT.DEFAULT);
        formData.top      = new FormAttachment (realPartTextField, 10);
        formData.left     = new FormAttachment (imaginaryPartLable, 10);
        formData.right    = new FormAttachment (78,-10);
        formData.height   = 15;
        
        imaginaryPartTextField.setLayoutData (formData);

		
	}
	
	private void buildPhaseLabel(String phaseName) {
		
		phaseLable = new Label(shell,SWT.NONE);
		phaseLable.setText(phaseName);
		
		FormData formData = new FormData (80,20);
		formData.top      = new FormAttachment (moduleLabel, 5);
		formData.left     = new FormAttachment (imaginaryPartTextField,10);
		formData.right    = new FormAttachment (120,-10);
		
		phaseLable.setLayoutData (formData);	
		
	}
	
	private void buildModuleLabel(String moduleName) {
		
		moduleLabel = new Label(shell,SWT.NONE);
		moduleLabel.setText(moduleName);
		
		FormData formData = new FormData (80,20);
		formData.top      = new FormAttachment (5, 10);
		formData.left     = new FormAttachment (realPartTextField,10);
		formData.right    = new FormAttachment (120,-10);
		
		moduleLabel.setLayoutData (formData);		
	}

	private void buildButton() {
		
		countButton = new Button(shell,SWT.PUSH);
		countButton.setText("Посчитать");
		
		FormData formData = new FormData(80,20);
		formData.right = new FormAttachment(100,-5);
		formData.bottom = new FormAttachment(100,0);

		countButton.setLayoutData(formData);
		countButton.addListener(SWT.Selection, event -> countListener());
		
	}
	
	private void countListener() {
		
		if(realPartTextField.getText().isEmpty()||imaginaryPartTextField.getText().isEmpty()) {		
			
			return;
			
		}
		
		double realNumber = 0, imaginaryNumber = 0;
		
		try {
			
			String realPartValue = realPartTextField.getText(),
					imaginaryPartValue = imaginaryPartTextField.getText();		
			realNumber = Double.parseDouble(realPartValue);
			imaginaryNumber = Double.parseDouble(imaginaryPartValue);
			
		}catch(NumberFormatException e) {
			
			
		}
		
		moduleLabel.setText("Модуль " + String.format("%.1f",ComplexNumbers.countModule(realNumber, imaginaryNumber)));
		phaseLable.setText("Фаза  " + String.format("%.2f",ComplexNumbers.countPhase(realNumber, imaginaryNumber)));
		
	}
		
}