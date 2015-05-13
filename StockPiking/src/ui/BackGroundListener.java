package ui;

/*
 * 修改不见背景颜色的鼠标事件
 */

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.wb.swt.SWTResourceManager;

public class BackGroundListener implements MouseListener, MouseMoveListener {

	private static final Color DEFAULT_BG_COLOR = SWTResourceManager.getColor(SWT.COLOR_WHITE);
	private static final Color DEFAULT_HOVER_COLOR = SWTResourceManager.getColor(SWT.COLOR_CYAN);
	private Color bgColor = DEFAULT_BG_COLOR; // 背景颜色
	private Color hoverBG = DEFAULT_HOVER_COLOR; //鼠标移过的颜色
	
	private Composite composite;
	
//	label.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
	
	public BackGroundListener(){
		super();
	}
	
	@Override
	public void mouseDoubleClick(MouseEvent e) {
		// TODO Auto-generated method stub
		this.composite = (Composite) e.getSource();
		this.composite.setBackground(hoverBG);
	}

	@Override
	public void mouseDown(MouseEvent e) {
		// TODO Auto-generated method stub
		this.composite = (Composite) e.getSource();
		this.composite.setBackground(hoverBG);
	}

	@Override
	public void mouseUp(MouseEvent e) {
		// TODO Auto-generated method stub
		this.composite = (Composite) e.getSource();
		this.composite.setBackground(bgColor);
	}

	@Override
	public void mouseMove(MouseEvent e) {
		// TODO Auto-generated method stub
		this.composite = (Composite) e.getSource();
		this.composite.setBackground(hoverBG);
		
	}
	
	public Color getBgColor() {
		return bgColor;
	}

	public void setBgColor(Color bgColor) {
		this.bgColor = bgColor;
	}

	public Color getHoverBG() {
		return hoverBG;
	}

	public void setHoverBG(Color hoverBG) {
		this.hoverBG = hoverBG;
	}

}
