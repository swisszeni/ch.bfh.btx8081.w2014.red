package intelligentstuff;

import java.util.List;

import models.User;

/**
 * this interface has 4 methods. Two return an user (either by id or username/password) and two return a list of users
 * 
 * @author florian, philipp
 *
 */
public interface UserDataSource {
	
	/**
	 * Returns an user for the given id
	 * 
	 * @param id : int - users id number
	 * @return User
	 */	
	public User getUserForId(int id);
	
	/**
	 * Returns an user for the given username and password
	 * 
	 * @param username : String
	 * @param password : String
	 * @return User
	 */
	public User getUserForUsernameAndPassword(String username, String password);
	
	/**
	 * Returns a list with all users
	 * 
	 * @return a list with users
	 */
	public List<User> getUsers();
	
	/**
	 * Returns a list of users form a given start- and endpoint
	 * 
	 * @param offset : int - startpoint for the list
	 * @param limit: int - endpoint
	 * @return a list with users
	 */
	public List<User> getUserss(int offset, int limit);
}