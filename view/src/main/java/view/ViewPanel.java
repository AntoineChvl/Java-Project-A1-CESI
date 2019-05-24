package view;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import entity.Entity;

/**
 * The Class ViewPanel.
 *
 * @author Jean-Aymeric Diet
 */
@SuppressWarnings("unused")
class ViewPanel extends JPanel implements Observer {

	/** The view frame. */
	private ViewFrame viewFrame;
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -998294702363713521L;

	/**
	 * Instantiates a new view panel.
	 *
	 * @param viewFrame the view frame
	 */
	public ViewPanel(final ViewFrame viewFrame) {
		this.setViewFrame(viewFrame);
		viewFrame.getModel().getObservable().addObserver(this);
		//viewFrame.getModel().getMap();
	}

	/**
	 * Gets the view frame.
	 *
	 * @return the view frame
	 */
	@SuppressWarnings("unused")
	private ViewFrame getViewFrame() {
		return this.viewFrame;
	}

	/**
	 * Sets the view frame.
	 *
	 * @param viewFrame the new view frame
	 */
	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(final Graphics graphics) {
		graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
		//graphics.drawString(this.getViewFrame().getModel().getMap().getContentOfMap(), 10, 20);	
		Entity[][] loadMap = this.viewFrame.getModel().getMap().getArrayMap();
		
		//((Graphics2D)graphics).scale(2,2);
		
		for(int x = 0; x <this.viewFrame.getModel().getMap().getWidthMap(); x++) {
			
			
			for(int y=0; y < this.viewFrame.getModel().getMap().getHeightMap(); y++) {
				
				
				graphics.drawImage(loadMap[x][y].getSprite().getImage(), x*16, 40+y*16, this);
				
			}
			Font font = new Font("Arial", Font.BOLD, 18);
			graphics.setFont(font);
			graphics.drawString(String.valueOf("Diamond Counter : "+this.viewFrame.getModel().getMap().getPlayer().getDiamondsCounter()), 15, 15);
		}
		
		
		
		
	}
}
