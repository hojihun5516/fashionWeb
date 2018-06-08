package news.frontController;

import member.controller.action.Action;
import news.controller.action.NewsInsertAction;
import news.controller.action.NewsInsertFormAction;
import news.controller.action.NewsListAction;

public class NewsActionFactory {

	private NewsActionFactory() {
		
	}
	
	private static NewsActionFactory factory = new NewsActionFactory();
	
	public static NewsActionFactory getInstance(){
		return factory;
	}
	
	public Action getAction(String command){
		Action action = null;
		 
		if(command.equals("news_board_list")){
			action = new NewsListAction();
		}else if(command.equals("news_insert_form")){
			action = new NewsInsertFormAction();
		}else if(command.equals("news_insert")){
			action = new NewsInsertAction();
		}
		return action;
	}
	
}
