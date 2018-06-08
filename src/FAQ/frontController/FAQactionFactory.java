package FAQ.frontController;

import FAQ.controller.action.FAQAction;
import FAQ.controller.action.FAQanswerAction;
import FAQ.controller.action.FAQanswerDeleteAction;
import FAQ.controller.action.FAQcategoryAction;
import FAQ.controller.action.FAQdeleteAction;
import FAQ.controller.action.FAQdeleteFormAction;
import FAQ.controller.action.FAQlistAction;
import FAQ.controller.action.FAQviewAction;
import FAQ.controller.action.FAQwriteAction;
import FAQ.controller.action.FAQwriteFormAction;

public class FAQactionFactory {
	private FAQactionFactory() {}
		private static FAQactionFactory factory = new FAQactionFactory();
		
		public static FAQactionFactory getInstance(){
			return factory;
		
		}
	
		public FAQAction getAction(String command){
			FAQAction action=null;
			
			if(command.equals("FAQ_list")){
				action = new FAQlistAction();
			}else if(command.equals("FAQ_write_form")){
				action = new FAQwriteFormAction();		
			}else if(command.equals("FAQ_write_action")){
				action = new FAQwriteAction();	
			}else if(command.equals("FAQ_view")){
				action = new FAQviewAction();
			}else if(command.equals("FAQ_delete_form")){ 
				action = new FAQdeleteFormAction();
			}else if(command.equals("FAQ_delete")){ 
				action = new FAQdeleteAction();
			}else if(command.equals("FAQ_answer")){ 
				action = new FAQanswerAction();
			}else if(command.equals("FAQ_answer_delete")){ 
				action = new FAQanswerDeleteAction();
			}else if(command.equals("FAQ_category_select")){ 
				action = new FAQcategoryAction();
			}
			return action;
		}
}
