package cf4j.data;

import cf4j.data.types.DynamicArray;
import cf4j.data.types.DynamicSortedArray;
import cf4j.utils.Methods;

/**
 * <p>A TestUser extends an User given it the following properties:</p>
 * <ul>
 *  <li>User index in the test users array</li>
 *  <li>Array of test items that the user have rated</li>
 *  <li>Array of test ratings hat the user have made</li>
 * </ul>
 * @author Fernando Ortega
 */
public class TestUser extends User {

	private static final long serialVersionUID = 20130403L;
	
	private final static String SIMILARITIES_KEY = "similarities";
	private final static String NEIGHBORS_KEY = "neighbors";
	private final static String PREDICTIONS_KEYS = "predictions";

	/**
	 * Test items that rated by the user
	 */
	protected DynamicSortedArray<String> testItems;

	/**
	 * Test ratings of the items
	 */
	protected DynamicArray<Double> testRatings;
	
	/**
	 * Test rating average of the user
	 */
	protected double testRatingAverage;
	
	/**
	 * Test rating standard deviation of this user
	 */
	protected double testRatingStandardDeviation;

	/**
	 * Creates a new instance of an user. This constructor should not be used by developers.
	 * @param userCode User code
	 */
	public TestUser (String userCode) {
		super(userCode);
		this.testItems = new DynamicSortedArray<String>();
		this.testRatings = new DynamicArray<Double>();
		//TODO: Metrics?
		//this.testRatingAverage = Methods.arrayAverage(testRatings);
		//this.testRatingStandardDeviation = Methods.arrayStandardDeviation(testRatings);
	}

	/**
	 * Average of the test ratings
	 * @return Test rating average
	 */
	public double getTestRatingAverage() {
		return this.testRatingAverage;
	}

	/**
	 * Standard deviation of the test ratings
	 * @return Test rating standard deviation
	 */
	public double getTestRatingStandardDeviation() {
		return this.testRatingStandardDeviation;
	}

	/**
	 * Get the test items rated by the user
	 * @return Test items codes sorted from low to high. 
	 */
	public DynamicSortedArray<String> getTestItems() {
		return this.testItems;
	}
	
	/**
	 * Returns the test item code at index position. 
	 * @param index Index.
	 * @return Test item code at index. 
	 */
	public String getTestItemAt(int index) {
		return this.getTestItems().get(index);
	}

	/**
	 * Get the ratings of the test items. The indexes of this array overlaps
	 * with indexes of the getTestItems() array.
	 * @return Test items ratings
	 */
	public DynamicArray<Double> getTestRatings() {
		return this.testRatings;
	}
	
	/**
	 * Returns the test rating at index position. 
	 * @param index Index.
	 * @return Test rating at index. 
	 */
	public double getTestRatingAt(int index) {
		return this.getTestRatings().get(index);
	}
	
	/**
	 * Get the index of an test item code at the test items array of the user.
	 * @param item_code Item code
	 * @return Test item index if the user has rated the item or -1 if not
	 */
	public int getTestItemIndex (String item_code) {
		return testItems.get(item_code);
	}
	
	/**
	 * Get the number of test ratings of the user.
	 * @return Number of test ratings made
	 */
	public int getNumberOfTestRatings () {
		return this.testRatings.size();
	}
	
//	/**
//	 * Return the similarities array of the test user. The similarity process must be
//	 * executed before use this method.
//	 * @return Similarities array or null
//	 */
//	public double [] getSimilarities () {
//		return (double []) this.get(SIMILARITIES_KEY);
//	}
//
//	/**
//	 * Set the similarity of this user with the training users. The positions of the
//	 * similarities arrays must overlaps with the positions of the users of the method
//	 * Kernel.getUsers().
//	 * @param similarities Similarities array. Higher is more similar.
//	 */
//	public void setSimilarities (double [] similarities) {
//		this.put(SIMILARITIES_KEY, similarities);
//	}
//
//	/**
//	 * Return the neighbors array of the test user. The neighbors process must be executed
//	 * before use this method.
//	 * @return Neighbors array or null
//	 */
//	public int [] getNeighbors () {
//		return (int []) this.get(NEIGHBORS_KEY);
//	}
//
//	/**
//	 * Set the users indexes that are neighbors of the user. First positions of the neighbors
//	 * array must be most similar users.
//	 * @param neighbors User indexes that are neighbors of this user sorted by similarity
//	 */
//	public void setNeighbors (int [] neighbors) {
//		this.put(NEIGHBORS_KEY, neighbors);
//	}
//
//	/**
//	 * Return the predictions array of the test user. The prediction process must be
//	 * executed before use this method.
//	 * @return Similarities array or null
//	 */
//	public double [] getPredictions () {
//		return (double []) this.get(PREDICTIONS_KEYS);
//	}
//
//	/**
//	 * Set rating prediction for the test items of this user. Predictions array positions must
//	 * overlap with items returned by this.getTestItems().
//	 * @param predictions Predictions of test items
//	 */
//	public void setPredictions (double [] predictions) {
//		this.put(PREDICTIONS_KEYS, predictions);
//	}

	/**
	 * Add/Modify a new test rating to the test user, associated to a item.
	 * @param itemCode itemCode which identify the specific item.
	 * @param rating rated value by user, refering this item.
	 */
	public void addTestRating(String itemCode, double rating){
		testRatings.add(testItems.add(itemCode), new Double(rating));
	}
}
