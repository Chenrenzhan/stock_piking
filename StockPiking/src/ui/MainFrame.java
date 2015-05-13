package ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.internal.win32.MINMAXINFO;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

public class MainFrame {

	private final Image CLOSE_ICON = 
			new Image(Display.getDefault(), "icons/close.png");
	private final Image CLOSE_HOVER_ICON = 
			new Image(Display.getDefault(), "icons/close_hover.png");
	private final Image MIN_ICON = 
			new Image(Display.getDefault(), "icons/min.png");
	private final Image MIN_HOVER_ICON = 
			new Image(Display.getDefault(), "icons/min_hover.png");
	protected int OPTION_WIDTH = 152;
	
	protected Shell shell;
	
	private Composite composite ;
	
	private Composite optionComp;
	private OptionComposite opComp;
	private Expand indComp ;
	private Expand collComp;
	
	
	private Composite conditionComp;
	private ConditionComposite subCondition;
	
	
	private Composite resultComp;
	private Label lblClose;
	private Label lblMin;
	private Composite composite_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainFrame window = new MainFrame();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell(SWT.NO_TRIM);
		shell.setAlpha(255);
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		shell.setSize(1000, 600);
		shell.setText("SWT Application");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		composite = new Composite(shell, SWT.NONE);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT));
//		composite.setBackgroundMode(SWT.INHERIT_DEFAULT); 
		
		optionComp = new Composite(composite, SWT.NONE);
		optionComp.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		optionComp.setBounds(10, 31, 152, 559);
		
		
		
		
		
		conditionComp = new Composite(composite, SWT.NONE);
		conditionComp.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		conditionComp.setBounds(166, 31, 256, 559);
		
		resultComp = new Composite(composite, SWT.NONE);
		resultComp.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		resultComp.setBounds(426, 31, 565, 559);
		
		lblClose = new Label(composite, SWT.NONE);
		lblClose.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT));
		lblClose.setBounds(940, 0, 30, 25);
		lblClose.setText("Close");
		
		
		lblMin = new Label(composite, SWT.NONE);
		lblMin.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT));
		lblMin.setText("Min");
		lblMin.setBounds(902, 0, 30, 25);
		
		option();
//		indicator(); //选股指标
//		collect(); //收藏
		
		
		condition();
		
		selectCondition();
		
		min(); //最小化窗口
		
		move();
		
		stockHead();
//		result();
		
		close();//关闭窗口
	}
	
	public void option(){
		opComp = new OptionComposite(optionComp, SWT.NONE); 
		opComp.setLocation(0, 0);
		opComp.setSize(152, 559);
	}

	private void indicator() {
		indComp = new Expand(optionComp, SWT.NONE);
		indComp.setOptionText("选股");
		indComp.setLocation(0, 0);
		indComp.setExpandItemCompHeigth(200);
		int heigth = indComp.getCompHeigth();
		indComp.setSize(OPTION_WIDTH, heigth);
	}
	
	private void collect(){
		collComp = new Expand(optionComp, SWT.NONE);
		collComp.setOptionText("收藏");
		int indHeigth = indComp.getCompHeigth();
		int heigth = collComp.getCompHeigth();
		collComp.setLocation(0, indHeigth);
		collComp.setSize(OPTION_WIDTH, heigth);
	}
	
	
	
	public void condition(){
		subCondition = new ConditionComposite(conditionComp, SWT.NONE);
		subCondition.setLocation(0, 0);
		subCondition.setSize(254, 559);
	}
	
	public void selectCondition(){
		for(int i = 0; i < 5; ++i){
			Button btnCheck = opComp.getBtnCheck(i);
			System.out.println("select");
			btnCheck.addSelectionListener(new SelectionListener() {
				private Button btnCheck;
				@Override
				public void widgetSelected(SelectionEvent e) {
					// TODO Auto-generated method stub
					btnCheck = (Button) e.getSource();
					String text = btnCheck.getText();
					if(btnCheck.getSelection()){
						subCondition.addCondition(text, 50);
					}
					else{
						subCondition.removeCondition(text);
					}
				}
				
				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
		}
	}
	
	public void move(){
//		composite.addListener(eventType, listener);
		MoveListener listener = new MoveListener(shell);
		composite.addListener(SWT.MouseDown, listener);
		composite.addListener(SWT.MouseMove, listener);
		
		optionComp.addListener(SWT.MouseDown, listener);
		optionComp.addListener(SWT.MouseMove, listener);
		
		conditionComp.addListener(SWT.MouseDown, listener);
		conditionComp.addListener(SWT.MouseMove, listener);
		
		resultComp.addListener(SWT.MouseDown, listener);
		resultComp.addListener(SWT.MouseMove, listener);
	}
	
	
	public void close(){
		lblClose.setImage(CLOSE_ICON);
		lblClose.addMouseMoveListener(new MouseMoveListener() {
			private Label close;
			@Override
			public void mouseMove(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e);
				this.close = (Label) e.getSource();
				close.setImage(CLOSE_HOVER_ICON);
				
				if( e.x <= 5 || e.x >= 25){
					close.setImage(CLOSE_ICON);
				}
				if(e.y <= 5 || e.y >= 20){
					close.setImage(CLOSE_ICON);
				}
//				composite.dispose();
//				conditionList.remove(this);
			}
		});
		
		lblClose.addMouseListener(new MouseListenerAdapt() {
			
			@Override
			public void mouseDown(MouseEvent arg0) {
				// TODO Auto-generated method stub
				shell.close();
				shell.dispose();
			}
		});
	}
	
	public void min(){
		
		lblMin.setImage(MIN_ICON);
		lblMin.addMouseMoveListener(new MouseMoveListener() {
			private Label min;
			@Override
			public void mouseMove(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e);
				this.min = (Label) e.getSource();
				min.setImage(MIN_HOVER_ICON);
				
				if( e.x <= 5 || e.x >= 25){
					min.setImage(MIN_ICON);
				}
				if(e.y <= 5 || e.y >= 20){
					min.setImage(MIN_ICON);
				}
//				composite.dispose();
//				conditionList.remove(this);
			}
		});
		lblMin.addMouseListener(new MouseListenerAdapt() {
			
			@Override
			public void mouseDown(MouseEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("min");
				shell.setMinimized(true);
			}
		});
		
	}
	
	public void stockHead(){
		
		Label label = new Label(resultComp, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setLocation(0, 45);
		label.setSize(565, 3);
		StockDetails stockHead = new StockDetails(resultComp, SWT.FLAT);
		stockHead.setSize(550, 30);
		stockHead.setLocation(0, 10);
		
		for(int i = 0; i < 8; ++i){
			Label lbl = stockHead.getLabel(i);
			lbl.setFont(SWTResourceManager
					.getFont("Microsoft YaHei UI", 10, SWT.BOLD));
		}
		
		composite_1 = new Composite(resultComp, SWT.V_SCROLL);
		composite_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		composite_1.setBounds(0, 45, 565, 513);
		
	}
	
	public void result(){
		
		
	}
}
