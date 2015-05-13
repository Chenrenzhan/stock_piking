package ui;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

public class StockDetails extends Composite {

	private static final Color DEFAULT_HOVER_COLOR = SWTResourceManager.getColor(SWT.COLOR_CYAN);
	
	private Label label_0; //序号
	private Label label_1; //代码
	private Label label_2; //股票简称
	private Label label_3; //涨跌幅
	private Label label_4; //现价
	private Label label_5; //市盈率
	private Label label_6; //动态市盈率 
	private Label label_7;  //市净率
	
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public StockDetails(Composite parent, int style) {
		super(parent, SWT.NONE);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		label_0 = new Label(this, SWT.NONE);
		label_0.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_0.setBounds(10, 0, 37, 17);
		label_0.setText("序号");
		
		label_1 = new Label(this, SWT.NONE);
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_1.setBounds(54, 0, 45, 17);
		label_1.setText("代码");
		
		label_2 = new Label(this, SWT.NONE);
		label_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_2.setBounds(105, 0, 70, 17);
		label_2.setText("股票简称");
		
		label_3 = new Label(this, SWT.NONE);
		label_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_3.setBounds(181, 0, 75, 17);
		label_3.setText("涨跌幅(%)");
		
		label_4 = new Label(this, SWT.NONE);
		label_4.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_4.setBounds(262, 0, 61, 17);
		label_4.setText("现价(元)");
		
		label_5 = new Label(this, SWT.NONE);
		label_5.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_5.setBounds(329, 0, 61, 17);
		label_5.setText("市盈率");
		
		label_6 = new Label(this, SWT.NONE);
		label_6.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_6.setBounds(396, 0, 73, 17);
		label_6.setText("动态市盈率");
		
		label_7 = new Label(this, SWT.NONE);
		label_7.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_7.setBounds(486, 0, 61, 17);
		label_7.setText("市净率");

	}
	
	public void setBG(Color hoverColor){
		this.setBackground(hoverColor);
		for(int i = 0; i < 8; ++i){
			Label lbl = getLabel(i);
			lbl.setBackground(hoverColor);
		}
	}
	public void setBG(){
		Color hoverColor = DEFAULT_HOVER_COLOR;
		this.setBackground(hoverColor);
		for(int i = 0; i < 8; ++i){
			Label lbl = getLabel(i);
			lbl.setBackground(hoverColor);
		}
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	public Label getLabel(int index){
		switch (index) {
		case 0:
			return label_0;
		case 1:
			return label_1;
		case 2:
			return label_2;
		case 3:
			return label_3;
		case 4:
			return label_4;
		case 5:
			return label_5;
		case 6:
			return label_6;
		case 7:
			return label_7;

		default:
			return null;
		}
	}
}
