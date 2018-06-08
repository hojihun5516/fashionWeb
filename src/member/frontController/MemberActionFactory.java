package member.frontController;

import member.controller.action.Action;
import member.controller.action.IdCheckAction;
import member.controller.action.JoinFormAction;
import member.controller.action.LogoutAction;
import member.controller.action.MainFormAction;
import member.controller.action.MemberInsertAction;
import member.controller.action.MemberUpdateAction;
import member.controller.action.MemberUpdateForm;

public class MemberActionFactory {
	private MemberActionFactory(){
		
	}
	
	private static MemberActionFactory factory = new MemberActionFactory();
	
	public static MemberActionFactory getInstance(){
		return factory;
	}
	
	public Action getAction(String command){
		Action action = null;
		
		if(command.equals("join_form")){
			action = new JoinFormAction();
		}else if(command.equals("member_insert")){
			action = new MemberInsertAction();
		}else if(command.equals("id_check")){
			action = new IdCheckAction();
		}else if(command.equals("main_form")){
			action = new MainFormAction();
		}else if(command.equals("logout")){
			action = new LogoutAction();
		}else if(command.equals("member_update_form")){
			action = new MemberUpdateForm();
		}else if(command.equals("member_update")){
			action = new MemberUpdateAction();
		}
		
		
		return action;
	}
}
