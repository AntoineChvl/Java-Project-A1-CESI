package view;

import java.awt.Font;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Observable;
import java.util.Observer;

import java.util.Timer;
import java.util.TimerTask;

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

	
	public ViewPanel() {}
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
	
	static int counter = 200; // Counter until the end of the game
	@Override
	protected void paintComponent(final Graphics graphics) {
		Font font = new Font("Arial", Font.BOLD, 20);
		graphics.setFont(font);
		if (counter != 0 && counter != -100) {
		graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
		
		graphics.drawString("Remaining time : "+counter, this.getWidth()-200, 35);
		
		Entity[][] loadMap = this.viewFrame.getModel().getMap().getArrayMap();
		
		//((Graphics2D)graphics).scale(2,2);
		
		for(int x = 0; x <this.viewFrame.getModel().getMap().getWidthMap(); x++) {
			
			for(int y=0; y < this.viewFrame.getModel().getMap().getHeightMap(); y++) {
				graphics.drawImage(loadMap[x][y].getSprite().getImage(), x*16, 40+y*16, this);
			}
			graphics.drawString(String.valueOf("Diamond Counter : "+this.viewFrame.getModel().getMap().getPlayer().getDiamondsCounter()), 15, 35);
		
		}
		}else { // If the remaining time is equal to 0
			graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
			graphics.drawString("YOU LOOSE", this.getWidth()/2-75, this.getHeight()/2);
			counter = -100;
			/* NOW WE HAVE TO PERFORM AN ACTION WHEN THE PLAYER LOOSES (+ RESTART THE TIMER = set it two 200
			when the player switch between the maps) */
		}
		
	}
	
	public void startTimer() { // This is a timer
		ViewPanel drawTimer = new ViewPanel();
		
    	TimerTask timerTask = new TimerTask() {

    	    @Override
    	    public void run() {
    	    	// If the counter is equal to -100 it means that the game has stopped
    	    	if (counter != -100) {
    	    		counter--;//increments the counter
    	    	}
    	    }
    	    
    	};
    	Timer timer = new Timer("MyTimer"); //create a new timer
    	timer.scheduleAtFixedRate(timerTask, 1000, 1000); // each seconds we perform the run method
	}
}
