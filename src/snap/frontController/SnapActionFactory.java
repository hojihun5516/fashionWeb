package snap.frontController;


import snap.controller.action.SnapAction;
import snap.controller.action.SnapDeleteAction;
import snap.controller.action.SnapGoodAction;
import snap.controller.action.SnapInsertAction;
import snap.controller.action.SnapInsertFormAction;
import snap.controller.action.SnapListAction;
import snap.controller.action.SnapViewAction;

public class SnapActionFactory {
	
	private SnapActionFactory() {
		
	}
	
	private static SnapActionFactory factory = new SnapActionFactory();
	
	public static SnapActionFactory getInstance(){
		return factory;
	}
	
	public SnapAction getAction(String command){
		SnapAction action = null;
		if(command.equals("snap_list")){
			System.out.println("snap_list");
			action = new SnapListAction();
		}else if(command.equals("snap_insert_form")){
			action = new SnapInsertFormAction();
		}else if(command.equals("snap_insert")){
			action = new SnapInsertAction();
		}else if(command.equals("Snap_View")){
			action = new SnapViewAction();
		}else if(command.equals("snap_goodCount")){
			action = new SnapGoodAction();
		}else if (command.equals("snap_delete")) {
			action = new SnapDeleteAction();
		}
		
		return action;
	}
	
}
