package ui;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;

public class OptionComposite extends Composite {

	private Composite composite ;
	
	
	private Composite selComp;
	private Label lblSel;
	private Label iconSle;
	private Composite conditionComp;
	private Button btnCheck_0;
	private Button btnCheck_1;
	private Button btnCheck_2;
	private Button btnCheck_3;
	private Button btnCheck_4;
	
	private Composite colComp;
	private Label lblCol;
	private Label iconCol;
	private Composite collectionComp;
	
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public OptionComposite(Composite parent, int style) {
		super(parent, SWT.NONE);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		composite = new Composite(this, SWT.NONE);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		colComp = new Composite(composite, SWT.NONE);
		colComp.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		colComp.setBounds(10, 237, 128, 343);
		
		lblCol = new Label(colComp, SWT.NONE);
		lblCol.setText("收藏");
		lblCol.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.BOLD));
		lblCol.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		lblCol.setAlignment(SWT.CENTER);
		lblCol.setBounds(0, 0, 100, 25);
		
		iconCol = new Label(colComp, SWT.NONE);
		iconCol.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		iconCol.setBounds(100, 0, 30, 25);
		
		collectionComp = new Composite(colComp, SWT.V_SCROLL);
		collectionComp.setBounds(0, 25, 128, 308);
		
		selComp = new Composite(composite, SWT.NONE);
		selComp.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		selComp.setBounds(10, 10, 128, 189);
		
		lblSel = new Label(selComp, SWT.NONE);
		lblSel.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		lblSel.setText("选股");
		lblSel.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.BOLD));
		lblSel.setAlignment(SWT.CENTER);
		lblSel.setBounds(0, 0, 100, 25);
		
		iconSle = new Label(selComp, SWT.NONE);
		iconSle.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		iconSle.setLocation(100, 0);
		iconSle.setSize(30, 25);
		
		conditionComp = new Composite(selComp, SWT.NONE);
		conditionComp.setBounds(0, 25, 128, 164);
		
		btnCheck_0 = new Button(conditionComp, SWT.CHECK);
		btnCheck_0.setBounds(10, 10, 100, 17);
		btnCheck_0.setText("涨跌幅(%)");
		
		btnCheck_1 = new Button(conditionComp, SWT.CHECK);
		btnCheck_1.setBounds(10, 40, 100, 17);
		btnCheck_1.setText("现价(元)");
		
		btnCheck_2 = new Button(conditionComp, SWT.CHECK);
		btnCheck_2.setBounds(10, 70, 100, 17);
		btnCheck_2.setText("市盈率");
		
		btnCheck_3 = new Button(conditionComp, SWT.CHECK);
		btnCheck_3.setBounds(10, 100, 100, 17);
		btnCheck_3.setText("动态市盈率");
		
		btnCheck_4 = new Button(conditionComp, SWT.CHECK);
		btnCheck_4.setBounds(10, 130, 100, 17);
		btnCheck_4.setText("市净率");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	public Button getBtnCheck(int index){
		switch (index) {
		case 0:
			return btnCheck_0;
		case 1:
			return btnCheck_1;
		case 2:
			return btnCheck_2;
		case 3:
			return btnCheck_3;
		case 4:
			return btnCheck_4;

		default:
			return null;
		}
	}

}
