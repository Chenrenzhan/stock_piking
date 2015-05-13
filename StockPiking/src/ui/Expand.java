package ui;

import javax.swing.Icon;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;

public class Expand extends Composite {

	private static final int WIDTH = 152;
	
	private Composite composite;
	private Composite expandItemComp;
	private int  expandItemCompHeigth;
	private int compHeigth;
	private Label option;
	private Label icon;
	private Boolean state; //状态
	
	private static final Image OPEN_ICON = 
			new Image(Display.getDefault(), "icons/expand_open.png");
	private static final Image CLOSE_ICON = 
			new Image(Display.getDefault(), "icons/expand_close.png");
	private Label lblNewLabel;
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public Expand(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		
		
		composite = new Composite(this, SWT.NONE);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		option = new Label(composite, SWT.NONE);
		option.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		option.setAlignment(SWT.CENTER);
		option.setBounds(10, 10, 100, 25);
		option.setText("选项");
		
		icon = new Label(composite, SWT.NONE);
		icon.setBounds(110, 10, 30, 25);
		icon.setText("图标");
		
		expandItemComp = new Composite(composite, SWT.NONE);
		expandItemComp.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		expandItemComp.setBounds(10, 35, 130, 222);

		
		state = false; //初始化状态处于关闭
		expandItemComp.setVisible(false);
		
		lblNewLabel = new Label(expandItemComp, SWT.NONE);
		lblNewLabel.setBounds(10, 58, 61, 17);
		lblNewLabel.setText("New Label");
		icon.setImage(CLOSE_ICON);
		
		this.expandItemCompHeigth = 30;
		
		this.compHeigth = option.getBounds().height + expandItemCompHeigth;
		this.composite.setSize(WIDTH, compHeigth);
		
		option.addMouseListener(new ExpandListener());
		icon.addMouseListener(new ExpandListener());
		
	}

	
	
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	public class ExpandListener extends MouseListenerAdapt{

		@Override
		public void mouseDown(MouseEvent arg0) {
			// TODO Auto-generated method stub
			if(state){
				System.out.println("expand");
				expandItemComp.setVisible(true);
				icon.setImage(CLOSE_ICON);
				compHeigth = option.getBounds().height + expandItemCompHeigth;
				composite.setSize(WIDTH, compHeigth);
				state = false;
				System.out.println(composite.getBounds());
				System.out.println("aaaaaaaaaaaa");
			}
			else {
				expandItemComp.setVisible(false);
				icon.setImage(OPEN_ICON);
				compHeigth = option.getBounds().height + 10;
				System.out.println(compHeigth);
				
				composite.setSize(WIDTH, compHeigth);
				System.out.println(composite.getBounds());
				composite.layout(true);
				state = true;
			}
		}
		
	}

	public int getExpandItemCompHeigth() {
		return expandItemCompHeigth;
	}



	public void setExpandItemCompHeigth(int expandItemCompHeigth) {
		this.expandItemCompHeigth = expandItemCompHeigth;
		expandItemComp.setSize(130, expandItemCompHeigth);
		compHeigth = option.getBounds().height + expandItemCompHeigth;
		composite.setSize(WIDTH, compHeigth);
	}



	public int getCompHeigth() {
		return compHeigth;
	}



	public void setCompHeigth(int compHeigth) {
		this.compHeigth = compHeigth;
		this.composite.setSize(WIDTH, compHeigth);
	}



	public Label getOption() {
		return option;
	}



	public void setOption(Label option) {
		this.option = option;
	}

	public void setOptionText(String text){
		option.setText(text);
	}


	public Boolean getState() {
		return state;
	}



	public void setState(Boolean state) {
		this.state = state;
	}



	public Composite getExpandItemComp() {
		return expandItemComp;
	}
	
	
	
}
