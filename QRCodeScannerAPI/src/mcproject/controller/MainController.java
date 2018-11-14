package mcproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mcproject.dao.PointOfInterestDAO;
import mcproject.dao.UserDAO;
import mcproject.model.PointOfInterest;
import mcproject.model.User;

@RestController
@RequestMapping(value = "/api")
public class MainController {

	/* DAOs Getters & Setters */
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private PointOfInterestDAO pointOfInterestDAO;

	public PointOfInterestDAO getPointOfInterestDAO() {
		return pointOfInterestDAO;
	}

	public void setPointOfInterestDAO(PointOfInterestDAO pointOfInterestDAO) {
		this.pointOfInterestDAO = pointOfInterestDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	
	// Add New User
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public User userSignUp(@RequestBody User user)
	{
		System.out.println("in sign up");
		return getUserDAO().userRegister(user);
	}
	
	// User Login
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public User validateUser(@RequestBody User user)
	{
		System.out.print("in validate user");
		return getUserDAO().getUser(user);
	}
	
	// Get POI description via title
	@RequestMapping(value = "/get/{title}", method = RequestMethod.GET)
	public PointOfInterest getInfo(@PathVariable String title)
	{
		System.out.print("in getInfo");
		return getPointOfInterestDAO().getDescription(title);
	}
	
	// Get all POIs
	@RequestMapping(value = "/get/all", method = RequestMethod.GET)
	public List<PointOfInterest> getAllPOI()
	{
		System.out.println(getPointOfInterestDAO().getAllPOI().get(0));
		return getPointOfInterestDAO().getAllPOI();
	}
	
	// Add new POI
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public PointOfInterest addNewPOI(@RequestBody PointOfInterest poi)
	{
		return getPointOfInterestDAO().addNew(poi);
	}
	
	// Delete POI
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	public PointOfInterest delPOI(@RequestBody PointOfInterest poi)
	{
		return getPointOfInterestDAO().del(poi);
	}
	
	// Edit POI
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public PointOfInterest editPOI(@RequestBody PointOfInterest poi)
	{
		return getPointOfInterestDAO().edit(poi);
	}
	
}
