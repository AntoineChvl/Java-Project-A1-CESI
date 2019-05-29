package model;

import java.sql.SQLException;
import java.util.Observable;

import com.databaseconnection.DBConnection;

import contract.IModel;
import entity.Map;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public final class Model extends Observable implements IModel {

	/** The helloWorld. */
	private Map map;
	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.map = new Map();
	}

	/**
     * Gets the hello world.
     *
     * @return the hello world
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage()
	 */
	public Map getMap() {
		return this.map;
	}

	/**
     * Sets the hello world.
     *
     * @param helloWorld
     *            the new hello world
     */
	private void setMap(final Map map) {
		this.map = map;
		this.modelNotify();
	}

	/**
     * Load hello world.
     *
     * @param code
     *            the code
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage(java.lang.String)
	 */
	public void loadMap(final int id) throws IndexOutOfBoundsException {
		
		if(id <= 7) {
			try {
				final DAOMap daoMap = new DAOMap(DBConnection.getInstance().getConnection());
				this.setMap(daoMap.find(id));
			} catch (final SQLException e) {
				e.printStackTrace();
			}
		} else {
				throw new IndexOutOfBoundsException("Incorrect id !");
		}
	}

	/**
     * Gets the observable.
     *
     * @return the observable
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	public Observable getObservable() {
		return this;
	}
	
	public void modelNotify() {
		setChanged();
		notifyObservers();
	}
	
	public void loop() {

		if(this.getMap().getNumberOfDiamondsNeeded() != 0) {
			this.getMap().loop();
			this.modelNotify();
		}
	}
}
