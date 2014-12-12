package intelligentstuff;

import java.util.List;

import models.User;

public interface UserDataSource {
	public User getUserForId(int id);
	public User getUserForUsernameAndPassword(String username, String password);
	public List<User> getUsers();
	public List<User> getUserss(int offset, int limit);
}