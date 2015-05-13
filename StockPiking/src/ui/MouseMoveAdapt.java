package ui;

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class MouseMoveAdapt implements MouseMoveListener {

	private Composite composite;
	private Image icon;
	private Image icon_hover;
	
	private Label lbl;
	
	public MouseMoveAdapt(Image icon, Image icon_hover){
		this.composite = composite;
		this.icon = icon;
		this.icon_hover = icon_hover;
	}
	@Override
	public void mouseMove(MouseEvent e) {
		// TODO Auto-generated method stub

		this.lbl = (Label) e.getSource();
		System.out.println(lbl + "   " + e);
		System.out.println(icon);
		lbl.setImage(icon_hover);
		int x = lbl.getBounds().x;
		int y = lbl.getBounds().y;
		
		if( e.x <= 5 || e.x >= x - 5){
			lbl.setImage(icon);
		}
		if(e.y <= 5 || e.y >= y - 5){
			lbl.setImage(icon);
		}
	}

	
}
