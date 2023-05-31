package test_cases;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Signup_Controller implements Initializable {
	
	static boolean start = true;

	// sign_up page ////////////////////////////////////
    @FXML
    private TextField userNameSignUp;

    @FXML
    private PasswordField passwordSignUp;

    @FXML
    private TextField addressSignUp;

    @FXML
    private TextField ageSignUp;

    @FXML
    private TextField phoneNumberSignUp;

    @FXML
    private TextField addressSignUp1;

    @FXML
    private Button backSignUp;

    @FXML
    private Button submitSignUp;

    @FXML
    private Label titleSignUp;
    /////////////////////////////////////////////////////////////////////
    
    // login page ////////////////////////////////
    
    @FXML
    private Label titleHome;

    @FXML
    private Button loginHome;

    @FXML
    private PasswordField passwordHome;

    @FXML
    private Button signUpHome;

    @FXML
    private TextField userNameHome;

    @FXML
    private ImageView imageView;
    ////////////////////////////////////////////////////////////
    
    // home page //////////////////////////////////////////////
    
    @FXML
    private Button buyItems;

    @FXML
    private Button payBilss;

    @FXML
    private Button transferAccounts;

    @FXML
    private Button seeStatements;

    @FXML
    private Button backFirstPage;

    @FXML
    private Label titleFirstPage;

    @FXML
    private ImageView imageView2;
    
    ////////////////////////////////////////////////////////////
    
    // buy item //////////////////////////////////////////////

        @FXML
        private Button buyPayBills;

        @FXML
        private Button BackBuyItem;

        @FXML
        private TextField buySecurityNumber;

        @FXML
        private ImageView laptopImage;

        @FXML
        private ImageView cameraImage;

        @FXML
        private ImageView TVImage;

        @FXML
        private ImageView headphonesImage;

        @FXML
        private RadioButton laptopToggle;
        
        @FXML
        private RadioButton cameraToggle;

        @FXML
        private RadioButton TVToggle;

        @FXML
        private RadioButton headphonesToggle;

        @FXML
        private Button buySingleItem;
    
    /////////////////////////////////////////////////////////
        
    // transfer ////////////////////////////////////////////
        @FXML
        private Button transferButton;

        @FXML
        private Button BackTransferButton;

        @FXML
        private TextField ownTranferSecurity;

        @FXML
        private TextField transferSecurityNumber;

        @FXML
        private TextField transferAmount;
    ////////////////////////////////////////////////////////
        
    // Add Account/////////////////////////////////////////
        @FXML
        private Button addAccountButton;

        @FXML
        private Button BackAddAccount;

        @FXML
        private TextField AddNameField;

        @FXML
        private TextField AddSecurityNumber;

        @FXML
        private TextField AddBalance;

        @FXML
        private RadioButton CheckingToggle;

        @FXML
        private RadioButton SavingToggle;

    ///////////////////////////////////////////////////////
        
    // statements ////////////////////////////////////////
        @FXML
        private Label BalanceLabel;

        @FXML
        private Label balanceStatemant;

        @FXML
        private ListView<String> boughtItemsList;

        @FXML
        private Label BoughtItemsLabel;

        @FXML
        private Button BackStatements;

        @FXML
        private Button checkAccountButton;

        @FXML
        private TextField securityNumberField;
    /////////////////////////////////////////////////////

    
    static ArrayList<User> users = new ArrayList<User>();
    static Item Laptop = new Item(1200, "laptop");
    static Item Camera = new Item(700, "Camera");
    static Item TV = new Item(1500, "TV");
    static Item Headphones = new Item(200, "Headphones");
    
    static User current_user; 

    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) 
    {
    	if(start) 
    	{
    		users.add(new User("gana", "22", "Gana", "456 main st", "555-5678", 25, 1234, 2000, AccountType.Saving));
    		users.add(new User("nada", "11", "Nada", "123 main st", "555-1111", 25, 1111, 2500, AccountType.Saving));
    		start = false;
    	}
    }


    @FXML
    private void pushsubmitSignUp(ActionEvent event) throws IOException {
    	try {
    	if(userNameSignUp.getText().isBlank() == false && passwordSignUp.getText().isBlank() == false && addressSignUp1.getText().isBlank() == false&& addressSignUp.getText().isBlank() == false && ageSignUp.getText().isBlank() == false ) 
    	{
    	// Retrieve values from text fields
        String username = userNameSignUp.getText();
        String password = passwordSignUp.getText();
        String fullName = addressSignUp1.getText();
        String address = addressSignUp.getText();
        String phoneNumber = phoneNumberSignUp.getText();
        int age = Integer.parseInt(ageSignUp.getText()); // Assuming user enters valid integer

        // Create new user object
        User newUser = new User(username, password, fullName, address, phoneNumber, age);
        System.out.println("user added: " + newUser.name + " "+ newUser.age + " " + newUser.username+ " "+newUser.Address+" "+newUser.phone_number+" "+newUser.password);
        users.add(newUser);
	        Alert alert = new Alert(AlertType.WARNING,
	                "registered successfully", ButtonType.OK);
	        alert.showAndWait();
	        if (alert.getResult() == ButtonType.OK) {
	        	alert.close();
	        }
        }else 
        {
        	Alert alert = new Alert(AlertType.WARNING,
                    "enter all information", ButtonType.OK);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
            	alert.close();
            }
            
        }
    	}catch(Exception e) 
    	{
    		Alert alert = new Alert(AlertType.WARNING,
                    "age must be a number", ButtonType.OK);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
            	alert.close();
            }
    	}
    }

    @FXML
    private void pushbackSignUp(ActionEvent event) throws IOException {
    	// Switch to another scene
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Home1.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void pushloginHome(ActionEvent event) throws IOException {
    	if(userNameHome.getText().isBlank() == false && passwordHome.getText().isBlank() == false ) 
    	{
    		boolean found = false; 
    		for(User u: users) 
			{
				if(u.username.equals(userNameHome.getText()) && u.password.equals(passwordHome.getText())) {
					 
					found = true;
					current_user = u;
					switch_scene(event, "Services.fxml");
					System.out.println("success");
				 }
			}
    		if (!found) 
    		{
    			Alert alert = new Alert(AlertType.WARNING,
                        "user does not exist. please try again", ButtonType.OK);
                alert.showAndWait();
                if (alert.getResult() == ButtonType.OK) {
                	alert.close();
                }
    		}else 
    		{
    			
    		}
        }else 
        {
        	Alert alert = new Alert(AlertType.WARNING,
                    "enter all information", ButtonType.OK);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
            	alert.close();
            }
            
        }
    }

    @FXML
    public void pushsignUpHome(ActionEvent event) throws IOException {
    	// Switch to another scene
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Signup1.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void switch_scene(ActionEvent event, String required_scene) throws IOException 
    {
    	try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(required_scene));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void pushbuyItems(ActionEvent event) throws IOException  {
    	switch_scene(event, "BuyItem.fxml");
    }

    @FXML
    public void pushAddAccountButton(ActionEvent event) throws IOException {
        switch_scene(event, "addAccount.fxml");
    }

    @FXML
    public void pushtransferAccounts(ActionEvent event) throws IOException {
        switch_scene(event, "transfer.fxml");
    }

    @FXML
    public void pushseeStatements(ActionEvent event) throws IOException {
    	switch_scene(event, "statements.fxml");
    }

    @FXML
    public void pushbackFirstPage(ActionEvent event) throws IOException {
    	// Switch to another scene
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Home1.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void pushPayBills(ActionEvent event) throws IOException {
    	try {
    	if (!buySecurityNumber.getText().isBlank()) {
	    	boolean exist = false;
	        for(Account a: current_user.accounts) 
	        {
	        	if (a.security_number == Integer.parseInt(buySecurityNumber.getText()) ) 
	        	{
	        		exist = true;
	        	}
	        }
	        if(!exist) 
	        {
	        	Alert alert = new Alert(AlertType.ERROR,
	                    "account security number does not exist", ButtonType.OK);
	            alert.showAndWait();
	            if (alert.getResult() == ButtonType.OK) {
	            	alert.close();
	            }
	        }else 
	        {
	        	if(laptopToggle.isSelected() || cameraToggle.isSelected() || TVToggle.isSelected() || headphonesToggle.isSelected()) {
		        	float total = 0;
		        	if (laptopToggle.isSelected()) 
		        	{
		        		total+=Laptop.price;
		        		current_user.items.add(Laptop);
		        	}
		        	if(cameraToggle.isSelected()) 
		        	{
		        		total+=Camera.price;
		        		current_user.items.add(Camera);
		        	}
		        	if(TVToggle.isSelected()) 
		        	{
		        		total+=TV.price;
		        		current_user.items.add(TV);
		        	}
		        	if(headphonesToggle.isSelected()) 
		        	{
		        		total+=Headphones.price;
		        		current_user.items.add(Headphones);
		        	}
		        	boolean transaction = current_user.pay_bill(Integer.parseInt(buySecurityNumber.getText()));
		        	if(transaction) 
		        	{
		        		Alert alert = new Alert(AlertType.CONFIRMATION,
		                        "paid successfully", ButtonType.OK);
		                alert.showAndWait();
		                if (alert.getResult() == ButtonType.OK) {
		                	alert.close();
		                }
		        	}else
		        	{
		        		Alert alert = new Alert(AlertType.ERROR,
		                        "not enough balance in the account", ButtonType.OK);
		                alert.showAndWait();
		                if (alert.getResult() == ButtonType.OK) {
		                	alert.close();
		                }
		                current_user.items.clear();
		        	}
	        	}else 
	        	{
	        		Alert alert = new Alert(AlertType.WARNING,
	                        "select an item first", ButtonType.OK);
	                alert.showAndWait();
	                if (alert.getResult() == ButtonType.OK) {
	                	alert.close();
	                }
	        	}
	        }
        }else 
        {
        	Alert alert = new Alert(AlertType.WARNING,
                    "enter account security number", ButtonType.OK);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
            	alert.close();
            }
        }
    	}catch(Exception e) 
    	{
    		Alert alert = new Alert(AlertType.WARNING,
                    "Account security number field must be a number", ButtonType.OK);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
            	alert.close();
            }
    	}
    }

    @FXML
    public void pushBackBuyItem(ActionEvent event) throws IOException {
    	switch_scene(event, "Services.fxml");
    }

    @FXML
    public void pushBuySingleItem(ActionEvent event) throws IOException {
    	try {
    	if (!buySecurityNumber.getText().isBlank()) {
	    	boolean exist = false;
	        for(Account a: current_user.accounts) 
	        {
	        	if (a.security_number == Integer.parseInt(buySecurityNumber.getText()) ) 
	        	{
	        		exist = true;
	        	}
	        }
	        if(!exist) 
	        {
	        	Alert alert = new Alert(AlertType.ERROR,
	                    "account security number does not exist", ButtonType.OK);
	            alert.showAndWait();
	            if (alert.getResult() == ButtonType.OK) {
	            	alert.close();
	            }
	        }else 
	        {
	        	if(laptopToggle.isSelected() ^ cameraToggle.isSelected() ^ TVToggle.isSelected() ^ headphonesToggle.isSelected()) {
		        	Item i = null;
		        	if (laptopToggle.isSelected()) 
		        	{
		        		i = Laptop;
		        	}
		        	else if(cameraToggle.isSelected()) 
		        	{
		        		i = Camera;
		        	}
		        	else if(TVToggle.isSelected()) 
		        	{
		        		i = TV;
		        	}
		        	else if(headphonesToggle.isSelected()) 
		        	{
		        		i = Headphones;
		        	}
		        	boolean transaction = current_user.buy_item(i, Integer.parseInt(buySecurityNumber.getText()));
		        	if(transaction) 
		        	{
		        		Alert alert = new Alert(AlertType.CONFIRMATION,
		                        "paid successfully", ButtonType.OK);
		                alert.showAndWait();
		                if (alert.getResult() == ButtonType.OK) {
		                	alert.close();
		                }
		        	}else
		        	{
		        		Alert alert = new Alert(AlertType.ERROR,
		                        "not enough balance in the account", ButtonType.OK);
		                alert.showAndWait();
		                if (alert.getResult() == ButtonType.OK) {
		                	alert.close();
		                }
		        	}
	        	}else 
	        	{
	        		Alert alert = new Alert(AlertType.WARNING,
	                        "select only one item", ButtonType.OK);
	                alert.showAndWait();
	                if (alert.getResult() == ButtonType.OK) {
	                	alert.close();
	                }
	        	}
	        }
        }else 
        {
        	Alert alert = new Alert(AlertType.WARNING,
                    "enter account security number", ButtonType.OK);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
            	alert.close();
            }
        }
    	}catch(Exception e) 
    	{
    		Alert alert = new Alert(AlertType.WARNING,
                    "Account security number field must be a number", ButtonType.OK);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
            	alert.close();
            }
    	}
    }
    
    public void PushTansfer(ActionEvent event) throws IOException {
    	try {
    	if (transferAmount.getText().isBlank() == false && transferSecurityNumber.getText().isBlank() == false && ownTranferSecurity.getText().isBlank() == false) {
	    	boolean exist = false;
	    	Account userAccount = null;
	        for(Account a: current_user.accounts) 
	        {
	        	if (a.security_number == Integer.parseInt(ownTranferSecurity.getText()) ) 
	        	{
	        		userAccount = a;
	        		exist = true;
	        	}
	        }
	        if(!exist) 
	        {
	        	Alert alert = new Alert(AlertType.ERROR,
	                    "your account security number does not exist", ButtonType.OK);
	            alert.showAndWait();
	            if (alert.getResult() == ButtonType.OK) {
	            	alert.close();
	            }
	        }else 
	        {
	        	boolean exists = false;
	        	Account otherAccount = null;
	        	for(User user: users) 
	        	{
	        		for(Account acc: user.accounts) 
	        		{
	        			if (acc.security_number == Integer.parseInt(transferSecurityNumber.getText()) ) 
	    	        	{
	        				otherAccount = acc;
	    	        		exists = true;
	    	        	}
	        		}
	        	}
	        	if(exists) {
	        		boolean transaction = userAccount.moneyTransfer(otherAccount, Integer.parseInt(transferAmount.getText()));
	        		if(transaction) 
		        	{
		        		Alert alert = new Alert(AlertType.CONFIRMATION,
		                        "Transfered successfully", ButtonType.OK);
		                alert.showAndWait();
		                if (alert.getResult() == ButtonType.OK) {
		                	alert.close();
		                }
		        	}else
		        	{
		        		Alert alert = new Alert(AlertType.ERROR,
		                        "not enough balance in your account", ButtonType.OK);
		                alert.showAndWait();
		                if (alert.getResult() == ButtonType.OK) {
		                	alert.close();
		                }
		        	}
	        	}else
	        	{
	        		Alert alert = new Alert(AlertType.WARNING,
	                        "The account security number you want to transfer to does not exist", ButtonType.OK);
	                alert.showAndWait();
	                if (alert.getResult() == ButtonType.OK) {
	                	alert.close();
	                }
	        	}
	        }
        }else 
        {
        	Alert alert = new Alert(AlertType.WARNING,
                    "please enter all required data", ButtonType.OK);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
            	alert.close();
            }
        }
    	}catch(Exception e) 
    	{
    		Alert alert = new Alert(AlertType.WARNING,
                    "please enter only numbers", ButtonType.OK);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
            	alert.close();
            }
    	}
    }

    public void PushBackTransfer(ActionEvent event) throws IOException {
    	switch_scene(event, "Services.fxml");
    }
    
    public void PushAddAccount(ActionEvent event) throws IOException {
    	try {
        	if (AddBalance.getText().isBlank() == false && AddSecurityNumber.getText().isBlank() == false && AddNameField.getText().isBlank() == false && (CheckingToggle.isSelected() || SavingToggle.isSelected())) {
        		String Name = AddNameField.getText();
                int security_number = Integer.parseInt(AddSecurityNumber.getText());
                float balance = Float.parseFloat(AddBalance.getText());
				AccountType type;
				if(CheckingToggle.isSelected()) 
				{
					type = AccountType.Checking;
				}else 
				{
					type = AccountType.Saving;
				}
				Account newAcc = new Account(Name, security_number, balance, type);
				current_user.add_account(newAcc);
				Alert alert = new Alert(AlertType.WARNING,
	                    "account added successfully", ButtonType.OK);
	            alert.showAndWait();
	            if (alert.getResult() == ButtonType.OK) {
	            	alert.close();
	            }
		
            }else 
            {
            	Alert alert = new Alert(AlertType.WARNING,
                        "please enter all required data", ButtonType.OK);
                alert.showAndWait();
                if (alert.getResult() == ButtonType.OK) {
                	alert.close();
                }
            }
        	}catch(Exception e) 
        	{
        		Alert alert = new Alert(AlertType.WARNING,
                        "Security Number field must be a number", ButtonType.OK);
                alert.showAndWait();
                if (alert.getResult() == ButtonType.OK) {
                	alert.close();
                }
        	}
    }

    public void PushBackAddAccount(ActionEvent event) throws IOException {
        switch_scene(event, "Services.fxml");
    }
    
    @FXML
    public void checkAccount(ActionEvent event) throws IOException {
    	try {
    		long startTime = System.currentTimeMillis();
        	if (securityNumberField.getText().isBlank() == false) {
        		boolean exist = false;
    	    	Account userAccount = null;
    	        for(Account a: current_user.accounts) 
    	        {
    	        	if (a.security_number == Integer.parseInt(securityNumberField.getText()) ) 
    	        	{
    	        		userAccount = a;
    	        		exist = true;
    	        	}
    	        }
    	        
    	        if(!exist) 
    	        {
    	        	Alert alert = new Alert(AlertType.ERROR,
    	                    "the account security number does not exist", ButtonType.OK);
    	            alert.showAndWait();
    	            if (alert.getResult() == ButtonType.OK) {
    	            	alert.close();
    	            }
    	        }else 
    	        {
    	        	boughtItemsList.getItems().clear();
    	        	BalanceLabel.setVisible(true);
    	        	balanceStatemant.setText(Float.toString(userAccount.balance));
    	        	BoughtItemsLabel.setVisible(true);
    	        	boughtItemsList.setVisible(true);
    	        	if (current_user.bought_items.size() == 0) 
    	        	{
    	        		boughtItemsList.getItems().add("No items bought yet");
    	        	}else 
    	        	{
    	        		for(Item item: current_user.bought_items) 
    	        		{
    	        			boughtItemsList.getItems().add(item.item_name + " " +Float.toString(item.price));
    	        		}
    	        	}
    	        	long end = System.currentTimeMillis();
    	        	long  TIME = end - startTime ;
    	        	String s =  String.valueOf(TIME) + "ms time taken  " ;
    	        	Alert alert = new Alert(AlertType.WARNING,
    	                   s, ButtonType.OK);
    	            alert.showAndWait();
    	            if (alert.getResult() == ButtonType.OK) {
    	            	alert.close();
    	            }
    	        }
		
            }else 
            {
            	Alert alert = new Alert(AlertType.WARNING,
                        "please enter the security number of your account", ButtonType.OK);
                alert.showAndWait();
                if (alert.getResult() == ButtonType.OK) {
                	alert.close();
                }
            }
        	}catch(Exception e) 
        	{
        		Alert alert = new Alert(AlertType.WARNING,
                        "Security Number field must be a number", ButtonType.OK);
                alert.showAndWait();
                if (alert.getResult() == ButtonType.OK) {
                	alert.close();
                }
        	}
    	
    } 
    
    public void PushBackStatements(ActionEvent event) throws IOException {
        switch_scene(event, "Services.fxml");
    }


}

