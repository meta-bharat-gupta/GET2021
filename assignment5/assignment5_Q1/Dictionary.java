package assignment5_Q1;

import org.json.JSONArray;
import org.json.JSONObject;


public class Dictionary implements DictionaryInterface {
	
	private BinarySearchTree bTree;
	
	/**
	 * Constructor to initialize the dictionary object by json
	 * @param data
	 * 			JSONObject key-value pair list for initializing the dictionary
	 */
	public Dictionary(JSONObject data){
		bTree = new BinarySearchTree();
		try{
			JSONArray array = data.getJSONArray("data");
//			System.out.println(array);
			for(int index=0; index<array.length(); index++){
				int key = Integer.parseInt(array.getJSONObject(index).getString("key"));
				String value = array.getJSONObject(index).getString("value");
//				System.out.println(key+value);
				bTree.add(key, value);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	// Add new key-value pair into the dictionary
	@Override
	public void add(int key, String value) {
		// TODO Auto-generated method stub
		bTree.add(key, value);	
	}

	// Remove exiting key-value pair by key
	@Override
	public void remove(int key) {
		// TODO Auto-generated method stub
		bTree.delete(key);
	}

	// Get the value of the specific index/key
	@Override
	public String get(int key) {
		// TODO Auto-generated method stub
		return bTree.get(key);
	}

	// Sort the dictionary on the basis of key
	@Override
	public void sort() {
		// TODO Auto-generated method stub
		bTree.inorderTraversal();
		
	}

	// Sort dictionary in the range of keys
	@Override
	public void sortInRange(int k1, int k2) {
		// TODO Auto-generated method stub
		bTree.rangeSort(k1, k2);
	}

	
}
