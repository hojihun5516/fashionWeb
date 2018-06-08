package board.frontController;

import free.board.controller.action.FreeBoardDeleteAction;
import free.board.controller.action.FreeBoardDeleteFormAction;
import free.board.controller.action.FreeBoardGoodAction;
import free.board.controller.action.FreeBoardListAction;
import free.board.controller.action.FreeBoardNickListAction;
import free.board.controller.action.FreeBoardReadCount;
import free.board.controller.action.FreeBoardUpdateAction;
import free.board.controller.action.FreeBoardUpdateFormAction;
import free.board.controller.action.FreeBoardViewAction;
import free.board.controller.action.FreeBoardWriteAction;
import free.board.controller.action.FreeBoardWriteFormAction;
import member.controller.action.Action;

public class FreeActionFactory {

	private FreeActionFactory() {
	}

	private static FreeActionFactory factory = new FreeActionFactory();

	public static FreeActionFactory getInstance() {
		return factory;
	}

	public Action getAction(String command) {

		System.out.println("ActionFactory : " + command);

		Action action = null;

		if (command.equals("free_board_list")) {
			action = new FreeBoardListAction();
		} else if (command.equals("free_board_nick_list")) {
			action = new FreeBoardNickListAction();
		} else if (command.equals("free_board_write_form")) {
			action = new FreeBoardWriteFormAction();
		} else if (command.equals("free_board_write")) {
			action = new FreeBoardWriteAction();
		} else if (command.equals("free_board_view")) {
			action = new FreeBoardViewAction();
		} else if (command.equals("free_board_update_form")) {
			action = new FreeBoardUpdateFormAction();
		} else if (command.equals("free_board_update")) {
			action = new FreeBoardUpdateAction();
		} else if (command.equals("free_board_delete_form")) {
			action = new FreeBoardDeleteFormAction();
		} else if (command.equals("free_board_delete")) {
			action = new FreeBoardDeleteAction();
		} else if (command.equals("free_board_read_count")) {
			action = new FreeBoardReadCount();
		} else if (command.equals("free_board_good")) {
			action = new FreeBoardGoodAction();
		}

		return action;
	}

}
