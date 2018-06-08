package user.frontController;

import snap.controller.action.SnapAction;
import snap.controller.action.SnapDeleteAction;
import snap.controller.action.SnapGoodAction;
import snap.controller.action.SnapInsertAction;
import snap.controller.action.SnapInsertFormAction;
import snap.controller.action.SnapListAction;
import snap.controller.action.SnapViewAction;
import snap.frontController.SnapActionFactory;
import user.controller.action.UserAction;
import user.controller.action.UserListAction;

public class UserActionFactory {

	private UserActionFactory() {
	
	}
	
	private static UserActionFactory factory = new UserActionFactory();
	
	public static UserActionFactory getInstance(){
		return factory;
	}
	
	public UserAction getAction(String command){
		UserAction action = null;
		if(command.equals("user_board_list")){
			action = new UserListAction();
		}
		
		return action;
	}
	
	
}
