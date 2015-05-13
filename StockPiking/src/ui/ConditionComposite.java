package ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;

public class ConditionComposite extends Composite {
	
	private static final Image DELETE_ICON = 
			new Image(Display.getDefault(), "icons/delete.png");
	
	private static final Image DELETE_HOVER_ICON = 
			new Image(Display.getDefault(), "icons/delete_hover.png");
	
	
	private List<SubCondition> conditionList;
	
	private int locationY;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public ConditionComposite(Composite parent, int style) {
		super(parent, SWT.NONE);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		setBackgroundMode(SWT.INHERIT_DEFAULT); 
		this.conditionList = new ArrayList<SubCondition>();
		
		Composite headComp = new Composite(this, SWT.NONE);
		headComp.setBounds(0, 10, 254, 30);
		
		Label lblCondition = new Label(headComp, SWT.NONE);
		lblCondition.setLocation(5, 0);
		lblCondition.setSize(60, 17);
		lblCondition.setText("筛选条件");
		lblCondition.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.BOLD));
		
		Label lblMin = new Label(headComp, SWT.NONE);
		lblMin.setText("最小值");
		lblMin.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.BOLD));
		lblMin.setBounds(70, 0, 60, 20);
		
		Label lblMax = new Label(headComp, SWT.NONE);
		lblMax.setText("最大值");
		lblMax.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.BOLD));
		lblMax.setBounds(150, 0, 69, 20);
		
		this.locationY = 50;
		
		Label lblNewLabel = new Label(this, SWT.BORDER | SWT.SHADOW_IN);
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel.setAlignment(SWT.CENTER);
		lblNewLabel.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.BOLD));
		lblNewLabel.setBounds(10, 510, 52, 21);
		lblNewLabel.setText("收藏");
		
		Label lblNewLabel_1 = new Label(this, SWT.BORDER);
		lblNewLabel_1.setAlignment(SWT.CENTER);
		lblNewLabel_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.BOLD));
		lblNewLabel_1.setBounds(73, 510, 52, 21);
		lblNewLabel_1.setText("重置");
		
		Label lblNewLabel_2 = new Label(this, SWT.BORDER);
		lblNewLabel_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_2.setAlignment(SWT.CENTER);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.BOLD));
		lblNewLabel_2.setBounds(179, 510, 52, 21);
		lblNewLabel_2.setText("选股");
		
//		addCondition("市盈率", locationY);
	}
	
	public void addCondition(String condition, int y){
		conditionList.add(new SubCondition(this, condition, locationY));
		locationY += 40;
	}

	public void removeCondition(String text){
		for(SubCondition sbc : conditionList){
			if(sbc.getConText().equals(text)){
				conditionList.remove(sbc);
				sbc.getComposite().dispose();
				break;
			}
		}
//		conditionList.remove(sbc);
		locationY -= 40;
	}
	
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	public class SubCondition{
		
		private int y;
		private String conText;
		private Composite parentComp;
		private Composite composite;
		
		private Text min;
		private Text max;
		
		public SubCondition(Composite parent, String condition, int y){
			this.y = y;
			this.parentComp = parent;
			this.conText = condition;
			composite = new Composite(parentComp, SWT.NONE);
			composite.setBounds(0, y, 254, 30);
			
			min = new Text(composite, SWT.BORDER);
			min.setBounds(70, 0, 70, 23);
			
			max = new Text(composite, SWT.BORDER);
			max.setBounds(150, 0, 70, 23);
			
			Label lblCodit = new Label(composite, SWT.NONE);
			lblCodit.setLocation(5, 4);
			lblCodit.setSize(61, 17);
			lblCodit.setText(conText);
			
			Label delete = new Label(composite, SWT.NONE);
			delete.setBounds(230, 4, 20, 17);
			delete.setText("删除");
			delete.setImage(DELETE_ICON);
			System.out.println(DELETE_ICON);
//			delete.addMouseMoveListener(
//					new MouseMoveAdapt(DELETE_ICON, DELETE_HOVER_ICON));
			delete.addMouseMoveListener(new MouseMoveListener() {
				private Label delete;
				@Override
				public void mouseMove(MouseEvent e) {
					// TODO Auto-generated method stub
					System.out.println(e);
					this.delete = (Label) e.getSource();
					delete.setImage(DELETE_HOVER_ICON);
					
					if( e.x <= 5 || e.x >= 15){
						delete.setImage(DELETE_ICON);
					}
					if(e.y <= 5 || e.y >= 12){
						delete.setImage(DELETE_ICON);
					}
//					composite.dispose();
//					conditionList.remove(this);
				}
			});
			
			delete.addMouseListener(new MouseListenerAdapt() {
				
				@Override
				public void mouseDown(MouseEvent arg0) {
					// TODO Auto-generated method stub
					composite.dispose();
					conditionList.remove(this);
					locationY -= 40;
				}
			});

		}

		public int getLocationY() {
			return y;
		}

		public void setLocationY(int locationY) {
			this.y = locationY;
		}

		public Text getMin() {
			return min;
		}

		public void setMin(Text min) {
			this.min = min;
		}

		public Text getMax() {
			return max;
		}

		public void setMax(Text max) {
			this.max = max;
		}

		public Composite getComposite() {
			return composite;
		}

		public String getConText() {
			return conText;
		}

		public void setConText(String conText) {
			this.conText = conText;
		}
	}

	public List<SubCondition> getConditionList() {
		return conditionList;
	}
}
